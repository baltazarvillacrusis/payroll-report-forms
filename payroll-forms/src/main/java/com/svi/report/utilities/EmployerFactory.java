package com.svi.report.utilities;

import java.util.Map;

import com.svi.payroll.report.objects.Address;
import com.svi.payroll.report.objects.Employer;
import com.svi.payroll.report.objects.EmployerContribution;
import com.svi.payroll.report.objects.Employer.CATEGORY;

public class EmployerFactory {
	
	/**
	 *  Creates employer object for BIR Form 1601-C
	 * @param tin
	 * @param rdoCode
	 * @param lineOfBusiness
	 * @param name
	 * @param telNum
	 * @param registeredAdd
	 * @param registeredAddZipCode
	 * @param category
	 * @param payeesAvailingTax
	 * @param specify
	 * @return
	 */
	public static Employer birForm1601CEmployer(String tin, String rdoCode, String lineOfBusiness,
		String name, String telNum, String registeredAdd, String registeredAddZipCode, CATEGORY category,
		boolean payeesAvailingTax, String specify){
		Employer employer = new Employer();
		employer.setTin(tin);
		employer.setRdoCode(rdoCode);
		employer.setLineOfBusiness(lineOfBusiness);
		employer.setName(name);
		employer.setTelNum(telNum);
		employer.setRegisteredAdd(registeredAdd);
		employer.setRegisteredAddZipCode(registeredAddZipCode);
		employer.setCategory(category);
		employer.setPayeesAvailingTax(payeesAvailingTax);
		employer.setSpecify(specify);		
		
		return employer;		
	}
	
	/** 
	 * Creates employer object for HDMF STLR Form.
	 * @param name
	 * @param pagibigNumber
	 * @param telNum
	 * @param address
	 * @return
	 */
	public static Employer hdmfSTLRFEmployer(String name, String pagibigNumber, 
		String telNum,  Address address){
		
		Employer employer = new Employer();				
		employer.setName(name);
		employer.setPagibigNumber(pagibigNumber);
		employer.setTelNum(telNum);		
		employer.setAddress(address);	
		
		return employer;		
	}
	
	/**
	 * Creates employer object for HDMF MCR Form. 
	 * @param name
	 * @param pagibigNumber
	 * @param address
	 * @return
	 */
	public static Employer hdmfMCRFEmployer(String name, String pagibigNumber, Address address){
		
		Employer employer = new Employer();				
		employer.setName(name);
		employer.setPagibigNumber(pagibigNumber);		
		employer.setAddress(address);	
		
		return employer;		
	}
		
	/**
	 * Creates employer object for PhilHealth RF1 Form. 
	 * @param philHealthNumber
	 * @param tin
	 * @param name
	 * @param registeredAdd
	 * @param telNum
	 * @param emailAddress
	 * @param category
	 * @return
	 */
	public static Employer philHealthRF1Employer(String philHealthNumber, String tin, String name,
		String registeredAdd, String telNum,  String emailAddress, CATEGORY category){
		
		Employer employer = new Employer();			
		employer.setPhilHealthNumber(philHealthNumber);
		employer.setTin(tin);
		employer.setName(name);
		employer.setRegisteredAdd(registeredAdd);
		employer.setTelNum(telNum);
		employer.setEmailAddress(emailAddress);
		employer.setCategory(category);
		
		return employer;		
	}
	
	/**
	 * Creates employer object for SSS Form R5. 
	 * @param name
	 * @param sssNumber
	 * @param registeredAddZipCode
	 * @param tin
	 * @param telNum
	 * @param mobileNo
	 * @param emailAddress
	 * @param website
	 * @param category
	 * @param address
	 * @param empConList
	 * @return
	 */
	public static Employer sssFormR5Employer( String name, String sssNumber, String registeredAddZipCode,
		String tin, String telNum, String mobileNo, String emailAddress, String website,
		CATEGORY category, Address address, Map<String, EmployerContribution> empConList){
		
		Employer employer = new Employer();			
		employer.setName(name);
		employer.setSssNumber(sssNumber);
		employer.setRegisteredAddZipCode(registeredAddZipCode);
		employer.setTin(tin);	
		employer.setTelNum(telNum);
		employer.setMobileNo(mobileNo);
		employer.setEmailAddress(emailAddress);
		employer.setWebsite(website);
		employer.setCategory(category);
		employer.setAddress(address);
		employer.setEmpConList(empConList);
		
		return employer;		
	}

}
