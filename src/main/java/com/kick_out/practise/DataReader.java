package com.kick_out.practise;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class DataReader {
	static Workbook workbook;
	static Sheet sheet;
	static String sheet_path="C:\\Users\\malli\\OneDrive\\Desktop\\testdata.xlsx";
	
	public static Object[][]  dataTable(String sheetname){
		File f = new File(sheet_path);
		FileInputStream fip = null;
		try {
			fip = new FileInputStream(f);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			workbook = WorkbookFactory.create(fip);
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = workbook.getSheet(sheetname);
		Row row =  sheet.getRow(0);
		int rowsize = sheet.getLastRowNum();
		int colsize = row.getLastCellNum();
		Object[][] data = new Object[rowsize][colsize];
			for(int i=0; i<rowsize;i++) {
				for(int j=0;j<colsize;j++) {
					data[i][j]=sheet.getRow(i+1).getCell(j).toString();
				}
			}
			return data;
			
	}
}
