package com.svi.payroll.report.forms;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.Test;

import com.svi.payroll.report.objects.Alphalist;
import com.svi.payroll.report.objects.NonTaxableCompensationIncome;
import com.svi.payroll.report.objects.TaxableCompensationIncome;

import net.sf.jasperreports.engine.JRException;

public class AlphalistTest extends BaseTestSetup {
	
	@Test
	public void main() throws IOException {
		long startTime = System.currentTimeMillis();
		System.out.println("Writing to PDF.");
		int max = 10;

		// creating the objects to be used to generate the form
		// employee object		
		ArrayList < Alphalist > employeeList = new ArrayList < Alphalist > ();		
		for (int x=1 ; x < max ; x++){			
			Alphalist employee = new Alphalist();
			
			employee.setLastName("Surname ");
			employee.setFirstName("Firstname ");
			employee.setMiddleName("Middlename "+x);
			employee.setTin("1001112223"+(x+300));
			employee.setAddress("Address Address "+x);
			employee.setResidenceStatus("RS" +x);
			employee.setAtc("atc" +x);
			employee.setNatureOfIncomePayment("WC-"+ x);
			employee.setAmountOfIncomePayment(20000+x*25.5);
			employee.setRateOfTax(0.15+0.001*x);
			employee.setAmountOfTaxWithhled(3000+x*15);
			
			employeeList.add(employee);			
		}
		
		ArrayList < Alphalist > employeeList2 = new ArrayList < Alphalist > ();		
		for (int x=1 ; x < max+1 ; x++){			
			Alphalist employee = new Alphalist();
						
			employee.setLastName("Surname ");
			employee.setFirstName("Firstname ");
			employee.setMiddleName("Middlename "+x);
			employee.setTin("0001112223"+(x+300));		
			employee.setAtc("atc" +x);
			employee.setAmountOfFringeBenefit(2600+x*15.5);
			employee.setGrossedUpMonetaryValue(1000+x*12.5);
			employee.setAmountOfTaxWithhled(3000+x*15);
			
			employeeList2.add(employee);			
		}
		

		ArrayList < Alphalist > employeeList3 = new ArrayList < Alphalist > ();		
		for (int x=1 ; x < max+2 ; x++){			
			Alphalist employee = new Alphalist();
			
			employee.setLastName("Surname ");
			employee.setFirstName("Firstname ");
			employee.setMiddleName("Middlename "+x);
			employee.setTin("0001112223"+(x+300));	
			employee.setGrossCompensationIncomePresent(32000+x*50);
			
			NonTaxableCompensationIncome presentEmployerNonTaxable = new NonTaxableCompensationIncome();
			presentEmployerNonTaxable.setThirteenthMonthAndOtherBenefits(14000+x);
			presentEmployerNonTaxable.setDeMinimis(5000.50+x);
			presentEmployerNonTaxable.setContributionsAndUnionDues(600.30+x);
			presentEmployerNonTaxable.setOtherFormsOfCompensation(400.30+x);
			employee.setPresentEmployerNonTaxable(presentEmployerNonTaxable);	
			
			
			TaxableCompensationIncome presentEmployerTaxable = new TaxableCompensationIncome();
			presentEmployerTaxable.setBasicSalary(10000.5+x);
			presentEmployerTaxable.setTaxable13thMonthAndOtherBenefits(24000+x);
			presentEmployerTaxable.setCostOfLivingAllowance(1000+x);
			employee.setPresentEmployerTaxable(presentEmployerTaxable);		
			
			employee.setExemptionCode(""+x%4); //
			employee.setExemptionAmount(25000*(x%4));//
			employee.setPremiumPaidOnHealth(5000+x);
			employee.setNetTaxableCompensationIncome(70000+x*300);
			
			
			if(x>5 && x<8){
				employee.setTaxWithheldJanToNovPresent(30000+x*150);//
				employee.setTaxDue(25000+x*15);
			}
			else{
				employee.setTaxDue(30000+x*150);
				employee.setTaxWithheldJanToNovPresent(25000+x*15);
			}
			
			
			if(x%4 > 2){
				employee.setSubstitutedFiling(true);//
			}			
			employeeList3.add(employee);			
		}

		ArrayList < Alphalist > employeeList4 = new ArrayList < Alphalist > ();		
		for (int x=1 ; x < max+3 ; x++){			
			Alphalist employee = new Alphalist();
			
			employee.setLastName("Surname ");
			employee.setFirstName("Firstname ");
			employee.setMiddleName("Middlename "+x);
			employee.setTin("0001112223"+(x+300));	
			employee.setGrossCompensationIncomePresent(32000+x*50);
			
			NonTaxableCompensationIncome presentEmployerNonTaxable = new NonTaxableCompensationIncome();
			presentEmployerNonTaxable.setThirteenthMonthAndOtherBenefits(14000+x);
			presentEmployerNonTaxable.setDeMinimis(5000.50+x);
			presentEmployerNonTaxable.setContributionsAndUnionDues(600.30+x);
			presentEmployerNonTaxable.setOtherFormsOfCompensation(400.30+x);
			employee.setPresentEmployerNonTaxable(presentEmployerNonTaxable);		
			TaxableCompensationIncome presentEmployerTaxable = new TaxableCompensationIncome();
			presentEmployerTaxable.setBasicSalary(10000.5+x);
			presentEmployerTaxable.setFixedHousingAllow(500+x);
			employee.setPresentEmployerTaxable(presentEmployerTaxable);			
			employee.setExemptionCode(""+x%4);
			employee.setExemptionAmount(25000*(x%4));
			employee.setPremiumPaidOnHealth(5000+x);
			employee.setNetTaxableCompensationIncome(70000+x*300);
			if(x>5 && x<7){				
				employee.setTaxDue(25000+x*15);
			}
			else{
				employee.setTaxDue(30000+x*150);				
			}					
			employeeList4.add(employee);			
		}
		
		ArrayList < Alphalist > employeeList5 = new ArrayList < Alphalist > ();		
		for (int x=1 ; x < max+4 ; x++){			
			Alphalist employee = new Alphalist();			
			employee.setLastName("Surname ");
			employee.setFirstName("Firstname ");
			employee.setMiddleName("Middlename "+x);
			employee.setTin("0001112223"+(x+300));	
			employee.setGrossCompensationIncomePresent(32000+x*50);
			NonTaxableCompensationIncome presentEmployerNonTaxable = new NonTaxableCompensationIncome();
			presentEmployerNonTaxable.setThirteenthMonthAndOtherBenefits(14000+x);
			presentEmployerNonTaxable.setDeMinimis(5000.50+x);
			presentEmployerNonTaxable.setContributionsAndUnionDues(600.30+x);
			presentEmployerNonTaxable.setOtherFormsOfCompensation(400.30+x);
			employee.setPresentEmployerNonTaxable(presentEmployerNonTaxable);		
			TaxableCompensationIncome presentEmployerTaxable = new TaxableCompensationIncome();
			presentEmployerTaxable.setBasicSalary(10000.5+x);
			presentEmployerTaxable.setFixedHousingAllow(500+x);
			employee.setPresentEmployerTaxable(presentEmployerTaxable);
			presentEmployerTaxable.setTaxable13thMonthAndOtherBenefits(24000+x);			
			employee.setExemptionCode(""+x%4);
			employee.setExemptionAmount(25000*(x%4));
			employee.setPremiumPaidOnHealth(5000+x);
			employee.setNetTaxableCompensationIncome(70000+x*300);
			if(x>6 && x<9){
				employee.setTaxDue(30000+x*150);
				employee.setTaxWithheldJanToNovPresent(25000+x*15);
			}
			else{				
				employee.setTaxWithheldJanToNovPresent(30000+x*150);
				employee.setTaxDue(25000+x*15);
			}
			
			
			if(x%4 < 2){
				employee.setSubstitutedFiling(true);
			}			
			employeeList5.add(employee);			
		}
		
		ArrayList < Alphalist > employeeList6 = new ArrayList < Alphalist > ();			
		for (int x=1 ; x < max+5 ; x++){			
			Alphalist employee = new Alphalist();			
			employee.setLastName("Surname ");
			employee.setFirstName("Firstname ");
			employee.setMiddleName("Middlename "+x);
			employee.setTin("0001112223"+(x+300));	
			employee.setGrossCompensationIncomePresent(32000+x*50);
			
			NonTaxableCompensationIncome presentEmployerNonTaxable = new NonTaxableCompensationIncome();
			presentEmployerNonTaxable.setThirteenthMonthAndOtherBenefits(11000+x);
			presentEmployerNonTaxable.setDeMinimis(1100.50+x);
			presentEmployerNonTaxable.setContributionsAndUnionDues(110.30+x);
			presentEmployerNonTaxable.setOtherFormsOfCompensation(110.30+x);
			employee.setPresentEmployerNonTaxable(presentEmployerNonTaxable);		
			
			TaxableCompensationIncome presentEmployerTaxable = new TaxableCompensationIncome();
			presentEmployerTaxable.setBasicSalary(11000.5+x);
			presentEmployerTaxable.setFixedHousingAllow(110+x);			
			presentEmployerTaxable.setTaxable13thMonthAndOtherBenefits(11000+x);		
			employee.setPresentEmployerTaxable(presentEmployerTaxable);
			
			NonTaxableCompensationIncome previousEmployerNonTaxable = new NonTaxableCompensationIncome();
			previousEmployerNonTaxable.setThirteenthMonthAndOtherBenefits(22000+x);
			previousEmployerNonTaxable.setDeMinimis(2200.50+x);
			previousEmployerNonTaxable.setContributionsAndUnionDues(220.30+x);
			previousEmployerNonTaxable.setOtherFormsOfCompensation(220.30+x);
			employee.setPreviousEmployerNonTaxable(previousEmployerNonTaxable);		
			
			TaxableCompensationIncome previousEmployerTaxable = new TaxableCompensationIncome();
			previousEmployerTaxable.setBasicSalary(22000.5+x);
			previousEmployerTaxable.setFixedHousingAllow(220+x);			
			previousEmployerTaxable.setTaxable13thMonthAndOtherBenefits(22000+x);		
			employee.setPreviousEmployerTaxable(previousEmployerTaxable);
			
			employee.setExemptionCode(""+x%4);
			employee.setExemptionAmount(25000*(x%4));
			employee.setPremiumPaidOnHealth(5000+x);
			employee.setNetTaxableCompensationIncome(70000+x*300);
			if(x>2 && x<7){
				employee.setTaxDue(30000+x*150);
				employee.setTaxWithheldJanToNovPresent(25000+x*15);
				employee.setTaxWithheldJanToNovPrevious(15000+x*150);
			}
			else{				
				employee.setTaxWithheldJanToNovPresent(10000+x*150);
				employee.setTaxWithheldJanToNovPrevious(5000+x*150);
				employee.setTaxDue(25000+x*15);
			}		
			
					
			employeeList6.add(employee);			
		}
		
		
		
		ArrayList < Alphalist > employeeList7 = new ArrayList < Alphalist > ();			
		for (int x=1 ; x < max+6 ; x++){					
			
			Alphalist employee = new Alphalist();				
			
			
			employee.setLastName("Surname "+x);
			employee.setFirstName("Firstname "+x);
			employee.setMiddleName("Middlename "+x);
			employee.setTin("0001112223"+(x+300));	
			String[] regions = {"I","II","III","IV","V","VI"};
			employee.setRegionNumber(regions[x%6]);
			employee.setGrossCompensationIncomePresent(22000+x*50);
			employee.setGrossCompensationIncomePrevious(32000+x*50);
			employee.setDateOfEmploymentFrom("1028"+(2000+x));
			employee.setDateOfEmploymentTo("1228"+(2001+x));			
			employee.setFactorUsed(365.5);			
			
			
			NonTaxableCompensationIncome presentEmployerNonTaxable = new NonTaxableCompensationIncome();
			presentEmployerNonTaxable.setBasicSalarySMWE(130000+x);
			presentEmployerNonTaxable.setHolidayPayMWE(600+x);
			presentEmployerNonTaxable.setOvertimePayMWE(500+x);
			presentEmployerNonTaxable.setNightShiftDiffMWE(700+x);
			presentEmployerNonTaxable.setHazardPayMWE(800+x);
			
			
			presentEmployerNonTaxable.setThirteenthMonthAndOtherBenefits(11000+x);
			presentEmployerNonTaxable.setDeMinimis(1100.50+x);
			presentEmployerNonTaxable.setContributionsAndUnionDues(110.30+x);
			presentEmployerNonTaxable.setOtherFormsOfCompensation(110.30+x);
			employee.setPresentEmployerNonTaxable(presentEmployerNonTaxable);		
			
			TaxableCompensationIncome presentEmployerTaxable = new TaxableCompensationIncome();
			presentEmployerTaxable.setFixedHousingAllow(110+x);			
			presentEmployerTaxable.setTaxable13thMonthAndOtherBenefits(11000+x);		
			employee.setPresentEmployerTaxable(presentEmployerTaxable);
			
			NonTaxableCompensationIncome previousEmployerNonTaxable = new NonTaxableCompensationIncome();
			previousEmployerNonTaxable.setBasicSalarySMWE(120000+x);
			previousEmployerNonTaxable.setHolidayPayMWE(500+x);
			previousEmployerNonTaxable.setOvertimePayMWE(400+x);
			previousEmployerNonTaxable.setNightShiftDiffMWE(600+x);
			previousEmployerNonTaxable.setHazardPayMWE(700+x);
			
			previousEmployerNonTaxable.setThirteenthMonthAndOtherBenefits(22000+x);
			previousEmployerNonTaxable.setDeMinimis(2200.50+x);
			previousEmployerNonTaxable.setContributionsAndUnionDues(220.30+x);
			previousEmployerNonTaxable.setOtherFormsOfCompensation(230.30+x);
			employee.setPreviousEmployerNonTaxable(previousEmployerNonTaxable);		
			
			TaxableCompensationIncome previousEmployerTaxable = new TaxableCompensationIncome();			
			previousEmployerTaxable.setFixedHousingAllow(220+x);			
			previousEmployerTaxable.setTaxable13thMonthAndOtherBenefits(22000+x);		
			employee.setPreviousEmployerTaxable(previousEmployerTaxable);
			
			employee.setExemptionCode(""+x%4);
			employee.setExemptionAmount(25000*(x%4));
			employee.setPremiumPaidOnHealth(5000+x);
			employee.setNetTaxableCompensationIncome(70000+x*300);
			if(x>2 && x<7){
				employee.setTaxDue(30000+x*150);
				employee.setTaxWithheldJanToNovPresent(25000+x*15);
				employee.setTaxWithheldJanToNovPrevious(15000+x*150);
			}
			else{				
				employee.setTaxWithheldJanToNovPresent(10000+x*150);
				employee.setTaxWithheldJanToNovPrevious(5000+x*150);
				employee.setTaxDue(25000+x*15);
			}			
					
			employeeList7.add(employee);			
		}
		// creating new form
		AlphalistForms form = new AlphalistForms(employeeList,employeeList2,employeeList3,employeeList4,employeeList5,employeeList6,employeeList7);				
	
		
		

		// creating the form as pdf	and opening it after
		try {
			File file = new File(getClass().getName()+".pdf");
			form.createFormStream(new FileOutputStream(file));			
			Desktop.getDesktop().open(file);
		} catch(JRException e) {
			e.printStackTrace();
		}

		System.out.println("Done writing to PDF.");
		long endTime = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("Total run time: " + totalTime + " ms");

	}

}
