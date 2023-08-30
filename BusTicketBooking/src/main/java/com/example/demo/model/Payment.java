package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="paymentdetails")
public class Payment {

	@Id
	private int paymentid;
	
	private String type;
	
	private int amount;

	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Payment(int paymentid, String type, int amount) {
		super();
		this.paymentid = paymentid;
		this.type = type;
		this.amount = amount;
	}

	public int getPaymentid() {
		return paymentid;
	}

	public void setPaymentid(int paymentid) {
		this.paymentid = paymentid;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	
	
}
