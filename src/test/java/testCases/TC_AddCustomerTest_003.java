package testCases;

import java.io.IOException;

import org.apache.commons.lang.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass
{
	@Test
	public void addNewCustomer() throws InterruptedException, IOException
	{
		
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("Entered Username");
		lp.setPassword(password);
		logger.info("Entered Password");
		lp.clickLoginButton();
		logger.info("Button Clicked");
		
		Thread.sleep(3000);
		
		
		AddCustomerPage addcust=new AddCustomerPage(driver);
		
		addcust.clickAddNewCustomer();
		
		logger.info("Providing Customer details...");
		
		addcust.customerName("Pavan");
		addcust.customerGender("male");
		addcust.customerDOB("10","15","1985");
		Thread.sleep(3000);
		addcust.customerAddress("INDIA");
		addcust.customerCity("HYD");
		addcust.customerState("AP");
		addcust.customerPIN("5000074");
		addcust.customerPhoneNum("3364454274");
		addcust.customerEmail(randomstring()+"@gmail.com");
		addcust.customerPassword("abcdef");
		addcust.clickSubmitButton();
		
		Thread.sleep(3000);
		
		boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		logger.info("Validation started");
		
		if (res==true) {
			Assert.assertTrue(true);
			logger.info("Test case Passed");
			
		} else {
		
			logger.info("Test case failed");
			Assert.assertTrue(false);
			captureScreen(driver,"addNewCustomer");
			
		}
		
	}
	
	
	
}
