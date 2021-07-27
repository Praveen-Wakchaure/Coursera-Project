package automationScripts;

import java.awt.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AmazonFeatureTests {
	
	ChromeDriver driver;
	
	@BeforeClass
	public void invokeBrowser() {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Administrator\\Desktop\\Selenium Testing\\chromedriver_win32 (1)\\chromedriver.exe");
		
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.get("http://amazon.com");
			
	}
	
	@Test(priority = 0)
	public void verifyTitleOfThePage() {
		
		String expectedTitle = "Amazon.com. Spend less. Smile more.";
		String actualTitle;
		
		actualTitle = driver.getTitle();
		
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	
	@Test(priority = 100)
	public void searchProduct() {
		String productItem = "Apple Watch";
		
		String category = "Electronics";
		
		WebElement selDropdown = driver.findElement(By.id("searchDropdownBox"));
		
		Select selCategory = new Select(selDropdown);
		
		selCategory.selectByVisibleText(category);
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(productItem);
		
		driver.findElement(By.xpath("//input[@value='Go']")).click();
	}
	
	@Test(priority = 200)
	public void getNthProduct() {
		
		int productItemNumber = 4;
		
		String xpathExpression = String.format("//div[@class='a-section aok-relative s-image-square-aspect']//img[@data-image-index='%d']", productItemNumber);

		WebElement nthProduct = driver.findElement(By.xpath(xpathExpression));
		
		String nthProductResult = nthProduct.getText();
		
		System.out.println(nthProductResult);
	}
	
	@Test(priority = 300, enabled = false)
	public void getAllProducts() {
		java.util.List<WebElement> allProducts = driver.findElements(By.xpath("//div[@class='a-section a-spacing-medium']//span[@data-component-type='s-product-image']"));
		
		String productResult;
		for (WebElement product : allProducts)
		{
			productResult = product.getText();
			
			System.out.println(productResult);
			
			System.out.println("--------------------");
		}
	}
	
	@Test(priority = 400, enabled = false)
	public void scrollDown() {
		
		java.util.List<WebElement> allProducts = driver.findElements(By.xpath("//div[@class='a-section a-spacing-medium']//span[@data-component-type='s-product-image']"));
		
		String productResult;
		
		Actions action = new Actions(driver);
		
		for (WebElement product : allProducts)
		{
			action.moveToElement(product).build().perform();
			
			productResult = product.getText();
			
			System.out.println(productResult);
			
			System.out.println("--------------------");
		}
		
	}
	
	@Test(priority = 500)
	public void scrollDownUsingJS() {
		
		java.util.List<WebElement> allProducts = driver.findElements(By.xpath("//div[@class='a-section a-spacing-medium']//span[@data-component-type='s-product-image']"));
		
		String productResult;
		
		int xCordinate, yCordinate;
		
		
		for (WebElement product : allProducts)
		{

			xCordinate = product.getLocation().x;
			yCordinate = product.getLocation().y;
			
			scrollDown(xCordinate,yCordinate);
			
			productResult = product.getText();
			
			System.out.println(productResult);
			
			System.out.println("--------------------");
		}
		
	}
	
	private void scrollDown(int x, int y) {
		JavascriptExecutor jsEngine;
		
		jsEngine = (JavascriptExecutor) driver;
		
		String jsCommand;
		
		jsCommand = String.format("window.scrollBy(%d, %d)",x,y );
		
		jsEngine.executeScript(jsCommand);
		
	}
	
	@AfterClass
public void closeBrowser() {
		driver.quit();
}
	
}
