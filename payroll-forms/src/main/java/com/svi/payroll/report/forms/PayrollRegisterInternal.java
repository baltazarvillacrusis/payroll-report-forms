package com.svi.payroll.report.forms;

import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidParameterException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.svi.payroll.report.objects.Employee;
import com.svi.payroll.report.objects.EmployeeBean;
import com.svi.report.utilities.ObjectComparator;

public class PayrollRegisterInternal {	
	private final int NAME_COLINDEX = 1;
	private final int DEPARTMENT_COLINDEX = 2;
	private final int SALARY_COLINDEX = 3;
	private final int LATE_COLINDEX = 4;
	private final int ABSENCES_COLINDEX = 5;
	private final int OVERTIME_COLINDEX = 6;
	private final int NIGHT_SHIFT_COLINDEX = 7;
	private final int NIGHT_SHIFT_OT_COLINDEX = 8;
	private final int VACATION_LEAVE_COLINDEX = 9;
	private final int SICK_LEAVE_COLINDEX = 10;
	private final int GROSS_PAY_COLINDEX = 11;
	private final int SSS_SHARE_COLINDEX = 12;
	private final int PAGIBIG_SHARE_COLINDEX = 13;
	private final int PHILHEALTH_SHARE_COLINDEX = 14;	
	private final int WITHHOLDING_TAX_COLINDEX = 15;
	private final int NET_PAY_COLINDEX = 16;
	private final int OTHERS_COLINDEX = 17;
	private final int COMISSARY_COLINDEX = 18;
	private final int ALLOTMENT_COLINDEX = 19;
	private final int SSS_LOAN_COLINDEX = 20;
	private final int PAGIBIG_LOAN_COLINDEX = 21;
	private final int AMOUNT_TO_RECEIVE_COLINDEX = 22;
	
	private Map<Integer,Double> grandTotals = new HashMap<Integer,Double>();
	
	
	
	private final int START_ROWINDEX = 6;
	private EmployeeBean employeeBean = new EmployeeBean();	
	private String period = "";
	private String companyName = "";
	private String runType = "";
	private static byte[] templateFileBytes;

	public PayrollRegisterInternal() {
	}

	public PayrollRegisterInternal(EmployeeBean employeeBean) {
		this.employeeBean = employeeBean;

	}

	public PayrollRegisterInternal(EmployeeBean employeeBean, String period, String companyName) {
		this.employeeBean = employeeBean;
		this.period = period;
		this.companyName = companyName;
	}

	public void createExcelStream(FileOutputStream outputStream) {
		if (getTemplateFile() == null) {
			throw new InvalidParameterException(
					"The templateFile is not set, this must contain the file template needed to produce this report.");
		}
		try {

			XSSFWorkbook workbook = new XSSFWorkbook(OPCPackage.open(getTemplateFile()));
			Sheet sheet = workbook.getSheetAt(0);

			// defining cell styles
			CellStyle cellStyle1 = workbook.createCellStyle();
			cellStyle1.setAlignment(XSSFCellStyle.ALIGN_CENTER);
			cellStyle1.setBorderBottom(XSSFCellStyle.BORDER_THIN);
			cellStyle1.setBorderTop(XSSFCellStyle.BORDER_THIN);
			cellStyle1.setBorderRight(XSSFCellStyle.BORDER_THIN);
			cellStyle1.setBorderLeft(XSSFCellStyle.BORDER_THIN);

			CellStyle cellStyle2 = workbook.createCellStyle();
			cellStyle2.cloneStyleFrom(cellStyle1);
			cellStyle2.setAlignment(XSSFCellStyle.ALIGN_LEFT);

			CellStyle cellStyle3 = workbook.createCellStyle();
			cellStyle3.cloneStyleFrom(cellStyle1);
			cellStyle3.setAlignment(XSSFCellStyle.ALIGN_RIGHT);
			cellStyle3.setDataFormat(workbook.getCreationHelper().createDataFormat().getFormat("#,###.00"));

			CellStyle cellStyle4 = workbook.createCellStyle();
			cellStyle4.cloneStyleFrom(cellStyle1);
			cellStyle4.setDataFormat(workbook.getCreationHelper().createDataFormat().getFormat("#,###.00"));
			XSSFFont font = workbook.createFont();
			font.setBold(true);
			cellStyle4.setFont(font);

			CellStyle cellStyle5 = workbook.createCellStyle();
			cellStyle5.cloneStyleFrom(cellStyle3);
			cellStyle5.setFont(font);
			
			 //  ordering employees by name
    		Collections.sort(employeeBean,ObjectComparator.compareEmployeesByName); 

			// writing period covered and company name
			writeData(1, 2, sheet, this.getPeriod());
			writeData(2, 2, sheet, this.getCompanyName());
			writeData(3, 2, sheet, this.getRunType());
			
			// Writing employee beans
			int rowNumber = START_ROWINDEX;			
			for (Employee employee : employeeBean) {
				if (employee != null) {					
					//writing the data for each employee
					writeData(rowNumber, NAME_COLINDEX, sheet, employee.getCompleteName(), cellStyle2);
					writeData(rowNumber, DEPARTMENT_COLINDEX, sheet, employee.getDepartment(), cellStyle1);
					writeData(rowNumber, SALARY_COLINDEX, sheet, employee.getBasicSalary(), cellStyle3);
					writeData(rowNumber, LATE_COLINDEX, sheet, employee.getLate(), cellStyle3);
					writeData(rowNumber, ABSENCES_COLINDEX, sheet, employee.getAbsences(), cellStyle3);
					writeData(rowNumber, OVERTIME_COLINDEX, sheet, employee.getOvertime(), cellStyle3);
					writeData(rowNumber, NIGHT_SHIFT_COLINDEX, sheet, employee.getNightShift(), cellStyle3);
					writeData(rowNumber, NIGHT_SHIFT_OT_COLINDEX, sheet, employee.getNightShiftOverTime(), cellStyle3);
					writeData(rowNumber, VACATION_LEAVE_COLINDEX, sheet, employee.getVacationLeave(), cellStyle3);
					writeData(rowNumber, SICK_LEAVE_COLINDEX, sheet, employee.getSickLeave(), cellStyle3);
					writeData(rowNumber, GROSS_PAY_COLINDEX, sheet, employee.getGrossPay(), cellStyle3);
					writeData(rowNumber, SSS_SHARE_COLINDEX, sheet, employee.getSssEmployeeShare(), cellStyle3);
					writeData(rowNumber, PAGIBIG_SHARE_COLINDEX, sheet, employee.getPagibigEEShare(), cellStyle3);
					writeData(rowNumber, PHILHEALTH_SHARE_COLINDEX, sheet, employee.getPersonalSharePhil(), cellStyle3);
					writeData(rowNumber, WITHHOLDING_TAX_COLINDEX, sheet, employee.getWithholdingTax(), cellStyle3);
					writeData(rowNumber, NET_PAY_COLINDEX, sheet, employee.getNetPay(), cellStyle3);
					writeData(rowNumber, OTHERS_COLINDEX, sheet, employee.getOthers(), cellStyle3);
					writeData(rowNumber, COMISSARY_COLINDEX, sheet, employee.getComissary(), cellStyle3);
					writeData(rowNumber, ALLOTMENT_COLINDEX, sheet, employee.getAllotment(), cellStyle3);
					writeData(rowNumber, SSS_LOAN_COLINDEX, sheet, employee.getSssLoan(), cellStyle3);
					writeData(rowNumber, PAGIBIG_LOAN_COLINDEX, sheet, employee.getPagibigLoan(), cellStyle3);
					writeData(rowNumber, AMOUNT_TO_RECEIVE_COLINDEX, sheet, employee.getAmountToBeReceived(), cellStyle3);					
					
					//updating grand totals			
					computeGrandTotals(employee);				
					
					rowNumber++;
					
				}
			}
			// writing grand totals
			writeData(rowNumber, 2, sheet, "Grand Totals:", cellStyle4);
			if(grandTotals != null){
				for (Entry<Integer, Double> entry : grandTotals.entrySet()){
					writeData(rowNumber, entry.getKey(), sheet, entry.getValue(), cellStyle4);
				}
			}
			
			
			
			
			// auto sizing the columns after inserting all the data
			autoSizeColumns(sheet);
			
			// generating output file
			workbook.write(outputStream);
			outputStream.flush();
			outputStream.close();

		} catch (IOException | InvalidFormatException | EncryptedDocumentException ex) {
			System.out.println("ERROR");
			System.out.println(ex);
		}
	}

	private void writeData(int rowIndex, int colIndex, Sheet sheet, Object data, CellStyle cellStyle) {
		// getting the row
		Row row = getRow(rowIndex, sheet);
		// getting the column
		Cell cell = getCell(colIndex, row);
		// setting cell style
		if (cellStyle != null) {
			cell.setCellStyle(cellStyle);
		}
		// writing data based on type
		if (data instanceof Number) {
			cell.setCellValue(((Number) data).doubleValue());
		} else {
			if (data == null) {
				data = new String("");
			}
			cell.setCellValue(data.toString());
		}
	}

	private void writeData(int rowIndex, int colIndex, Sheet sheet, Object data) {
		writeData(rowIndex, colIndex, sheet, data, null);
	}

	/**
	 * Gets row cell. Creates new cell if it does not exist.
	 * 
	 * @param index
	 * @param row
	 * @return
	 */
	private Cell getCell(int index, Row row) {
		Cell cell = row.getCell(index);
		if (cell == null) {
			cell = row.createCell(index);
		}
		return cell;
	}

	/**
	 * Gets the row. Creates new row if it does not exist.
	 * 
	 * @param index
	 * @param sheet
	 * @return
	 */
	private Row getRow(int index, Sheet sheet) {
		Row row = sheet.getRow(index);
		if (row == null) {
			row = sheet.createRow(index);
		}
		return row;
	}

	// getters and setters
	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public static InputStream getTemplateFile() {
		return new ByteArrayInputStream(templateFileBytes);
	}

	public static void setTemplateFile(InputStream templateFile) {
		try {
			templateFileBytes=IOUtils.toByteArray(templateFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getRunType() {
		return runType;
	}

	public void setRunType(String runType) {
		this.runType = runType;
	}
	private void autoSizeColumns(Sheet sheet){
		for(int i=0; i<=22 ; i++){
			sheet.autoSizeColumn(i);
		}
	}
	
	private void computeGrandTotals(Employee employee){
		updateGrandTotals(SALARY_COLINDEX, employee.getBasicSalary());
		updateGrandTotals(LATE_COLINDEX, employee.getLate());
		updateGrandTotals(ABSENCES_COLINDEX, employee.getAbsences());
		updateGrandTotals(OVERTIME_COLINDEX, employee.getOvertime());
		updateGrandTotals(NIGHT_SHIFT_COLINDEX, employee.getNightShift());
		updateGrandTotals(NIGHT_SHIFT_OT_COLINDEX, employee.getNightShiftOverTime());
		updateGrandTotals(VACATION_LEAVE_COLINDEX, employee.getVacationLeave());
		updateGrandTotals(SICK_LEAVE_COLINDEX, employee.getSickLeave());
		updateGrandTotals(GROSS_PAY_COLINDEX, employee.getGrossPay());
		updateGrandTotals(SSS_SHARE_COLINDEX, employee.getSssEmployeeShare());
		updateGrandTotals(PAGIBIG_SHARE_COLINDEX, employee.getPagibigEEShare());
		updateGrandTotals(PHILHEALTH_SHARE_COLINDEX, employee.getPersonalSharePhil());
		updateGrandTotals(WITHHOLDING_TAX_COLINDEX, employee.getWithholdingTax());
		updateGrandTotals(NET_PAY_COLINDEX, employee.getNetPay());
		updateGrandTotals(OTHERS_COLINDEX, employee.getOthers());
		updateGrandTotals(COMISSARY_COLINDEX, employee.getComissary());
		updateGrandTotals(ALLOTMENT_COLINDEX, employee.getAllotment());
		updateGrandTotals(SSS_LOAN_COLINDEX, employee.getSssLoan());
		updateGrandTotals(PAGIBIG_LOAN_COLINDEX, employee.getPagibigLoan());
		updateGrandTotals(AMOUNT_TO_RECEIVE_COLINDEX, employee.getAmountToBeReceived());	
	}
	
	
	private void updateGrandTotals(int key, double value){		
		if(grandTotals.containsKey(key)){
			grandTotals.put(key, grandTotals.get(key) + value);			
		}
		else{
			grandTotals.put(key, value);		
		}
	}

}
