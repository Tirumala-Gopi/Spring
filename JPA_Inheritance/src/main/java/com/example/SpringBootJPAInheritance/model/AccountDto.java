package com.example.SpringBootJPAInheritance.model;

public class AccountDto {

	private double balance;
	private double interestRate;
	private double minBalance;
	private String accountType;
	public AccountDto() {
		super();
	}
	public AccountDto(double balance, double interestRate, double minBalance, String accountType) {
		super();
		this.balance = balance;
		this.interestRate = interestRate;
		this.minBalance = minBalance;
		this.accountType = accountType;
	}
	
	public AccountDto(double balance, double minBalance, String accountType) {
		super();
		this.balance = balance;
		this.minBalance = minBalance;
		this.accountType = accountType;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public double getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	public double getMinBalance() {
		return minBalance;
	}
	public void setMinBalance(double minBalance) {
		this.minBalance = minBalance;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	@Override
	public String toString() {
		return "AccountDto [balance=" + balance + ", interestRate=" + interestRate + ", minBalance=" + minBalance
				+ ", accountType=" + accountType + "]";
	}
	
	
	
}
