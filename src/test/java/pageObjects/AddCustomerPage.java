package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class AddCustomerPage {

	WebDriver driver = null;

	By link_AddNewCustomer = By.xpath("//a[contains(text(),'New Customer')]");
	By text_CustomerName = By.name("name");
	By rd_Gender = By.name("rad1");
	By text_dob = By.name("dob");
	By text_Address = By.name("addr");
	By text_City = By.name("city");
	By text_State = By.name("state");
	By text_PIN = By.name("pinno");
	By text_PhoneNum = By.name("telephoneno");
	By text_Email = By.name("emailid");
	By text_Password = By.name("password");
	By button_Submit = By.name("sub");
	By button_Reset = By.name("res");

	public AddCustomerPage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickAddNewCustomer() {
		driver.findElement(link_AddNewCustomer).click();
	}

	public void customerName(String cname) {
		driver.findElement(text_CustomerName).sendKeys(cname);
	}

	public void customerGender(String cgender) {
		driver.findElement(rd_Gender).click();
	}

	public void customerDOB(String mm, String dd, String yy) {
		driver.findElement(text_dob).sendKeys(mm);
		driver.findElement(text_dob).sendKeys(dd);
		driver.findElement(text_dob).sendKeys(yy);

	}

	public void customerAddress(String caddress) {

		driver.findElement(text_Address).sendKeys(caddress);
	}

	public void customerCity(String ccity) {

		driver.findElement(text_City).sendKeys(ccity);
	}

	public void customerState(String cstate) {

		driver.findElement(text_State).sendKeys(cstate);
	}
	
	public void customerPIN(String cpin) {

		driver.findElement(text_PIN).sendKeys(String.valueOf(cpin));
	}
	
	public void customerPhoneNum(String cphn) {

		driver.findElement(text_PhoneNum).sendKeys(cphn);
	}
	
	public void customerEmail(String cemail) {

		driver.findElement(text_Email).sendKeys(cemail);
	}

	public void customerPassword(String cpass) {

		driver.findElement(text_Password).sendKeys(cpass);
	}
	public void clickSubmitButton() {
		
		driver.findElement(button_Submit).click();	
	}
	
	public void clickResetButton() {
		driver.findElement(button_Reset).click();
	}
}
