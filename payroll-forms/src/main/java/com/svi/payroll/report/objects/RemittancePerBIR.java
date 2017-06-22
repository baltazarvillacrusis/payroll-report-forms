package com.svi.payroll.report.objects;


public class RemittancePerBIR {
	private String date = "";
	private String nameOfBankOrBankCode = ""; // or  ROR No. if any
	private double taxesWithheld;
	private double adjustment;
	private double  penalties;	
	private MONTH month;	
	private int indexOrder;	
	private double totalAmount;
	private QUARTER quarter;	
	
	public RemittancePerBIR(){
		
	}
	public enum MONTH{
		JANUARY(1),
		FEBRUARY(2),
		MARCH(3),
		APRIL(4),
		MAY(5),
		JUNE(6),
		JULY(7),
		AUGUST(8),
		SEPTEMBER(9),
		OCTOBER(10),
		NOVEMBER(11),
		DECEMBER(12);
		
		private int value;		
		MONTH(int value){
			this.value = value;
		}
		public int getValue(){			
			return this.value;
		}
	}
	public enum QUARTER{
		FIRST_QUARTER(1),
		SECOND_QUARTER(2),
		THIRD_QUARTER(3),
		FOURTH_QUARTER(4);
		
		private int value;		
		QUARTER(int value){
			this.value = value;
		}
		public int getValue(){
			return this.value;
		}
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getNameOfBankOrBankCode() {
		return nameOfBankOrBankCode;
	}

	public void setNameOfBankOrBankCode(String nameOfBankOrBankCode) {
		this.nameOfBankOrBankCode = nameOfBankOrBankCode;
	}

	public double getTaxesWithheld() {
		return taxesWithheld;
	}

	public void setTaxesWithheld(double taxesWithheld) {
		this.taxesWithheld = taxesWithheld;
	}

	public double getAdjustment() {
		return adjustment;
	}

	public void setAdjustment(double adjustment) {
		this.adjustment = adjustment;
	}

	public double getPenalties() {
		return penalties;
	}

	public void setPenalties(double penalties) {
		
		this.penalties = penalties;
	}

	public double getTotalAmount() {
		totalAmount = penalties+taxesWithheld+adjustment;
		return totalAmount;
	}

	public MONTH getMonth() {
		return month;
	}

	public void setMonth(MONTH month) {
		this.month = month;
		this.indexOrder = month.getValue();
	}

	public int getIndexOrder() {
		return indexOrder;
	}
	public QUARTER getQuarter() {		
		return quarter;
	}
	
	public void setQuarter(QUARTER quarter) {
		this.indexOrder = quarter.getValue();
		this.quarter = quarter;
	}

	public String getQuarterEquivalent() {			
		if(quarter == QUARTER.FIRST_QUARTER){
			return "1st QTR";
		}
		else if(quarter == QUARTER.SECOND_QUARTER){
			return "2nd QTR";
		}
		else if(quarter == QUARTER.THIRD_QUARTER){
			return "3rd QTR";
		}
		else if(quarter == QUARTER.FOURTH_QUARTER){
			return "4th QTR";
		}
		else{
			return "";
		}
	}

	
	
	

}
