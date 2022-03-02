package testCases;

import org.testng.annotations.Test;

import base.BaseClass;
import pageObjects.AddCustomerPage;
import pageObjects.EditCustomerPage;
import pageObjects.LoginPage;

public class TC_EditCustomerTest_004 extends BaseClass
{
	
	@Test
	public void editCustomer() throws InterruptedException
	{
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("Entered Username");
		lp.setPassword(password);
		logger.info("Entered Password");
		lp.clickLoginButton();
		logger.info("Button Clicked");
		
		Thread.sleep(3000);
		
		EditCustomerPage editCus=new EditCustomerPage(driver);
		
		editCus.ClickEditCustomer();
		editCus.customerID("14121");
		editCus.clickSubmitButton();
		
		AddCustomerPage addcust=new AddCustomerPage(driver);
		addcust.customerAddress("C block,Askari 10");
		Thread.sleep(5000);
		addcust.clickSubmitButton();
	}

}
