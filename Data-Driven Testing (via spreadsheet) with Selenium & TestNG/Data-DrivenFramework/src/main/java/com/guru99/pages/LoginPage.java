package com.guru99.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonLibs.implementation.Interactions;

public class LoginPage {
	
	@FindBy(name="uid")
	public WebElement userId;
	
	@FindBy(name="password")
	public WebElement userPassword;
	
	@FindBy(name="btnLogin")
	public WebElement loginButton;
	
	Interactions interactions = new Interactions();
	
	public LoginPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	public void loginToApplication(String sUsername, String sPassword) throws Exception {
		interactions.setText(userId, sUsername);
		
		interactions.setText(userPassword, sPassword);
		
		interactions.clickElement(loginButton);
	}

}
