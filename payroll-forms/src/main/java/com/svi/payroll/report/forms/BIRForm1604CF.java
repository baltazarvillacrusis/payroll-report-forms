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

import com.svi.payroll.report.objects.Employer;
import com.svi.payroll.report.objects.RemittancePerBIR;
import com.svi.payroll.report.objects.RemittancePerBIR.MONTH;
import com.svi.payroll.report.objects.RemittancePerBIR.QUARTER;
import com.svi.report.utilities.ObjectComparator;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

public class BIRForm1604CF {
	
		private String forTheYear = "";
		private boolean isAmendedReturn;
		private String numSheetsAttached = "";			
		private Employer employerInfo = new Employer();		
		private List<RemittancePerBIR> schedule1 = new ArrayList<RemittancePerBIR>();
		private List<RemittancePerBIR> schedule2 = new ArrayList<RemittancePerBIR>();
		private List<RemittancePerBIR> schedule3 = new ArrayList<RemittancePerBIR>();
		private List<RemittancePerBIR> schedule4 = new ArrayList<RemittancePerBIR>();		
		private final String EMPLOYER_INFO_KEY = "employerInfo";	
		private final String SCHEDULE1_KEY = "schedule1";	
		private final String SCHEDULE2_KEY = "schedule2";	
		private final String SCHEDULE3_KEY = "schedule3";
		private final String SCHEDULE4_KEY = "schedule4";	
		private final String OTHER_INFO_KEY = "otherInfo";
		private final String FORM_IMAGE_KEY = "formImage";
		
		private static byte[] templateFileBytes;
		private static byte[] imageTemplateFileBytes;
		
		
		public BIRForm1604CF(){		
		}
		public BIRForm1604CF(Employer employerInfo,  List<RemittancePerBIR> schedule1){		
			this.employerInfo = employerInfo;	
			this.schedule1 = schedule1;
		}
		public BIRForm1604CF(Employer employerInfo,  List<RemittancePerBIR> schedule1,
				 List<RemittancePerBIR> schedule2){		
			this.employerInfo = employerInfo;	
			this.schedule1 = schedule1;
			this.schedule2= schedule2;
		}
		public BIRForm1604CF(Employer employerInfo,  List<RemittancePerBIR> schedule1,
				 List<RemittancePerBIR> schedule2,
				 List<RemittancePerBIR> schedule3){		
			this.employerInfo = employerInfo;	
			this.schedule1 = schedule1;
			this.schedule2= schedule2;
			this.schedule3= schedule3;
		}
		public BIRForm1604CF(Employer employerInfo,  List<RemittancePerBIR> schedule1,
				 List<RemittancePerBIR> schedule2,
				 List<RemittancePerBIR> schedule3,
				 List<RemittancePerBIR> schedule4){		
			this.employerInfo = employerInfo;	
			this.schedule1 = schedule1;
			this.schedule2= schedule2;
			this.schedule3= schedule3;
			this.schedule4= schedule4;
		}
		
		public void createFormStream(OutputStream outputStream) throws JRException, IOException{				
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
			otherInfo.put("isAmendedReturn", isAmendedReturn+"");
			otherInfo.put("numSheetsAttached", numSheetsAttached);
		
			// standardizing collection and sorting in ascending order by month
			standardizeMonths(schedule1);
			standardizeMonths(schedule2);
			standardizeMonths(schedule3);
			standardizeQuarters(schedule4);
		    Collections.sort(schedule1,ObjectComparator.compareRemittanceByIndexOrder);
		    Collections.sort(schedule2,ObjectComparator.compareRemittanceByIndexOrder);
		    Collections.sort(schedule3,ObjectComparator.compareRemittanceByIndexOrder);
		    Collections.sort(schedule4,ObjectComparator.compareRemittanceByIndexOrder);
		    
			// adding all the objects needed for the form			
			parameters.put(EMPLOYER_INFO_KEY, employerInfo);			
			parameters.put(SCHEDULE1_KEY, schedule1);
			parameters.put(SCHEDULE2_KEY, schedule2);
			parameters.put(SCHEDULE3_KEY, schedule3);
			parameters.put(SCHEDULE4_KEY, schedule4);
			parameters.put(OTHER_INFO_KEY, otherInfo);

			//add image parameter
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
		public void setAmendedReturn(boolean isAmendedReturn) {
			this.isAmendedReturn = isAmendedReturn;
		}
		public void setNumSheetsAttached(String numSheetsAttached) {
			this.numSheetsAttached = numSheetsAttached;
		}	

		public void setEmployerInfo(Employer employerInfo) {
			this.employerInfo = employerInfo;
		}
		
		
		private void standardizeMonths(List<RemittancePerBIR> remittanceList){
			if(remittanceList.size() == 12){
				return;
			}
			List<MONTH> months = new ArrayList<MONTH>();
			months.add(MONTH.JANUARY);
			months.add(MONTH.FEBRUARY);
			months.add(MONTH.MARCH);
			months.add(MONTH.APRIL);
			months.add(MONTH.MAY);
			months.add(MONTH.JUNE);
			months.add(MONTH.JULY);
			months.add(MONTH.AUGUST);
			months.add(MONTH.SEPTEMBER);
			months.add(MONTH.OCTOBER);
			months.add(MONTH.NOVEMBER);
			months.add(MONTH.DECEMBER);
			
			outerloop:
			for(MONTH month : months){
				boolean isPresent = false;
				for(RemittancePerBIR remittance : remittanceList){
					if(remittance.getMonth().getValue() == month.getValue()){
						isPresent = true;
						continue outerloop;
					}
				}
				
				if(!isPresent){
					RemittancePerBIR newRemit = new RemittancePerBIR();
					newRemit.setMonth(month);
					remittanceList.add(newRemit);
				}
			}			
		}
		
		private void standardizeQuarters(List<RemittancePerBIR> remittanceList){
			if(remittanceList.size() == 4){
				return;
			}
			List<QUARTER> quarters = new ArrayList<QUARTER>();
			quarters.add(QUARTER.FIRST_QUARTER);
			quarters.add(QUARTER.SECOND_QUARTER);
			quarters.add(QUARTER.THIRD_QUARTER);
			quarters.add(QUARTER.FOURTH_QUARTER);
			
			
			outerloop:
			for(QUARTER quarter : quarters){
				boolean isPresent = false;
				for(RemittancePerBIR remittance : remittanceList){
					if(remittance.getQuarter().getValue() == quarter.getValue()){
						isPresent = true;
						continue outerloop;
					}
				}
				
				if(!isPresent){
					RemittancePerBIR newRemit = new RemittancePerBIR();
					newRemit.setQuarter(quarter);;
					remittanceList.add(newRemit);
				}
			}			
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
