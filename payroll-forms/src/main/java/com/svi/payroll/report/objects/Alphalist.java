package com.svi.payroll.report.objects;


public class Alphalist {
	private String tin = "";
	private String lastName = "";
	private String firstName = "";
	private String middleName = "";
	private String address = "";
	private String residenceStatus = "";
	private String atc = "";
	private String natureOfIncomePayment = "";
	private String exemptionCode = "";
	private String regionNumber = "";	
	private String dateOfEmploymentFrom = "";
	private String dateOfEmploymentTo = "";
	private double amountOfIncomePayment;
	private double rateOfTax;
	private double amountOfTaxWithhled;
	private double taxWithheldFringe;
	private double amountOfFringeBenefit;
	private double grossedUpMonetaryValue;
	private double grossCompensationIncomePresent;
	private double grossCompensationIncomePrevious;	
	private double exemptionAmount;
	private double premiumPaidOnHealth;
	private double netTaxableCompensationIncome;
	private double taxDue;
	private double taxWithheldJanToNovPresent;
	private double taxWithheldJanToNovPrevious;
	private Boolean substitutedFiling;	
	private double factorUsed;		
	private TaxableCompensationIncome presentEmployerTaxable = new TaxableCompensationIncome();
	private TaxableCompensationIncome previousEmployerTaxable  = new TaxableCompensationIncome();
	private NonTaxableCompensationIncome presentEmployerNonTaxable  = new NonTaxableCompensationIncome();
	private NonTaxableCompensationIncome previousEmployerNonTaxable = new NonTaxableCompensationIncome();		
	private boolean rankAndFile;
	private boolean withPreviousEmployer;
	private boolean terminatedBeforeEndOfYear;
	private boolean minimumWageEarner;
	
	
	public String getTin() {
		return tin;
	}
	public void setTin(String tin) {
		this.tin = tin;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getResidenceStatus() {
		return residenceStatus;
	}
	public void setResidenceStatus(String residenceStatus) {
		this.residenceStatus = residenceStatus;
	}
	public String getAtc() {
		return atc;
	}
	public void setAtc(String atc) {
		this.atc = atc;
	}
	public String getNatureOfIncomePayment() {
		return natureOfIncomePayment;
	}
	public void setNatureOfIncomePayment(String natureOfIncomePayment) {
		this.natureOfIncomePayment = natureOfIncomePayment;
	}
	public double getAmountOfIncomePayment() {
		return amountOfIncomePayment;
	}
	public void setAmountOfIncomePayment(double amountOfIncomePayment) {
		this.amountOfIncomePayment = amountOfIncomePayment;
	}
	public double getRateOfTax() {
		return rateOfTax;
	}
	public void setRateOfTax(double rateOfTax) {
		this.rateOfTax = rateOfTax;
	}
	public double getAmountOfTaxWithhled() {
		return amountOfTaxWithhled;
	}
	public void setAmountOfTaxWithhled(double amountOfTaxWithhled) {
		this.amountOfTaxWithhled = amountOfTaxWithhled;
	}
	public double getAmountOfFringeBenefit() {
		return amountOfFringeBenefit;
	}
	public void setAmountOfFringeBenefit(double amountOfFringeBenefit) {
		this.amountOfFringeBenefit = amountOfFringeBenefit;
	}
	public double getGrossedUpMonetaryValue() {
		return grossedUpMonetaryValue;
	}
	public void setGrossedUpMonetaryValue(double grossedUpMonetaryValue) {
		this.grossedUpMonetaryValue = grossedUpMonetaryValue;
	}
	public double getGrossCompensationIncomePresent() {
		return grossCompensationIncomePresent;
	}
	public void setGrossCompensationIncomePresent(double grossCompensationIncomePresent) {
		this.grossCompensationIncomePresent = grossCompensationIncomePresent;
	}
	
	public String getExemptionCode() {
		return exemptionCode;
	}
	public void setExemptionCode(String exemptionCode) {
		this.exemptionCode = exemptionCode;
	}
	public double getExemptionAmount() {
		return exemptionAmount;
	}
	public void setExemptionAmount(double exemptionAmount) {
		this.exemptionAmount = exemptionAmount;
	}
	public double getPremiumPaidOnHealth() {
		return premiumPaidOnHealth;
	}
	public void setPremiumPaidOnHealth(double premiumPaidOnHealth) {
		this.premiumPaidOnHealth = premiumPaidOnHealth;
	}
	public double getNetTaxableCompensationIncome() {
		return netTaxableCompensationIncome;
	}
	public void setNetTaxableCompensationIncome(double netTaxableCompensationIncome) {
		this.netTaxableCompensationIncome = netTaxableCompensationIncome;
	}
	public double getTaxDue() {
		return taxDue;
	}
	public void setTaxDue(double taxDue) {
		this.taxDue = taxDue;
	}


	public String getRegionNumber() {
		return regionNumber;
	}
	public void setRegionNumber(String regionNumber) {
		this.regionNumber = regionNumber;
	}
	
	public double getFactorUsed() {
		return factorUsed;
	}
	public void setFactorUsed(double factorUsed) {
		this.factorUsed = factorUsed;
	}
	
	public TaxableCompensationIncome getPresentEmployerTaxable() {
		return presentEmployerTaxable;
	}
	public void setPresentEmployerTaxable(
			TaxableCompensationIncome presentEmployerTaxable) {
		this.presentEmployerTaxable = presentEmployerTaxable;
	}
	public TaxableCompensationIncome getPreviousEmployerTaxable() {
		return previousEmployerTaxable;
	}
	public void setPreviousEmployerTaxable(
			TaxableCompensationIncome previousEmployerTaxable) {
		this.previousEmployerTaxable = previousEmployerTaxable;
	}
	public NonTaxableCompensationIncome getPresentEmployerNonTaxable() {
		return presentEmployerNonTaxable;
	}
	public void setPresentEmployerNonTaxable(
			NonTaxableCompensationIncome presentEmployerNonTaxable) {
		this.presentEmployerNonTaxable = presentEmployerNonTaxable;
	}
	public NonTaxableCompensationIncome getPreviousEmployerNonTaxable() {
		return previousEmployerNonTaxable;
	}
	public void setPreviousEmployerNonTaxable(
			NonTaxableCompensationIncome previousEmployerNonTaxable) {
		this.previousEmployerNonTaxable = previousEmployerNonTaxable;
	}
	public double getTaxWithheldJanToNovPresent() {
		return taxWithheldJanToNovPresent;
	}
	public void setTaxWithheldJanToNovPresent(double taxWithheldJanToNovPresent) {
		this.taxWithheldJanToNovPresent = taxWithheldJanToNovPresent;
	}
	public double getTaxWithheldJanToNovPrevious() {
		return taxWithheldJanToNovPrevious;
	}
	public void setTaxWithheldJanToNovPrevious(double taxWithheldJanToNovPrevious) {
		this.taxWithheldJanToNovPrevious = taxWithheldJanToNovPrevious;
	}
	public double getGrossCompensationIncomePrevious() {
		return grossCompensationIncomePrevious;
	}
	public void setGrossCompensationIncomePrevious(
			double grossCompensationIncomePrevious) {
		this.grossCompensationIncomePrevious = grossCompensationIncomePrevious;
	}
	public String getDateOfEmploymentFrom() {
		return dateOfEmploymentFrom;
	}
	public void setDateOfEmploymentFrom(String dateOfEmploymentFrom) {
		this.dateOfEmploymentFrom = dateOfEmploymentFrom;
	}
	public String getDateOfEmploymentTo() {
		return dateOfEmploymentTo;
	}
	public void setDateOfEmploymentTo(String dateOfEmploymentTo) {
		this.dateOfEmploymentTo = dateOfEmploymentTo;
	}
	public boolean isRankAndFile() {
		return rankAndFile;
	}
	public void setRankAndFile(boolean rankAndFile) {
		this.rankAndFile = rankAndFile;
	}

	public double getTaxWithheldFringe() {
		return taxWithheldFringe;
	}
	public void setTaxWithheldFringe(double taxWithheldFringe) {
		this.taxWithheldFringe = taxWithheldFringe;
	}

	public Boolean getSubstitutedFiling() {
		return substitutedFiling;
	}
	public void setSubstitutedFiling(Boolean substitutedFiling) {
		this.substitutedFiling = substitutedFiling;
	}
	public String getCompleteName() {
		if((lastName+firstName+middleName).trim().length() == 0){
			return "";
		}		
		return lastName+", "+firstName+" "+middleName;
	}
	public boolean isWithPreviousEmployer() {
		return withPreviousEmployer;
	}
	public void setWithPreviousEmployer(boolean withPreviousEmployer) {
		this.withPreviousEmployer = withPreviousEmployer;
	}
	public boolean isTerminatedBeforeEndOfYear() {
		return terminatedBeforeEndOfYear;
	}
	public void setTerminatedBeforeEndOfYear(boolean terminatedBeforeEndOfYear) {
		this.terminatedBeforeEndOfYear = terminatedBeforeEndOfYear;
	}
	public boolean isMinimumWageEarner() {
		return minimumWageEarner;
	}
	public void setMinimumWageEarner(boolean minimumWageEarner) {
		this.minimumWageEarner = minimumWageEarner;
	}

	
}
