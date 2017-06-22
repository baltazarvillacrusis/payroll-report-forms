package com.svi.payroll.report.objects;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EmployeeBean extends ArrayList<Employee>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int totalPages;
	private final int MAX_NUMBER_OF_ROWS_PER_PAGE = 13;
	private int numEmployeesInLastPage;
	private List<Double> subtotalPersonalShare = new ArrayList<Double>();
	private List<Double> subtotalEmployerShare = new ArrayList<Double>();
	private double grandTotalPS; // philhealth
	private double grandTotalES; // philhealth	
	
	
	
	private int computeTotalPages(){
		return (int) Math.ceil((this.size()/(double)MAX_NUMBER_OF_ROWS_PER_PAGE));		
	}
	
	private List<Double> computeSubtotalPersonalShare(){
		List<Double> subtotalPS= new ArrayList<Double>();
		for(int i=0; i <computeTotalPages();i++){
			double subTotal = 0;
			int startIndex =i*MAX_NUMBER_OF_ROWS_PER_PAGE;
			int endIndex = (i*MAX_NUMBER_OF_ROWS_PER_PAGE)+MAX_NUMBER_OF_ROWS_PER_PAGE-1;
			for(int j=startIndex; j<= endIndex && j<this.size();j++){
				
				subTotal = subTotal + this.get(j).getPersonalSharePhil();
			}
			subtotalPS.add(subTotal);
		}
		return subtotalPS;
	}
	
	private List<Double> computeSubtotalEmployerShare(){
		List<Double> subtotalES= new ArrayList<Double>();
		for(int i=0; i <computeTotalPages();i++){
			double subTotal = 0;
			int startIndex =i*MAX_NUMBER_OF_ROWS_PER_PAGE;
			int endIndex = (i*MAX_NUMBER_OF_ROWS_PER_PAGE)+MAX_NUMBER_OF_ROWS_PER_PAGE-1;
			for(int j=startIndex; j<= endIndex  && j<this.size();j++){
				subTotal = subTotal + this.get(j).getEmployerSharePhil();
			}
			subtotalES.add(subTotal);
		}
		return subtotalES;
	}

	public int getMaxNumberOfRowsDisplayed() {
		return MAX_NUMBER_OF_ROWS_PER_PAGE;
	}

	public int getTotalPages() {
		totalPages = computeTotalPages();
		return totalPages;
	}

	public List<Double> getSubtotalPersonalShare() {
		subtotalPersonalShare = computeSubtotalPersonalShare();
		return subtotalPersonalShare;
	}

	public List<Double> getSubtotalEmployerShare() {
		subtotalEmployerShare = computeSubtotalEmployerShare();
		return subtotalEmployerShare;
	}

	public int getNumEmployeesInLastPage() {
		numEmployeesInLastPage = this.size()%MAX_NUMBER_OF_ROWS_PER_PAGE;
		
		return numEmployeesInLastPage;
	}

	public double getGrandTotalPS() {
		double total = 0;
		for(Double subtotal: getSubtotalPersonalShare()){
			total = total + subtotal;
		}
		grandTotalPS = total;
		return grandTotalPS;
	}

	public double getGrandTotalES() {
		double total = 0;
		for(Double subtotal: getSubtotalEmployerShare()){
			total = total + subtotal;
		}
		grandTotalES = total;
		return grandTotalES;
	}
	
	public double getGrandTotalEE() {
		double total = 0;
		for(Employee employee : this){
			total = total + employee.getPagibigEEShare();
		}		
		return total;
	}
	public double getGrandTotalER() {
		double total = 0;
		for(Employee employee : this){
			total = total + employee.getPagibigERShare();
		}		
		return total;
	}
	
	public double getGrandTotalSSAmount(String monthNumber) {
		double total = 0.0;
		for(Employee employee : this){
			for (Map.Entry<String, Double> entry : employee.getQuarterSSAmount().entrySet()){
			    if(entry.getKey().equalsIgnoreCase(monthNumber)){
			    	total = total +entry.getValue();
			    }
			}
		}
		return total;
	}
	
	public double getGrandTotalSSECAmount(String monthNumber) {
		double total = 0.0;
		for(Employee employee : this){
			for (Map.Entry<String, Double> entry : employee.getQuarterECAmount().entrySet()){
			    if(entry.getKey().equalsIgnoreCase(monthNumber)){
			    	total = total +entry.getValue();
			    }
			}
		}
		return total;
	}
	
	

}
