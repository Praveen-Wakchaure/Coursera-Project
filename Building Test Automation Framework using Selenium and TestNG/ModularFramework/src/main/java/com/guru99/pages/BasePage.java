package com.guru99.pages;

import org.openqa.selenium.WebDriver;

import commonLibs.implemention.ElementControl;

public class BasePage  {
	WebDriver driver;
	
	public ElementControl elementControl;
	
	  public BasePage(WebDriver driver) {
		this.driver=driver;
		
		elementControl = new ElementControl(driver);
	}

}
