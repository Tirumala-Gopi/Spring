package com.example.demo.model;

import java.util.Objects;

public class Contact {
	private long id;
	private String firstName;
	private String lastName;
	private String middleName;
	private String phoneNUmber;
	public Contact() {
		super();
	}
	public Contact(long id, String firstName, String lastName, String middleName, String phoneNUmber) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.middleName = middleName;
		this.phoneNUmber = phoneNUmber;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getPhoneNUmber() {
		return phoneNUmber;
	}
	public void setPhoneNUmber(String phoneNUmber) {
		this.phoneNUmber = phoneNUmber;
	}
	@Override
	public int hashCode() {
		return Objects.hash(firstName, id, lastName, middleName, phoneNUmber);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contact other = (Contact) obj;
		return Objects.equals(firstName, other.firstName) && id == other.id && Objects.equals(lastName, other.lastName)
				&& Objects.equals(middleName, other.middleName) && Objects.equals(phoneNUmber, other.phoneNUmber);
	}
	@Override
	public String toString() {
		return "Contact [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", middleName="
				+ middleName + ", phoneNUmber=" + phoneNUmber + "]";
	}
	

}
