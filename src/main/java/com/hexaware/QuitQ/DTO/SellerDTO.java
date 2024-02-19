package com.hexaware.QuitQ.DTO;

public class SellerDTO {
	
	
	private String mobile;
	
	
	private String password;
	
	
	public SellerDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	


	public SellerDTO(String mobile, String password) {
		super();
		this.mobile = mobile;
		this.password = password;
	}




	public String getMobile() {
		return mobile;
	}


	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
}
