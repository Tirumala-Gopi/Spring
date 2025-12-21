package com.example.SpringBootRESTAPIClient.service;

import java.util.List;

import com.example.SpringBootRESTAPIClient.model.Contact;

public interface IContactClient {
List<Contact> getContacts();
Contact getContact(long id);
Contact createContact(Contact contact);
Contact updateContact(Contact contact);
void deleteContact(long id);
}
