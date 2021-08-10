package com.guru99.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.guru99.pages.LoginPage;
import com.guru99.utils.TestDataProvider;

import commonLibs.implementation.CommonDriver;

public class LoginPageTests {
	
	CommonDriver cmnDriver;
	
	String url = "http://demo.guru99.com/v4";
	
	LoginPage loginPage;
	
	@BeforeMethod
	
	public void setup() throws Exception{
		
		cmnDriver = new CommonDriver("chrome");
		
		cmnDriver.navigateToFirstUrl(url);
		
		loginPage = new LoginPage(cmnDriver.getDriver());
	}
	
	@Test(dataProvider = "getDataFromExcel", dataProviderClass = TestDataProvider.class)
	public void verifyLogin(String sUsername, String sPassword)  throws Exception {
		
		loginPage.loginToApplication(sUsername, sPassword);
		
		Thread.sleep(3000);
		
		String actualTitle = cmnDriver.getTitle();
		
		String ExpectedTitle = "Guru99 Bank Manager HomePage";
		
		Assert.assertEquals(actualTitle, ExpectedTitle);
		
	}
	
	@AfterMethod
	public void cleanUp() throws Exception{
		cmnDriver.closeAllBrowsers();
	}

}
