package com.kick_out.practise;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelReader {
	private String excelFilePath;
	String sheetname; 
	ExcelReader(String excelFilePath) throws Exception{
		this.excelFilePath = excelFilePath;
	}
	FileInputStream fip = new FileInputStream(excelFilePath);
	Workbook workbook = WorkbookFactory.create(fip);
	Sheet sheet = workbook.getSheet(sheetname);
	int rowsize = sheet.getLastRowNum();
	int colsize = sheet.getRow(0).getLastCellNum();
	

}	
