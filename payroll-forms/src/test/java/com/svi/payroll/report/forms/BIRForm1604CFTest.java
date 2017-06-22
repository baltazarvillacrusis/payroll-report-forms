package com.svi.payroll.report.forms;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.svi.payroll.report.objects.Employer;
import com.svi.payroll.report.objects.RemittancePerBIR;
import com.svi.payroll.report.objects.RemittancePerBIR.MONTH;
import com.svi.payroll.report.objects.RemittancePerBIR.QUARTER;

import net.sf.jasperreports.engine.JRException;

public class BIRForm1604CFTest extends BaseTestSetup{

	@Test
	public void main() throws IOException {
		
		long startTime = System.currentTimeMillis();	
		System.out.println("Writing to PDF.");
		
		//employer info
		Employer employer = new Employer();
		employer.setTin("0001112223333");		
		employer.setRdoCode("123");
		employer.setLineOfBusiness("IT Industry");
		employer.setName("Softwares Venture International");		
		employer.setTelNum("0212345");
		employer.setRegisteredAdd("Pasig, Mandaluyong");
		employer.setRegisteredAddZipCode("4605");
		employer.setCategory(Employer.CATEGORY.GOVERNMENT);	
		employer.setRefundReleased(true);
		employer.setDateOfRefund("12042017");
		employer.setOverRemittanceAmount(24356.52);
		employer.setMonthOfFirstCrediting("09");
		
		
		// schedule 1
	
		List<MONTH> months = new ArrayList<MONTH>();
		months.add(MONTH.DECEMBER);
		months.add(MONTH.MARCH);
		months.add(MONTH.JULY);
		months.add(MONTH.FEBRUARY);
		
	
		List<RemittancePerBIR> schedule1 = new ArrayList<RemittancePerBIR>();
		for(int i=0; i<4; i++){
			RemittancePerBIR remittance = new RemittancePerBIR();			
			remittance.setDate("1"+i);
			remittance.setNameOfBankOrBankCode("BPI"+i);
			remittance.setTaxesWithheld(1340.5+i*25);
			remittance.setAdjustment(100+i*20);
			remittance.setPenalties(10+i*15);			
			remittance.setMonth(months.get(i));
			schedule1.add(remittance);
		}
		

		List<RemittancePerBIR> schedule2= new ArrayList<RemittancePerBIR>();
		for(int i=0; i<4; i++){
			RemittancePerBIR remittance = new RemittancePerBIR();			
			remittance.setDate("2"+i);
			remittance.setNameOfBankOrBankCode("BDO"+i);
			remittance.setTaxesWithheld(2340.5+i*25);
			//remittance.setAdjustment(100+i*20);
			remittance.setPenalties(20+i*15);			
			remittance.setMonth(months.get(i));
			schedule2.add(remittance);
		}
		
		List<RemittancePerBIR> schedule3= new ArrayList<RemittancePerBIR>();
		for(int i=0; i<4; i++){
			RemittancePerBIR remittance = new RemittancePerBIR();			
			remittance.setDate("3"+i);
			remittance.setNameOfBankOrBankCode("CHINA BANK"+i);
			remittance.setTaxesWithheld(3340.5+i*25);
			//remittance.setAdjustment(100+i*20);
			remittance.setPenalties(30+i*15);			
			remittance.setMonth(months.get(i));
			schedule3.add(remittance);
		}
		List<QUARTER> quarters = new ArrayList<QUARTER>();
		quarters.add(QUARTER.THIRD_QUARTER);
		quarters.add(QUARTER.FOURTH_QUARTER);
		quarters.add(QUARTER.FIRST_QUARTER);
	
		
		
		List<RemittancePerBIR> schedule4= new ArrayList<RemittancePerBIR>();
		for(int i=0; i<3; i++){
			RemittancePerBIR remittance = new RemittancePerBIR();			
			remittance.setDate("4"+i);
			remittance.setNameOfBankOrBankCode("CHINA"+i);
			remittance.setTaxesWithheld(4340.5+i*25);
			//remittance.setAdjustment(100+i*20);
			remittance.setPenalties(40+i*15);		
			remittance.setQuarter(quarters.get(i));
			//remittance.setMonth(months.get(i));
			schedule4.add(remittance);
		}
		
		// creating new form
		BIRForm1604CF form = new BIRForm1604CF(employer,schedule1,schedule2,schedule3,schedule4);
		form.setForTheYear("2017");
		form.setAmendedReturn(false);
		form.setNumSheetsAttached("12");			
		
		// creating the form as pdf	and opening it after
		try {
			File file = new File(getClass().getName()+".pdf");
			form.createFormStream(new FileOutputStream(file));			
			Desktop.getDesktop().open(file);
		} catch (JRException e) {			
			e.printStackTrace();
		} 
		 
		
		System.out.println("Done writing to PDF."); 
	    long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("Total run time: "+totalTime+" ms");

	}

}
