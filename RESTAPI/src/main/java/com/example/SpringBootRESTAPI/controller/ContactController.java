package com.example.SpringBootRESTAPI.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringBootRESTAPI.model.Contact;
import com.example.SpringBootRESTAPI.service.ContactService;

import jakarta.validation.Valid;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;



@RestController
@RequestMapping("api/v1/contacts")
public class ContactController {
	
	private ContactService contactService;
@Autowired
	public ContactController(ContactService contactService) {
		super();
		this.contactService = contactService;
	}
	@GetMapping
	public ResponseEntity<List<Contact>> getContacts(){
		List<Contact> contacts=contactService.retriveContacts();
		return ResponseEntity.ok(contacts);
	}
	
	@PostMapping
	public ResponseEntity<Contact> createContact(@Valid  @RequestBody Contact contact){
		Contact createdContact= contactService.createContact(contact);
		
		URI location = ServletUriComponentsBuilder
	            .fromCurrentRequest()
	            .path("/{id}")
	            .buildAndExpand(createdContact.getId())
	            .toUri();
		//return ResponseEntity.created(location).build();
		return ResponseEntity.created(location).body(createdContact);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Contact> updateContact(@PathVariable long id, @RequestBody Contact contact){
		
		Contact updatedContact= contactService.updateContact(contact);
		return ResponseEntity.ok(updatedContact);
	}
	
	@DeleteMapping("/{id}")
	public void deleteMapping(@PathVariable long id) {
		contactService.deleteContact(id);
	}

	
	@GetMapping("/{id}")
	public ResponseEntity<Contact> getContact(@PathVariable long id){
		
		Contact contact=contactService.retriveContact(id);
		return ResponseEntity.ok(contact);
	}
}
