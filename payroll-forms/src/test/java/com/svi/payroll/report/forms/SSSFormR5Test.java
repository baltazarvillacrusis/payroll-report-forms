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

import com.svi.payroll.report.objects.Address;
import com.svi.payroll.report.objects.Employer;
import com.svi.payroll.report.objects.Employer.CATEGORY;
import com.svi.payroll.report.objects.EmployerContribution;
import com.svi.payroll.report.objects.EmployerContribution.MONTH;
import com.svi.payroll.report.objects.EmployerContribution.PENALTY_TYPE;
import com.svi.payroll.report.objects.PaymentDetail;
import com.svi.payroll.report.objects.PaymentDetail.TYPE;

import net.sf.jasperreports.engine.JRException;


public class SSSFormR5Test extends BaseTestSetup{
	
	@Test
	public void main() throws IOException {
		
		Employer employer = new Employer();
		employer.setName("SVI Software Services Corporation");
		employer.setSssNumber("0123456789123");
		employer.setRegisteredAddZipCode("2180");
		employer.setTin("012345678912");
		employer.setTelNum("0212345");
		employer.setMobileNo("09954683166");
		employer.setEmailAddress("macidera@svi.com.ph");
		employer.setWebsite("www.macidera.com");	
		employer.setCategory(CATEGORY.BUSINESS);
	
		
		Map<String, EmployerContribution> empConList = new HashMap<String, EmployerContribution>();
		EmployerContribution empCon1 = new EmployerContribution();
		empCon1.setEmployeeCompensation(1000);
		empCon1.setMonth(MONTH.JANUARY);
		empCon1.setSsContribution(1000);	
		empCon1.setYear("2017");		
		EmployerContribution empCon2 = new EmployerContribution();
		empCon2.setEmployeeCompensation(1000);
		empCon2.setMonth(MONTH.MARCH);
		empCon2.setSsContribution(1000);		
		empCon2.setYear("2017");
		
		
		
		empConList.put(empCon1.getMonth().getValue(), empCon1);
		empConList.put(empCon2.getMonth().getValue(), empCon2);
		employer.setEmpConList(empConList);
		
		
		
		
		Map<String, List<EmployerContribution>> penalties = new HashMap<String, List<EmployerContribution>>();
		List<EmployerContribution> penalty = new ArrayList<EmployerContribution>();
		List<EmployerContribution> interest = new ArrayList<EmployerContribution>();
		List<EmployerContribution> underPayment = new ArrayList<EmployerContribution>();		
		
			
		EmployerContribution penalty1 = new EmployerContribution();
		penalty1.setEmpCompPenalty(100);
		penalty1.setPenaltyType(PENALTY_TYPE.INTEREST);
		penalty1.setSsConPenalty(100);
		
		penalty.add(penalty1);
		penalties.put(penalty1.getPenaltyType().getValue(), penalty);
		
		EmployerContribution penalty2 = new EmployerContribution();
		penalty2.setEmpCompPenalty(200);
		penalty2.setPenaltyType(PENALTY_TYPE.PENALTY);
		penalty2.setSsConPenalty(200);
		
		
		
		interest.add(penalty2);
		penalties.put(penalty2.getPenaltyType().getValue(), interest);
		
		
		EmployerContribution penalty3 = new EmployerContribution();
		penalty3.setEmpCompPenalty(400);
		penalty3.setPenaltyType(PENALTY_TYPE.UNDER_PAYMENT);
		penalty3.setSsConPenalty(300);
		
		underPayment.add(penalty3);
		
		penalties.put(penalty3.getPenaltyType().getValue(), underPayment);
		
		
		//employer.setPenaltyList(penalties);
		
		Address address = new Address();
		address.setBarangay("Pasiocan");
		address.setBlockNo("#3");
		address.setBuildingName("Acidera Residence");
		address.setCity("Bacarra");
		address.setProvince("Ilocos Norte");
		address.setStreet("Arayat St.");
		address.setSubdivision("Panabuan");		
		
		employer.setAddress(address);
		
		// setting payment details
		Map<TYPE, PaymentDetail> paymentDetails = new HashMap<TYPE, PaymentDetail>();		
		PaymentDetail paymentDetail = new PaymentDetail();
		paymentDetail.setAmount(3099.00);		
		paymentDetail.setDraweeBankOrAgency("BPI");
		paymentDetail.setDate("12/12/2017");
		paymentDetail.setNumber("011103093");
		paymentDetail.setType(TYPE.CHECK);
		
		PaymentDetail paymentDetail2 = new PaymentDetail();
		paymentDetail2.setAmount(1100.50);			
		paymentDetail2.setType(TYPE.CASH);
		
		PaymentDetail paymentDetail3 = new PaymentDetail();
		paymentDetail3.setAmount(1100.50);			
		paymentDetail3.setType(TYPE.POSTAL_MONEY_ORDER);		
		
		
		paymentDetails.put(paymentDetail.getType(),paymentDetail);
		paymentDetails.put(paymentDetail2.getType(),paymentDetail2);		
		paymentDetails.put(paymentDetail3.getType(),paymentDetail3);
		
		SSSFormR5 form = new SSSFormR5(employer,penalties,paymentDetails);		
		form.setSignatoryPosition("President");
		form.setSignatoryName("Mark Acidera");			
	
		
		try {
			File file = new File(getClass().getName()+".pdf");
			form.createFormStream(new FileOutputStream(file));			
			Desktop.getDesktop().open(file);
		} catch (JRException e) {			
			e.printStackTrace();
		}
	}
	
	
	
		
		
}
