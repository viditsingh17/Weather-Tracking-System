package com.vidit.singh.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vidit.singh.model.WeatherModel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Service
public class WeatherService{
//	private static final String WEATHER_API = "http://api.weatherapi.com/v1/current.json?key=YOUR_API_KEY&q=London";
	private static final String WEATHER_API = "http://api.weatherapi.com/v1/current.json?key=4739a1a84b1446c29d695448241910&q=Ghaziabad";
	
	public static WeatherModel getWeatherUpdates() throws JsonMappingException, JsonProcessingException {
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.getForEntity(WEATHER_API, String.class);
		
		WeatherModel curWeather;
		
		if(response.getStatusCode() == HttpStatus.OK){
			//proceed further
			String responseBody = response.getBody();
			JsonNode jsonNode = new ObjectMapper().readTree(responseBody);
			
			
			String location = jsonNode.get("location").get("name").asText();
			String condition = jsonNode.get("current").get("condition").get("text").asText();
			String temperatureC = jsonNode.get("current").get("temp_c").asText();
			String temperatureF = jsonNode.get("current").get("temp_f").asText();
			String feelsLike = jsonNode.get("current").get("feelslike_c").asText();
			String rainfall = jsonNode.get("current").get("precip_mm").asText(); //mm
			
			curWeather = new WeatherModel(location, condition, temperatureC, temperatureF, feelsLike, rainfall);
			
		}
		else {
			//Some issue occurred - try again
			curWeather = new WeatherModel();
		}		
		return curWeather;
	}
}