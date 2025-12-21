package com.example.SpringBootRESTAPI.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
@Entity

public class Contact {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "CONTACT_SEQ_GEN")
	@SequenceGenerator(name = "CONTACT_SEQ_GEN" ,sequenceName="CONTACT_SEQ" )
	private long id;
	@Column(name = "First_name")
	@NotBlank(message = " first name must not be blank")
	private String firstName;
	private String lastName;
	private String middleName;
	@Pattern(regexp="^[+][0-9][-.]\\b\\d{3}[-.]\\d{3}[-.]\\d{4}\\b",message=" not valid phone number")
	private String phoneNUmber;
	public Contact(long id, String firstName, String lastName, String middleName, String phoneNUmber) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.middleName = middleName;
		this.phoneNUmber = phoneNUmber;
	}
	public Contact() {
		super();
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
	public String toString() {
		return "Contact [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", middleName="
				+ middleName + ", phoneNUmber=" + phoneNUmber + "]";
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
	public Contact(String firstName, String lastName, String middleName, String phoneNUmber) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.middleName = middleName;
		this.phoneNUmber = phoneNUmber;
	}
	
	
}
