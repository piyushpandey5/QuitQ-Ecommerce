package com.hexaware.QuitQ.entity;

public class CreditCard {
	
	private String cardNumber;
	
	private String cardValidity;
	
	private String cardCVV;

	public CreditCard() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CreditCard(String cardNumber, String cardValidity,String cardCVV) {
		super();
		this.cardNumber = cardNumber;
		this.cardValidity = cardValidity;
		this.cardCVV = cardCVV;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getCardValidity() {
		return cardValidity;
	}

	public void setCardValidity(String cardValidity) {
		this.cardValidity = cardValidity;
	}

	public String getCardCVV() {
		return cardCVV;
	}

	public void setCardCVV(String cardCVV) {
		this.cardCVV = cardCVV;
	}
	
	
	
}
