package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EditCustomerPage {
	WebDriver driver = null;

	By link_EditCustomer = By.xpath("//a[contains(text(),'Edit Customer')]");
	By text_CustomerID = By.name("cusid");
	By button_Submit = By.name("AccSubmit");
	By button_Reset = By.name("res");

	public EditCustomerPage(WebDriver driver) {
		this.driver = driver;
	}

	public void ClickEditCustomer() {
		driver.findElement(link_EditCustomer).click();
	}

	public void customerID(String id) {
		driver.findElement(text_CustomerID).sendKeys(id);
	}

	public void clickSubmitButton() {

		driver.findElement(button_Submit).click();
	}

	public void clickResetButton() {
		driver.findElement(button_Reset).click();
	}

}
