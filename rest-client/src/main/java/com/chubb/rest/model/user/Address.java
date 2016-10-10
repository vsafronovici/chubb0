package com.chubb.rest.model.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Address {
	
	private String zip;
	private String phone;
	private String street;
	
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}


	@Override
	public String toString() {
		return "Address{" +
				"zip='" + zip + '\'' +
				", phone='" + phone + '\'' +
				", street='" + street + '\'' +
				'}';
	}
}
