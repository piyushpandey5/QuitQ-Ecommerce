package com.hexaware.QuitQ.DTO;

public class SellerDTO {
	
	
	private String mobileNo;
	
	private String email;

	private String password;

	@Override
	public String toString() {
		return "SellerDTO [mobile=" + mobileNo + ", email=" + email + ", password=" + password + "]";
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobile(String mobileNo) {
		this.mobileNo = mobileNo;
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

	public SellerDTO(String mobileNo, String email, String password) {
		super();
		this.mobileNo = mobileNo;
		this.email = email;
		this.password = password;
	}

	public SellerDTO() {
		super();
		// TODO Auto-generated constructor stub
	}	
}
