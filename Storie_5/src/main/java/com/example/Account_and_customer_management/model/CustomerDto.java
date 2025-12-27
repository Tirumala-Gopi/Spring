package com.example.Account_and_customer_management.model;

import jakarta.persistence.Column;

public class CustomerDto {

	private String name;
	private String streetNumber;
	private String postalCode;
	
	private String customerType;

	private String accountType;
	private Double interestRate;
	private Integer nextCheckNumber;
	private double balance;
	
	
	
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public CustomerDto(String name, String streetNumber, String postalCode, String customerType, String accountType,
			Double interestRate, Integer nextCheckNumber, double balance) {
		super();
		this.name = name;
		this.streetNumber = streetNumber;
		this.postalCode = postalCode;
		this.customerType = customerType;
		this.accountType = accountType;
		this.interestRate = interestRate;
		this.nextCheckNumber = nextCheckNumber;
		this.balance = balance;
	}
	public String getCustomerType() {
		return customerType;
	}
	public void setCustomerType(String customerType) {
		this.customerType = customerType;
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
	
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public Double getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(Double interestRate) {
		this.interestRate = interestRate;
	}
	public Integer getNextCheckNumber() {
		return nextCheckNumber;
	}
	public void setNextCheckNumber(Integer nextCheckNumber) {
		this.nextCheckNumber = nextCheckNumber;
	}
	@Override
	public String toString() {
		return "CustomerDto [name=" + name + ", streetNumber=" + streetNumber + ", postalCode=" + postalCode
				+ ", customerType=" + customerType + ", accountType=" + accountType + ", interestRate=" + interestRate
				+ ", nextCheckNumber=" + nextCheckNumber + ", balance=" + balance + "]";
	}
	
}
