package com.example.Account_and_customer_management.model;

public class CustomerDto {
	
	private String name;
	private String streetNumber;
	private String postalCode;
	public CustomerDto(String name, String streetNumber, String postalCode) {
		super();
		this.name = name;
		this.streetNumber = streetNumber;
		this.postalCode = postalCode;
	}
	public CustomerDto() {
		super();
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
	@Override
	public String toString() {
		return "CustomerDto [name=" + name + ", streetNumber=" + streetNumber + ", postalCode=" + postalCode + "]";
	}
	

}
