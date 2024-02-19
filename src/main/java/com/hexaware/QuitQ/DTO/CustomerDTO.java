package com.hexaware.QuitQ.DTO;

import jakarta.persistence.Entity;

public class CustomerDTO {
	
	private String mobileId;
	private String password;
	private String emailId;

	public CustomerDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public CustomerDTO(String mobileId, String password, String emailId) {
		super();
		this.mobileId = mobileId;
		this.password = password;
		this.emailId = emailId;
	}


	public String getMobileId() {
		return mobileId;
	}

	public void setMobileId(String mobileId) {
		this.mobileId = mobileId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
}
