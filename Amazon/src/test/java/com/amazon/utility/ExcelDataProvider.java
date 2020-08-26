package com.amazon.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	XSSFWorkbook wb;

	public ExcelDataProvider() {
		File src = new File("./Test_Data/data.xlsx");
		try {
			FileInputStream fis = new FileInputStream(src);

			wb = new XSSFWorkbook(fis);
		} catch (IOException e) {
			System.out.println("Unable to read the file" + e.getMessage());
		}

	}

	public String getStringData(int rowno, int colno, String sheetname) {
		return wb.getSheet(sheetname).getRow(rowno).getCell(colno).getStringCellValue();
	}

	public double getNumericdata(int sheetnumber, int rowno, int colno) {
		return wb.getSheetAt(sheetnumber).getRow(rowno).getCell(colno).getNumericCellValue();
	}

}