package com.svi.payroll.report.objects;

public class TaxSummary {
	private double taxableIncomeFromPreviousEmployer;
	private double totalExemptions;
	private double premiumsPaidOnHealth;
	private double taxDue;
	private double taxWithheldPresentEmployer;
	private double taxWithheldPreviousEmployer;
	private double totalTaxesWithheldAsAdjusted;
	
	public TaxSummary(){
		
	}
	public TaxSummary(double taxableIncomeFromPreviousEmployer,
			double totalExemptions, double premiumsPaidOnHealth, double taxDue,
			double taxWithheldPresentEmployer,
			double taxWithheldPreviousEmployer,
			double totalTaxesWithheldAsAdjusted) {
		super();
		this.taxableIncomeFromPreviousEmployer = taxableIncomeFromPreviousEmployer;
		this.totalExemptions = totalExemptions;
		this.premiumsPaidOnHealth = premiumsPaidOnHealth;
		this.taxDue = taxDue;
		this.taxWithheldPresentEmployer = taxWithheldPresentEmployer;
		this.taxWithheldPreviousEmployer = taxWithheldPreviousEmployer;
		this.totalTaxesWithheldAsAdjusted = totalTaxesWithheldAsAdjusted;
	}
	public double getTaxableIncomeFromPreviousEmployer() {
		return taxableIncomeFromPreviousEmployer;
	}
	public void setTaxableIncomeFromPreviousEmployer(
			double taxableIncomeFromPreviousEmployer) {
		this.taxableIncomeFromPreviousEmployer = taxableIncomeFromPreviousEmployer;
	}
	public double getTotalExemptions() {
		return totalExemptions;
	}
	public void setTotalExemptions(double totalExemptions) {
		this.totalExemptions = totalExemptions;
	}
	public double getPremiumsPaidOnHealth() {
		return premiumsPaidOnHealth;
	}
	public void setPremiumsPaidOnHealth(double premiumsPaidOnHealth) {
		this.premiumsPaidOnHealth = premiumsPaidOnHealth;
	}
	public double getTaxDue() {
		return taxDue;
	}
	public void setTaxDue(double taxDue) {
		this.taxDue = taxDue;
	}
	public double getTaxWithheldPresentEmployer() {
		return taxWithheldPresentEmployer;
	}
	public void setTaxWithheldPresentEmployer(double taxWithheldPresentEmployer) {
		this.taxWithheldPresentEmployer = taxWithheldPresentEmployer;
	}
	public double getTaxWithheldPreviousEmployer() {
		return taxWithheldPreviousEmployer;
	}
	public void setTaxWithheldPreviousEmployer(double taxWithheldPreviousEmployer) {
		this.taxWithheldPreviousEmployer = taxWithheldPreviousEmployer;
	}
	public double getTotalTaxesWithheldAsAdjusted() {
		return totalTaxesWithheldAsAdjusted;
	}
	public void setTotalTaxesWithheldAsAdjusted(double totalTaxesWithheldAsAdjusted) {
		this.totalTaxesWithheldAsAdjusted = totalTaxesWithheldAsAdjusted;
	}
	

}
