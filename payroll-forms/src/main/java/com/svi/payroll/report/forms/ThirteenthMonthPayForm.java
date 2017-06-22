package com.svi.payroll.report.forms;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

import org.apache.poi.util.IOUtils;

import com.svi.payroll.report.objects.EmployeeBean;

public class ThirteenthMonthPayForm {
	
	private final String EMPLOYEE_BEAN_KEY = "EmployeeBean";
	private final String YEAR_KEY = "ForTheYear";

	private static byte[] templateFileBytes;
	private String year;	
	
	private EmployeeBean employeeBean = new EmployeeBean();	
		
	public ThirteenthMonthPayForm(){		
	}
	
	public ThirteenthMonthPayForm(EmployeeBean employeeBean){		
		this.employeeBean = employeeBean;
	}
	
	public ThirteenthMonthPayForm(EmployeeBean employeeBean, String year) {
		super();
		this.year = year;
		this.employeeBean = employeeBean;
	}

	public void createFormStream(OutputStream outputStream) throws JRException, IOException{	
		// checking for report template and images
		if(getTemplateFile()==null){
			throw new InvalidParameterException("The templateFile is not set, this must contain the file template needed to produce this report.");
		}
		
		// creating the objects
		Map<String, Object> parameters = new HashMap<String, Object>();
			
		// adding all the objects needed for the form		
		parameters.put(EMPLOYEE_BEAN_KEY, employeeBean);	
		parameters.put(YEAR_KEY, year);
		
		// creating the report stream
		JasperReport jasperReport = (JasperReport)JRLoader.loadObject(getTemplateFile());
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,parameters, new JREmptyDataSource());		
		JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
		outputStream.flush();
		outputStream.close();
	
	}

	public static InputStream getTemplateFile() {
		return new ByteArrayInputStream(templateFileBytes);
	}
	
	public static void setTemplateFile(InputStream templateFile) {
		try {
			templateFileBytes=IOUtils.toByteArray(templateFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public EmployeeBean getEmployeeBean() {
		return employeeBean;
	}

	public void setEmployeeBean(EmployeeBean employeeBean) {
		this.employeeBean = employeeBean;
	}
	

}
