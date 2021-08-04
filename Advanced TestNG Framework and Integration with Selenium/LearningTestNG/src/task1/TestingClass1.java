package task1;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestingClass1 {
	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Before a test suite");
	}
	
	@AfterSuite
	public void afterSuite() {
		System.out.println("After a test suit");
	}
	
	@BeforeTest
	public void beforeTestRun() {
		System.out.println("Before a test run");
	}
	
	@AfterTest
	public void afterTestRun() {
		System.out.println("After a test run");
	}
	
	@BeforeClass
	public void beforeAClass() {
		System.out.println("First method in this class");
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("Last test method in this class");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("\t Before a test method");
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("\t After a test method");
	}
	
	@Test
	public void testcase1() {
		System.out.println("\t\t Test case 1");
	}
	
	@Test
	public void testcase2() {
		System.out.println("\t\t Test case 2");
	}

}
