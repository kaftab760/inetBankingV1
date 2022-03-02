package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;

import pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {
	
	@Test
	public void loginTest() {

		LoginPage lp = new LoginPage(driver);

		lp.setUserName(username);
		logger.info("Entered Username");
		
		lp.setPassword(password);
		logger.info("Entered Password");
		
		lp.clickLoginButton();
		logger.info("Button Clicked");
		
		if (driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			Assert.assertTrue(true);
			logger.info("Login Test Passed");
		} else {
			Assert.assertTrue(false);
			logger.info("Login Test Failed");
		}
		
	}

}
