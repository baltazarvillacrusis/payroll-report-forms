package com.svi.payroll.report.objects;


public class EmployerContribution {
	
	private double ssContribution;
	private double employeeCompensation;
	private MONTH month = MONTH.DEFAULT;	
	private PENALTY_TYPE penaltyType = PENALTY_TYPE.DEFAULT;
	private double ssConPenalty;
	private double empCompPenalty;
	private String year= "";
	
	public EmployerContribution(){
		
	}
	
	public EmployerContribution(String year, double ssContribution,
			double employeeCompensation, MONTH month, PENALTY_TYPE penaltyType,
			double ssConPenalty, double empCompPenalty) {	
		this.year = year;
		this.ssContribution = ssContribution;
		this.employeeCompensation = employeeCompensation;
		this.month = month;
		this.penaltyType = penaltyType;
		this.ssConPenalty = ssConPenalty;
		this.empCompPenalty = empCompPenalty;
	}

	
	
	
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public double getSsContribution() {
		return ssContribution;
	}
	public void setSsContribution(double ssContribution) {
		this.ssContribution = ssContribution;
	}
	public double getEmployeeCompensation() {
		return employeeCompensation;
	}
	public void setEmployeeCompensation(double employeeCompensation) {
		this.employeeCompensation = employeeCompensation;
	}
	public MONTH getMonth() {
		return month;
	}
	public void setMonth(MONTH month) {
		this.month = month;
	}
	
	public PENALTY_TYPE getPenaltyType() {
		return penaltyType;
	}
	public void setPenaltyType(PENALTY_TYPE penaltyType) {
		this.penaltyType = penaltyType;
	}
	public double getSsConPenalty() {
		return ssConPenalty;
	}
	public void setSsConPenalty(double ssConPenalty) {
		this.ssConPenalty = ssConPenalty;
	}
	public double getEmpCompPenalty() {
		return empCompPenalty;
	}
	public void setEmpCompPenalty(double empCompPenalty) {
		this.empCompPenalty = empCompPenalty;
	}
	
	
	
	public enum PENALTY_TYPE{
		PENALTY("PENALTY"),INTEREST("INTEREST"),UNDER_PAYMENT("UNDER_PAYMENT"),DEFAULT("");
		private String value;
		
		PENALTY_TYPE(String value){
			this.value = value;
		}
		
		public String getValue(){
			if(value ==  null){
				return "";
			}
			return this.value;
		}
	}
	
	public enum MONTH{
		JANUARY("January"),
		FEBRUARY("February"),
		MARCH("March"),
		APRIL("April"),
		MAY("May"),
		JUNE("June"),
		JULY("July"),
		AUGUST("August"),
		SEPTEMBER("September"),
		OCTOBER("October"),
		NOVEMBER("November"),
		DECEMBER("December"),
		DEFAULT("");
		
		private String value;
		
		MONTH(String value){
			this.value = value;
		}
		public String getValue(){
			if(value ==  null){
				return "";
			}
			return this.value;
		}
	}

	
}
