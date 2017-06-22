package com.svi.payroll.report.forms;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.svi.payroll.report.objects.Employee;
import com.svi.payroll.report.objects.EmployeeBean;

public class BankRegistersSalaryLoanRepaymentTest extends BaseTestSetup {
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
			employee.setBankAcctNum("1076-453-"+(200+i));
			employee.setBankName("Bank Name "+ (i+100));
			employee.setID("1234-"+(i+2000));			
			
			Map<String,BigDecimal> salaryLoans = new HashMap<String,BigDecimal>();
			BigDecimal bigDeci = new BigDecimal(i+1000.00);
			salaryLoans.put("BPI Loan "+i, bigDeci);
			salaryLoans.put("BDO"+i, bigDeci.multiply(new BigDecimal(2)));
			employee.setSalaryLoans(salaryLoans);
			
			employeeBean.add(employee);			
		}			
		
		 BankRegisterSalaryLoanRepayment form = new BankRegisterSalaryLoanRepayment(employeeBean);
		 form.setPeriod("April 2017");
		 form.setCompanyName("SVI Softwares Services Corporation");		
	
		// Desktop.getDesktop().open(form.createExcel());
		 
		File file = new File(getClass().getName()+".xlsx");
		form.createExcelStream(new FileOutputStream(file));			
		Desktop.getDesktop().open(file);
		 
		 System.out.println("Done writing to excel file.");

	}

}
