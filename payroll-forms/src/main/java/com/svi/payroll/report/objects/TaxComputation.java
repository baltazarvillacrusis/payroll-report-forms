package com.svi.payroll.report.objects;

import java.util.ArrayList;
import java.util.List;

public class TaxComputation {
	private double totalAmtCompensation;
	private double nonTaxableMWES;
	private double nonTaxableHONHPay;
	private double nonTaxableOthers;		
	private double requiredTaxWithheld;	
	private double taxRemittedInReturn;
	private double otherPaymentsMade;	
	private double surchargePenalty;
	private double interestPenalty;
	private double compromisePenalty;		
	private List<TaxAdjustment> taxAdjustments = new ArrayList<TaxAdjustment>();
	
	public TaxComputation(){
		
	}
	public TaxComputation(double totalAmtCompensation, double nonTaxableMWES,
			double nonTaxableHONHPay, double nonTaxableOthers,
			double requiredTaxWithheld, double taxRemittedInReturn,
			double otherPaymentsMade, double surchargePenalty,
			double interestPenalty, double compromisePenalty,
			List<TaxAdjustment> taxAdjustments) {
		this.totalAmtCompensation = totalAmtCompensation;
		this.nonTaxableMWES = nonTaxableMWES;
		this.nonTaxableHONHPay = nonTaxableHONHPay;
		this.nonTaxableOthers = nonTaxableOthers;
		this.requiredTaxWithheld = requiredTaxWithheld;
		this.taxRemittedInReturn = taxRemittedInReturn;
		this.otherPaymentsMade = otherPaymentsMade;
		this.surchargePenalty = surchargePenalty;
		this.interestPenalty = interestPenalty;
		this.compromisePenalty = compromisePenalty;
		this.taxAdjustments = taxAdjustments;
	}
	public double getTaxableCompensation() {
		return totalAmtCompensation-(nonTaxableMWES+nonTaxableHONHPay+nonTaxableOthers);
	}
	public double getRequiredTaxWithheldForRemittance() {
		return requiredTaxWithheld+getTotalAdjustments();
	}
	public double getTotalTaxPayment() {
		return taxRemittedInReturn+otherPaymentsMade;
	}
	public double getTaxStillDue() {
		return getRequiredTaxWithheldForRemittance()-getTotalTaxPayment();
	}
	public double getTotalPenalty() {
		return surchargePenalty+interestPenalty+compromisePenalty;
	}
	public double getTotalTaxStillDue() {
		return getTaxStillDue()+getTotalPenalty();
	}
	
	
	
	public double getTotalAmtCompensation() {
		return totalAmtCompensation;
	}
	public void setTotalAmtCompensation(double totalAmtCompensation) {
		this.totalAmtCompensation = totalAmtCompensation;
	}
	public double getNonTaxableMWES() {
		return nonTaxableMWES;
	}
	public void setNonTaxableMWES(double nonTaxableMWES) {
		this.nonTaxableMWES = nonTaxableMWES;
	}
	public double getNonTaxableHONHPay() {
		return nonTaxableHONHPay;
	}
	public void setNonTaxableHONHPay(double nonTaxableHONHPay) {
		this.nonTaxableHONHPay = nonTaxableHONHPay;
	}
	public double getNonTaxableOthers() {
		return nonTaxableOthers;
	}
	public void setNonTaxableOthers(double nonTaxableOthers) {
		this.nonTaxableOthers = nonTaxableOthers;
	}
	public double getRequiredTaxWithheld() {
		return requiredTaxWithheld;
	}
	public void setRequiredTaxWithheld(double requiredTaxWithheld) {
		this.requiredTaxWithheld = requiredTaxWithheld;
	}
	
	public double getTaxRemittedInReturn() {
		return taxRemittedInReturn;
	}
	public void setTaxRemittedInReturn(double taxRemittedInReturn) {
		this.taxRemittedInReturn = taxRemittedInReturn;
	}
	public double getOtherPaymentsMade() {
		return otherPaymentsMade;
	}
	public void setOtherPaymentsMade(double otherPaymentsMade) {
		this.otherPaymentsMade = otherPaymentsMade;
	}
	public double getSurchargePenalty() {
		return surchargePenalty;
	}
	public void setSurchargePenalty(double surchargePenalty) {
		this.surchargePenalty = surchargePenalty;
	}
	public double getInterestPenalty() {
		return interestPenalty;
	}
	public void setInterestPenalty(double interestPenalty) {
		this.interestPenalty = interestPenalty;
	}
	public double getCompromisePenalty() {
		return compromisePenalty;
	}
	public void setCompromisePenalty(double compromisePenalty) {
		this.compromisePenalty = compromisePenalty;
	}
	public List<TaxAdjustment> getTaxAdjustments() {
		return taxAdjustments;
	}
	public void setTaxAdjustments(List<TaxAdjustment> taxAdjustments) {
		this.taxAdjustments = taxAdjustments;
	}
	
	public double getTotalAdjustments(){
		double adjusmentTotal = 0.0;
		for(TaxAdjustment adjustment : taxAdjustments){
			adjusmentTotal = adjusmentTotal +adjustment.getAdjustmentFromCurrentYear()+adjustment.getAdjustmentFromYearToPrevYear();
		}
		return adjusmentTotal;
	}
	
	

}
