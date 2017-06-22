package com.svi.payroll.report.forms;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.junit.BeforeClass;
import org.junit.Ignore;

@Ignore
public class BaseTestSetup {
    private static final String RESOURCES_LOCATION = "src/main/resources/";

	@BeforeClass
	public static void setUpBaseClass() throws FileNotFoundException {
		AlphalistFormsSetUp();
		BIRForm1601CSetUp();
		SSSFormR5SetUp();
		HDMFmcrfSetUp();
		HDMFstlrfSetUp();
		BIRForm2316SetUp();
		BIRForm1604CFSetUp();
		BankRegisterSalaryLoanRepaymentSetUp();
		NetPayRegisterForBankSetUp();
		PhilHealthRF1SetUp();
		SSSR3FormSetUp();
		PayrollRegisterSetUp();
		ThirteenthMonthPay();
	}
	
	private static void PhilHealthRF1SetUp() throws FileNotFoundException {
		InputStream template =new FileInputStream(new File(RESOURCES_LOCATION + "Report Resources/Jasper Templates/PhilHealthRF1.jasper"));
		PhilHealthRF1.setTemplateFile(template);
		
		InputStream imageTemplateFile = new FileInputStream(new File(RESOURCES_LOCATION + "Report Resources/FormImages/PhilHealthRF1Header.png"));
		PhilHealthRF1.setHeaderImageFile(imageTemplateFile);
		
		InputStream footerTemplateFile = new FileInputStream(new File(RESOURCES_LOCATION + "Report Resources/FormImages/PhilHealthRF1Footer.png"));
		PhilHealthRF1.setFooterImageFile(footerTemplateFile);
	}

	private static void NetPayRegisterForBankSetUp() throws FileNotFoundException {
		InputStream template =new FileInputStream(new File(RESOURCES_LOCATION + "Report Resources/Jasper Templates/NetPayRegisterForBank.xlsx"));
		NetPayRegisterForBank.setTemplateFile(template);
	}

	private static void BankRegisterSalaryLoanRepaymentSetUp() throws FileNotFoundException {
		InputStream template =new FileInputStream(new File(RESOURCES_LOCATION + "Report Resources/Jasper Templates/BankRegisterSalaryLoanRepayment.xlsx"));
		BankRegisterSalaryLoanRepayment.setTemplateFile(template);
	}

	private static void BIRForm1604CFSetUp() throws FileNotFoundException {
		InputStream template =new FileInputStream(new File(RESOURCES_LOCATION + "Report Resources/Jasper Templates/BIRForm1604CF.jasper"));
		BIRForm1604CF.setTemplateFile(template);
		
		InputStream imageTemplateFile = new FileInputStream(new File(RESOURCES_LOCATION + "Report Resources/FormImages/BIRForm1604CF.png"));
		BIRForm1604CF.setImageTemplateFile(imageTemplateFile);
	}

	private static void BIRForm2316SetUp() throws FileNotFoundException {
		InputStream template =new FileInputStream(new File(RESOURCES_LOCATION + "Report Resources/Jasper Templates/BIRForm2316.jasper"));
		BIRForm2316.setTemplateFile(template);
		
		InputStream imageTemplateFile = new FileInputStream(new File(RESOURCES_LOCATION + "Report Resources/FormImages/BIRForm2316.png"));
		BIRForm2316.setImageTemplateFile(imageTemplateFile);
	}

	private static void HDMFstlrfSetUp() throws FileNotFoundException {
		InputStream template =new FileInputStream(new File(RESOURCES_LOCATION + "Report Resources/Jasper Templates/HDMFstlrf.jasper"));
		HDMFstlrf.setTemplateFile(template);
		
		InputStream imageTemplateFile = new FileInputStream(new File(RESOURCES_LOCATION + "Report Resources/FormImages/HDMFstlrf.png"));
		HDMFstlrf.setImageTemplateFile(imageTemplateFile);
	}

	private static void HDMFmcrfSetUp() throws FileNotFoundException {
		InputStream template =new FileInputStream(new File(RESOURCES_LOCATION + "Report Resources/Jasper Templates/HDMFmcrf.jasper"));
		HDMFmcrf.setTemplateFile(template);
		
		InputStream imageTemplateFile = new FileInputStream(new File(RESOURCES_LOCATION + "Report Resources/FormImages/HDMFMCRFHeader.png"));
		HDMFmcrf.setHeaderImageFile(imageTemplateFile);
		
		InputStream footerTemplateFile = new FileInputStream(new File(RESOURCES_LOCATION + "Report Resources/FormImages/HDMFMCRFFooter.png"));
		HDMFmcrf.setFooterImageFile(footerTemplateFile);
	}

	private static void SSSFormR5SetUp() throws FileNotFoundException {
		InputStream template =new FileInputStream(new File(RESOURCES_LOCATION + "Report Resources/Jasper Templates/SSSFormR5.jasper"));
		SSSFormR5.setTemplateFile(template);
		
		InputStream imageTemplateFile = new FileInputStream(new File(RESOURCES_LOCATION + "Report Resources/FormImages/SSSFormR5.png"));
		SSSFormR5.setFormImageFile(imageTemplateFile);
		
		InputStream blankTemplateFile = new FileInputStream(new File(RESOURCES_LOCATION + "Report Resources/FormImages/blank.png"));
		SSSFormR5.setBlankImageFile(blankTemplateFile);
		
		InputStream checkTemplateFile = new FileInputStream(new File(RESOURCES_LOCATION + "Report Resources/FormImages/check.png"));
		SSSFormR5.setCheckImageFile(checkTemplateFile);
	}

	private static void AlphalistFormsSetUp() throws FileNotFoundException {
		InputStream template = new FileInputStream(new File(RESOURCES_LOCATION + "Report Resources/Jasper Templates/AlphalistForm.jasper"));
		AlphalistForms.setTemplateFile(template);
	}

	private static void BIRForm1601CSetUp() throws FileNotFoundException {
		InputStream template = new FileInputStream(new File(RESOURCES_LOCATION + "Report Resources/Jasper Templates/BIRForm1601C.jasper"));
		BIRForm1601C.setTemplateFile(template);

		InputStream imageTemplateFile = new FileInputStream(new File(RESOURCES_LOCATION + "Report Resources/FormImages/BIR Form1601C.png"));
		BIRForm1601C.setImageTemplateFile(imageTemplateFile);
	}
	
	private static void SSSR3FormSetUp() throws FileNotFoundException {
		InputStream template = new FileInputStream(new File(RESOURCES_LOCATION + "Report Resources/Jasper Templates/SSSFormR3.jasper"));
		SSSFormR3.setTemplateFile(template);
		
		InputStream blankTemplateFile = new FileInputStream(new File(RESOURCES_LOCATION + "Report Resources/FormImages/blank.png"));
		SSSFormR3.setBlankImageFile(blankTemplateFile);
		
		InputStream checkTemplateFile = new FileInputStream(new File(RESOURCES_LOCATION + "Report Resources/FormImages/check.png"));
		SSSFormR3.setCheckImageFile(checkTemplateFile);
		
		InputStream sssLogo = new FileInputStream(new File(RESOURCES_LOCATION + "Report Resources/FormImages/ssslogo.png"));
		SSSFormR3.setSssLogo(sssLogo);
	}
	
	
	private static void PayrollRegisterSetUp() throws FileNotFoundException {
		InputStream template =new FileInputStream(new File(RESOURCES_LOCATION + "Report Resources/Jasper Templates/PayrollRegister.xlsx"));
		PayrollRegister.setTemplateFile(template);
		
		InputStream template2 =new FileInputStream(new File(RESOURCES_LOCATION + "Report Resources/Jasper Templates/PayrollRegisterInternal.xlsx"));
		PayrollRegisterInternal.setTemplateFile(template2);
	}
	
	
	private static void ThirteenthMonthPay() throws FileNotFoundException {
		InputStream template =new FileInputStream(new File(RESOURCES_LOCATION + "Report Resources/Jasper Templates/ThirteenthMonthPayForm.jasper"));
		ThirteenthMonthPayForm.setTemplateFile(template);
	}
	
}
