package com.svi.payroll.report.forms;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Test;

import com.svi.payroll.report.objects.Employee;
import com.svi.payroll.report.objects.EmployeeBean;

public class PayrollRegisterInternalTest extends BaseTestSetup{
	
	@Test
	public void main() throws IOException {
		System.out.println("Writing to excel file..");		
		// making employee objects
		EmployeeBean employeeBean = new EmployeeBean();
		
		for(int i=0; i<=22; i++){
			Employee employee = new Employee();			
			employee.setFirstName("Juan");
			employee.setLastName("De La Cruz");
			employee.setMiddleName("Protacio" +i);
			employee.setDepartment("Dept "+i);
			employee.setBasicSalary(1000+i);
			employee.setLate(2000+i);
			employee.setAbsences(3000+i);
			employee.setOvertime(4000+i);
			employee.setNightShift(5000+i);
			employee.setNightShiftOverTime(5500+i);
			employee.setVacationLeave(6000+i);
			employee.setSickLeave(7000+i);
			employee.setGrossPay(8000+i);
			employee.setSssEmployeeShare(9000+i);
			employee.setPagibigEEShare(10000+i);
			employee.setPersonalSharePhil(11000+i);
			employee.setWithholdingTax(12000+i);
			employee.setNetPay(13000+i);
			employee.setOthers(14000+i);
			employee.setComissary(15000+i);
			employee.setAllotment(16000+i);			
			employee.setSssLoan(17000+i);
			employee.setPagibigLoan(18000+i);			
			employee.setAmountToBeReceived(19000+i);
			
			employeeBean.add(employee);			
		}			
		
		PayrollRegister form = new PayrollRegister(employeeBean);
		form.setPeriod("April 2017");
		form.setCompanyName("SVI Softwares Services Corporation");		
		form.setRunType("Rerun");		
	
		// Desktop.getDesktop().open(form.createExcel());
		 
		File file = new File(getClass().getName()+".xlsx");
		form.createExcelStream(new FileOutputStream(file));			
		Desktop.getDesktop().open(file);
		 
		 System.out.println("Done writing to excel file.");

	}
}
