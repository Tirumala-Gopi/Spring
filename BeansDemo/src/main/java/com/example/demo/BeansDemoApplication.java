package com.example.demo;

import java.util.Optional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.demo.model.Contact;
import com.example.demo.service.ContactService;

@SpringBootApplication
public class BeansDemoApplication implements CommandLineRunner {
	
	ApplicationContext ctx;
	

	public BeansDemoApplication(ApplicationContext ctx) {
		super();
		this.ctx = ctx;
	}


	public static void main(String[] args) {
		SpringApplication.run(BeansDemoApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		ContactService conatctService=ctx.getBean(ContactService.class);
		Contact johnContact=new Contact(1,"john","Ambraham","john","123456789");
		Contact johnContact1=new Contact(2,"john","Ambraham","john","123456789");
		Optional<Contact> created=conatctService.createContact(johnContact);
		Optional<Contact> created1=conatctService.createContact(johnContact1);
		
		if(created1.isPresent()) {
			System.out.println(created1);
		}
		
		if(created.isPresent()) {
			System.out.println(created);
		}
	}

}
