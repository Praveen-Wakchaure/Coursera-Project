package task3;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestingClass2 {
	
	@BeforeClass
	public void beforeAClass() {
		System.out.println("Class 2 - First method in this class");
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("Class 2 - Last test method in this class");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("\t Class 2 - Before a test method");
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("\t Class 2 - After a test method");
	}
	
	@Test
	public void testcase1() {
		System.out.println("\t\t Class 2 - Test case 1");
	}
	
	@Test(groups = "Sanity")
	public void testcase2() {
		System.out.println("\t\t Class 2 - Test case 2");
	}

}
