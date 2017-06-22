package com.svi.payroll.report.forms;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.InvalidParameterException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;

import org.apache.commons.lang.WordUtils;
import org.apache.poi.util.IOUtils;

import com.svi.payroll.report.objects.Employer;
import com.svi.payroll.report.objects.EmployerContribution;
import com.svi.payroll.report.objects.PaymentDetail;
import com.svi.payroll.report.objects.PaymentDetail.TYPE;
import com.svi.report.utilities.EnglishNumberToWords;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

public class SSSFormR5 {			
	private Employer employerInfo = new Employer();	
	private Map<String, List<EmployerContribution>> penaltyList = new HashMap<String, List<EmployerContribution>>();
	private Map<TYPE, PaymentDetail> paymentDetails = new HashMap<TYPE, PaymentDetail>() ;
	private String signatoryPosition = "";
	private String signatoryName = "";	
	private final String EMPLOYER_INFO_KEY = "employerInfo";
	private final String OTHER_INFO_KEY = "otherInfo";
	private final String PAYMENT_DETAIL_KEY = "paymentDetail";
	private final String PENALTY_LIST_KEY = "penaltyList";
	private final String FORM_IMAGE_KEY = "formImage";
	private final String BLANK_IMAGE_KEY = "blankImage";
	private final String CHECK_IMAGE_KEY = "checkImage";
	private static byte[] templateFileBytes;
	private static byte[] formImageFileBytes;
	private static byte[] blankImageFileBytes;
	private static byte[] checkImageFileBytes;
	
	public SSSFormR5(){
		
	}
	public SSSFormR5(Employer employerInfo, Map<String, List<EmployerContribution>> penaltyList){
		this.employerInfo = employerInfo;
		this.penaltyList = penaltyList;	
	}
	
	public SSSFormR5(Employer employerInfo,Map<String, List<EmployerContribution>> penaltyList, Map<TYPE, PaymentDetail> paymentDetails){
		this.employerInfo = employerInfo;
		this.penaltyList = penaltyList;
		this.paymentDetails = paymentDetails;
	}
	
	

	public void createFormStream(OutputStream outputStream) throws JRException, IOException{		
		if(getTemplateFile() == null){
			throw new InvalidParameterException("The templateFile is not set, this must contain the file template needed to produce this report.");
		}
		if(getFormImageFile() == null | getBlankImageFile() == null | getCheckImageFile() == null ){
			throw new InvalidParameterException("The image inputstream is not set. The image is needed to produce this report.");
		}
	
		// other info
		Map<String, Object> otherInfo = new HashMap<String, Object>();
		otherInfo.put("signatoryPosition", signatoryPosition);
		otherInfo.put("signatoryName", signatoryName);
		otherInfo.put("numToWord", getTotalAmountToWord());
		otherInfo.put("ssConSubTotal", getSSConSubTotal());
		otherInfo.put("ecConSubTotal", getECConSubTotal());		
		otherInfo.put("ssConPenaltySubTotal", getSSConPenaltySubTotal());
		otherInfo.put("ecConPenaltySubTotal", getECConPenaltySubTotal());
		otherInfo.put("getTotalAmtOfPayment", getTotalAmtOfPayment());	
		
		// creating the objects
		Map<String, Object> parameters = new HashMap<String, Object>();		
		// adding all the objects needed for the form			
		parameters.put(EMPLOYER_INFO_KEY, employerInfo);	
		parameters.put(PAYMENT_DETAIL_KEY, paymentDetails);
		parameters.put(PENALTY_LIST_KEY, penaltyList);
		parameters.put(OTHER_INFO_KEY, otherInfo);

		// add image parameters
        BufferedImage imageForm = ImageIO.read(getFormImageFile());
        BufferedImage imageCheck = ImageIO.read(getCheckImageFile());
        BufferedImage imageBlank = ImageIO.read(getBlankImageFile());
		parameters.put(FORM_IMAGE_KEY, imageForm);
		parameters.put(BLANK_IMAGE_KEY, imageBlank);
		parameters.put(CHECK_IMAGE_KEY, imageCheck);
		
		// creating the report stream
		JasperReport jasperReport = (JasperReport)JRLoader.loadObject(getTemplateFile());
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,parameters, new JREmptyDataSource());		
		JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
		outputStream.flush();
		outputStream.close();

	}
	
	public double getSSConSubTotal(){
		double total = 0;
		for (Map.Entry<String, EmployerContribution> entry : employerInfo.getEmpConList().entrySet()){
			total = total + entry.getValue().getSsContribution();
		}
		return total;
	}
	
	public double getECConSubTotal(){
		double total = 0;
		for (Map.Entry<String, EmployerContribution> entry : employerInfo.getEmpConList().entrySet()){
			total = total + entry.getValue().getEmployeeCompensation();
		}
		return total;
	}

	public double getSSConPenaltySubTotal(){
		double total = 0;
		for (Map.Entry<String,List<EmployerContribution>> entry : penaltyList.entrySet()){
			for(EmployerContribution empContri: entry.getValue()){
				total = total + empContri.getSsConPenalty();
			}			
		}
		return total;
	}
	
	public double getECConPenaltySubTotal(){
		double total = 0;
		for (Map.Entry<String,List<EmployerContribution>> entry : penaltyList.entrySet()){
			for(EmployerContribution empContri: entry.getValue()){
				total = total + empContri.getEmpCompPenalty();
			}			
		}
		return total;
	}

	public String getTotalAmountToWord() {		
		// use this when payment types are available
		/*double total = 0;
		for (Map.Entry<TYPE, PaymentDetail> entry : paymentDetails.entrySet()){
			total = total + entry.getValue().getAmount();		    
		}	*/	
		double total = getTotalAmtOfPayment();
		long whole = (long) total;		
		String amount = EnglishNumberToWords.convert((long) total);	
		amount = WordUtils.capitalize(amount);
		amount = amount +"\n and "+new DecimalFormat("0.00").format((total-whole))+" cents";
		return amount;
	}
	
	public double getTotalAmtOfPayment(){
		return  getSSConSubTotal()+getECConSubTotal()+getSSConPenaltySubTotal()+getECConPenaltySubTotal();		
	}
	
	
	public void setPaymentDetails(Map<TYPE, PaymentDetail> paymentDetails) {
		this.paymentDetails = paymentDetails;
	}

	public void setEmployerInfo(Employer employerInfo) {
		this.employerInfo = employerInfo;
	}

	public void setSignatoryPosition(String signatoryPosition) {
		this.signatoryPosition = signatoryPosition;
	}

	
	public void setSignatoryName(String signatoryName) {
		this.signatoryName = signatoryName;
	}
	
	public void setPenaltyList(Map<String, List<EmployerContribution>> penaltyList) {
		this.penaltyList = penaltyList;
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
	public static InputStream getFormImageFile() {
		return new ByteArrayInputStream(formImageFileBytes);
	}
	public static void setFormImageFile(InputStream formImageFile) {
		try {
			formImageFileBytes  = IOUtils.toByteArray(formImageFile);
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
	
}
