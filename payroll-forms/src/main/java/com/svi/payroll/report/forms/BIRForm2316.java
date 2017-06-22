package com.svi.payroll.report.forms;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import org.apache.poi.util.IOUtils;

import com.svi.payroll.report.objects.Employee;
import com.svi.payroll.report.objects.NonTaxableCompensationIncome;
import com.svi.payroll.report.objects.TaxSummary;
import com.svi.payroll.report.objects.TaxableCompensationIncome;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

public class BIRForm2316 {
	private String forTheYear = "";	
	private String startPeriod = "";
	private String endPeriod = "";
	private String employerSignatoryName = "";
	private Employee employeeInfo = new Employee();	
	private NonTaxableCompensationIncome nonTaxableCompensation = new NonTaxableCompensationIncome();
	private TaxableCompensationIncome taxableCompensation = new TaxableCompensationIncome();
	private TaxSummary taxSummary = new TaxSummary();	
	private final String EMPLOYEE_INFO_KEY = "employeeInfo";
	private final String NONTAXABLE_KEY = "nonTaxable";
	private final String TAXABLE_KEY = "taxable";
	private final String TAX_SUMMARY_KEY = "taxSummary";
	private final String OTHER_INFO_KEY = "otherInfo";
	private final String FORM_IMAGE_KEY = "formImage";
	private static byte[] templateFileBytes ;
	private static byte[] imageTemplateFileBytes;
	
	
	public BIRForm2316(){			
	}
	public BIRForm2316(Employee employeeInfo, NonTaxableCompensationIncome nonTaxableCompensation,TaxableCompensationIncome taxableCompensation){		
		this.employeeInfo = employeeInfo;
		this.nonTaxableCompensation = nonTaxableCompensation;
		this.taxableCompensation = taxableCompensation;		
	}
	public BIRForm2316(Employee employeeInfo, NonTaxableCompensationIncome nonTaxableCompensation,TaxableCompensationIncome taxableCompensation, TaxSummary taxSummary){		
		this.employeeInfo = employeeInfo;
		this.nonTaxableCompensation = nonTaxableCompensation;
		this.taxableCompensation = taxableCompensation;
		this.taxSummary = taxSummary;
	}
	
	public void createFormStream(OutputStream outputStream) throws JRException, IOException{		
		// checking for report template and images
		if(getTemplateFile() == null){
			throw new InvalidParameterException("The templateFile is not set, this must contain the file template needed to produce this report.");
		}
		if(getImageTemplateFile() == null){
			throw new InvalidParameterException("The image inputstream is not set. The image is needed to produce this report.");
		}
		// creating the objects
		Map<String, Object> parameters = new HashMap<String, Object>();
		
		// other info
		Map<String, String> otherInfo = new HashMap<String, String>();
		otherInfo.put("forTheYear", forTheYear);
		otherInfo.put("startPeriod", startPeriod);
		otherInfo.put("endPeriod", endPeriod);
		otherInfo.put("employerSignatoryName", employerSignatoryName);		
		
		// adding all the objects needed for the form
		parameters.put(EMPLOYEE_INFO_KEY, employeeInfo);
		parameters.put(NONTAXABLE_KEY, nonTaxableCompensation);
		parameters.put(TAXABLE_KEY, taxableCompensation);
		parameters.put(TAX_SUMMARY_KEY, taxSummary);
		parameters.put(OTHER_INFO_KEY, otherInfo);

		// add image parameter
        BufferedImage image = ImageIO.read(getImageTemplateFile());
		parameters.put(FORM_IMAGE_KEY, image);		
		
		// creating the report stream	
		JasperReport jasperReport = (JasperReport)JRLoader.loadObject(getTemplateFile());
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,parameters, new JREmptyDataSource());		
		JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
		outputStream.flush();
		outputStream.close();		
	}

	public void setForTheYear(String forTheYear) {
		this.forTheYear = forTheYear;
	}

	public void setStartPeriod(String startPeriod) {
		this.startPeriod = startPeriod;
	}

	public void setEndPeriod(String endPeriod) {
		this.endPeriod = endPeriod;
	}

	public void setEmployeeInfo(Employee employeeInfo) {
		this.employeeInfo = employeeInfo;
	}

	public void setNonTaxableCompensation(
			NonTaxableCompensationIncome nonTaxableCompensation) {
		this.nonTaxableCompensation = nonTaxableCompensation;
	}

	public void setTaxableCompensation(TaxableCompensationIncome taxableCompensation) {
		this.taxableCompensation = taxableCompensation;
	}

	public void setTaxSummary(TaxSummary taxSummary) {
		this.taxSummary = taxSummary;
	}	

	public void setEmployerSignatoryName(String employerSignatoryName) {
		this.employerSignatoryName = employerSignatoryName;
	}
	public static InputStream getTemplateFile() {
		return new ByteArrayInputStream(templateFileBytes);
	}
	public static void setTemplateFile(InputStream templateFile) {
		try {
			templateFileBytes = IOUtils.toByteArray(templateFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static InputStream getImageTemplateFile() {
		return new ByteArrayInputStream(imageTemplateFileBytes);
	}
	public static void setImageTemplateFile(InputStream imageTemplateFile) {
		try {
			imageTemplateFileBytes = IOUtils.toByteArray(imageTemplateFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


}
