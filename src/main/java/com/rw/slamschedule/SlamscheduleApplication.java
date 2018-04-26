package com.rw.slamschedule;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
public class SlamscheduleApplication {

	@Bean
	public ObjectMapper ObjectMapper(){
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper;
	}

	public static void main(String[] args) {
		SpringApplication.run(SlamscheduleApplication.class, args);
	}
}
