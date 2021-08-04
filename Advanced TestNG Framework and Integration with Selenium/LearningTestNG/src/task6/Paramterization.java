package task6;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Paramterization {
	
	WebDriver driver;
	
	@BeforeClass
	public void invokeBrowser() {
		
		System.setProperty("webdriver.edge.driver", "C:\\Users\\Administrator\\Desktop\\TestNG Testing\\edgedriver_win64 (1)\\msedgedriver.exe");
		
		driver = new EdgeDriver();
		
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("http://demo.guru99.com/v4");
		
	}
	
	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}
	
	//User ID :	mngr345647
	//Password :	hadYjen
	
	@Parameters({"userId","userPassword"})
	@Test
	public void loginToApplication(String username, String password) {
		driver.findElement(By.name("uid")).sendKeys(username);
		
		driver.findElement(By.name("password")).sendKeys(password);
		
		driver.findElement(By.name("btnLogin")).click();
	}

}
