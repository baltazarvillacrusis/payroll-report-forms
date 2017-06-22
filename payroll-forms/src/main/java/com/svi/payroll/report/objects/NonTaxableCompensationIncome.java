package com.svi.payroll.report.objects;

public class NonTaxableCompensationIncome {
	private double basicSalaryMWE;	// yearly	
	private double holidayPayMWE;
	private double overtimePayMWE;
	private double nightShiftDiffMWE;
	private double hazardPayMWE;
	private double thirteenthMonthAndOtherBenefits;
	private double deMinimis;
	private double contributionsAndUnionDues;
	private double otherFormsOfCompensation;
	
	public NonTaxableCompensationIncome(){
		
	}
	public NonTaxableCompensationIncome(double basicSalaryMWE,
			double holidayPayMWE, double overtimePayMWE,
			double nightShiftDiffMWE, double hazardPayMWE,
			double thirteenthMonthAndOtherBenefits, double deMinimis,
			double contributionsAndUnionDues, double otherFormsOfCompensation) {	
		this.basicSalaryMWE = basicSalaryMWE;
		this.holidayPayMWE = holidayPayMWE;
		this.overtimePayMWE = overtimePayMWE;
		this.nightShiftDiffMWE = nightShiftDiffMWE;
		this.hazardPayMWE = hazardPayMWE;
		this.thirteenthMonthAndOtherBenefits = thirteenthMonthAndOtherBenefits;
		this.deMinimis = deMinimis;
		this.contributionsAndUnionDues = contributionsAndUnionDues;
		this.otherFormsOfCompensation = otherFormsOfCompensation;
	}
	
	public double getBasicSalarySMWE() {
		return basicSalaryMWE;
	}
	public void setBasicSalarySMWE(double basicSalary) {
		this.basicSalaryMWE = basicSalary;
	}
	public double getHolidayPayMWE() {
		return holidayPayMWE;
	}
	public void setHolidayPayMWE(double holidayPay) {
		this.holidayPayMWE = holidayPay;
	}
	public double getOvertimePayMWE() {
		return overtimePayMWE;
	}
	public void setOvertimePayMWE(double overtimePay) {
		this.overtimePayMWE = overtimePay;
	}
	public double getNightShiftDiffMWE() {
		return nightShiftDiffMWE;
	}
	public void setNightShiftDiffMWE(double nightShiftDiff) {
		this.nightShiftDiffMWE = nightShiftDiff;
	}
	public double getHazardPayMWE() {
		return hazardPayMWE;
	}
	public void setHazardPayMWE(double hazardPay) {
		this.hazardPayMWE = hazardPay;
	}
	public double getThirteenthMonthAndOtherBenefits() {
		return thirteenthMonthAndOtherBenefits;
	}
	public void setThirteenthMonthAndOtherBenefits(
			double thirteenthMonthAndOtherBenefits) {
		this.thirteenthMonthAndOtherBenefits = thirteenthMonthAndOtherBenefits;
	}
	public double getDeMinimis() {
		return deMinimis;
	}
	public void setDeMinimis(double deMinimis) {
		this.deMinimis = deMinimis;
	}
	public double getContributionsAndUnionDues() {
		return contributionsAndUnionDues;
	}
	public void setContributionsAndUnionDues(double contributionsAndUnionDues) {
		this.contributionsAndUnionDues = contributionsAndUnionDues;
	}
	public double getOtherFormsOfCompensation() {
		return otherFormsOfCompensation;
	}
	public void setOtherFormsOfCompensation(double otherFormsOfCompensation) {
		this.otherFormsOfCompensation = otherFormsOfCompensation;
	}
	public double getTotal() {
		return sumNonTaxable();
	}
	private double sumNonTaxable(){
		double total = basicSalaryMWE + holidayPayMWE + overtimePayMWE + nightShiftDiffMWE
				+ hazardPayMWE + thirteenthMonthAndOtherBenefits + deMinimis + contributionsAndUnionDues
				+otherFormsOfCompensation;
		return total;
	}



}
