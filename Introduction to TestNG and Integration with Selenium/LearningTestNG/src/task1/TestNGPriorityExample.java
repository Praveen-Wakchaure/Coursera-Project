package task1;

import org.testng.annotations.Test;

public class TestNGPriorityExample {
	
	@Test(priority = 500)
	public void testcase1()
	{
		System.out.println("Test Case 1");
	}
	
	@Test(priority = -300)
	public void testcase4()
	{
		System.out.println("Test Case 4");
	}
	
	@Test(priority = 100)
	public void testcase3()
	{
		System.out.println("Test Case 3");
	}
	
	@Test(priority = 300)
	public void testcase2()
	{
		System.out.println("Test Case 2");
	}
	
	@Test(priority = -500)
	public void testcase5()
	{
		System.out.println("Test Case 5");
	}
	
	
}
