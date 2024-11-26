package com.vidit.singh.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WeatherModel {
	private String location;
	private String condition;
	private String temperatureC;
	private String temperatureF;
	private String feelsLike;
	private String rainfall;
	
	
	@Override
	public String toString() {
		return "Current weather in " + location + " is as follows: \nCondition: " + condition 
				+ "\nTemperature: " + temperatureC + "\u00B0 C (" + temperatureF 
				+ "\u00B0 F) \nFeels Like: " + feelsLike 
				+ "\u00B0 C \nRainfall: " + rainfall;
	}
	
}
