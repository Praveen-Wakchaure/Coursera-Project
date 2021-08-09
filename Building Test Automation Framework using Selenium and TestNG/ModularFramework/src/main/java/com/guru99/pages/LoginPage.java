package com.guru99.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
	
	@FindBy(name="uid")
	private WebElement userId;
	
	@FindBy(name="password")
	private WebElement userpassword;
	
	@FindBy(name="btnLogin")
	private WebElement loginButton;
	
	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void loginToApplication(String username, String password) {
		
		elementControl.setText(userId, username);
		
		elementControl.setText(userpassword, password);
		
		elementControl.clickElement(loginButton);
		
	}

}
