package testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseClass;
import pageObjects.LoginPage;
import utilities.ULUtils;

public class TC_LoginDDT_002 extends BaseClass {
	@Test(dataProvider = "LoginData")
	public void loginDDT(String user, String pwd) throws InterruptedException {
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(user);
		logger.info("Entered Username");
		lp.setPassword(pwd);
		logger.info("Entered Password");
		lp.clickLoginButton();
		logger.info("Login Button Clicked");
		
		Thread.sleep(3000);
		
		if(isAlertPresent()==true)
		{
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("Login failed");
		}else 
		{
			
			Assert.assertTrue (true);
			logger.info("Login Passed");
			Thread.sleep(3000);
			lp.clickLogoutButton();
			
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			
		}
	}

	//User defined method created to check alert is present or not
	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	@DataProvider(name = "LoginData")
	String[][] getData() throws IOException {
		String path = System.getProperty("user.dir") + "/src/test/java/testData/LoginData.xlsx";

		int rownum = ULUtils.getRowCount(path, "Sheet1");
		int colcount = ULUtils.getCellCount(path, "Sheet1", 1);
		String logindata[][] = new String[rownum][colcount];

		for (int i = 1; i <= rownum; i++) {
			for (int j = 0; j < colcount; j++) {

				logindata[i - 1][j] = ULUtils.getCellData(path, "Sheet1", i, j);
			}
		}

		return logindata;
	}

}
