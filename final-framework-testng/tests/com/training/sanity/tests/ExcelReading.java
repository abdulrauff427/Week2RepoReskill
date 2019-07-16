package com.training.sanity.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReading {

	static File src;
	static FileInputStream fis;
	static XSSFWorkbook wb;
	static XSSFSheet sh1;
	
	public ExcelReading()throws Exception {
		// TODO Auto-generated method stub
		try {
			src = new File("C:\\Abdul\\TestData.xlsx");
			fis = new FileInputStream(src);
			wb = new XSSFWorkbook(fis);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
        //String data1 = sh1.getRow(0).getCell(0).getStringCellValue();
        //System.out.println(data1);
	}
	
	public String getData(int sheetno, int row, int column)
	{
		sh1 = wb.getSheetAt(sheetno);
		String data = sh1.getRow(row).getCell(column).getStringCellValue();
		return data;
		
	}

}
