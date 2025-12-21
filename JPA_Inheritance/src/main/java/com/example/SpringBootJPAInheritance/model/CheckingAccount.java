package com.example.SpringBootJPAInheritance.model;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "CheckingMapped")
public class CheckingAccount extends Account {

	private double interestRate;
	
	public CheckingAccount(double balance, double interestRate) {
		super(balance);
		this.interestRate = interestRate;
	}

	public CheckingAccount(double balance) {
		super(balance);
		// TODO Auto-generated constructor stub
	}

	public CheckingAccount(int id, double balance) {
		super(id, balance);
	}

	public CheckingAccount() {
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
		return "CheckingAccount [interestRate=" + interestRate + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(interestRate);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		CheckingAccount other = (CheckingAccount) obj;
		return Double.doubleToLongBits(interestRate) == Double.doubleToLongBits(other.interestRate);
	}
	

}
