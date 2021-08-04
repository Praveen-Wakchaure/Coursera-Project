package task8;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderExample {
	
	WebDriver driver;
	
	@BeforeMethod
	public void invokeBrowser() {
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Administrator\\Desktop\\TestNG Testing\\chromedriver.exe");

		driver = new ChromeDriver();
		
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("http://demo.guru99.com/v4");
		
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}
	

	@Test(dataProvider = "getData", dataProviderClass = TestData.class)
	public void loginToApplication(String username, String password) {
		driver.findElement(By.name("uid")).sendKeys(username);

		driver.findElement(By.name("password")).sendKeys(password);

		driver.findElement(By.name("btnLogin")).click();
	}

}
