package com.svi.payroll.report.objects;

import java.util.HashMap;
import java.util.Map;

public class TaxableCompensationIncome {
	private double basicSalary;
	private double representation;
	private double transportation;
	private double costOfLivingAllowance;
	private double fixedHousingAllow;
	private double commission;
	private double profitSharing;
	private double fees;
	private double taxable13thMonthAndOtherBenefits;
	private double overtimePay;
	private double hazarddPay;
	private double salaryAndOtherCompenstion;
	private Map<String,Double> taxableOthers = new HashMap<String,Double>();
	private Map<String,Double> supplementaryOthers = new HashMap<String,Double>();	
	
	public TaxableCompensationIncome(){
		
	}
	
	public TaxableCompensationIncome(double basicSalary, double representation,
			double transportation, double costOfLivingAllowance,
			double fixedHousingAllow, double commission, double profitSharing,
			double fees, double taxable13thMonthAndOtherBenefits,
			double overtimePay, double hazarddPay,
			Map<String, Double> taxableOthers,
			Map<String, Double> supplementaryOthers) {
		super();
		this.basicSalary = basicSalary;
		this.representation = representation;
		this.transportation = transportation;
		this.costOfLivingAllowance = costOfLivingAllowance;
		this.fixedHousingAllow = fixedHousingAllow;
		this.commission = commission;
		this.profitSharing = profitSharing;
		this.fees = fees;
		this.taxable13thMonthAndOtherBenefits = taxable13thMonthAndOtherBenefits;
		this.overtimePay = overtimePay;
		this.hazarddPay = hazarddPay;
		this.taxableOthers = taxableOthers;
		this.supplementaryOthers = supplementaryOthers;
	}
	public double getBasicSalary() {
		return basicSalary;
	}
	public void setBasicSalary(double basicSalary) {
		this.basicSalary = basicSalary;
	}
	public double getRepresentation() {
		return representation;
	}
	public void setRepresentation(double representation) {
		this.representation = representation;
	}
	public double getTransportation() {
		return transportation;
	}
	public void setTransportation(double transportation) {
		this.transportation = transportation;
	}
	public double getCostOfLivingAllowance() {
		return costOfLivingAllowance;
	}
	public void setCostOfLivingAllowance(double costOfLivingAllowance) {
		this.costOfLivingAllowance = costOfLivingAllowance;
	}
	public double getFixedHousingAllow() {
		return fixedHousingAllow;
	}
	public void setFixedHousingAllow(double fixedHousingAllow) {
		this.fixedHousingAllow = fixedHousingAllow;
	}
	public double getCommission() {
		return commission;
	}
	public void setCommission(double commission) {
		this.commission = commission;
	}
	public double getProfitSharing() {
		return profitSharing;
	}
	public void setProfitSharing(double profitSharing) {
		this.profitSharing = profitSharing;
	}
	public double getFees() {
		return fees;
	}
	public void setFees(double fees) {
		this.fees = fees;
	}
	public double getTaxable13thMonthAndOtherBenefits() {
		return taxable13thMonthAndOtherBenefits;
	}
	public void setTaxable13thMonthAndOtherBenefits(
			double taxable13thMonthAndOtherBenefits) {
		this.taxable13thMonthAndOtherBenefits = taxable13thMonthAndOtherBenefits;
	}
	public double getOvertimePay() {
		return overtimePay;
	}
	public void setOvertimePay(double overtimePay) {
		this.overtimePay = overtimePay;
	}
	public double getHazarddPay() {
		return hazarddPay;
	}
	public void setHazarddPay(double hazarddPay) {
		this.hazarddPay = hazarddPay;
	}
	public Map<String, Double> getTaxableOthers() {
		return taxableOthers;
	}
	public void setTaxableOthers(Map<String, Double> taxableOthers) {
		this.taxableOthers = taxableOthers;
	}
	public Map<String, Double> getSupplementaryOthers() {
		return supplementaryOthers;
	}
	public void setSupplementaryOthers(Map<String, Double> supplementaryOthers) {
		this.supplementaryOthers = supplementaryOthers;
	}
	
	public double getTotal(){
		double total = basicSalary + representation +transportation + costOfLivingAllowance
				+ fixedHousingAllow + commission + profitSharing + fees
				+ taxable13thMonthAndOtherBenefits + overtimePay +  hazarddPay;
		
		if(taxableOthers != null){
			for (Map.Entry<String, Double> entry : taxableOthers.entrySet())			{
			    total = total + entry.getValue();
			}
		}
		
		if(supplementaryOthers != null){
			for (Map.Entry<String, Double> entry : supplementaryOthers.entrySet())			{
			    total = total + entry.getValue();
			}
		}
				
		return total;
	}

	public double getSalaryAndOtherCompenstion() {
		return salaryAndOtherCompenstion;
	}

	public void setSalaryAndOtherCompenstion(double salaryAndOtherCompenstion) {
		this.salaryAndOtherCompenstion = salaryAndOtherCompenstion;
	}

	/*public double getTotalLessBasic() {
		return getTotal()-basicSalary;
	}
	public double getTotalLessBasicAnd13th() {
		return getTotal()-basicSalary-taxable13thMonthAndOtherBenefits;
	}
*/
	
	
}
