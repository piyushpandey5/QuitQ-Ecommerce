package com.hexaware.QuitQ.DTO;

import com.hexaware.QuitQ.entity.CreditCard;

public class OrderDTO {
	
	private CreditCard cardNumber;

	private String addressType;
	public OrderDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderDTO(CreditCard cardNumber, String addressType) {
		super();
		this.cardNumber = cardNumber;
		this.addressType = addressType;
	}
	public CreditCard getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(CreditCard cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getAddressType() {
		return addressType;
	}
	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}
}
