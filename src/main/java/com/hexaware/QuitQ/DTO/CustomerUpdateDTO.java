package com.hexaware.QuitQ.DTO;

import java.util.HashMap;
import java.util.Map;

import com.hexaware.QuitQ.entity.Address;

public class CustomerUpdateDTO {
	private String firstName;
	
	private String lastName;
	
	private String mobileNo;
	
	private String emailId;
	
	private String password;
	
	private Map<String, Address> address = new HashMap<>();

	public CustomerUpdateDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustomerUpdateDTO(String firstName, String lastName, String mobileNo,String emailId,String password,	Map<String, Address> address) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNo = mobileNo;
		this.emailId = emailId;
		this.password = password;
		this.address = address;
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

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Map<String, Address> getAddress() {
		return address;
	}

	public void setAddress(Map<String, Address> address) {
		this.address = address;
	}
	
}
