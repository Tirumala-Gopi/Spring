package com.example.Account_and_customer_management.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class CustomerConfig {
	private final String GEOCODER_BASE_URL = "https://geocoder.ca";

	@Bean
	public WebClient.Builder webClientBuilder() {
		return WebClient.builder();
	}

	@Bean
	public WebClient webClient(WebClient.Builder builder) {
		return builder.baseUrl(GEOCODER_BASE_URL).build();
	}

}

