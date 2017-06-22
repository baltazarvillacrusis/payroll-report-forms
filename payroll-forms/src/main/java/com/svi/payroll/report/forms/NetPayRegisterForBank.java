package com.svi.payroll.report.forms;
import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidParameterException;
import java.util.Collections;

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

public class NetPayRegisterForBank {
	
	 private final int ID_COLINDEX =  1;
	 private final int NAME_COLINDEX =  2;
	 private final int BANK_ACCT_NUM_COLINDEX =  3;	
	 private final int BANK_NAME_COLINDEX =  4;
	 private final int AMOUNT_COLINDEX =  5;
	 private final int START_ROWINDEX =  5;	 
	 private EmployeeBean employeeBean = new EmployeeBean();
	 private String period = "";
	 private String companyName = "";
	private static byte[] templateFileBytes;
	 
	 public NetPayRegisterForBank(){		 
	 }
	 
	 public NetPayRegisterForBank(EmployeeBean employeeBean){
		 this.employeeBean = employeeBean;
		 
	 } 
	 
	 public NetPayRegisterForBank(EmployeeBean employeeBean, String period, String companyName){
		 this.employeeBean = employeeBean;
		 this.period = period;
		 this.companyName = companyName;		
	 }
	
	 public void createExcelStream(FileOutputStream outputStream) { 		
		 if(getTemplateFile()==null){
				throw new InvalidParameterException("The templateFile is not set, this must contain the file template needed to produce this report.");
		 }
		 
        try {                   
            XSSFWorkbook workbook  = new XSSFWorkbook(OPCPackage.open(getTemplateFile()) );
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
            XSSFFont font= workbook.createFont();
            font.setBold(true);
            cellStyle4.setFont(font);
            
            CellStyle cellStyle5= workbook.createCellStyle();
            cellStyle5.cloneStyleFrom(cellStyle3);
            cellStyle5.setFont(font);
            
            
            // writing period covered and company name               
            writeData(2,2,sheet,this.getCompanyName());
            writeData(3,2,sheet,this.getPeriod());
            
            //  ordering employees by name
    		Collections.sort(employeeBean,ObjectComparator.compareEmployeesByName);    		
            
            //Writing employee beans              
            int rowNumber = START_ROWINDEX;
            double totalAmount = 0;
            for (Employee employee : employeeBean) {                	
            	// writing employee ID
                writeData(rowNumber,ID_COLINDEX,sheet,employee.getID(),cellStyle1);
            	// writing employee name
                writeData(rowNumber,NAME_COLINDEX,sheet,employee.getCompleteName(),cellStyle2);
            	// writing bank account number
                writeData(rowNumber,BANK_ACCT_NUM_COLINDEX,sheet,employee.getBankAcctNum(),cellStyle1);
            	// writing bank name
                writeData(rowNumber,BANK_NAME_COLINDEX,sheet,employee.getBankName(),cellStyle1);
                // writing bank name
                writeData(rowNumber,AMOUNT_COLINDEX,sheet,employee.getNetPay(),cellStyle3);
                
                totalAmount = totalAmount +employee.getNetPay();
                rowNumber++;                          
            }        
            // writing total amount              
            writeData(rowNumber,AMOUNT_COLINDEX-1,sheet,"Total Amount: ",cellStyle4);
            writeData(rowNumber,AMOUNT_COLINDEX,sheet,totalAmount,cellStyle5);
            
            // generating output file
            workbook.write(outputStream);     
            outputStream.flush();
            outputStream.close();
        
        } catch (IOException | InvalidFormatException | EncryptedDocumentException ex) {        
	          System.out.println("ERROR"); 
	          System.out.println(ex);
        }      
    }	 
	 
	 private void writeData(int rowIndex, int colIndex, Sheet sheet, Object data,  CellStyle cellStyle){    	
    	// getting the row
    	Row row = getRow(rowIndex,sheet);   
    	// getting the column
    	Cell cell = getCell(colIndex,row);    
    	// setting cell style
    	if(cellStyle != null){
    		cell.setCellStyle(cellStyle);
    	}    	
    	// writing data based on type
    	if (data instanceof Number){    		
    		cell.setCellValue(((Number) data).doubleValue());
    	}
    	else{
    		if(data == null){
    			data = new String("");
    		}
    		cell.setCellValue(data.toString());	
    	}
    }
	
	 private void writeData(int rowIndex, int colIndex, Sheet sheet, Object data){
    	writeData(rowIndex, colIndex, sheet, data, null);
    }
	    


	/**
	 * Gets row cell. Creates new cell if it does not exist.
	 * @param index
	 * @param row
	 * @return
	 */
    private Cell getCell(int index, Row row){
    	Cell cell = row.getCell(index);
      	if(cell == null){
      		cell = row.createCell(index);    
      	}
      	return cell;
    }

	/**
	 * Gets the row. Creates new row if it does not exist.
	 * @param index
	 * @param sheet
	 * @return
	 */
    private Row getRow(int index, Sheet sheet){
    	Row row = sheet.getRow(index);
         if(row == null){
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

}
