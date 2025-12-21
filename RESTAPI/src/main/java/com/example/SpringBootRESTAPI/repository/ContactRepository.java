package com.example.SpringBootRESTAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SpringBootRESTAPI.model.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {

}
