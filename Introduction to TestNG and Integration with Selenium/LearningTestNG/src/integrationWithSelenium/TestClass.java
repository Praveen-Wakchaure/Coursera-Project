package integrationWithSelenium;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestClass {
	
	BaseClass base =  new BaseClass();

	@BeforeClass
	public void setup() {
		base.invokeBrowser();
	}
	
	@AfterClass
	public void teardown()
	{
		base.closeBrowser();
	}
	
	@Test
	public void verifyTitleOfThePage()
	{
		String TitleOfThePage = base.getTitleOfThePage();
		
		//System.out.println("Title of the page is: "+TitleOfThePage);
		
		String expectedTitle = "Test QA Tech Hub – Learning By Doing is the best way to learn!";
		
		Assert.assertEquals(TitleOfThePage, expectedTitle);
	}
	
}
