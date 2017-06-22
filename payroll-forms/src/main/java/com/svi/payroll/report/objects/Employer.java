package com.svi.payroll.report.objects;

import java.util.HashMap;
import java.util.Map;

public class Employer {
	private String tin= "";
	private String name= "";
	private String registeredAdd= "";
	private String registeredAddZipCode= "";
	private Boolean isMainEmployer; 
	private Boolean payeesAvailingTax;
	private Boolean isRefundReleased;
	private String rdoCode= "";
	private String lineOfBusiness= "";	
	private String telNum= "";	
	private String mobileNo= "";
	private String website= "";
	
	private String specify= "";
	private CATEGORY category = CATEGORY.DEFAULT;  //or type: private , government
	private CATEGORY sssCategory = CATEGORY.DEFAULT;  //or type: household, business	(if business, regular)
	
	private String philHealthNumber= "";
	private String emailAddress= "";
	private String pagibigNumber= "";
	private Address address = new Address();
	private String sssNumber= "";
	private Map<String, EmployerContribution> empConList = new HashMap<String, EmployerContribution>();		
	
	private String dateOfRefund= "";
	private double overRemittanceAmount;
	private String monthOfFirstCrediting= "";
	
	public String getTin() {
		return tin;
	}
	public void setTin(String tin) {
		this.tin = tin;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRegisteredAdd() {
		return registeredAdd;
	}
	public void setRegisteredAdd(String registeredAdd) {
		this.registeredAdd = registeredAdd;
	}
	public String getRegisteredAddZipCode() {
		return registeredAddZipCode;
	}
	public void setRegisteredAddZipCode(String registeredAddZipCode) {
		this.registeredAddZipCode = registeredAddZipCode;
	}
	
	public String getRdoCode() {
		return rdoCode;
	}
	public void setRdoCode(String rdoCode) {
		this.rdoCode = rdoCode;
	}
	public String getLineOfBusiness() {
		return lineOfBusiness;
	}
	public void setLineOfBusiness(String lineOfBusiness) {
		this.lineOfBusiness = lineOfBusiness;
	}
	public String getTelNum() {
		return telNum;
	}
	public void setTelNum(String telNum) {
		this.telNum = telNum;
	}
	public String getSpecify() {
		return specify;
	}
	public void setSpecify(String specify) {
		this.specify = specify;
	}
	public CATEGORY getCategory() {
		return category;
	}
	public void setCategory(CATEGORY category) {
		this.category = category;
	}
	
	public enum CATEGORY{
		PRIVATE,GOVERNMENT,HOUSEHOLD,BUSINESS,DEFAULT;
	}

	public String getPhilHealthNumber() {
		return philHealthNumber;
	}
	public void setPhilHealthNumber(String philHealthNumber) {
		this.philHealthNumber = philHealthNumber;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getPagibigNumber() {
		return pagibigNumber;
	}
	public void setPagibigNumber(String pagibigNumber) {
		this.pagibigNumber = pagibigNumber;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getSssNumber() {
		return sssNumber;
	}
	public void setSssNumber(String sssNumber) {
		this.sssNumber = sssNumber;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public Map<String, EmployerContribution> getEmpConList() {
		return empConList;
	}
	public void setEmpConList(Map<String, EmployerContribution> empConList) {
		this.empConList = empConList;
	}
	public boolean isRefundReleased() {
		return isRefundReleased;
	}
	public void setRefundReleased(boolean isRefundReleased) {
		this.isRefundReleased = isRefundReleased;
	}
	public String getDateOfRefund() {
		return dateOfRefund;
	}
	public void setDateOfRefund(String dateOfRefund) {
		this.dateOfRefund = dateOfRefund;
	}
	public double getOverRemittanceAmount() {
		return overRemittanceAmount;
	}
	public void setOverRemittanceAmount(double overRemittanceAmount) {
		this.overRemittanceAmount = overRemittanceAmount;
	}
	public String getMonthOfFirstCrediting() {
		return monthOfFirstCrediting;
	}
	public void setMonthOfFirstCrediting(String monthOfFirstCrediting) {
		this.monthOfFirstCrediting = monthOfFirstCrediting;
	}
	public CATEGORY getSssCategory() {
		return sssCategory;
	}
	public void setSssCategory(CATEGORY sssCategory) {
		this.sssCategory = sssCategory;
	}
	public Boolean getIsMainEmployer() {
		return isMainEmployer;
	}
	public void setIsMainEmployer(Boolean isMainEmployer) {
		this.isMainEmployer = isMainEmployer;
	}
	public Boolean getPayeesAvailingTax() {
		return payeesAvailingTax;
	}
	public void setPayeesAvailingTax(Boolean payeesAvailingTax) {
		this.payeesAvailingTax = payeesAvailingTax;
	}
	public Boolean getIsRefundReleased() {
		return isRefundReleased;
	}
	public void setIsRefundReleased(Boolean isRefundReleased) {
		this.isRefundReleased = isRefundReleased;
	}

	

}
