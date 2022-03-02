package pageObjects;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class LoginPage {

	WebDriver driver = null;

	By text_UserName = By.name("uid");
	By text_Password = By.name("password");
	By button_Login = By.name("btnLogin");
	By button_Reset = By.name("btnReset");
	By button_Logout=By.xpath("//a[@href='Logout.php']");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void setUserName(String text) {
		driver.findElement(text_UserName).sendKeys(text);

	}

	public void setPassword(String text) {
		driver.findElement(text_Password).sendKeys(text);

	}

	public void clickLoginButton() {
		driver.findElement(button_Login).click();
	}

	public void clickResetButton() {
		driver.findElement(button_Reset).click();
	}
	
	public void clickLogoutButton() {
		
		Actions action=new Actions(driver);
		action.moveToElement(driver.findElement(button_Logout)).perform();
		driver.findElement(button_Logout).click();
		
	}
}
