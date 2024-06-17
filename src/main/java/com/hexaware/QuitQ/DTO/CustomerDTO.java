package com.hexaware.QuitQ.DTO;


public class CustomerDTO {
	
	private String mobileNo;
	private String password;
	private String email;
	public CustomerDTO(String mobileNo, String password, String email) {
		super();
		this.mobileNo = mobileNo;
		this.password = password;
		this.email = email;
	}
	public CustomerDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getemail() {
		return email;
	}
	public void setemail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "CustomerDTO [mobileNo=" + mobileNo + ", password=" + password + ", email=" + email + "]";
	}

	
}
