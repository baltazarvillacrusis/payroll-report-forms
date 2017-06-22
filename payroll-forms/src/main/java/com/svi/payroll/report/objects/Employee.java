package com.svi.payroll.report.objects;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Employee {	
	
	private String tin= "";
	private String name= ""; //TODO to be deleted
	private String firstName = "";
	private String middleName = "";
	private String lastName = "";
	private String extensionName = "";
	private String rdoCode= "";
	private String registeredAdd= "";
	private String registeredAddZipCode= "";
	private String localAdd= "";
	private String localAddZipCode= "";
	private String foreignAdd= "";
	private String foreignAddZipCode= "";
	private String birthDate= "";
	private String telNum= "";	
	private Boolean isSingle;
	private Boolean isWifeClaimingExemption;	
	private double smwRatePerDay;
	private double smwRatePerMonth;
	private Boolean isMinimumWageEarner;
	private boolean isRankAndFile;
	private boolean isTerminatedBeforeEndOfYear;
	private boolean hasPreviousEmployer;	
	private Employer presentEmployer = new Employer();
	private Employer previousEmployer = new Employer();
	private String ctcNum= "";
	private String ctcPlaceOfIssue= "";
	private String ctcDateOfIssue= "";
	private double ctcAmountPaid;	
	private Map<String,String> dependents = new HashMap<String,String>();
	
	private SEX sex = SEX.NDEFAULT;	
	private int monthlySalaryBracket;
	private double personalSharePhil;
	private double employerSharePhil;
	private STATUS status = STATUS.DEFAULT;
	private String effectivityDate= ""; // of status
	private String pin= ""; //philhealth identification number
	
	private String pagibigMIDNumber= "";
	private String pagibigAcccountNumber= "";
	private String pagibigMembershipProgram= "";
	private String pagibigPeriodCovered= "";
	private double pagibigEEShare;
	private double pagibigERShare;
	private String pagibigRemark= "";
	private double monthlyCompensation; //basic salary plus cola
	private String applicationNum= "";
	private String loanType= "";
	private double amount;
	private String ID= "";
	private String bankAcctNum= "";
	private double netPay;
	private String bankName= "";
	private String loanName= "";
	private Map<String,BigDecimal> salaryLoans = new HashMap<String,BigDecimal>();
	private double sssSSAmount;
	private double sssECAmount;
	private String sssNumber = "";
	private Map<String,Double> quarterSSAmount = new HashMap<String,Double>();
	private Map<String,Double> quarterECAmount = new HashMap<String,Double>();
	
	// newly added for payroll register report
	private String department = "";
	private double basicSalary;
	private double late;
	private double absences;
	private double overtime;
	private double nightShift;
	private double nightShiftOverTime;
	private double vacationLeave;
	private double sickLeave;
	private double grossPay;
	private double sssEmployeeShare;
	private double withholdingTax;
	private double others;
	private double comissary;
	private double allotment;
	private double amountToBeReceived;
	private double sssLoan;
	private double pagibigLoan;
	
	private double taxExemption;
	private String atc = "";	
	private String residenceStatus = "";		
	private String exemptionCode = "";	
	private String regionNumAssigned = "";		
	private Boolean substitutedFiling;	
	private double thirteenthMonthPay;
	
	
	
	public String getTin() {
		return tin;
	}
	public void setTin(String tin) {
		this.tin = tin;
	}
	public String getName() {
		if(name.length() == 0 || name == null){
			return firstName+" "+middleName+" "+lastName+" "+extensionName;
		}
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRdoCode() {
		return rdoCode;
	}
	public void setRdoCode(String rdoCode) {
		this.rdoCode = rdoCode;
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
	public String getLocalAdd() {
		return localAdd;
	}
	public void setLocalAdd(String localAdd) {
		this.localAdd = localAdd;
	}
	public String getLocalAddZipCode() {
		return localAddZipCode;
	}
	public void setLocalAddZipCode(String localAddZipCode) {
		this.localAddZipCode = localAddZipCode;
	}
	public String getForeignAdd() {
		return foreignAdd;
	}
	public void setForeignAdd(String foreignAdd) {
		this.foreignAdd = foreignAdd;
	}
	public String getForeignAddZipCode() {
		return foreignAddZipCode;
	}
	public void setForeignAddZipCode(String foreignAddZipCode) {
		this.foreignAddZipCode = foreignAddZipCode;
	}
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	public String getTelNum() {
		return telNum;
	}
	public void setTelNum(String telNum) {
		this.telNum = telNum;
	}

	public double getSmwRatePerDay() {
		return smwRatePerDay;
	}
	public void setSmwRatePerDay(double smwRatePerDay) {
		this.smwRatePerDay = smwRatePerDay;
	}
	public double getSmwRatePerMonth() {
		return smwRatePerMonth;
	}
	public void setSmwRatePerMonth(double smwRatePerMonth) {
		this.smwRatePerMonth = smwRatePerMonth;
	}
	
	public Employer getPresentEmployer() {
		return presentEmployer;
	}
	public void setPresentEmployer(Employer presentEmployer) {
		this.presentEmployer = presentEmployer;
	}
	public Employer getPreviousEmployer() {
		return previousEmployer;
	}
	public void setPreviousEmployer(Employer previousEmployer) {
		this.previousEmployer = previousEmployer;
	}
	public String getCtcNum() {
		return ctcNum;
	}
	public void setCtcNum(String ctcNum) {
		this.ctcNum = ctcNum;
	}
	public String getCtcPlaceOfIssue() {
		return ctcPlaceOfIssue;
	}
	public void setCtcPlaceOfIssue(String ctcPlaceOfIssue) {
		this.ctcPlaceOfIssue = ctcPlaceOfIssue;
	}
	public String getCtcDateOfIssue() {
		return ctcDateOfIssue;
	}
	public void setCtcDateOfIssue(String ctcDateOfIssue) {
		this.ctcDateOfIssue = ctcDateOfIssue;
	}
	public double getCtcAmountPaid() {
		return ctcAmountPaid;
	}
	public void setCtcAmountPaid(double ctcAmountPaid) {
		this.ctcAmountPaid = ctcAmountPaid;
	}
	public Map<String, String> getDependents() {
		return dependents;
	}
	public void setDependents(Map<String, String> dependents) {
		this.dependents = dependents;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getExtensionName() {
		return extensionName;
	}
	public void setExtensionName(String extensionName) {
		this.extensionName = extensionName;
	}


	public SEX getSex() {
		return sex;
	}
	public void setSex(SEX sex) {
		this.sex = sex;
	}
	
	

	public int getMonthlySalaryBracket() {
		return monthlySalaryBracket;
	}
	public void setMonthlySalaryBracket(int monthlySalaryBracket) {
		this.monthlySalaryBracket = monthlySalaryBracket;
	}
	public double getPersonalSharePhil() {
		return personalSharePhil;
	}
	public void setPersonalSharePhil(double personalSharePhil) {
		this.personalSharePhil = personalSharePhil;
	}
	public double getEmployerSharePhil() {
		return employerSharePhil;
	}
	public void setEmployerSharePhil(double employerSharePhil) {
		this.employerSharePhil = employerSharePhil;
	}
	public String getStatus() {
		return status.getCode();
	}
	public void setStatus(STATUS status) {
		this.status = status;
	}
	public String getEffectivityDate() {
		return effectivityDate;
	}
	public void setEffectivityDate(String effectivityDate) {
		this.effectivityDate = effectivityDate;
	}
	public String getPin() {
		if(pin == null){
			return "";
		}
		return pin;
	}
	public void setPin(String pin) {		
		this.pin = pin;
	}
	
	
	public enum STATUS{
		SEPARATED("S"),NO_EARNINGS("NE"),NEWLY_HIRED("NH"),DEFAULT("");
		
		private String value;
		
		private STATUS(String value){
			this.value = value;
		}
		
		public String getCode(){
			return this.value;
		}
	}

	public enum SEX{
		MALE("MALE"),FEMALE("FEMALE"),NDEFAULT("");
		private String value;
		private SEX(String value){
			this.value = value;
		}		
		public String getCode(){
			return this.value;
		}
	}

	public String getPagibigMIDNumber() {
		return pagibigMIDNumber;
	}
	public void setPagibigMIDNumber(String pagibigMIDNumber) {
		this.pagibigMIDNumber = pagibigMIDNumber;
	}
	public String getPagibigAcccountNumber() {
		return pagibigAcccountNumber;
	}
	public void setPagibigAcccountNumber(String pagibigAcccountNumber) {
		this.pagibigAcccountNumber = pagibigAcccountNumber;
	}
	public String getPagibigMembershipProgram() {
		return pagibigMembershipProgram;
	}
	public void setPagibigMembershipProgram(String pagibigMembershipProgram) {
		this.pagibigMembershipProgram = pagibigMembershipProgram;
	}
	public String getPagibigPeriodCovered() {
		return pagibigPeriodCovered;
	}
	public void setPagibigPeriodCovered(String pagibigPeriodCovered) {
		this.pagibigPeriodCovered = pagibigPeriodCovered;
	}
	public double getPagibigEEShare() {
		return pagibigEEShare;
	}
	public void setPagibigEEShare(double pagibigEEShare) {
		this.pagibigEEShare = pagibigEEShare;
	}
	public double getPagibigERShare() {
		return pagibigERShare;
	}
	public void setPagibigERShare(double pagibigERShare) {
		this.pagibigERShare = pagibigERShare;
	}
	public String getPagibigRemark() {
		return pagibigRemark;
	}
	public void setPagibigRemark(String pagibigRemark) {
		this.pagibigRemark = pagibigRemark;
	}
	public double getMonthlyCompensation() {
		return monthlyCompensation;
	}
	public void setMonthlyCompensation(double monthlyCompensation) {
		this.monthlyCompensation = monthlyCompensation;
	}
	
	public String getCompleteName(){
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(lastName+", ");
		stringBuilder.append(firstName+" ");
		stringBuilder.append(middleName);	
		return stringBuilder.toString();
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getBankAcctNum() {
		return bankAcctNum;
	}
	public void setBankAcctNum(String bankAcctNum) {
		this.bankAcctNum = bankAcctNum;
	}
	public double getNetPay() {
		return netPay;
	}
	public void setNetPay(double netPay) {
		this.netPay = netPay;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getLoanName() {
		return loanName;
	}
	public void setLoanName(String loanName) {
		this.loanName = loanName;
	}
	public String getApplicationNum() {
		return applicationNum;
	}
	public void setApplicationNum(String applicationNum) {
		this.applicationNum = applicationNum;
	}
	public String getLoanType() {
		return loanType;
	}
	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Map<String, BigDecimal> getSalaryLoans() {
		return salaryLoans;
	}
	public void setSalaryLoans(Map<String, BigDecimal> salaryLoans) {
		this.salaryLoans = salaryLoans;
	}
	public double getSssSSAmount() {
		return sssSSAmount;
	}
	public void setSssSSAmount(double sssSSAmount) {
		this.sssSSAmount = sssSSAmount;
	}
	public double getSssECAmount() {
		return sssECAmount;
	}
	public void setSssECAmount(double sssECAmount) {
		this.sssECAmount = sssECAmount;
	}
	public String getSssNumber() {
		return sssNumber;
	}
	public void setSssNumber(String sssNumber) {
		this.sssNumber = sssNumber;
	}
	public Map<String, Double> getQuarterSSAmount() {
		return quarterSSAmount;
	}
	public void setQuarterSSAmount(Map<String, Double> quarterSSAmount) {
		this.quarterSSAmount = quarterSSAmount;
	}
	public Map<String, Double> getQuarterECAmount() {
		return quarterECAmount;
	}
	public void setQuarterECAmount(Map<String, Double> quarterECAmount) {
		this.quarterECAmount = quarterECAmount;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public double getBasicSalary() {
		return basicSalary;
	}
	public void setBasicSalary(double basicSalary) {
		this.basicSalary = basicSalary;
	}
	public double getLate() {
		return late;
	}
	public void setLate(double late) {
		this.late = late;
	}
	public double getAbsences() {
		return absences;
	}
	public void setAbsences(double absences) {
		this.absences = absences;
	}
	public double getOvertime() {
		return overtime;
	}
	public void setOvertime(double overtime) {
		this.overtime = overtime;
	}
	public double getNightShift() {
		return nightShift;
	}
	public void setNightShift(double nightShift) {
		this.nightShift = nightShift;
	}
	public double getVacationLeave() {
		return vacationLeave;
	}
	public void setVacationLeave(double vacationLeave) {
		this.vacationLeave = vacationLeave;
	}
	public double getSickLeave() {
		return sickLeave;
	}
	public void setSickLeave(double sickLeave) {
		this.sickLeave = sickLeave;
	}
	public double getGrossPay() {
		return grossPay;
	}
	public void setGrossPay(double grossPay) {
		this.grossPay = grossPay;
	}
	public double getSssEmployeeShare() {
		return sssEmployeeShare;
	}
	public void setSssEmployeeShare(double sssEmployeeShare) {
		this.sssEmployeeShare = sssEmployeeShare;
	}
	public double getWithholdingTax() {
		return withholdingTax;
	}
	public void setWithholdingTax(double withholdingTax) {
		this.withholdingTax = withholdingTax;
	}
	public double getOthers() {
		return others;
	}
	public void setOthers(double others) {
		this.others = others;
	}
	public double getComissary() {
		return comissary;
	}
	public void setComissary(double comissary) {
		this.comissary = comissary;
	}
	public double getAllotment() {
		return allotment;
	}
	public void setAllotment(double allotment) {
		this.allotment = allotment;
	}
	public double getAmountToBeReceived() {
		return amountToBeReceived;
	}
	public void setAmountToBeReceived(double amountToBeReceived) {
		this.amountToBeReceived = amountToBeReceived;
	}
	public double getSssLoan() {
		return sssLoan;
	}
	public void setSssLoan(double sssLoan) {
		this.sssLoan = sssLoan;
	}
	public double getPagibigLoan() {
		return pagibigLoan;
	}
	public void setPagibigLoan(double pagibigLoan) {
		this.pagibigLoan = pagibigLoan;
	}
	public double getNightShiftOverTime() {
		return nightShiftOverTime;
	}
	public void setNightShiftOverTime(double nightShiftOverTime) {
		this.nightShiftOverTime = nightShiftOverTime;
	}
	public double getTaxExemption() {
		return taxExemption;
	}
	public void setTaxExemption(double taxExemption) {
		this.taxExemption = taxExemption;
	}
	
	public String getAtc() {
		return atc;
	}
	public void setAtc(String atc) {
		this.atc = atc;
	}
	public String getResidenceStatus() {
		return residenceStatus;
	}
	public void setResidenceStatus(String residenceStatus) {
		this.residenceStatus = residenceStatus;
	}
	public String getExemptionCode() {
		return exemptionCode;
	}
	public void setExemptionCode(String exemptionCode) {
		this.exemptionCode = exemptionCode;
	}
	public String getRegionNumAssigned() {
		return regionNumAssigned;
	}
	public void setRegionNumAssigned(String regionNumAssigned) {
		this.regionNumAssigned = regionNumAssigned;
	}
	public Boolean getSubstitutedFiling() {
		return substitutedFiling;
	}
	public void setSubstitutedFiling(Boolean substitutedFiling) {
		this.substitutedFiling = substitutedFiling;
	}
	public Boolean getIsSingle() {
		return isSingle;
	}
	public void setIsSingle(Boolean isSingle) {
		this.isSingle = isSingle;
	}
	public Boolean getIsWifeClaimingExemption() {
		return isWifeClaimingExemption;
	}
	public void setIsWifeClaimingExemption(Boolean isWifeClaimingExemption) {
		this.isWifeClaimingExemption = isWifeClaimingExemption;
	}
	public Boolean getIsMinimumWageEarner() {
		return isMinimumWageEarner;
	}
	public void setIsMinimumWageEarner(Boolean isMinimumWageEarner) {
		this.isMinimumWageEarner = isMinimumWageEarner;
	}
	public boolean getIsRankAndFile() {
		return isRankAndFile;
	}
	public void setIsRankAndFile(boolean isRankAndFile) {
		this.isRankAndFile = isRankAndFile;
	}
	public boolean getIsTerminatedBeforeEndOfYear() {
		return isTerminatedBeforeEndOfYear;
	}
	public void setIsTerminatedBeforeEndOfYear(boolean isTerminatedBeforeEndOfYear) {
		this.isTerminatedBeforeEndOfYear = isTerminatedBeforeEndOfYear;
	}
	public boolean getHasPreviousEmployer() {
		return hasPreviousEmployer;
	}
	public void setHasPreviousEmployer(boolean hasPreviousEmployer) {
		this.hasPreviousEmployer = hasPreviousEmployer;
	}
	public double getThirteenthMonthPay() {
		return thirteenthMonthPay;
	}
	public void setThirteenthMonthPay(double thirteenthMonthPay) {
		this.thirteenthMonthPay = thirteenthMonthPay;
	}
	
	

	
}
