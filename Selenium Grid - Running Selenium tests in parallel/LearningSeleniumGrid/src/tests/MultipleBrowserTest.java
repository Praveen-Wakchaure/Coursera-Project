package tests;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MultipleBrowserTest {
	
	WebDriver driver;
	
	@Parameters("browserType")
	@Test
	public void invokeBrowser(String browserType) throws MalformedURLException
	{
		
		URL remoteURL = new URL("http://172.31.128.129:4555/wd/hub");
		
		if(browserType.equals("chrome"))
		{
			ChromeOptions chromeOptions = new ChromeOptions();
			
			driver = new RemoteWebDriver(remoteURL, chromeOptions);
		}
		else if (browserType.equals("edge"))
		{
			EdgeOptions edgeOption = new EdgeOptions();
			
			driver = new RemoteWebDriver(remoteURL, edgeOption);
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		driver.get("http://test.qatechhub.com");
	}

}
