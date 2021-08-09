package com.guru99.tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class LoginTests extends BaseTests {
	
	@Parameters({"username","userPassword"})
	@Test
	public void verifyUserLoginWithCorrectCredentials(String username, String password) {
		
		reportUtils.createATestCase("verifyUserLoginWithCorrectCredentials");
		reportUtils.addTestLog(Status.INFO, "Performing Login");
		
		loginpage.loginToApplication(username, password);
		
		//String expectedTitle = "Guru99 Bank Manager HomePage";
		
		String expectedTitle = "To failed the test and Take the Screenshot";
		String actualTitle=cmnDriver.getTitleOfThePage();
		
		reportUtils.addTestLog(Status.INFO, "Comparing expected and actual title");
		Assert.assertEquals(actualTitle, expectedTitle);
	
	}

}
