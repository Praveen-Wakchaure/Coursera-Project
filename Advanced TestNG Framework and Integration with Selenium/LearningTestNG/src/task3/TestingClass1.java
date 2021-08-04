package task3;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestingClass1 {
	
	@BeforeClass
	public void beforeAClass() {
		System.out.println("First method in this class");
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("Last test method in this class");
	}
	
	@BeforeMethod(alwaysRun = true)
	public void beforeMethod() {
		System.out.println("\t Before a test method");
	}
	
	@AfterMethod(alwaysRun = true)
	public void afterMethod() {
		System.out.println("\t After a test method");
	}
	
	@Test
	public void testcase1() {
		System.out.println("\t\t Test case 1");
	}
	
	@Test(groups = {"Sanity" , "Regression"})
	public void testcase2() {
		System.out.println("\t\t Test case 2");
	}

}
