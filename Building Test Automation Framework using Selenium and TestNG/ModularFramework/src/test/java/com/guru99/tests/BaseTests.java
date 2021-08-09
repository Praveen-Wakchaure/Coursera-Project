package com.guru99.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.Status;
import com.guru99.pages.LoginPage;

import commonLibs.implemention.CommonDriver;
import commonLibs.utils.ConfigUtils;
import commonLibs.utils.ReportUtils;
import commonLibs.utils.ScreenshotUtils;

public class BaseTests {
	
	CommonDriver cmnDriver;
	String url;
	
	WebDriver driver;
	
	LoginPage loginpage;
	
	String configFileName;
	
	String currentWorkingDirectory;
	
	Properties configProperty;
	
	ReportUtils reportUtils;
	
	String reportFilename;
	
	ScreenshotUtils screenshot;
	
	@BeforeSuite
	public void presetup() throws Exception {
		currentWorkingDirectory = System.getProperty("user.dir");
		
		configFileName = "C:\\Users\\Administrator\\Desktop\\Learning Git\\config.properties";
		
		reportFilename = currentWorkingDirectory + "/reports/guru99TestReports.html"; 
				
		configProperty = ConfigUtils.readProperties(configFileName);
		
		reportUtils = new ReportUtils(reportFilename);
	}
	
	@BeforeClass
	public void setup() throws Exception {
		
		url=configProperty.getProperty("baseUrl");
		
		String browserType = configProperty.getProperty("browserType");
	
		cmnDriver = new CommonDriver(browserType);
		
		driver = cmnDriver.getDriver();
		
		loginpage = new LoginPage(driver);
		
		screenshot = new ScreenshotUtils(driver);
		
		cmnDriver.navigateToUrl(url);
	}
	
	@AfterMethod
	public void postTestAction(ITestResult result) throws Exception {
		String testcasename = result.getName();
		long executionTime = System.currentTimeMillis();
		
		String screenshotFilename = currentWorkingDirectory + "/screenshots/" + testcasename + executionTime +".jpeg";
		
		if(result.getStatus() == ITestResult.FAILURE) {
			reportUtils.addTestLog(Status.FAIL,	"One or more steps failed");
			
			screenshot.captureAndSaveScreenshot(screenshotFilename);
			
			reportUtils.attacheScreenshotToReport(screenshotFilename);
		}
	}
	
	@AfterClass
	public void tearDown() {
		cmnDriver.closeAllBrowser();
	}
	
	@AfterSuite
	public void postTeardown() {
		reportUtils.flushReport();
	}

}
