package com.rajesh.springboot.model;



public class Card {

	private String CardTpye;
	private String cardNumber;
	private String expiryDate;
	
	public String getCardTpye() {
				return CardTpye;
	}
	public void setCardTpye(String cardTpye) {
		CardTpye = cardTpye;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}
	@Override
	public String toString() {
		return "Card [CardTpye=" + CardTpye + ", cardNumber=" + cardNumber + ", expiryDate=" + expiryDate + "]";
	}
	
	
	
	
}
