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

public class HDMFmcrf {
	
	private String signatoryName  = "";
	private String signatoryPosition = "";
	private Employer employerInfo = new Employer();
	private EmployeeBean employeeBean = new EmployeeBean();
	private final String EMPLOYER_INFO_KEY = "employerInfo";
	private final String EMPLOYEE_BEAN_KEY = "employeeBean";
	private final String OTHER_INFO_KEY = "otherInfo";
	private final String HEADER_IMAGE_KEY = "headerImage";
	private final String FOOTER_IMAGE_KEY = "footerImage";
	private static byte[] templateFileBytes;
	private static byte[] headerImageFileBytes;
	private static byte[] footerImageFileBytes;
	
	public HDMFmcrf(){		
	}
	public HDMFmcrf(Employer employerInfo){		
		this.employerInfo = employerInfo;
	}
	public HDMFmcrf(Employer employerInfo, EmployeeBean employeeBean){		
		this.employerInfo = employerInfo;
		this.employeeBean = employeeBean;
	}
	
	public void createFormStream(OutputStream outputStream) throws JRException, IOException{	
		// checking for report template and images
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
		otherInfo.put("signatoryName", signatoryName);
		otherInfo.put("signatoryPosition", signatoryPosition);
		
		// adding all the objects needed for the form
		parameters.put(EMPLOYER_INFO_KEY, employerInfo);
		parameters.put(EMPLOYEE_BEAN_KEY, employeeBean);	
		parameters.put(OTHER_INFO_KEY, otherInfo);
		
		// add image parameters
        BufferedImage imageHeader = ImageIO.read(getHeaderImageFile());
        BufferedImage imageFooter =  ImageIO.read(getFooterImageFile());
		parameters.put(HEADER_IMAGE_KEY, imageHeader);
		parameters.put(FOOTER_IMAGE_KEY, imageFooter);
	
		// creating the report stream
		JasperReport jasperReport = (JasperReport)JRLoader.loadObject(getTemplateFile());
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,parameters, new JREmptyDataSource());		
		JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
		outputStream.flush();
		outputStream.close();
	
	}


	public void setSignatoryName(String signatoryName) {
		this.signatoryName = signatoryName;
	}
	public void setSignatoryPosition(String signatoryPosition) {
		this.signatoryPosition = signatoryPosition;
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
	public static InputStream getHeaderImageFile() {
		return new ByteArrayInputStream(headerImageFileBytes);
	}
	public static void setHeaderImageFile(InputStream headerImageFile) {
		try {
			headerImageFileBytes = IOUtils.toByteArray(headerImageFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static InputStream getFooterImageFile() {
		return new ByteArrayInputStream(footerImageFileBytes);
	}
	public static void setFooterImageFile(InputStream footerImageFile) {
		try {
			footerImageFileBytes = IOUtils.toByteArray(footerImageFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
