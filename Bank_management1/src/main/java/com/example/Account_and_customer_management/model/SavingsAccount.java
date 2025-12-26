package com.example.Account_and_customer_management.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
@Entity
public class SavingsAccount extends Account {

	@NotBlank
	@Column(name = "INTEREST_RATE")
	private double interestRate;



	public SavingsAccount(@NotBlank(message = " balance must not be null") double balance, Customer customer,
			@NotBlank double interestRate) {
		super(balance, customer);
		this.interestRate = interestRate;
	}
	
	

	public SavingsAccount(@NotBlank double interestRate) {
		super();
		this.interestRate = interestRate;
	}



	public SavingsAccount() {
		super();
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	@Override
	public String toString() {
		return "SavingsAccount [interestRate=" + interestRate + "]";
	}
	
}
