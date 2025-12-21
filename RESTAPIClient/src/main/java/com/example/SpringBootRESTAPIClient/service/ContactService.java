package com.example.SpringBootRESTAPIClient.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.SpringBootRESTAPIClient.model.Contact;

@Service
public class ContactService {

	private IContactClient contactClient;

	public ContactService(IContactClient contactClient) {
		super();
		this.contactClient = contactClient;
	}

	public Contact createContact(Contact johncontact) {
		// TODO Auto-generated method stub
		return contactClient.createContact(johncontact);
	}
	
	public List<Contact> getContacts(){
		return contactClient.getContacts();
	}
	
	
	public Contact getContact(long id) {
		return contactClient.getContact(id);
	}
	
	
	public Contact updateContact(Contact contact) {
		return contactClient.updateContact(contact);
	}
	
	public void deleteContact(long id) {
		contactClient.deleteContact(id);
	}
}
