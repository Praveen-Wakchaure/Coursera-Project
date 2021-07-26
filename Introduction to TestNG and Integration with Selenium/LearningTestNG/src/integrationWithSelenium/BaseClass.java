package integrationWithSelenium;

import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {

	ChromeDriver driver;
	
	public void invokeBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\Desktop\\TestNG Testing\\ChromeDriver\\chromedriver_win32 (1)\\chromedriver.exe");
		
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		
		driver.get("http://qatechhub.com");
	
	}
	
	public String getTitleOfThePage() {
		
		String titleOfThePage = driver.getTitle();
		
		return titleOfThePage;
	}
	
	public void closeBrowser() {
		
		driver.close();
		
	}
}
