package com.svi.payroll.report.forms;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.svi.payroll.report.objects.Employer;
import com.svi.payroll.report.objects.PaymentDetail;
import com.svi.payroll.report.objects.PaymentDetail.TYPE;
import com.svi.payroll.report.objects.TaxAdjustment;
import com.svi.payroll.report.objects.TaxComputation;

import net.sf.jasperreports.engine.JRException;

public class BIRForm1601CTest extends BaseTestSetup{

	
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
		employer.setCategory(Employer.CATEGORY.PRIVATE);
		employer.setPayeesAvailingTax(false);
		employer.setSpecify("Special Law");
		
		// TaxComputation info
		TaxComputation taxComputation = new TaxComputation();	
		taxComputation.setCompromisePenalty(1000);
		taxComputation.setInterestPenalty(500);
		taxComputation.setNonTaxableHONHPay(300);
		taxComputation.setNonTaxableMWES(200.5);
		taxComputation.setNonTaxableOthers(500.50); //done
		taxComputation.setOtherPaymentsMade(10300.50);
		taxComputation.setRequiredTaxWithheld(450000);
		taxComputation.setSurchargePenalty(200);
		taxComputation.setTaxRemittedInReturn(3000);
		taxComputation.setTotalAmtCompensation(1020201.3); //done
		
		List<TaxAdjustment> taxAdjustments = new ArrayList<TaxAdjustment>();
		TaxAdjustment taxAdjustment1 = new TaxAdjustment();
		taxAdjustment1.setAdjustmentFromCurrentYear(100.11);
		taxAdjustment1.setAdjustmentFromYearToPrevYear(200.11);
		taxAdjustment1.setBankCode("Bank Code 1");
		taxAdjustment1.setBankValidationNum("000111000111");
		taxAdjustment1.setDatePaid("12292017");
		taxAdjustment1.setPreviousMonth("122017");
		taxAdjustment1.setTaxDue(10000.11);
		taxAdjustment1.setTaxPaid(1000.11);
		taxAdjustments.add(taxAdjustment1);
		
		TaxAdjustment taxAdjustment2 = new TaxAdjustment();
		taxAdjustment2.setAdjustmentFromCurrentYear(100.22);
		taxAdjustment2.setAdjustmentFromYearToPrevYear(200.22);
		taxAdjustment2.setBankCode("Bank Code 2");
		taxAdjustment2.setBankValidationNum("000111000222");
		taxAdjustment2.setDatePaid("12302017");
		taxAdjustment2.setPreviousMonth("112017");
		taxAdjustment2.setTaxDue(10000.22);
		taxAdjustment2.setTaxPaid(1000.22);
		taxAdjustments.add(taxAdjustment2);
		
		/*TaxAdjustment taxAdjustment3= new TaxAdjustment();
		taxAdjustment3.setAdjustmentFromCurrentYear(100.33);
		taxAdjustment3.setAdjustmentFromYearToPrevYear(200.33);
		taxAdjustment3.setBankCode("Bank Code 3");
		taxAdjustment3.setBankValidationNum("000111000333");
		taxAdjustment3.setDatePaid("123120");
		taxAdjustment3.setPreviousMonth("1020");
		taxAdjustment3.setTaxDue(10000.33);
		taxAdjustment3.setTaxPaid(1000.33);
		taxAdjustments.add(taxAdjustment3);*/
		
		
		taxComputation.setTaxAdjustments(taxAdjustments);
		
		
		// payment details
		Map<TYPE, PaymentDetail> paymentDetails = new HashMap<TYPE, PaymentDetail>();
		PaymentDetail paymentDetail1 = new PaymentDetail();
		paymentDetail1.setAmount(100000.10);
		paymentDetail1.setDate("12292017");
		paymentDetail1.setDraweeBankOrAgency("BPI");
		paymentDetail1.setNumber("123123123");
		paymentDetail1.setType(TYPE.CASH);
		paymentDetails.put(PaymentDetail.TYPE.CASH, paymentDetail1);
		
		PaymentDetail paymentDetail2 = new PaymentDetail();
		paymentDetail2.setAmount(200000.20);
		paymentDetail2.setDate("12302017");
		paymentDetail2.setDraweeBankOrAgency("BDO");
		paymentDetail2.setNumber("234234234");
		paymentDetail2.setType(TYPE.CHECK);
		paymentDetails.put(PaymentDetail.TYPE.CHECK, paymentDetail2);
		
		PaymentDetail paymentDetail3 = new PaymentDetail();
		paymentDetail3.setAmount(300000.30);
		paymentDetail3.setDate("12312017");
		paymentDetail3.setDraweeBankOrAgency("China Bank");
		paymentDetail3.setNumber("345345345");
		paymentDetail3.setType(TYPE.OTHERS);
		paymentDetails.put(PaymentDetail.TYPE.OTHERS, paymentDetail3);
	
		
		// creating new form
		BIRForm1601C form = new BIRForm1601C(employer,taxComputation,paymentDetails);
		
		form.setForTheMonth("122017");
		form.setAmendedReturn("true");
		form.setNumSheetsAttached("12");
		form.setAnyTaxWithheld("true");	
		
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
