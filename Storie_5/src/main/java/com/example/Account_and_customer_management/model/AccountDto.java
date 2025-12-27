package com.example.Account_and_customer_management.model;

public class AccountDto {
	private String accountType;
	private Double interestRate;
	private Integer nextCheckNumber;
	private double balance;
	public AccountDto(String accountType, Double interestRate, Integer nextCheckNumber, double balance) {
		super();
		this.accountType = accountType;
		this.interestRate = interestRate;
		this.nextCheckNumber = nextCheckNumber;
		this.balance = balance;
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
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	

}
