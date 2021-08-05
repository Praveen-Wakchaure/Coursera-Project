package tests;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class TestingGrid {
	
	WebDriver driver;
	
	@Test
	public void invokeBrowser() throws MalformedURLException
	{
		URL remoteURL = new URL("http://172.31.128.129:4555/wd/hub");
		
		ChromeOptions chromeOptions = new ChromeOptions();
		
		driver = new RemoteWebDriver(remoteURL, chromeOptions);
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		driver.get("http://test.qatechhub.com");
	}

}
