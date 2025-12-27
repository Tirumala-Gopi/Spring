package com.example.Account_and_customer_management.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
@Entity
public class CheckingAccount extends Account {

	
	@Column(name = "NEXT_CHECK_NUMBER")
	private int nextCheckNumber;

	public CheckingAccount(@NotNull(message = " balance must not be null") double balance, Customer customer,
			 int nextCheckNumber) {
		super(balance, customer);
		this.nextCheckNumber = nextCheckNumber;
	}

	public CheckingAccount(int nextCheckNumber) {
		super();
		this.nextCheckNumber = nextCheckNumber;
	}
	

	

	public CheckingAccount() {
		super();
	}

	public int getNextCheckNumber() {
		return nextCheckNumber;
	}

	public void setNextCheckNumber(int nextCheckNumber) {
		this.nextCheckNumber = nextCheckNumber;
	}

	@Override
	public String toString() {
		return "CheckingAccount [nextCheckNumber=" + nextCheckNumber + "]";
	}
	
	
}
