package com.svi.payroll.report.forms;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.InvalidParameterException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import org.apache.poi.util.IOUtils;

import com.svi.payroll.report.objects.EmployeeBean;
import com.svi.payroll.report.objects.Employer;
import com.svi.report.utilities.ObjectComparator;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

public class PhilHealthRF1 {		
	private REPORT_TYPE reportType = REPORT_TYPE.DEFAULT;	
	private String preparedByName = "";
	private String preparedByDesignation= "";
	private String certifiedByName= "";
	private String certifiedByDesignation= "";	
	private String applicablePeriod= "";
	private Employer employerInfo = new Employer();
	private EmployeeBean employeeBean = new EmployeeBean();
	private final String EMPLOYER_INFO_KEY = "employerInfo";
	private final String OTHER_INFO_KEY = "otherInfo";	
	private final String EMPLOYEE_BEAN_KEY = "employeeBean";
	private final String HEADER_IMAGE_KEY = "headerImage";
	private final String FOOTER_IMAGE_KEY = "footerImage";
	private static byte[] headerImageFileBytes;
	private static byte[] templateFileBytes;
	private static byte[] footerImageFileBytes;
	
	public PhilHealthRF1(){
		
	}
	
	public PhilHealthRF1(Employer employerInfo){
		this.employerInfo = employerInfo;
	}
	
	public PhilHealthRF1(Employer employerInfo, EmployeeBean employeeBean){		
		this.employerInfo = employerInfo;
		this.employeeBean = employeeBean;
	}
	

	public void createFormStream(OutputStream outputStream) throws JRException, IOException{		
		if(getTemplateFile()==null){
			throw new InvalidParameterException("The templateFile is not set, this must contain the file template needed to produce this report.");
		}
		if(getHeaderImageFile() == null | getFooterImageFile() == null){
			throw new InvalidParameterException("The image inputstream is not set. The image is needed to produce this report.");
		}
		
		 //  ordering employees by name
		Collections.sort(employeeBean,ObjectComparator.compareEmployeesByName); 
		
		// creating the objects
		Map<String, Object> parameters = new HashMap<String, Object>();		
		// other info
		Map<String, String> otherInfo = new HashMap<String, String>();
		if(reportType == null){
			otherInfo.put("reportType", "");
		}
		else{
			otherInfo.put("reportType", reportType.toString());
		}		
		otherInfo.put("applicablePeriod", applicablePeriod);
		otherInfo.put("preparedByName", preparedByName);
		otherInfo.put("preparedByDesignation", preparedByDesignation);
		otherInfo.put("certifiedByName", certifiedByName);
		otherInfo.put("certifiedByDesignation", certifiedByDesignation);	
		
		// adding all the objects needed for the form			
		parameters.put(EMPLOYER_INFO_KEY, employerInfo);
		parameters.put(EMPLOYEE_BEAN_KEY, employeeBean);	
		parameters.put(OTHER_INFO_KEY, otherInfo);

		// add image parameters
        BufferedImage imageHeader = ImageIO.read(getHeaderImageFile());
        BufferedImage imageFooter = ImageIO.read(getFooterImageFile());			
		parameters.put(HEADER_IMAGE_KEY, imageHeader);
		parameters.put(FOOTER_IMAGE_KEY, imageFooter);
		
		// creating the report stream
		JasperReport jasperReport = (JasperReport)JRLoader.loadObject(getTemplateFile());
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,parameters, new JREmptyDataSource());		
		JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
		outputStream.flush();
		outputStream.close();
	}

	public void setEmployer(Employer employerInfo) {
		this.employerInfo = employerInfo;
	}

	public void setReportType(REPORT_TYPE reportType) {
		this.reportType = reportType;
	}

	public void setApplicablePeriod(String applicablePeriod) {
		this.applicablePeriod = applicablePeriod;
	}
	
	public enum REPORT_TYPE{
		REGULAR,ADDITION_TO_PREVIOUS,DEDUCTION_TO_PREVIOUS,DEFAULT;
	}

	public void setPreparedByName(String preparedByName) {
		this.preparedByName = preparedByName;
	}

	public void setPreparedByDesignation(String preparedByDesignation) {
		this.preparedByDesignation = preparedByDesignation;
	}

	public void setCertifiedByName(String certifiedByName) {
		this.certifiedByName = certifiedByName;
	}

	public void setCertifiedByDesignation(String certifiedByDesignation) {
		this.certifiedByDesignation = certifiedByDesignation;
	}
	public void setEmployeeBean(EmployeeBean employeeBean) {
		this.employeeBean = employeeBean;
	}

	public void setEmployerInfo(Employer employerInfo) {
		this.employerInfo = employerInfo;
	}

	public static InputStream getTemplateFile() {
		return new ByteArrayInputStream(templateFileBytes);
	}

	public static InputStream getHeaderImageFile() {
		return new ByteArrayInputStream(headerImageFileBytes);
	}

	public static InputStream getFooterImageFile() {
		return new ByteArrayInputStream(footerImageFileBytes);
	}

	public static void setHeaderImageFile(InputStream headerImageFile) {
		try {
			headerImageFileBytes=IOUtils.toByteArray(headerImageFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void setTemplateFile(InputStream templateFile) {
		try {
			templateFileBytes=IOUtils.toByteArray(templateFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void setFooterImageFile(InputStream footerImageFile) {
		try {
			footerImageFileBytes=IOUtils.toByteArray(footerImageFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
