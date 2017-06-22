package com.svi.payroll.report.forms;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;

import org.junit.Test;

import com.svi.payroll.report.forms.SSSFormR3.TYPE;
import com.svi.payroll.report.objects.Address;
import com.svi.payroll.report.objects.Employee;
import com.svi.payroll.report.objects.Employee.STATUS;
import com.svi.payroll.report.objects.EmployeeBean;
import com.svi.payroll.report.objects.Employer;
import com.svi.payroll.report.objects.Employer.CATEGORY;

public class SSSFormR3Test extends BaseTestSetup{

	@Test
	public void main() throws IOException {

		long startTime = System.currentTimeMillis();
		System.out.println("Writing to PDF.");

		// creating the objects to be used to generate the form
		// employee object		
		EmployeeBean employeeList = new EmployeeBean();
		
		for (int x=1 ; x < 16 ; x++){			
			Employee employee = new Employee();
			employee.setSssNumber(""+(1000000000+x));			
			employee.setLastName("Surname");
			employee.setFirstName("Firstname "+x);
			employee.setMiddleName(x+"rt");
			employee.setEffectivityDate("1115"+(2000+x));
			
			 Map<String,Double> quarterSSAmount = new HashMap<String,Double>();
			
			 Map<String,Double> quarterECAmount = new HashMap<String,Double>();
			
			
			
			if(x%2==0){
				employee.setExtensionName("JR");
				employee.setStatus(STATUS.SEPARATED);
				
				 quarterSSAmount.put("FIRST", 101.0);
				 quarterSSAmount.put("SECOND", 102.0);
				 quarterSSAmount.put("THIRD", 103.0);
				 
				 quarterECAmount.put("FIRST",201.0);
				 quarterECAmount.put("SECOND", 202.0);
				 quarterECAmount.put("THIRD", 203.0);
				 
			}
			else if(x%3==0){
				employee.setExtensionName("SR");
				employee.setStatus(STATUS.SEPARATED);
				
				 quarterSSAmount.put("SECOND", 102.0);
				 quarterSSAmount.put("THIRD", 103.0);
				 
				 quarterECAmount.put("SECOND", 202.0);
				 quarterECAmount.put("THIRD", 203.0);
			}
			else if(x%5==0){
				quarterSSAmount.put("THIRD", 103.0);				 
				quarterECAmount.put("SECOND",202.0);
			}
			
			employee.setQuarterSSAmount(quarterSSAmount);
			
			employee.setQuarterECAmount(quarterECAmount);
			
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
		employer.setRegisteredAdd(employerAdd.completeAddress());
		
		employer.setName("SVI Software Services Corporation");
		employer.setSssNumber("0001-2345678-90");
		employer.setTelNum("911 1111");
		employer.setSssCategory(CATEGORY.HOUSEHOLD);	
		
	

		// creating new form
		SSSFormR3 form = new SSSFormR3();
		form.setEmployerInfo(employer);		
		form.setEmployeeInfo(employeeList);
		form.setAuthorizeRep("Mister Representativez");
		form.setPosition("CEO");						
		form.setQuarterEnding("122017");
		form.setAdjustMentType(TYPE.ADDITION_TO_PREVIOUS);

	
		// creating the form as pdf	and opening it after
		try {
			File file = new File(getClass().getName()+".pdf");
			form.createFormStream(new FileOutputStream(file));
			Desktop.getDesktop().open(file);
		} catch (JRException e) {			
			e.printStackTrace();
		}

		System.out.println("Done writing to PDF.");
		long endTime = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("Total run time: " + totalTime + " ms");

	}

}