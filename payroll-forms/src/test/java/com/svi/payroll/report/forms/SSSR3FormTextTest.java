package com.svi.payroll.report.forms;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.svi.payroll.report.objects.Employee;
import com.svi.payroll.report.objects.Employer;
import com.svi.payroll.report.objects.PaymentDetail;


public class SSSR3FormTextTest {
	
	@Test
	public void main() {
		//employer info
		Employer employer = new Employer();
		employer.setName("SVI SOFTWARE SERVICES CORPORATION");		
		employer.setSssNumber("03-9140457-7");

		PaymentDetail paymentDetail = new PaymentDetail();
		paymentDetail.setAmount(100000.10);
		paymentDetail.setDate("Aug 31, 2016");			// Format: MMM dd, yyyy
		paymentDetail.setNumber("123123123");
		
		List<Employee> employees = new ArrayList<>();
		Employee e = new Employee();
		e.setSssSSAmount(110.00);
		e.setSssECAmount(10.00);
		employees.add(e);
		employees.add(e);
		employees.add(e);
		
		SSSR3FormText txtFileCreator = new SSSR3FormText();
		txtFileCreator.setApplicablePeriod("072016");	// Format: MMyyyy
		txtFileCreator.setEmployees(employees);
		txtFileCreator.setEmployer(employer);
		txtFileCreator.setPaymentDetail(paymentDetail);

		try {
			File file = new File("C:/BPVillacrusis Files/data.txt");
			txtFileCreator.createTxtFile(new FileOutputStream(file));
			Desktop.getDesktop().open(file);
		} catch (IOException ex) {			
			ex.printStackTrace();
		}
		
	
	}

}
