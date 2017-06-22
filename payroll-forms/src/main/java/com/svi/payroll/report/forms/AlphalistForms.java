package com.svi.payroll.report.forms;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.util.IOUtils;

import com.svi.payroll.report.objects.Alphalist;
import com.svi.report.utilities.ObjectComparator;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

public class AlphalistForms {
	
	private ArrayList<Alphalist> employeesS1 = new ArrayList<Alphalist>();	
	private ArrayList<Alphalist> employeesS2 = new ArrayList<Alphalist>();	
	private ArrayList<Alphalist> employeesS3 = new ArrayList<Alphalist>();
	private ArrayList<Alphalist> employeesS4 = new ArrayList<Alphalist>();
	private ArrayList<Alphalist> employeesS5 = new ArrayList<Alphalist>();
	private ArrayList<Alphalist> employeesS6 = new ArrayList<Alphalist>();
	private ArrayList<Alphalist> employeesS7 = new ArrayList<Alphalist>();	
	private final String employeesS1Key = "employeesS1";
	private final String employeesS2Key = "employeesS2";
	private final String employeesS3Key = "employeesS3";
	private final String employeesS4Key = "employeesS4";
	private final String employeesS5Key = "employeesS5";
	private final String employeesS6Key = "employeesS6";
	private final String employeesS7Key = "employeesS7";
	private static byte[] templateFileBytes ;
	
	public AlphalistForms(){		
	}
	public AlphalistForms(ArrayList<Alphalist> employeesS1){
		this.employeesS1 = employeesS1;
	}
	public AlphalistForms(ArrayList<Alphalist> employeesS1, ArrayList<Alphalist> employeesS2){
		this.employeesS1 = employeesS1;
		this.employeesS2 = employeesS2;
	}
	public AlphalistForms(ArrayList<Alphalist> employeesS1, ArrayList<Alphalist> employeesS2, 
			ArrayList<Alphalist> employeesS3){
		this.employeesS1 = employeesS1;
		this.employeesS2 = employeesS2;
		this.employeesS3 = employeesS3;
	}
	public AlphalistForms(ArrayList<Alphalist> employeesS1, ArrayList<Alphalist> employeesS2, 
			ArrayList<Alphalist> employeesS3, ArrayList<Alphalist> employeesS4){
		this.employeesS1 = employeesS1;
		this.employeesS2 = employeesS2;
		this.employeesS3 = employeesS3;
		this.employeesS4 = employeesS4;
	}
	public AlphalistForms(ArrayList<Alphalist> employeesS1, ArrayList<Alphalist> employeesS2, 
			ArrayList<Alphalist> employeesS3, ArrayList<Alphalist> employeesS4,
			ArrayList<Alphalist> employeesS5){
		this.employeesS1 = employeesS1;
		this.employeesS2 = employeesS2;
		this.employeesS3 = employeesS3;
		this.employeesS4 = employeesS4;
		this.employeesS5 = employeesS5;
	}
	public AlphalistForms(ArrayList<Alphalist> employeesS1, ArrayList<Alphalist> employeesS2, 
			ArrayList<Alphalist> employeesS3, ArrayList<Alphalist> employeesS4,
			ArrayList<Alphalist> employeesS5, ArrayList<Alphalist> employeesS6){
		this.employeesS1 = employeesS1;
		this.employeesS2 = employeesS2;
		this.employeesS3 = employeesS3;
		this.employeesS4 = employeesS4;
		this.employeesS5 = employeesS5;
		this.employeesS6 = employeesS6;
	}
	public AlphalistForms(ArrayList<Alphalist> employeesS1, ArrayList<Alphalist> employeesS2, 
			ArrayList<Alphalist> employeesS3, ArrayList<Alphalist> employeesS4,
			ArrayList<Alphalist> employeesS5, ArrayList<Alphalist> employeesS6,
			ArrayList<Alphalist> employeesS7){
		this.employeesS1 = employeesS1;
		this.employeesS2 = employeesS2;
		this.employeesS3 = employeesS3;
		this.employeesS4 = employeesS4;
		this.employeesS5 = employeesS5;
		this.employeesS6 = employeesS6;
		this.employeesS7 = employeesS7;
	}
	
	
	public void createFormStream(OutputStream outputStream) throws JRException, IOException{	
		if(getTemplateFile() == null){
			throw new InvalidParameterException("The templateFile is not set, this must contain the file template needed to produce this report.");
		}
		 //  ordering alphalist by name
		Collections.sort(employeesS1,ObjectComparator.compareAlphalistByName); 
		Collections.sort(employeesS2,ObjectComparator.compareAlphalistByName); 
		Collections.sort(employeesS3,ObjectComparator.compareAlphalistByName); 
		Collections.sort(employeesS4,ObjectComparator.compareAlphalistByName); 
		Collections.sort(employeesS5,ObjectComparator.compareAlphalistByName); 
		Collections.sort(employeesS6,ObjectComparator.compareAlphalistByName); 
		Collections.sort(employeesS7,ObjectComparator.compareAlphalistByName); 
		
		// creating the parameter
		Map<String, Object> parameters = new HashMap<String, Object>();	
		parameters.put(employeesS1Key, employeesS1);
		parameters.put(employeesS2Key, employeesS2);
		parameters.put(employeesS3Key, employeesS3);
		parameters.put(employeesS4Key, employeesS4);
		parameters.put(employeesS5Key, employeesS5);
		parameters.put(employeesS6Key, employeesS6);
		parameters.put(employeesS7Key, employeesS7);
		// creating the report stream
		JasperReport jasperReport = (JasperReport)JRLoader.loadObject(getTemplateFile());
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,parameters, new JREmptyDataSource());		
		JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
		outputStream.flush();
		outputStream.close();
	}	
	
	public void setEmployeesS1(ArrayList<Alphalist> employeesS1) {
		this.employeesS1 = employeesS1;
	}
	public void setEmployeesS2(ArrayList<Alphalist> employeesS2) {
		this.employeesS2 = employeesS2;
	}
	public void setEmployeesS3(ArrayList<Alphalist> employeesS3) {
		this.employeesS3 = employeesS3;
	}
	public void setEmployeesS4(ArrayList<Alphalist> employeesS4) {
		this.employeesS4 = employeesS4;
	}
	public void setEmployeesS5(ArrayList<Alphalist> employeesS5) {
		this.employeesS5 = employeesS5;
	}
	public void setEmployeesS6(ArrayList<Alphalist> employeesS6) {
		this.employeesS6 = employeesS6;
	}
	public void setEmployeesS7(ArrayList<Alphalist> employeesS7) {
		this.employeesS7 = employeesS7;
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
}
