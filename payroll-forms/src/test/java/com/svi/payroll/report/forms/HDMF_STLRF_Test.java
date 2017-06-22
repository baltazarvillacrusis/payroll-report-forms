package com.svi.payroll.report.forms;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.Test;

import com.svi.payroll.report.objects.Address;
import com.svi.payroll.report.objects.Employee;
import com.svi.payroll.report.objects.Employer;

import net.sf.jasperreports.engine.JRException;

public class HDMF_STLRF_Test extends BaseTestSetup{

	@Test
	public void main() throws IOException {
		
		long startTime = System.currentTimeMillis();
		System.out.println("Writing to PDF.");

		// creating the objects to be used to generate the form
		// employee object		
		ArrayList < Employee > employeeList = new ArrayList < Employee > ();
		
		for (int x=1 ; x < 70 ; x++){			
			Employee employee = new Employee();
			employee.setPagibigMIDNumber("Pag-ibig num: "+x);
			employee.setApplicationNum(""+x);
			employee.setLastName("Surname "+x);
			employee.setFirstName("Firstname "+x);
			employee.setMiddleName("Middlename "+x);
			employee.setLoanType("Loantype "+x);
			employee.setAmount(1000.00);
			employee.setPagibigRemark("Remarks "+x);
			employee.setExtensionName("ext"+x);
			employeeList.add(employee);			
		}


		// employer object
		Employer employer = new Employer();
		
		Address employerAdd = new Address();
		employerAdd.setBarangay("Berengey");
		employerAdd.setBlockNo("1");
		employerAdd.setBuildingName("Belding");
		employerAdd.setCity("Zity");
		employerAdd.setCountry("Philippines");
		employerAdd.setFloorNum("2");
		employerAdd.setProvince(null);
		employerAdd.setStreet("Ztreet");
		employerAdd.setSubdivision("Zubdivision");
		employerAdd.setUnitOrRoomNum("508");
		employerAdd.setZipCode("1100");
		employerAdd.setProvince("Metro Manila");
		employer.setAddress(employerAdd);
		
		employer.setName("SVI Software Services Corporation");
		employer.setPagibigNumber("0001-2345678-9");
		employer.setTelNum("911 1111");		
	

		// creating new form
		HDMFstlrf form = new HDMFstlrf();
		form.setEmployerInfo(employer);		
		form.setEmployeeInfo(employeeList);
		form.setAuthorizeRep("Mister Representativez");
		form.setPosition("CEO");					
		form.setPeriodCovered("March 2017");
		

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