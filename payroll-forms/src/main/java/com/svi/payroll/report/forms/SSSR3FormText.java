package com.svi.payroll.report.forms;

import java.io.IOException;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.NullArgumentException;

import com.svi.payroll.report.objects.Employee;
import com.svi.payroll.report.objects.Employer;
import com.svi.payroll.report.objects.PaymentDetail;

public class SSSR3FormText {
	private static final int MAX_LENGTH = 30;
	private Employer employer = new Employer();
	private PaymentDetail paymentDetail = new PaymentDetail();
	private List<Employee> employees = new ArrayList<Employee>();	
	private String applicablePeriod = "";
	private double totalSS;
	private double totalEC;
	
	public SSSR3FormText() {
		
	}

	public SSSR3FormText(Employer employer, PaymentDetail paymentDetail,
			List<Employee> employees, String applicablePeriod) {
		super();
		this.employer = employer;
		this.paymentDetail = paymentDetail;
		this.employees = employees;
		this.applicablePeriod = applicablePeriod;
	}
	
	public void createTxtFile(OutputStream outputStream) throws IOException{
		if(employees == null || employees.size() == 0)
			throw new NullArgumentException("employees");
		totalAllAmounts();
		StringBuilder sb = new StringBuilder();
		String content = sb
				.append(getHeader())
				.append(getDetails())
				.append(getFooter())
				.toString();
		
		byte[] contentInBytes = content.getBytes();
		outputStream.write(contentInBytes);
		outputStream.flush();
		outputStream.close();		
	}
	
	private String getHeader(){
		String employerName = "";
		String originalEmployerName = employer.getName();
		if(originalEmployerName != null){
			if(originalEmployerName.trim().length() > MAX_LENGTH){
				employerName = originalEmployerName.substring(0, MAX_LENGTH);
			}
			else{
				employerName = originalEmployerName.substring(0, originalEmployerName.length());
			}
		}
		
		String header = String.format("\n\n"+
						"File name    : %1$s" + "\n" +
						"Employer name: %2$-30s      Date: %3$s" + "\n" +
						"Employer No  : %4$-30s    App. Period: %5$s",
						getFileName(),
						employerName,
						getCurrentDate(),
						employer.getSssNumber(),
						applicablePeriod);
		return header;
	}
	
	private String getCurrentDate(){
		String currentDateString =  new SimpleDateFormat("MMM dd, yyyy").format(new Date());
		return currentDateString;
	}
	
	private String getFileName(){
		String sssNo = employer.getSssNumber().replace("-","");		
		
		//Change date format
		DateFormat targetFormat = new SimpleDateFormat("MMddHHmm");
		String dateTime = targetFormat.format(new Date());  // 20120821
		
		return "R3" + sssNo + applicablePeriod + "." + dateTime;
	}
	
	private String getDetails(){
		String details = String.format("\n\n\n" +
						 "             PAYMENT INFORMATION" + "\n" +
						 "             TR/SBR NUMBER   :    %1$s" + "\n" +
						 "             DATE OF PAYMENT :    %2$s" + "\n" +
						 "             AMOUNT PAID     : %3$15s" + "\n\n\n" +
						 "             ENCODED INFORMATION" + "\n" +
						 "             SS AMOUNT       : %4$15s" + "\n" +
						 "             EC AMOUNT       : %5$15s" + "\n" +
						 "             TOTAL AMOUNT    : %6$15s" + "\n\n" +
						 "             Total number of Employees: %7$s" + "\n\n\n\n",
						 paymentDetail.getNumber(),
						 paymentDetail.getDate(),
						 (new DecimalFormat("#,###.00")).format(paymentDetail.getAmount()),
						 (new DecimalFormat("#,###.00")).format(totalSS),
						 (new DecimalFormat("#,###.00")).format(totalEC),
						 (new DecimalFormat("#,###.00")).format(totalSS + totalEC),
						 employees.size()
						 );
		return details;
	
	}
	
	private void totalAllAmounts(){
		if(employees == null){
			return;
		}
			
		for(Employee employee : employees){
			totalSS += employee.getSssSSAmount();
			totalEC += employee.getSssECAmount();
		}
	}
	
	private String getFooter(){
		String footer = "CERTIFIED CORRECT AND PAID" + "\n" +
						"RECEIVED BY   : _____________________________" + "\n" +
						"DATE RECEIVED : _____________________________" + "\n" +
						"TRANSACTION NO: _____________________________";
		return footer;
	}

	public Employer getEmployer() {
		return employer;
	}

	public void setEmployer(Employer employer) {
		this.employer = employer;
	}

	public PaymentDetail getPaymentDetail() {
		return paymentDetail;
	}

	public void setPaymentDetail(PaymentDetail paymentDetail) {
		this.paymentDetail = paymentDetail;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public String getApplicablePeriod() {
		return applicablePeriod;
	}

	public void setApplicablePeriod(String applicablePeriod) {
		this.applicablePeriod = applicablePeriod;
	}
	
	
	
	
}
