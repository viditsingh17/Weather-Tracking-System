package com.vidit.singh.service;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class MessagingService{
	private static final String TELEGRAM_API = "https://api.telegram.org/bot7918329544:AAHLQ0whwzC7lw0V2LfvR8R8zLmdDAAT_fw/sendMessage?chat_id=1299025429&text=";
	
	
	//send a text message to me
	public static Boolean sendMessage(String message) {
		RestTemplate restTemplate = new RestTemplate();
		String url = TELEGRAM_API + message;
		
		try {
			ResponseEntity response = restTemplate.getForEntity(url, String.class);
			
			if(response.getStatusCode() == HttpStatus.OK) return true;
			else return false;
		}
		catch(HttpClientErrorException e) {
			System.out.println(e.getMessage());
		}
		
		return false;
	}
	
	
	//delete a previously sent message
	
	//send an image
	
	//send a file
	
	
	
}