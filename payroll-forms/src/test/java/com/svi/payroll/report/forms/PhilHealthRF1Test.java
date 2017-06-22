package com.svi.payroll.report.forms;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Test;

import com.svi.payroll.report.forms.PhilHealthRF1.REPORT_TYPE;
import com.svi.payroll.report.objects.Employee;
import com.svi.payroll.report.objects.Employee.SEX;
import com.svi.payroll.report.objects.Employee.STATUS;
import com.svi.payroll.report.objects.EmployeeBean;
import com.svi.payroll.report.objects.Employer;

import net.sf.jasperreports.engine.JRException;

public class PhilHealthRF1Test extends BaseTestSetup{

	@Test
	public void main() throws IOException {
		
		long startTime = System.currentTimeMillis();	
		System.out.println("Writing to PDF.");
		
		// employer info
		Employer employer = new Employer();		
		employer.setPhilHealthNumber("001234567890");		
		employer.setTin("000111222");
		employer.setName("Softwares Venture International");
		employer.setRegisteredAdd("22/F, ANTEL GLOBAL CORPORATE CENTER, #3, DONA JULIA VARGAS AVENUE, PASIG CITY, METRO MANILA, PHILIPPINES, 1605,");
		employer.setTelNum("0212345");
		employer.setEmailAddress("emailadd.svi.com.ph");
		employer.setCategory(Employer.CATEGORY.HOUSEHOLD);		
		
		// making employee objects
		EmployeeBean employeeBean = new EmployeeBean();
		
		for(int i=0; i<=32; i++){
			Employee employee = new Employee();
			employee.setFirstName("First Name " +i);
			employee.setLastName("Last Name " +i);
			employee.setMiddleName("Middle Name " +i);
			employee.setBirthDate("1025"+(2000+i));
			employee.setMonthlySalaryBracket((int) (Math.random()*27) + 1);
			employee.setPersonalSharePhil((employee.getMonthlySalaryBracket()*12.5)+200);
			employee.setEmployerSharePhil(employee.getPersonalSharePhil());
			
			employee.setEffectivityDate("1025"+(2000+i));		
			
			if(i%2 == 0){
				employee.setExtensionName("JR");
				employee.setSex(SEX.MALE);	
				employee.setStatus(STATUS.NEWLY_HIRED);
				employee.setPin((200+i)+"123456"+(300+i));
			}
			else if(i%3 == 0){
				employee.setExtensionName("SR");
				employee.setSex(SEX.MALE);
				employee.setStatus(STATUS.SEPARATED);
				employee.setPin((i)+"123456"+(300+i));
			}
			else{
				employee.setSex(SEX.FEMALE);	
				employee.setStatus(STATUS.NO_EARNINGS);
				//employee.setPin("");
			}
		
			employeeBean.add(employee);			
		}
		
		// creating new form
		PhilHealthRF1 form = new PhilHealthRF1(employer,employeeBean);			
		form.setApplicablePeriod("May 2017");
		form.setReportType(REPORT_TYPE.ADDITION_TO_PREVIOUS);
		form.setPreparedByName("Juan De La Cruz");
		form.setPreparedByDesignation("Treasurer");
		form.setCertifiedByName("Juana De La Cruz");
		form.setCertifiedByDesignation("Accountant");
		
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
