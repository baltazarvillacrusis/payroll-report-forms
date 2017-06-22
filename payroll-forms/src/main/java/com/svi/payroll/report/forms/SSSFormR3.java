package com.svi.payroll.report.forms;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

import org.apache.poi.util.IOUtils;

import com.svi.payroll.report.objects.Employee;
import com.svi.payroll.report.objects.EmployeeBean;
import com.svi.payroll.report.objects.Employer;
import com.svi.report.utilities.ObjectComparator;

public class SSSFormR3 {
	
	private String quarterEnding = "";		
	private TYPE adjustMentType = TYPE.DEFAULT;
	private Employer employerInfo = new Employer();	
	private EmployeeBean employeeInfo = new EmployeeBean();	
	private final String OTHER_INFO_KEY = "otherInfo";	
	private final String EMPLOYER_INFO_KEY = "employerInfo";
	private final String EMPLOYEE_INFO_KEY = "employeeBean";
	private final String BLANK_IMAGE_KEY = "blankImage";
	private final String CHECK_IMAGE_KEY = "checkImage";
	private final String SSS_LOGO_KEY = "sssLogo";
	private static byte[]  templateFileBytes;
	private static byte[] blankImageFileBytes;
	private static byte[] checkImageFileBytes;
	private static byte[] sssLogoBytes;

	
	private String authorizeRep;//HEAD OF OFFICE OR AUTHORIZED REPRESENTATIVE
	private String position; //HEAD OF OFFICE OR AUTHORIZED REPRESENTATIVE designation/position

	
	public SSSFormR3(){		
	}
	public SSSFormR3(EmployeeBean employeeInfo){
		this.employeeInfo= employeeInfo;		
	}
	public SSSFormR3(EmployeeBean employeeInfo,Employer employerInfo){
		this.employeeInfo= employeeInfo;
		this.employerInfo = employerInfo;
	}
	
	public void createFormStream(OutputStream outputStream) throws JRException, IOException{	
		// checking for report template and images
		if(getTemplateFile() == null){
			throw new InvalidParameterException("The templateFile is not set. This must contain the file template needed to produce this report.");
		}		
		 //  ordering employees by name
		Collections.sort(employeeInfo,ObjectComparator.compareEmployeesByName); 
		
		Map<String, String> otherInfo = new HashMap<String, String>();
		otherInfo.put("quarterEnding", quarterEnding);
		otherInfo.put("adjustMentType", adjustMentType.getCode());
		
		// creating the parameter
		Map<String, Object> parameters = new HashMap<String, Object>();	
		parameters.put(EMPLOYER_INFO_KEY, employerInfo);	
		parameters.put(EMPLOYEE_INFO_KEY, employeeInfo);
		parameters.put(OTHER_INFO_KEY, otherInfo);
		
		// add image parameters       
        BufferedImage imageCheck = ImageIO.read(getCheckImageFile());
        BufferedImage imageBlank = ImageIO.read(getBlankImageFile());		
        BufferedImage sssLogo = ImageIO.read(getSssLogo());	
		parameters.put(BLANK_IMAGE_KEY, imageBlank);
		parameters.put(CHECK_IMAGE_KEY, imageCheck);
		parameters.put(SSS_LOGO_KEY, sssLogo);

		JasperReport jasperReport = (JasperReport)JRLoader.loadObject(getTemplateFile());
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,parameters, new JREmptyDataSource());		
		JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
		outputStream.flush();
		outputStream.close();
	}	

	public String getAuthorizeRep() {
		return authorizeRep;
	}

	public void setAuthorizeRep(String authorizeRep) {
		this.authorizeRep = authorizeRep;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public ArrayList<Employee> getEmployeeInfo() {
		return employeeInfo;
	}

	public void setEmployeeInfo(EmployeeBean employeeInfo) {
		this.employeeInfo = employeeInfo;
	}

	public void setEmployerInfo(Employer employerInfo) {
		this.employerInfo = employerInfo;
	}

	public Employer getEmployerInfo() {
		return employerInfo;
	}
	public String getQuarterEnding() {
		return quarterEnding;
	}
	public void setQuarterEnding(String quarterEnding) {
		this.quarterEnding = quarterEnding;
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
	public static InputStream getBlankImageFile() {
		return new ByteArrayInputStream(blankImageFileBytes);
	}
	public static void setBlankImageFile(InputStream blankImageFile) {
		try {
			blankImageFileBytes  = IOUtils.toByteArray(blankImageFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static InputStream getCheckImageFile() {
		return new ByteArrayInputStream(checkImageFileBytes);
	}
	public static void setCheckImageFile(InputStream checkImageFile) {
		try {
			checkImageFileBytes  = IOUtils.toByteArray(checkImageFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static InputStream getSssLogo() {
		return new ByteArrayInputStream(sssLogoBytes);
	}
	public static void setSssLogo(InputStream sssLogo) {
		try {
			sssLogoBytes = IOUtils.toByteArray(sssLogo);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public enum TYPE{
		ADDITION_TO_PREVIOUS("ADDITION"),DEDUCTION_TO_PREVIOUS("DEDUCTION"),DEFAULT("");
		
		private String value;
		
		private TYPE(String value){
			this.value = value;
		}
		
		public String getCode(){
			return this.value;
		}
	}

	public TYPE getAdjustMentType() {
		return adjustMentType;
	}
	public void setAdjustMentType(TYPE adjustMentType) {
		this.adjustMentType = adjustMentType;
	}
	
	
	
}
