package com.backend.HotelReservation.entity;

public class UseLoginModel {
	
	String email;
	String password;
	
	public UseLoginModel() {
		
	}

	public UseLoginModel(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
