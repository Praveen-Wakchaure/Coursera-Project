package com.guru99.utils;

import java.sql.SQLException;

import org.testng.annotations.DataProvider;

import commonLibs.utils.DatabaseUtils;

public class TestDataSource {
	
	@DataProvider
	public Object [][] getData(){
		
		Object [][] data = new Object[3][2];
		
		data [0][0] = "mngr345411";
		data [0][1] = "edYhYvY";
		
		data [1][0] = "mngr345411";
		data [1][1] = "edYhYvY";
		
		data [2][0] = "mngr345411";
		data [2][1] = "edYhYvY"; 
		
		return data;
		
	}
	
	@DataProvider
	public Object [][] getDataFromDatabase() throws SQLException{
		
		Object [][] data;
		
		DatabaseUtils databaseUtils = new DatabaseUtils();
		
		String server = "localhost";
		int portNumber = 3306;
		String database = "Guru99TestData";
		String username= "root";
		String password = "admin@1234";
		
		databaseUtils.openConnection(server, portNumber, database, username, password);
		
		String sqlQuery = "select * from users";
		
		data = databaseUtils.executeSqlSelectQuery(sqlQuery);
		
		databaseUtils.closeConnection();
		return data;
		
	}
}
