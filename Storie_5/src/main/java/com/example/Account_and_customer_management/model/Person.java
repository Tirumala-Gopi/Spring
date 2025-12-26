package com.example.Account_and_customer_management.model;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Person extends Customer {

	public Person(@NotBlank String name, Address address) {
		super(name, address);
	}
	

}
