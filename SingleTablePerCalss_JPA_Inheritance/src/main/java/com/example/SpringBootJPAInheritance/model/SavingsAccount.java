package com.example.SpringBootJPAInheritance.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@DiscriminatorValue(value="Savings")
public class SavingsAccount extends Account {

	private double minBalance;

	public SavingsAccount(int id, double balance, double minBalance) {
		super(id, balance);
		this.minBalance = minBalance;
	}

	public SavingsAccount(double balance, double minBalance) {
		super(balance);
		this.minBalance = minBalance;
	}

	public SavingsAccount(double minBalance) {
		super();
		this.minBalance = minBalance;
	}

	public SavingsAccount() {
		super();
	}

	public double getMinBalance() {
		return minBalance;
	}

	public void setMinBalance(double minBalance) {
		this.minBalance = minBalance;
	}

	@Override
	public String toString() {
		return "SavingsAccount [minBalance=" + minBalance + "]";
	}
	
	
}
