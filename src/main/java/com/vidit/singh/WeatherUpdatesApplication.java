package com.vidit.singh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.vidit.singh.model.WeatherModel;
import com.vidit.singh.service.MessagingService;
import com.vidit.singh.service.WeatherService;

@SpringBootApplication 
@EnableScheduling
public class WeatherUpdatesApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherUpdatesApplication.class, args);
	}

}
