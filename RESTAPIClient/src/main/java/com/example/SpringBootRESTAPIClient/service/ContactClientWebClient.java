package com.example.SpringBootRESTAPIClient.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.SpringBootRESTAPIClient.model.Contact;

import reactor.core.publisher.Mono;
@Service
public class ContactClientWebClient implements IContactClient {

	private WebClient contactWebClient;
	
	public ContactClientWebClient(WebClient contactWebClient) {
		super();
		this.contactWebClient = contactWebClient;
	}

	@Override
	public List<Contact> getContacts() {
		// TODO Auto-generated method stub
		return contactWebClient.get()
				.retrieve()
				.bodyToFlux(Contact.class)
				.collectList().block();
	}

	@Override
	public Contact getContact(long id) {
		// TODO Auto-generated method stub
		return contactWebClient.get()
				.uri("/"+id).retrieve()
				.onStatus(status -> status.value()==HttpStatus.NOT_FOUND.value(), 
				response -> Mono.error(new ContactNotFound("contact wirh id"+id+" not found"))).bodyToMono(Contact.class).block();
	}

	@Override
	public Contact createContact(Contact contact) {
		// TODO Auto-generated method stub
		return contactWebClient.post()
				.bodyValue(contact)
				.retrieve()
				.bodyToMono(Contact.class)
				.block();
	}

	@Override
	public Contact updateContact(Contact contact) {
		// TODO Auto-generated method stub
		return contactWebClient.put().uri("/"+contact.getId()).bodyValue(contact).retrieve().bodyToMono(Contact.class).block();
	}

	@Override
	public void deleteContact(long id) {
		// TODO Auto-generated method stub
		contactWebClient.delete()
		.uri("/"+id).retrieve().toBodilessEntity().block();
	}

}
