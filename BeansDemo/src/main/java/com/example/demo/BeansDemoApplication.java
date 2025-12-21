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
		ContactService contactService=ctx.getBean(ContactService.class);
		Contact johnContact=new Contact("john","Ambraham","john","123456789");
		Contact johnContact1=new Contact("john","Ambraham","john","123456789");
		Optional<Contact> created=contactService.createContact(johnContact);
		Optional<Contact> created1=contactService.createContact(johnContact1);
		
//		if(created1.isPresent()) {
//			System.out.println(created1);
//		}
//		
		if(created.isPresent()) {
			System.out.println(created);
		}
		
		System.out.println("All contacts :"+contactService.getAllContacts());
	}

}
