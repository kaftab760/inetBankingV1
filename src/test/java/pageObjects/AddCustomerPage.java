package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import utilities.BasicFunctions;

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

	BasicFunctions base = new BasicFunctions();

	public AddCustomerPage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickAddNewCustomer() {
		base.Click(link_AddNewCustomer);
	}

	public void customerName(String cname) {
		base.setText(text_CustomerName, cname);
	}

	public void customerGender(String cgender) {
		base.Click(rd_Gender);
	}

	public void customerDOB(String mm, String dd, String yy) {
		base.setText(text_dob, mm);
		base.setText(text_dob, dd);
		base.setText(text_dob, yy);

	}

	public void customerAddress(String caddress) {
		base.setText(text_Address, caddress);
	}

	public void customerCity(String ccity) {
		base.setText(text_City, ccity);
	}

	public void customerState(String cstate) {
		base.setText(text_State, cstate);
	}

	public void customerPIN(String cpin) {
		base.setText(text_PIN, String.valueOf(cpin));
	}

	public void customerPhoneNum(String cphn) {
		base.setText(text_PhoneNum, cphn);
	}

	public void customerEmail(String cemail) {
		base.setText(text_Email, cemail);
	}

	public void customerPassword(String cpass) {
		base.setText(text_Password, cpass);
	}

	public void clickSubmitButton() {
		base.Click(button_Submit);
	}

	public void clickResetButton() {
		base.Click(button_Reset);
		
	}
}
