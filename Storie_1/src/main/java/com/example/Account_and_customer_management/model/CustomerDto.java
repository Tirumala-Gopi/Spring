package com.example.Account_and_customer_management.model;

public class CustomerDto {
	
	private String name;
	private String streetNumber;
	private String city;
	private String province;
	private String postalCode;
	public CustomerDto(String name, String streetNumber, String city, String province, String postalCode) {
		super();
		this.name = name;
		this.streetNumber = streetNumber;
		this.city = city;
		this.province = province;
		this.postalCode = postalCode;
	}
	
	
//	public CustomerDto(String name, String city, String province, String postalCode) {
//		super();
//		this.name = name;
//		this.city = city;
//		this.province = province;
//		this.postalCode = postalCode;
//	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStreetNumber() {
		return streetNumber;
	}
	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	@Override
	public String toString() {
		return "CustomerDto [name=" + name + ", streetNumber=" + streetNumber + ", city=" + city + ", province="
				+ province + ", postalCode=" + postalCode + "]";
	}
	
	

}
