package com.svi.report.utilities;

import java.util.Map;

import com.svi.payroll.report.objects.Alphalist;
import com.svi.payroll.report.objects.Employee;
import com.svi.payroll.report.objects.Employer;
import com.svi.payroll.report.objects.NonTaxableCompensationIncome;
import com.svi.payroll.report.objects.TaxableCompensationIncome;
import com.svi.payroll.report.objects.Employee.SEX;
import com.svi.payroll.report.objects.Employee.STATUS;

public class EmployeeFactory {
	
	/**
	 * Creates employee object for bank register salary loan repayments.
	 * @param ID
	 * @param firstName
	 * @param middleName
	 * @param lastName
	 * @param bankAcctNum
	 * @param bankName
	 * @param netPay
	 * @param loanName
	 * @return
	 */
	public static Employee bankRegisterLoanRepaymentEmployee(String ID, String firstName, String middleName,
		String lastName, String bankAcctNum, String bankName, double netPay, String loanName){
		
		Employee employee = new Employee();
		employee.setID(ID);
		employee.setFirstName(firstName);
		employee.setMiddleName(middleName);
		employee.setLastName(lastName);
		employee.setBankAcctNum(bankAcctNum);
		employee.setBankName(bankName);
		employee.setNetPay(netPay);
		employee.setLoanName(loanName);		
		
		return employee;
	}
	/**
	 * Creates employee object for BIR form 2316.
	 * @param birthDate
	 * @param foreignAdd
	 * @param foreignAddZipCode
	 * @param localAdd
	 * @param localAddZipCode
	 * @param registeredAdd
	 * @param registeredAddZipCode
	 * @param isMinimumWageEarner
	 * @param name
	 * @param rdoCode
	 * @param isSingle
	 * @param smwRatePerDay
	 * @param smwRatePerMonth
	 * @param telNum
	 * @param tin
	 * @param isWifeClaimingExemption
	 * @param ctcNum
	 * @param ctcPlaceOfIssue
	 * @param ctcDateOfIssue
	 * @param ctcAmountPaid
	 * @param dependents
	 * @param presentEmployer
	 * @param previousEmployer
	 * @return
	 */
	public static Employee birForm2316Employee(String birthDate, String foreignAdd, String foreignAddZipCode, 
		String localAdd, String localAddZipCode,String registeredAdd,String registeredAddZipCode,
		boolean isMinimumWageEarner, String name, String rdoCode, boolean isSingle, double smwRatePerDay,
		double smwRatePerMonth, String telNum, String tin,  boolean isWifeClaimingExemption, String ctcNum,
		String ctcPlaceOfIssue, String ctcDateOfIssue, double ctcAmountPaid,Map<String,String> dependents,
		Employer presentEmployer, Employer previousEmployer){
		
		Employee employee = new Employee();
		employee.setBirthDate(birthDate);
		employee.setForeignAdd(foreignAdd);
		employee.setForeignAddZipCode(foreignAddZipCode);
		employee.setLocalAdd(localAdd);
		employee.setLocalAddZipCode(localAddZipCode);
		employee.setRegisteredAdd(registeredAdd);
		employee.setRegisteredAddZipCode(registeredAddZipCode);
		employee.setIsMinimumWageEarner(isMinimumWageEarner);
		employee.setName(name);
		employee.setRdoCode(rdoCode);
		employee.setIsSingle(isSingle);
		employee.setSmwRatePerDay(smwRatePerDay);
		employee.setSmwRatePerMonth(smwRatePerMonth);
		employee.setTelNum(telNum);
		employee.setTin(tin);
		employee.setIsWifeClaimingExemption(isWifeClaimingExemption);
		employee.setCtcNum(ctcNum);
		employee.setCtcPlaceOfIssue(ctcPlaceOfIssue);
		employee.setCtcDateOfIssue(ctcDateOfIssue);
		employee.setCtcAmountPaid(ctcAmountPaid);
		employee.setDependents(dependents);
		employee.setPresentEmployer(presentEmployer);
		employee.setPreviousEmployer(previousEmployer);
		
		return employee;
	}
	
	/**
	 * Creates employee object for HDMF STLR Form.
	 * @param pagibigMIDNumber
	 * @param applicationNum
	 * @param firstName
	 * @param middleName
	 * @param lastName
	 * @param extensionName
	 * @param loanType
	 * @param amount
	 * @param pagibigRemark
	 * @return
	 */
	public static Employee hdmfSTLRFEmployee( String pagibigMIDNumber, String applicationNum, String firstName, String middleName,
		String lastName, String extensionName,  String loanType, double amount,  String pagibigRemark){		
		
		Employee employee = new Employee();
		employee.setPagibigMIDNumber(pagibigMIDNumber);
		employee.setApplicationNum(applicationNum);
		employee.setFirstName(firstName);
		employee.setMiddleName(middleName);
		employee.setLastName(lastName);
		employee.setExtensionName(extensionName);
		employee.setLoanType(loanType);
		employee.setAmount(amount);
		employee.setPagibigRemark(pagibigRemark);		
		
		return employee;
	}
	
	/**
	 * Creates employee object for HDMF MCRF Form.
	 * @param pagibigMIDNumber
	 * @param pagibigAcccountNumber
	 * @param firstName
	 * @param middleName
	 * @param lastName
	 * @param extensionName
	 * @param pagibigPeriodCovered
	 * @param monthlyCompensation
	 * @param pagibigEEShare
	 * @param pagibigERShare
	 * @param pagibigMembershipProgram
	 * @param pagibigRemark
	 * @return
	 */
	public static Employee hdmfMCRFEmployee( String pagibigMIDNumber, String pagibigAcccountNumber, String firstName, String middleName,
		String lastName, String extensionName, String pagibigPeriodCovered, double monthlyCompensation,double pagibigEEShare, 
		double pagibigERShare, String pagibigMembershipProgram, String pagibigRemark){		
		
		Employee employee = new Employee();		
		employee.setPagibigMIDNumber(pagibigMIDNumber);	
		employee.setPagibigAcccountNumber(pagibigAcccountNumber);
		employee.setFirstName(firstName);
		employee.setMiddleName(middleName);
		employee.setLastName(lastName);
		employee.setExtensionName(extensionName);		
		employee.setPagibigPeriodCovered(pagibigPeriodCovered);
		employee.setMonthlyCompensation(monthlyCompensation);	
		employee.setPagibigEEShare(pagibigEEShare);
		employee.setPagibigERShare(pagibigERShare);
		employee.setPagibigMembershipProgram(pagibigMembershipProgram);
		employee.setPagibigRemark(pagibigRemark);		
		
		return employee;
	}
	
	/**
	 * Creates employee object for net pay register for banks.
	 * @param ID
	 * @param firstName
	 * @param middleName
	 * @param lastName
	 * @param bankAcctNum
	 * @param bankName
	 * @param netPay
	 * @return
	 */
	public static Employee netPayRegisterForBankEmployee(String ID, String firstName, String middleName,
		String lastName, String bankAcctNum, String bankName, double netPay){
		
		Employee employee = new Employee();
		employee.setID(ID);
		employee.setFirstName(firstName);
		employee.setMiddleName(middleName);
		employee.setLastName(lastName);			
		employee.setBankAcctNum(bankAcctNum);
		employee.setBankName(bankName);			
		employee.setNetPay(netPay);			
		
		return employee;
	}
	
	/**
	 * Creates employee object for PhilHealth RF1
	 * @param firstName
	 * @param middleName
	 * @param lastName
	 * @param extensionName
	 * @param birthDate
	 * @param monthlySalaryBracket
	 * @param personalSharePhil
	 * @param employerSharePhil
	 * @param effectivityDate
	 * @param sex
	 * @param status
	 * @param pin
	 * @return
	 */
	public static Employee philHealthRF1Employee(String firstName, String middleName,
		String lastName, String extensionName, String birthDate, int monthlySalaryBracket, double personalSharePhil, double employerSharePhil,
		String effectivityDate, SEX sex, STATUS status, String pin ){
		
		Employee employee = new Employee();		
		employee.setFirstName(firstName);
		employee.setMiddleName(middleName);
		employee.setLastName(lastName);			
		employee.setExtensionName(extensionName);		
		employee.setBirthDate(birthDate);
		employee.setMonthlySalaryBracket(monthlySalaryBracket);
		employee.setPersonalSharePhil(personalSharePhil);
		employee.setEmployerSharePhil(employerSharePhil);
		employee.setEffectivityDate(effectivityDate);
		employee.setSex(sex);
		employee.setStatus(status);
		employee.setPin(pin);
		
		return employee;
	}
	/**
	 * Creates employee object for alphalist used in schedule 5 as attachment to BIR form 1604 CF.
	 * @param lastName
	 * @param firstName
	 * @param middleName
	 * @param tin
	 * @param address
	 * @param residenceStatus
	 * @param atc
	 * @param natureOfIncomePayment
	 * @param amountOfIncomePayment
	 * @param rateOfTax
	 * @param amountOfTaxWithhled
	 * @return
	 */
	public static Alphalist alphalistForSchedule5(String lastName,String firstName,
			String middleName,String tin,String address,String residenceStatus,
			String atc,String natureOfIncomePayment,double amountOfIncomePayment,
			double rateOfTax,double amountOfTaxWithhled){
		
		Alphalist alphalist = new Alphalist();
		alphalist.setLastName(lastName);
		alphalist.setFirstName(firstName);
		alphalist.setMiddleName(middleName);
		alphalist.setTin(tin);
		alphalist.setAddress(address);
		alphalist.setResidenceStatus(residenceStatus);
		alphalist.setAtc(atc);
		alphalist.setNatureOfIncomePayment(natureOfIncomePayment);
		alphalist.setAmountOfIncomePayment(amountOfIncomePayment);
		alphalist.setRateOfTax(rateOfTax);
		alphalist.setAmountOfTaxWithhled(amountOfTaxWithhled);		
		return alphalist;		
	}
	/**
	 *  Creates employee object for alphalist used in schedule 6 as attachment to BIR form 1604 CF.
	 * @param lastName
	 * @param firstName
	 * @param middleName
	 * @param tin
	 * @param atc
	 * @param amountOfTaxWithhled
	 * @param amountOfFringeBenefit
	 * @param grossedUpMonetaryValue
	 * @return
	 */
	public static Alphalist alphalistForSchedule6(String lastName,String firstName,
			String middleName,String tin, String atc,double amountOfTaxWithhled, 
			double amountOfFringeBenefit, double grossedUpMonetaryValue){
		
		Alphalist alphalist = new Alphalist();
		alphalist.setLastName(lastName);
		alphalist.setFirstName(firstName);
		alphalist.setMiddleName(middleName);
		alphalist.setTin(tin);
		alphalist.setAtc(atc);		
		alphalist.setAmountOfTaxWithhled(amountOfTaxWithhled);		
		alphalist.setAmountOfFringeBenefit(amountOfFringeBenefit);
		alphalist.setGrossedUpMonetaryValue(grossedUpMonetaryValue);
		return alphalist;		
	}
	
	/**
	 *  Creates employee object for alphalist used in schedule 7.1 as attachment to BIR form 1604 CF.
	 * @param lastName
	 * @param firstName
	 * @param middleName
	 * @param tin
	 * @param grossCompensationIncomePresent
	 * @param taxWithheldJanToNovPresent
	 * @param taxDue
	 * @param isSubstitutedFiling
	 * @param presentEmployerTaxable
	 * @param presentEmployerNonTaxable
	 * @return
	 */
	public static Alphalist alphalistForSchedule7Pt1(String lastName,String firstName,
			String middleName,String tin, double grossCompensationIncomePresent,
			double taxWithheldJanToNovPresent,double taxDue,boolean isSubstitutedFiling,
			TaxableCompensationIncome presentEmployerTaxable, NonTaxableCompensationIncome presentEmployerNonTaxable){
		
		Alphalist alphalist = new Alphalist();
		alphalist.setLastName(lastName);
		alphalist.setFirstName(firstName);
		alphalist.setMiddleName(middleName);
		alphalist.setTin(tin);
		alphalist.setGrossCompensationIncomePresent(grossCompensationIncomePresent);
		alphalist.setTaxWithheldJanToNovPresent(taxWithheldJanToNovPresent);
		alphalist.setTaxDue(taxDue);
		alphalist.setSubstitutedFiling(isSubstitutedFiling);
		alphalist.setPresentEmployerTaxable(presentEmployerTaxable);
		alphalist.setPresentEmployerNonTaxable(presentEmployerNonTaxable);		
		
		return alphalist;		
	}
	/**
	 * Creates employee object for alphalist used in schedule 7.2 as attachment to BIR form 1604 CF.
	 * @param lastName
	 * @param firstName
	 * @param middleName
	 * @param tin
	 * @param grossCompensationIncomePresent
	 * @param taxDue
	 * @param exemptionCode
	 * @param exemptionAmount
	 * @param presentEmployerTaxable
	 * @param presentEmployerNonTaxable
	 * @param premiumPaidOnHealth
	 * @param netTaxableCompensationIncome
	 * @return
	 */
	public static Alphalist alphalistForSchedule7Pt2(String lastName,String firstName,
			String middleName,String tin, double grossCompensationIncomePresent,
			double taxDue,String exemptionCode,double exemptionAmount,
			TaxableCompensationIncome presentEmployerTaxable,
			NonTaxableCompensationIncome presentEmployerNonTaxable,
			double premiumPaidOnHealth, double netTaxableCompensationIncome){
		
		Alphalist alphalist = new Alphalist();
		alphalist.setLastName(lastName);
		alphalist.setFirstName(firstName);
		alphalist.setMiddleName(middleName);
		alphalist.setTin(tin);
		alphalist.setGrossCompensationIncomePresent(grossCompensationIncomePresent);	
		alphalist.setTaxDue(taxDue);
		alphalist.setExemptionCode(exemptionCode);
		alphalist.setExemptionAmount(exemptionAmount);
		alphalist.setPresentEmployerTaxable(presentEmployerTaxable);
		alphalist.setPresentEmployerNonTaxable(presentEmployerNonTaxable);
		alphalist.setPremiumPaidOnHealth(premiumPaidOnHealth);
		alphalist.setNetTaxableCompensationIncome(netTaxableCompensationIncome);
		
		return alphalist;		
	}
	
	/**
	 *  Creates employee object for alphalist used in schedule 7.3 as attachment to BIR form 1604 CF.
	 * @param lastName
	 * @param firstName
	 * @param middleName
	 * @param tin
	 * @param grossCompensationIncomePresent
	 * @param taxWithheldJanToNovPresent
	 * @param taxDue
	 * @param isSubstitutedFiling
	 * @param presentEmployerTaxable
	 * @param presentEmployerNonTaxable
	 * @return
	 */
	public static Alphalist alphalistForSchedule7Pt3(String lastName,String firstName,
			String middleName,String tin, double grossCompensationIncomePresent,
			double taxWithheldJanToNovPresent,double taxDue,boolean isSubstitutedFiling,
			TaxableCompensationIncome presentEmployerTaxable, NonTaxableCompensationIncome presentEmployerNonTaxable){
		
		Alphalist alphalist = new Alphalist();
		alphalist.setLastName(lastName);
		alphalist.setFirstName(firstName);
		alphalist.setMiddleName(middleName);
		alphalist.setTin(tin);
		alphalist.setGrossCompensationIncomePresent(grossCompensationIncomePresent);
		alphalist.setTaxWithheldJanToNovPresent(taxWithheldJanToNovPresent);
		alphalist.setTaxDue(taxDue);
		alphalist.setSubstitutedFiling(isSubstitutedFiling);
		alphalist.setPresentEmployerTaxable(presentEmployerTaxable);
		alphalist.setPresentEmployerNonTaxable(presentEmployerNonTaxable);		
		
		return alphalist;		
	}
	
	/**
	 *  Creates employee object for alphalist used in schedule 7.4 as attachment to BIR form 1604 CF.
	 * @param lastName
	 * @param firstName
	 * @param middleName
	 * @param tin
	 * @param grossCompensationIncomePresent
	 * @param taxWithheldJanToNovPresent
	 * @param taxWithheldJanToNovPrevious
	 * @param taxDue
	 * @param presentEmployerTaxable
	 * @param presentEmployerNonTaxable
	 * @param previousEmployerTaxable
	 * @param previousEmployerNonTaxable
	 * @param exemptionCode
	 * @param exemptionAmount
	 * @param premiumPaidOnHealth
	 * @param netTaxableCompensationIncome
	 * @return
	 */
	public static Alphalist alphalistForSchedule7Pt4(String lastName,String firstName,
			String middleName,String tin, double grossCompensationIncomePresent,
			double taxWithheldJanToNovPresent,double taxWithheldJanToNovPrevious,double taxDue,
			TaxableCompensationIncome presentEmployerTaxable, NonTaxableCompensationIncome presentEmployerNonTaxable,
			TaxableCompensationIncome previousEmployerTaxable,
			NonTaxableCompensationIncome previousEmployerNonTaxable,
			String exemptionCode,double exemptionAmount,
			double premiumPaidOnHealth, double netTaxableCompensationIncome){
		
		Alphalist alphalist = new Alphalist();
		alphalist.setLastName(lastName);
		alphalist.setFirstName(firstName);
		alphalist.setMiddleName(middleName);
		alphalist.setTin(tin);
		alphalist.setGrossCompensationIncomePresent(grossCompensationIncomePresent);
		alphalist.setTaxWithheldJanToNovPresent(taxWithheldJanToNovPresent);
		alphalist.setTaxWithheldJanToNovPrevious(taxWithheldJanToNovPrevious);
		alphalist.setTaxDue(taxDue);	
		alphalist.setPresentEmployerTaxable(presentEmployerTaxable);		
		alphalist.setPresentEmployerNonTaxable(presentEmployerNonTaxable);		
		alphalist.setPreviousEmployerTaxable(previousEmployerTaxable);
		alphalist.setPreviousEmployerNonTaxable(previousEmployerNonTaxable);
		alphalist.setExemptionCode(exemptionCode);
		alphalist.setExemptionAmount(exemptionAmount);
		alphalist.setPremiumPaidOnHealth(premiumPaidOnHealth);
		alphalist.setNetTaxableCompensationIncome(netTaxableCompensationIncome);
		
		return alphalist;		
	}
	
	/**
	 * Creates employee object for alphalist used in schedule 7.5 as attachment to BIR form 1604 CF.
	 * @param lastName
	 * @param firstName
	 * @param middleName
	 * @param tin
	 * @param regionNumber
	 * @param grossCompensationIncomePresent
	 * @param grossCompensationIncomePrevious
	 * @param dateOfEmploymentFrom
	 * @param dateOfEmploymentTo
	 * @param factorUsed
	 * @param taxWithheldJanToNovPresent
	 * @param taxWithheldJanToNovPrevious
	 * @param taxDue
	 * @param presentEmployerTaxable
	 * @param presentEmployerNonTaxable
	 * @param previousEmployerTaxable
	 * @param previousEmployerNonTaxable
	 * @param exemptionCode
	 * @param exemptionAmount
	 * @param premiumPaidOnHealth
	 * @param netTaxableCompensationIncome
	 * @return
	 */
	public static Alphalist alphalistForSchedule7Pt5(String lastName,String firstName,
			String middleName,String tin,String regionNumber, double grossCompensationIncomePresent,
			double grossCompensationIncomePrevious,String dateOfEmploymentFrom,String dateOfEmploymentTo,
			double factorUsed,double taxWithheldJanToNovPresent,double taxWithheldJanToNovPrevious,double taxDue,
			TaxableCompensationIncome presentEmployerTaxable, NonTaxableCompensationIncome presentEmployerNonTaxable,
			TaxableCompensationIncome previousEmployerTaxable,
			NonTaxableCompensationIncome previousEmployerNonTaxable,
			String exemptionCode,double exemptionAmount,
			double premiumPaidOnHealth, double netTaxableCompensationIncome){
		
		Alphalist alphalist = new Alphalist();
		alphalist.setLastName(lastName);
		alphalist.setFirstName(firstName);
		alphalist.setMiddleName(middleName);
		alphalist.setTin(tin);
		alphalist.setGrossCompensationIncomePresent(grossCompensationIncomePresent);
		alphalist.setGrossCompensationIncomePrevious(grossCompensationIncomePrevious);
		alphalist.setDateOfEmploymentFrom(dateOfEmploymentFrom);
		alphalist.setDateOfEmploymentTo(dateOfEmploymentTo);
		alphalist.setFactorUsed(factorUsed);			
		alphalist.setTaxWithheldJanToNovPresent(taxWithheldJanToNovPresent);
		alphalist.setTaxWithheldJanToNovPrevious(taxWithheldJanToNovPrevious);			
		alphalist.setPresentEmployerTaxable(presentEmployerTaxable);		
		alphalist.setPresentEmployerNonTaxable(presentEmployerNonTaxable);		
		alphalist.setPreviousEmployerTaxable(previousEmployerTaxable);
		alphalist.setPreviousEmployerNonTaxable(previousEmployerNonTaxable);		
		alphalist.setTaxDue(taxDue);
		alphalist.setExemptionCode(exemptionCode);
		alphalist.setExemptionAmount(exemptionAmount);
		alphalist.setPremiumPaidOnHealth(premiumPaidOnHealth);
		alphalist.setNetTaxableCompensationIncome(netTaxableCompensationIncome);
		
		return alphalist;		
	}

}
