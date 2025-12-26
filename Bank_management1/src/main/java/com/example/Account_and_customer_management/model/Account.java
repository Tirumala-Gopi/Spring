package com.example.Account_and_customer_management.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity

@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "ACCOUNT_SEQ_GEN")
	@SequenceGenerator(name = "ACCOUNT_SEQ_GEN" ,sequenceName="ACCOUNT_SEQ" )
	@Column(name = "ACCOUNT_ID")
	private long accountId;
	
	@NotBlank(message =" balance must not be null")
	@Column(name = "BALANCE")
	private double balance;
	
	@ManyToOne
	@JoinColumn(name="FK_CUST_ID")
	private Customer customer;

	public Account() {
		super();
	}

	

	public Account(@NotBlank(message = " balance must not be null") double balance, Customer customer) {
		super();
		this.balance = balance;
		this.customer = customer;
	}



	public long getAccountId() {
		return accountId;
	}

	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", balance=" + balance + ", customer=" + customer + "]";
	}
	
	
	
	

}
