package com.example.Account_and_customer_management.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUSTOMER_SEQ_GEN")
	@SequenceGenerator(name = "CUSTOMER_SEQ_GEN", sequenceName = "CUSTOMER_SEQ")
	@Column(name = "CUSTOMER_id")
	private long customerId;
	
	private String name;
	private String streetNumber;
	private String postalCode;
	private String city;
	private String province;

	public Customer(long customerId, String name, String streetNumber, String postalCode) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.streetNumber = streetNumber;
		this.postalCode = postalCode;
	}

	public Customer(String name, String streetNumber, String postalCode) {
		super();
		this.name = name;
		this.streetNumber = streetNumber;
		this.postalCode = postalCode;
	}

	public Customer() {
		super();
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", name=" + name + ", streetNumber=" + streetNumber
				+ ", postalCode=" + postalCode + ", city=" + city + ", province=" + province + "]";
	}



}
