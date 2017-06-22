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
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;

import org.apache.poi.util.IOUtils;

import com.svi.payroll.report.objects.Employee;
import com.svi.payroll.report.objects.Employer;
import com.svi.report.utilities.ObjectComparator;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;

public class HDMFstlrf {	
	private String periodCovered = "";
	private ArrayList<Employee> employeeInfo = new ArrayList<Employee>();	
	private Employer employerInfo = new Employer();	
	private String authorizeRep = "";
	private String position = ""; 
	private final String EMPLOYER_INFO_KEY = "employerInfo";
	private final String FORM_IMAGE_KEY = "logoImage";
	private static byte[] templateFileBytes;
	private static byte[] imageTemplateFileBytes;
	
	public HDMFstlrf(){		
	}
	public HDMFstlrf(ArrayList<Employee> employeeInfo){
		this.employeeInfo= employeeInfo;		
	}
	public HDMFstlrf(ArrayList<Employee> employeeInfo,Employer employerInfo){
		this.employeeInfo= employeeInfo;
		this.employerInfo = employerInfo;
	}
	
	
	public void createFormStream(OutputStream outputStream) throws JRException, IOException{	
		// checking for report template and images
		if(getTemplateFile()==null){
			throw new InvalidParameterException("The templateFile is not set, this must contain the file template needed to produce this report.");
		}
		if(getImageTemplateFile() == null){
			throw new InvalidParameterException("The image inputstream is not set. The image is needed to produce this report.");
		}
		
		//  ordering employees by name
		Collections.sort(employeeInfo,ObjectComparator.compareEmployeesByName);
		
		// creating the parameter
		Map<String, Object> parameters = new HashMap<String, Object>();	
		parameters.put(EMPLOYER_INFO_KEY, employerInfo);
		
		// add image parameter
        BufferedImage image = ImageIO.read(getImageTemplateFile());
		parameters.put(FORM_IMAGE_KEY, image);		

		List<HDMFstlrf> formList = new ArrayList<HDMFstlrf>();
		formList.add(this);	
		
		// creating the report stream
		JasperReport jasperReport = (JasperReport)JRLoader.loadObject(getTemplateFile());
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,parameters, new JRBeanCollectionDataSource(formList));		
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

	public void setEmployeeInfo(ArrayList<Employee> employeeInfo) {
		this.employeeInfo = employeeInfo;
	}

	public String getPeriodCovered() {
		return periodCovered;
	}

	public void setPeriodCovered(String periodCovered) {
		this.periodCovered = periodCovered;
	}
	
	public void setEmployerInfo(Employer employerInfo) {
		this.employerInfo = employerInfo;
	}

	public Employer getEmployerInfo() {
		return employerInfo;
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
	public static InputStream getImageTemplateFile() {
		return new ByteArrayInputStream(imageTemplateFileBytes);
	}
	public static void setImageTemplateFile(InputStream imageTemplateFile) {
		try {
			imageTemplateFileBytes=IOUtils.toByteArray(imageTemplateFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
