package commonLibs.implementation;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Interactions {
	
	
	public String getText(WebElement element) throws Exception {

		return element.getText();
	}

	
	public void clickElement(WebElement element) throws Exception {
		element.click();

	}

	
	public String getAttribute(WebElement element, String attribute) throws Exception {

		return element.getAttribute(attribute);
	}

	
	public String getCssValue(WebElement element, String csspropertyName) throws Exception {

		return element.getCssValue(csspropertyName);
	}

	
	public boolean isElementEnabled(WebElement element) throws Exception {

		return element.isEnabled();
	}

	
	public boolean isElementVisible(WebElement element) throws Exception {

		return element.isDisplayed();
	}

	
	public boolean isElementSelected(WebElement element) throws Exception {

		return element.isSelected();
	}

	
	public void setText(WebElement element, String textToWrite) throws Exception {

		element.sendKeys(textToWrite);
	}

	
	public void clearText(WebElement element) throws Exception {
		element.clear();

	}

	
	public void changeCheckboxStatus(WebElement element, boolean expectedStatus) throws Exception {

		boolean currentStatus = element.isSelected();

		if (currentStatus != expectedStatus) {
			element.click();
		}

	}

	
	private Select getSelect(WebElement element) {
		Select select = new Select(element);

		return select;
	}

	
	public void selectViaVisibleText(WebElement element, String visibleText) throws Exception {

		getSelect(element).selectByVisibleText(visibleText);

	}

	
	public void selectViaValue(WebElement element, String value) throws Exception {
		getSelect(element).selectByValue(value);

	}

	
	public void selectViaIndex(WebElement element, int index) throws Exception {
		getSelect(element).selectByIndex(index);

	}

	
	public List<WebElement> getAllOptions(WebElement element) {

		return getSelect(element).getOptions();
	}


}
