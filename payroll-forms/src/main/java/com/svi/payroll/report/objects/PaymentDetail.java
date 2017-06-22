package com.svi.payroll.report.objects;

public class PaymentDetail {
	private TYPE type = TYPE.DEFAULT;
	private String draweeBankOrAgency;
	private String number = "";
	private String date = "";
	private double amount;
	
	public PaymentDetail(){
		
	}
	public PaymentDetail(TYPE type, String draweeBankOrAgency, String number,
			String date, double amount) {
		super();
		this.type = type;
		this.draweeBankOrAgency = draweeBankOrAgency;
		this.number = number;
		this.date = date;
		this.amount = amount;
	}
	public TYPE getType() {
		return type;
	}
	public void setType(TYPE type) {
		this.type = type;
	}
	public String getDraweeBankOrAgency() {
		return draweeBankOrAgency;
	}
	public void setDraweeBankOrAgency(String draweeBankOrAgency) {
		this.draweeBankOrAgency = draweeBankOrAgency;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}

	public enum TYPE {
	    CASH, CHECK, OTHERS, POSTAL_MONEY_ORDER,DEFAULT;	   
	}

}
