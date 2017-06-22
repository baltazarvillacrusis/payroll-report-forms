package com.svi.report.utilities;

import java.util.Comparator;

import com.svi.payroll.report.objects.Alphalist;
import com.svi.payroll.report.objects.Employee;
import com.svi.payroll.report.objects.RemittancePerBIR;



public class ObjectComparator {
	
	/**
	 * Defines the ordering of RemittancePerBIR in the list. 
	 * This comparator orders RemittancePerBIR by month in ascending order. 
	 */
	public static Comparator<RemittancePerBIR> compareRemittanceByIndexOrder = new Comparator<RemittancePerBIR>() {
		// in ascending order 
		public int compare(RemittancePerBIR element1, RemittancePerBIR element2) {		
			int idElement1 = element1.getIndexOrder();
			int idElement2 = element2.getIndexOrder();			
			return idElement1 - idElement2; 		
		}	
	};
	
	

	/**
	 * Defines the ordering of employees in the list. 
	 * This comparator orders employees by last name, first name then by middle name
	 */
	public static Comparator<Employee> compareEmployeesByName = new Comparator<Employee>() {
		// in ascending order 
		public int compare(Employee element1, Employee element2) {		
			String lastName1 = element1.getLastName().toUpperCase();
			String lastName2 = element2.getLastName().toUpperCase();			
			
			int lastName = lastName1.compareTo(lastName2);
			if( lastName == 0) {					
				String firstName1 = element1.getFirstName().toUpperCase();
				String firstName2 = element2.getFirstName().toUpperCase();	
				
				int firstName = firstName1.compareTo(firstName2);		
				if( firstName == 0) {	
					String middleName1 = element1.getMiddleName().toUpperCase();
					String middleName2 = element2.getMiddleName().toUpperCase();	
					return middleName1.compareTo(middleName2);
				}
				else{
					return firstName1.compareTo(firstName2); 		//in ascending order
				}
			} else {
				return lastName;
			}
		}	
	};
	
	
	/**
	 * Defines the ordering of Alphalist in the list. 
	 * This comparator orders Alphalist by last name, first name then by middle name
	 */
	public static Comparator<Alphalist> compareAlphalistByName = new Comparator<Alphalist>() {
		// in ascending order 
		public int compare(Alphalist element1, Alphalist element2) {		
			String lastName1 = element1.getLastName().toUpperCase();
			String lastName2 = element2.getLastName().toUpperCase();			
			
			int lastName = lastName1.compareTo(lastName2);
			if( lastName == 0) {					
				String firstName1 = element1.getFirstName().toUpperCase();
				String firstName2 = element2.getFirstName().toUpperCase();	
				
				int firstName = firstName1.compareTo(firstName2);		
				if( firstName == 0) {	
					String middleName1 = element1.getMiddleName().toUpperCase();
					String middleName2 = element2.getMiddleName().toUpperCase();	
					return middleName1.compareTo(middleName2);
				}
				else{
					return firstName1.compareTo(firstName2); 		//in ascending order
				}
			} else {
				return lastName;
			}
		}	
	};
			

}
