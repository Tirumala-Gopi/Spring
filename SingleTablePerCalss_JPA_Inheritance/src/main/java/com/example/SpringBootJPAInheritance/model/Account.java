package com.example.SpringBootJPAInheritance.model;

import java.util.Objects;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.SequenceGenerator;

//@MappedSuperclass
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="Account_Type",discriminatorType=DiscriminatorType.STRING)
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "ACCOUNT_SEQ_GEN")
	@SequenceGenerator(name = "ACCOUNT_SEQ_GEN" ,sequenceName="ACCOUNT_SEQ" )
	private int id;
	private double balance;
	public Account(int id, double balance) {
		super();
		this.id = id;
		this.balance = balance;
	}
	public Account(double balance) {
		super();
		this.balance = balance;
	}
	public Account() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "Account [id=" + id + ", balance=" + balance + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(balance, id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		return Double.doubleToLongBits(balance) == Double.doubleToLongBits(other.balance) && id == other.id;
	}
	
}
