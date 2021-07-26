package task1;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestingTestNG {

	@Test
	public void testcase1()
	{
		System.out.println("First Test Case");
	}
	
	@Test(enabled = false)
	public void testcase2()
	{
		System.out.println("Second Test Case");
	}
	
	@BeforeMethod
    public void beforeTestCase() {
		System.out.println("Before a test case");
	}
	
	@AfterMethod
	public void afterTestCase()
	{
		System.out.println("After every test case");
	}
	
	@BeforeClass
	public void beforeClass()
	{
		System.out.println("First statement to be execute in a class");
	}
	
	@AfterClass
	public void afterClass()
	{
		System.out.println("Last statement to be execute in a class");
	}
	
	
	
	
	
	
	
	
}
