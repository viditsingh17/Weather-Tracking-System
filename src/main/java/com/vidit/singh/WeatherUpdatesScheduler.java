package com.vidit.singh;

import java.time.LocalTime;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.vidit.singh.model.WeatherModel;
import com.vidit.singh.service.MessagingService;
import com.vidit.singh.service.WeatherService;

@Component
public class WeatherUpdatesScheduler {

	
	
	@Scheduled(cron = "0 0 */5 * * ?")  // Runs every 5 hours
	public static void sendPeriodicUpdates(){
		WeatherModel weather;
		try {
			weather = WeatherService.getWeatherUpdates();
			String greeting = "morning";
			LocalTime currentTime = LocalTime.now();
			if(currentTime.getHour()>=5 && currentTime.getHour()<12) greeting = "morning";
			else if(currentTime.getHour()==12) greeting = "noon";
			else if(currentTime.getHour()>12 && currentTime.getHour()<=17) greeting = "after-noon";
			else if(currentTime.getHour()>17 && currentTime.getHour()<=22) greeting = "evening";
			else greeting = "night";
			System.out.println("log :: Message sent to the user successfully ::" + MessagingService.sendMessage("Good " + greeting + " Sir!\n\nHere are your updates:\n" + weather.toString()));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}
		
	
}
