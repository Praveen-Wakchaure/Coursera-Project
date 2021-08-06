package task3;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByClassName;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {
	
	public static void waitTillElementVisible(WebDriver driver, int timeSeconds, By by) {
		
		WebDriverWait wait = new WebDriverWait(driver, timeSeconds);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		
	}
	
	public static void waitTillAnAlertIsPresent(WebDriver driver, int timeoutInSeconds) {
		
		WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
		
		wait.until(ExpectedConditions.alertIsPresent());
		
	}
	
	public static void waitTillElementClickable(WebDriver driver, int timeSeconds, By locator) {
		
		WebDriverWait wait = new WebDriverWait(driver, timeSeconds);
		
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	public static void waitTillElementIsInvisible(WebDriver driver, int timeSeconds, By locator) {
		
		WebDriverWait wait = new WebDriverWait(driver, timeSeconds);
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}
	
	public static void waitTillElementVisibleWithFluentWait(WebDriver driver,int pollingTime, int timeoutInSeconds, By locator) {
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(timeoutInSeconds))
				.pollingEvery(Duration.ofMillis(pollingTime))
				.ignoring(NoSuchElementException.class);
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}

}
