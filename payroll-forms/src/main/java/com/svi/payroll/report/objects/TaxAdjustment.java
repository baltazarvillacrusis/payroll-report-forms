package com.svi.payroll.report.objects;

public class TaxAdjustment {
	private String previousMonth  = ""; //MMYYYY
	private String datePaid  = ""; //MMDDYYYY
	private String bankValidationNum  = "";
	private String bankCode  = "";
	private double taxPaid;
	private double taxDue;
	private double adjustmentFromCurrentYear;
	private double adjustmentFromYearToPrevYear;
	
	public TaxAdjustment(){
		
	}
	public TaxAdjustment(String previousMonth, String datePaid,
			String bankValidationNum, String bankCode, double taxPaid,
			double taxDue, double adjustmentFromCurrentYear,
			double adjustmentFromYearToPrevYear) {
		super();
		this.previousMonth = previousMonth;
		this.datePaid = datePaid;
		this.bankValidationNum = bankValidationNum;
		this.bankCode = bankCode;
		this.taxPaid = taxPaid;
		this.taxDue = taxDue;
		this.adjustmentFromCurrentYear = adjustmentFromCurrentYear;
		this.adjustmentFromYearToPrevYear = adjustmentFromYearToPrevYear;
	}
	public String getPreviousMonth() {
		return previousMonth;
	}
	public void setPreviousMonth(String previuousMonth) {
		this.previousMonth = previuousMonth;
	}
	public String getDatePaid() {
		return datePaid;
	}
	public void setDatePaid(String datePaid) {
		this.datePaid = datePaid;
	}
	public String getBankValidationNum() {
		return bankValidationNum;
	}
	public void setBankValidationNum(String bankValidationNum) {
		this.bankValidationNum = bankValidationNum;
	}
	public String getBankCode() {
		return bankCode;
	}
	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}
	public double getTaxPaid() {
		return taxPaid;
	}
	public void setTaxPaid(double taxPaid) {
		this.taxPaid = taxPaid;
	}
	public double getTaxDue() {
		return taxDue;
	}
	public void setTaxDue(double taxDue) {
		this.taxDue = taxDue;
	}
	public double getAdjustmentFromCurrentYear() {
		return adjustmentFromCurrentYear;
	}
	public void setAdjustmentFromCurrentYear(double adjustmentFromCurrentYear) {
		this.adjustmentFromCurrentYear = adjustmentFromCurrentYear;
	}
	public double getAdjustmentFromYearToPrevYear() {
		return adjustmentFromYearToPrevYear;
	}
	public void setAdjustmentFromYearToPrevYear(double adjustmentFromYearToPrevYear) {
		this.adjustmentFromYearToPrevYear = adjustmentFromYearToPrevYear;
	}
	

}
