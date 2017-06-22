package com.svi.payroll.report.forms;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.svi.payroll.report.objects.Employee;
import com.svi.payroll.report.objects.Employer;
import com.svi.payroll.report.objects.NonTaxableCompensationIncome;
import com.svi.payroll.report.objects.TaxSummary;
import com.svi.payroll.report.objects.TaxableCompensationIncome;

import net.sf.jasperreports.engine.JRException;



public class BIRForm2316Test extends BaseTestSetup{

	@Test
	public void main() throws IOException {
		
		long startTime = System.currentTimeMillis();
		System.out.println("Writing to PDF.");
		
		// creating the objects to be used to generate the form
		// employee object
		Employee employee = new Employee();		
		employee.setBirthDate("11112017");
		employee.setForeignAdd("United States of America");
		employee.setForeignAddZipCode("1234");
		employee.setLocalAdd("Mandaluyong, Metro Manila");
		employee.setLocalAddZipCode("5678");
	//	employee.setIsMinimumWageEarner(Boolean.TRUE.booleanValue());
		employee.setIsMinimumWageEarner(null);
		//employee.setName("Baltazar Pajares Villacrusis");
		employee.setFirstName("Baltazar");
		employee.setMiddleName("Pajares");
		employee.setLastName("Villacrusis");
		employee.setRdoCode("123");
		employee.setRegisteredAdd("Vinzons, Camarines Norte, Bicol");
		employee.setRegisteredAddZipCode("4603");
	//	employee.setIsSingle(Boolean.TRUE.booleanValue());
		employee.setIsSingle(null);
		employee.setSmwRatePerDay(5956.23);
		employee.setSmwRatePerMonth(123456.75);
		employee.setTelNum("02-657-7890");
		employee.setTin("1234567890123");
		//employee.setIsWifeClaimingExemption(Boolean.TRUE.booleanValue());
		employee.setIsWifeClaimingExemption(null);
		employee.setCtcNum("6969690010");
		employee.setCtcDateOfIssue("01312016");
		employee.setCtcPlaceOfIssue("Mandaluyong");
		employee.setCtcAmountPaid(250.25);
		Map<String,String> dependents = new HashMap<String,String>();	
		//dependents.put("Complete Name 1", "12252016");
		//dependents.put("Complete Name 2", "12252017");
		//dependents.put("Complete Name 3", "12252018");
		//dependents.put("Complete Name 4", "12252019");
		//dependents.put("Complete Name 0", "12252020");
		employee.setDependents(dependents);
		
		//employer
		Employer presentEmployer = new Employer();
		presentEmployer.setIsMainEmployer(true);
		presentEmployer.setName("SVI");
		presentEmployer.setRegisteredAdd("Pasig, Mandaluyong");
		presentEmployer.setRegisteredAddZipCode("4605");
		presentEmployer.setTin("0001110001111");
		employee.setPresentEmployer(presentEmployer);
		
		Employer previousEmployer = new Employer();		
		previousEmployer.setName("CDCI");
		previousEmployer.setRegisteredAdd("Clark, Pampanga");
		previousEmployer.setRegisteredAddZipCode("4607");
		previousEmployer.setTin("2223332223333");		
		employee.setPreviousEmployer(previousEmployer);
		
		// nontaxable compensation of the employee
		NonTaxableCompensationIncome nonTaxableCompensation = new NonTaxableCompensationIncome();
		//nonTaxableCompensation.setBasicSalarySMWE(1230000.45);
		nonTaxableCompensation.setContributionsAndUnionDues(250.24);
		nonTaxableCompensation.setDeMinimis(3245.20);
		nonTaxableCompensation.setHazardPayMWE(4536);
		//nonTaxableCompensation.setHolidayPayMWE(5632.23);
		nonTaxableCompensation.setNightShiftDiffMWE(623.25);
	//	nonTaxableCompensation.setOtherFormsOfCompensation(74.23);
		//nonTaxableCompensation.setOvertimePayMWE(854.23);
		nonTaxableCompensation.setThirteenthMonthAndOtherBenefits(956.12);
		
		// taxable compensation of the employee
		TaxableCompensationIncome taxableCompensation = new TaxableCompensationIncome();
		taxableCompensation.setBasicSalary(650);
		taxableCompensation.setCommission(650.02);
		taxableCompensation.setCostOfLivingAllowance(650.03);
		taxableCompensation.setFees(650.01);
		taxableCompensation.setFixedHousingAllow(650.04);
	//	taxableCompensation.setHazarddPay(650.05);
		taxableCompensation.setOvertimePay(650.06);
	//	taxableCompensation.setProfitSharing(650.07);
		taxableCompensation.setRepresentation(650.08);
		taxableCompensation.setTaxable13thMonthAndOtherBenefits(650.09);
		taxableCompensation.setTransportation(650.10);
		Map<String,Double> taxableOther = new HashMap<String,Double>();		
		//taxableOther.put("Rice Allowance", 650.11);
		taxableOther.put("Grocery Allowance", 650.12);
		Map<String,Double> suppOther = new HashMap<String,Double>();
		//suppOther.put("Dividends", 650.13);		
		suppOther.put("Productivity Bonus", 650.14);
		
		taxableCompensation.setTaxableOthers(taxableOther);
		taxableCompensation.setSupplementaryOthers(suppOther);
		
		// tax summary
		TaxSummary taxSummary = new TaxSummary();
		//taxSummary.setPremiumsPaidOnHealth(2000);
		taxSummary.setTaxableIncomeFromPreviousEmployer(30000.50);
		taxSummary.setTaxDue(35213.52);
		taxSummary.setTaxWithheldPresentEmployer(12000.25);
		taxSummary.setTaxWithheldPreviousEmployer(5000.21);
		//taxSummary.setTotalExemptions(30000);
		taxSummary.setTotalTaxesWithheldAsAdjusted(18000.35);		
	
		// creating new form
		BIRForm2316 form = new BIRForm2316(employee,nonTaxableCompensation,taxableCompensation,taxSummary);
		form.setForTheYear("2017");
		form.setStartPeriod("0101");
		form.setEndPeriod("1231");			
		form.setEmployerSignatoryName("Signatory Name");
		
		// creating the form as pdf	and opening it after
	
			File file = new File(getClass().getName()+".pdf");
			try {
				form.createFormStream(new FileOutputStream(file));
			} catch (JRException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
			Desktop.getDesktop().open(file);
		
	
		
		 
		
		System.out.println("Done writing to PDF."); 
	    long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("Total run time: "+totalTime+" ms");
		
	

	}

}
