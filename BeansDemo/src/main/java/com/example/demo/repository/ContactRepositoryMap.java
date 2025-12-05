package com.example.demo.repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.example.demo.model.Contact;
import org.springframework.stereotype.Repository;

@Repository

public class ContactRepositoryMap implements ContactRepository {
 private Map<Long,Contact> contacts;
 
	public ContactRepositoryMap(Map<Long, Contact> contacts) {
	super();
	this.contacts = contacts;
}

	@Override
	public Contact SAVE(Contact t) {
	contacts.put(t.getId(), t);
		return t;
	}

	@Override
	public Optional<Contact> findById(Long id) {
		
		return Optional.ofNullable(contacts.get(id));
	}

	@Override
	public List<Contact> finaAll() {
		
		return contacts.values().stream().collect(Collectors.toList());}

	@Override
	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

}
