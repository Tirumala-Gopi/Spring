package com.example.SpringBootRESTAPI.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SpringBootRESTAPI.model.Contact;
import com.example.SpringBootRESTAPI.repository.ContactRepository;

@Service
public class ContactService {

	private ContactRepository contactRepo;

	@Autowired
	public ContactService(ContactRepository contactRepo) {
		super();
		this.contactRepo = contactRepo;
	}

	public List<Contact> retriveContacts() {

		return contactRepo.findAll();

	}

	public Contact retriveContact(long contactId) {
		Optional<Contact> contactopt = contactRepo.findById(contactId);
		if(!contactopt.isPresent()) {
			throw new ContactNotFoundException (" contact with id "+ contactId+ " not found");
		}
		return contactopt.get();
	}

	public Contact createContact(Contact contact) {

		return contactRepo.save(contact);

	}

	public Contact updateContact(Contact contact) {
		return contactRepo.save(contact);

	}

	public void deleteContact(long contactId) {
		contactRepo.deleteById(contactId);
	}
}
