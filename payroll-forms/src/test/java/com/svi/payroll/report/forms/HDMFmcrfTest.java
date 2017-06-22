package com.svi.payroll.report.forms;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Test;

import com.svi.payroll.report.objects.Address;
import com.svi.payroll.report.objects.Employee;
import com.svi.payroll.report.objects.EmployeeBean;
import com.svi.payroll.report.objects.Employer;

import net.sf.jasperreports.engine.JRException;

public class HDMFmcrfTest extends BaseTestSetup{

	@Test
	public void main() throws IOException {
		
		
		long startTime = System.currentTimeMillis();
		System.out.println("Writing to PDF.");
	
		//employer info
		Employer employer = new Employer();
		employer.setPagibigNumber("000111222333");
		employer.setName("Softwares Venture International");		
		
		Address address = new Address();		
		address.setBarangay("Brg. Name");
		address.setBlockNo("#3");		
		address.setBuildingName("Antel Global Corporate Center");
		address.setCity("Pasig City");
		address.setCountry("Philippines");
		address.setFloorNum("22/F");
		address.setProvince("Metro Manila");
		address.setFloorNum("22F");
		address.setStreet("Julia Vargas Avenue");
		address.setSubdivision("Subd. Name");
		address.setUnitOrRoomNum("Rm 10");
		address.setZipCode("1605");
		
		employer.setAddress(address);
		
		// making employee objects
		EmployeeBean employeeBean = new EmployeeBean();
		
		for(int i=0; i<=22; i++){
			Employee employee = new Employee();
			employee.setPagibigMIDNumber("000111222"+(300+i));
			employee.setPagibigAcccountNumber("000111222"+(400+i));
			employee.setFirstName("Juan");
			employee.setLastName("De La Cruz");
			employee.setMiddleName("Protacio" +i);
			employee.setPagibigPeriodCovered((2000+i)+"-11");
			employee.setMonthlyCompensation(140000 +i*125.4);
			employee.setPagibigEEShare(100+i*23.0);
			employee.setPagibigERShare(100+i*25.0);			
			
			
			
			if(i%2 == 0){
				employee.setPagibigMembershipProgram("P-I");
				employee.setPagibigRemark("N: 11/24/"+(2000+i));
				employee.setExtensionName("Jr");
			}
			else if(i%3 == 0){
				employee.setPagibigMembershipProgram("P-II");
				employee.setPagibigRemark("L: 10/19/"+(2000+i));
				employee.setExtensionName("Sr");
			}
			else{
				employee.setPagibigMembershipProgram("MP-I");
			}		
			employeeBean.add(employee);			
		}
						
		
		
		// creating new form
		HDMFmcrf form = new HDMFmcrf(employer,employeeBean);	
		
		form.setSignatoryName("Juan De La Cruz");
		form.setSignatoryPosition("Accountant");
		
		
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
