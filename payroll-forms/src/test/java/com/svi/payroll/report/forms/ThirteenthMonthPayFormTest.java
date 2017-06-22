package com.svi.payroll.report.forms;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.junit.Test;

import net.sf.jasperreports.engine.JRException;

import com.svi.payroll.report.forms.ThirteenthMonthPayForm;
import com.svi.payroll.report.objects.Employee;
import com.svi.payroll.report.objects.EmployeeBean;

public class ThirteenthMonthPayFormTest  extends BaseTestSetup {

	@Test
	public void main() throws IOException {
		/*InputStream template =new FileInputStream(
				new File("Report Resources/Jasper Templates/"
						+ "ThirteenthMonthPayForm.jasper"));
		ThirteenthMonthPayForm.setTemplateFile(template);*/
		long startTime = System.currentTimeMillis();
		System.out.println("Writing to PDF.");
		
		// making employee objects
		EmployeeBean employeeBean = getSampleEmployeeBean();
							
		// creating new form
		ThirteenthMonthPayForm form = new ThirteenthMonthPayForm(
				employeeBean, "2016");
				
		// creating the form as pdf	and opening it after
		try {
			File file = new File("data.pdf");
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

	private static EmployeeBean getSampleEmployeeBean(){

		EmployeeBean employeeBean = new EmployeeBean();
		
		for(int i=0; i<=22; i++){
			Employee employee = new Employee();
			employee.setID("000111222"+(200+i));
			employee.setThirteenthMonthPay(240000 +i*125.4);

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
		
		return employeeBean;
	}
}
