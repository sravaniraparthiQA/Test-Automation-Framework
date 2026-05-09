package com.ui.tests;

import static com.constants.Browser.CHROME;
import static org.testng.Assert.assertEquals;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pages.HomePage;
import com.ui.pojo.User;
import com.utility.LoggerUtility;

@Listeners(com.ui.listeners.TestListener.class)
public class LoginTest extends TestBase{
	
	/*
	 * Test method!!
	 * 1. Test Script should be small!!
	 * 2. You cannot have conditional statement, loops, try-catch in your test method/test scripts-->test steps
	 * 3. Reduce/do not the usage of local variables!!
	 * 4. Should have atleast one assertion(verifying something)
	 */
	
	Logger logger =	LoggerUtility.getLogger(this.getClass());
	
	
	@Test(description = "Verifies with the valid user is able to login into the applilication", groups= {"e2e","sanity"},
			dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, dataProvider = "LoginTestdataProvider")
	public void loginTest(User user) {
		
		assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(),user.getPassword()).getUsername(), "Sravani Raparthi");
	}

//	@Test(description = "Verifies with the valid user is able to login into the applilication", groups= {"e2e","sanity"},
//			dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, dataProvider = "LoginCSVDataprovider")
//	public void loginCSVTest(User user) {
//		
//		assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(),user.getPassword()).getUsername(), "Sravani Raparthi");
//	}
//	
//	@Test(description = "Verifies with the valid user is able to login into the applilication", groups= {"e2e","sanity"},
//			dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, dataProvider = "LoginExcelDataprovider", retryAnalyzer = com.ui.listeners.MyRetryAnalyzer.class)
//	public void loginExcelTest(User user) {
//		
//		assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(),user.getPassword()).getUsername(), "Sravani Raparthi1");
//		
//	}
	
}
