package com.example.SpringBootRESTAPIClient;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.SpringBootRESTAPIClient.model.Contact;
import com.example.SpringBootRESTAPIClient.service.ContactService;

@SpringBootApplication
public class RestapiClientApplication implements CommandLineRunner{

	ApplicationContext ctx;
	
	public RestapiClientApplication(ApplicationContext ctx) {
		super();
		this.ctx = ctx;
	}

	private final String CONTACT_BASE_URL="http://localhost:8080/api/v1/contacts";
	public static void main(String[] args) {
		SpringApplication.run(RestapiClientApplication.class, args);
	}

	@Bean
	public WebClient.Builder webClientBuilder(){
		return WebClient.builder();
	}
	
	@Bean
	public WebClient contactWebClient(WebClient.Builder builder) {
		return builder.baseUrl(CONTACT_BASE_URL).defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).build();
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		ContactService contactService=ctx.getBean(ContactService.class);
		
		Contact johncontact=new Contact("john","abc","edf","+1-123-456-7890");
		Contact createdContact1= contactService.createContact(johncontact);
		
		Contact joecontact=new Contact("joe","abc","edf","+1-123-456-7890");
		Contact createdContact2= contactService.createContact(joecontact);
		
	}
	
	
	
}
