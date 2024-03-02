package com.example.model;

import java.time.LocalDate;

import jakarta.persistence.Column;

public class PaymentInformation {

	@Column(name="cardholder_name")
	private String cardholderName;
	
	@Column(name="card_name")
	private String cardName;
	
	@Column(name="expiration_date")
	private LocalDate expirationDate;
	
	@Column(name="cvv")
	private String cvv;
	
}
