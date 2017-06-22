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

import com.svi.payroll.report.objects.Employer;
import com.svi.payroll.report.objects.PaymentDetail;
import com.svi.payroll.report.objects.PaymentDetail.TYPE;
import com.svi.payroll.report.objects.TaxComputation;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

public class BIRForm1601C {
	// required fields
	private String forTheMonth = "";
	private String isAmendedReturn;
	private String numSheetsAttached = "";
	private String anyTaxWithheld;	
	private Employer employerInfo = new Employer();
	private TaxComputation taxComputation = new TaxComputation();	
	private Map<TYPE, PaymentDetail> paymentDetails = new HashMap<TYPE, PaymentDetail>();	
	private final String EMPLOYER_INFO_KEY = "employerInfo";
	private final String TAX_COMPUTATION_KEY = "taxComputation";
	private final String PAYMENT_DETAILS_KEY = "paymentDetails";
	private final String OTHER_INFO_KEY = "otherInfo";
	private final String FORM_IMAGE_KEY = "formImage";
	private static byte[]  templateFileBytes;
	private static byte[]  imageTemplateFileBytes;
	

	public BIRForm1601C(){		
	}
	public BIRForm1601C(Employer employerInfo,TaxComputation taxComputation){		
		this.employerInfo = employerInfo;			
		this.taxComputation = taxComputation;
	}
	public BIRForm1601C(Employer employerInfo,TaxComputation taxComputation,Map<TYPE, PaymentDetail> paymentDetails){		
		this.employerInfo = employerInfo;			
		this.taxComputation = taxComputation;
		this.paymentDetails = paymentDetails;
	}
	
	
	public void createFormStream(OutputStream outputStream) throws JRException, IOException{
		// checking for report template and images
		if(getTemplateFile() == null){
			throw new InvalidParameterException("The templateFile is not set. This must contain the file template needed to produce this report.");
		}
		if(getImageTemplateFile() == null){
			throw new InvalidParameterException("The image inputstream is not set. The image is needed to produce this report.");
		}
		// creating the objects
		Map<String, Object> parameters = new HashMap<String, Object>();		
		// other info
		Map<String, String> otherInfo = new HashMap<String, String>();
		otherInfo.put("forTheMonth", forTheMonth);
		otherInfo.put("isAmendedReturn", isAmendedReturn+"");
		otherInfo.put("numSheetsAttached", numSheetsAttached);
		otherInfo.put("anyTaxWithheld", anyTaxWithheld+"");
		// adding all the objects needed for the form			
		parameters.put(EMPLOYER_INFO_KEY, employerInfo);
		parameters.put(TAX_COMPUTATION_KEY, taxComputation);
		parameters.put(PAYMENT_DETAILS_KEY, paymentDetails);
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
	
	public void setForTheMonth(String forTheMonth) {
		this.forTheMonth = forTheMonth;
	}
	public void setAmendedReturn(String isAmendedReturn) {
		this.isAmendedReturn = isAmendedReturn;
	}
	public void setNumSheetsAttached(String numSheetsAttached) {
		this.numSheetsAttached = numSheetsAttached;
	}
	public void setAnyTaxWithheld(String anyTaxWithheld) {
		this.anyTaxWithheld = anyTaxWithheld;
	}
	
	public void setEmployerInfo(Employer employerInfo) {
		this.employerInfo = employerInfo;
	}
	public void setTaxComputation(TaxComputation taxComputation) {
		this.taxComputation = taxComputation;
	}
	public void setPaymentDetails(Map<TYPE, PaymentDetail> paymentDetails) {
		this.paymentDetails = paymentDetails;
	}
	public static InputStream getTemplateFile() {
		return  new ByteArrayInputStream(templateFileBytes);
	}
	public static void setTemplateFile(InputStream templateFile) {
		try {
			templateFileBytes = IOUtils.toByteArray(templateFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static InputStream getImageTemplateFile() {
		return  new ByteArrayInputStream(imageTemplateFileBytes);
	}
	public static void setImageTemplateFile(InputStream imageTemplateFile) {
		try {
			imageTemplateFileBytes = IOUtils.toByteArray(imageTemplateFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
