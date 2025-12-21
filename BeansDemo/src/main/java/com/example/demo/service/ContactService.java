package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Contact;
import com.example.demo.repository.ContactRepository;

@Service
public class ContactService {
	private ContactRepository contactRepository;
	
	@Autowired

	public ContactService(ContactRepository contactRepository) {
		super();
		this.contactRepository = contactRepository;
	}
	
	public Optional<Contact> createContact(Contact contact){
		Optional<Contact> contactOpt=Optional.empty();
				if(!contactRepository.existsById(contact.getId())){
					contactOpt=Optional.ofNullable(contactRepository.save(contact));
				}
		return contactOpt;
	}
	
	public Optional<Contact> readByConatctId(long id){
		return contactRepository.findById(id);
	}
	
	public Optional<Contact> updateContact(Contact contact){
		Optional<Contact> contactOpt=Optional.empty();
		contactOpt=Optional.ofNullable(contactRepository.save(contact));
		return contactOpt;
	}
	
	public void deleteById(long id){
		contactRepository.deleteById(id);
	}
	
	public List<Contact> getAllContacts(){
		return contactRepository.findAll();
	}

}
