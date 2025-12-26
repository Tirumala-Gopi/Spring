package com.example.Account_and_customer_management.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.NotBlank;

@Entity

@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "CUSTOMER_SEQ_GEN")
	@SequenceGenerator(name = "CUSTOMER_SEQ_GEN" ,sequenceName="CUSTOMER_SEQ" )
	@Column(name = "CUSTOMER_id")
	private long customerId;
	
	@NotBlank
	@Column(name = "CUSTOMER_NAME", nullable = false, updatable = false)
	private String name;
	
	@NotBlank
	@Column(name = "CUSTOMER_ADDRESS")
	@OneToOne
	private Address address;
	
	@OneToMany(mappedBy="customer", cascade=CascadeType.ALL)
	private List<Account> accounts;
	
	
	
	
}
