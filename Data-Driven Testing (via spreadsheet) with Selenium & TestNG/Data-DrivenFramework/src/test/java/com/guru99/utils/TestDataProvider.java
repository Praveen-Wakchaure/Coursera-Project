package com.guru99.utils;

import org.testng.annotations.DataProvider;

import commonLibs.utils.ExcelDriver;

public class TestDataProvider {
	
	@DataProvider
	public Object[][] getData() {
		
		Object [][] data = new Object[3][2];
		
		data [0][0] = "mngr346859";
		data [0][1] = "EpeqUhu";	
		
		data [1][0] = "mngr346859";
		data [1][1] = "EpeqUhu";
		
		data [2][0] = "mngr34685";   //Incorrect Value
		data [2][1] = "EpeqUhu";
		
		return data;
	}
	
	@DataProvider
	public Object[][] getDataFromExcel() throws Exception{
		String excelFileName = System.getProperty("user.dir") + "/testDataInputFiles/TestData.xlsx";
	
		String sheetname = "TestData";
		
		ExcelDriver excelDriver = new ExcelDriver();
	
		excelDriver.openWorkbook(excelFileName);
		
		Object[][] data;
		
		int rowCount = excelDriver.getRowCount(sheetname);
		
		int cellCount = excelDriver.getCellCountFromArow(sheetname, 1);
		
		data = new Object[rowCount + 1][cellCount];
		
		for(int row = 0; row <= rowCount; row++) {
			for(int cell=0; cell< cellCount; cell++) {
				data[row][cell] =  excelDriver.getCellData(sheetname, row, cell);
			}
		}
		
		return data;
	}

}
