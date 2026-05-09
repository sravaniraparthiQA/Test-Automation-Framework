package com.ui.pages;

import static com.constants.Env.QA;
import static com.utility.JSONUtility.readJSON;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.constants.Browser;
import com.utility.BrowserUtility;
import com.utility.LoggerUtility;

public final class HomePage extends BrowserUtility {
	
	Logger logger =	LoggerUtility.getLogger(this.getClass());

	// this class follow Page object Design pattern
	private static final By SIGN_IN_LINK_LOCATOR = By.xpath("//a[contains(text(),'Sign in')]");

	public HomePage(Browser browserName, boolean isHeadless) {
		super(browserName, isHeadless); // To Call the Parent class constructor from the child class constructor

		//read from config.json file
		goToWebsite(readJSON(QA).getUrl());
		
		//read from .properties file
//		goToWebsite(readProperty(QA, "URL"));
	}
	
	public HomePage(WebDriver driver) {
		super(driver); // To call the Parent Class constructor from the child constructor
		goToWebsite(readJSON(QA).getUrl());
	}
	
	public LoginPage goToLoginPage() { // Page Functions---->cannot use
		logger.info("Trying to perform click to go to Sign in page");
		
		clickOn(SIGN_IN_LINK_LOCATOR);
		LoginPage loginPage = new LoginPage(getDriver());
		return loginPage;
	}

	public void quit() {
		quiteSession();
	}

}
