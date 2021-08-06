package task2;

import java.awt.Desktop.Action;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FlipkartProject {
	
	ChromeDriver driver;
	String url = "https://flipkart.com";
	
	@BeforeClass
	public void invokeBrowser() {
		
		System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\Administrator\\Desktop\\Selenium Testing\\chromedriver.exe");
		
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get(url);
		
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();;
	}
	
	@Test
	public void mouseHover() {
		
		
		
		driver.findElement(By.xpath("//div[@class='xtXmba'][text()='Electronics']")).click();
		
		//driver.findElement(By.partialLinkText("Electronics"));
		
		Actions action = new Actions(driver);
		
		WebElement electronicsLink =  driver.findElement(By.xpath("//span[@class='_2I9KP_'][text()='Electronics']"));
		
		action.moveToElement(electronicsLink).build().perform();
		
		WebElement samsungLink= driver.findElement(By.linkText("Samsung"));
		
		action.moveToElement(samsungLink).click(samsungLink).build().perform();
			
	}
	
	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}

}
