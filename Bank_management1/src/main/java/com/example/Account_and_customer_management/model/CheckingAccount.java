package com.example.Account_and_customer_management.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class CheckingAccount extends Account {

	@NotBlank
	@Column(name = "NEXT_CHECK_NUMBER")
	private int nextCheckNumber;

	public CheckingAccount() {
		super();
	}

	public CheckingAccount(@NotBlank int nextCheckNumber) {
		super();
		this.nextCheckNumber = nextCheckNumber;
	}

	public CheckingAccount(@NotBlank double balance, Customer customer, @NotBlank int nextCheckNumber) {
		super(balance, customer);
		this.nextCheckNumber = nextCheckNumber;
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
