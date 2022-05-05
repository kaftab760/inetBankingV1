package pageObjects;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import utilities.BasicFunctions;

public class LoginPage {

	WebDriver driver = null;

	By text_UserName = By.name("uid");
	By text_Password = By.name("password");
	By button_Login = By.name("btnLogin");
	By button_Reset = By.name("btnReset");
	By button_Logout = By.xpath("//a[@href='Logout.php']");
	
	BasicFunctions base=new BasicFunctions();

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void setUserName(String text) {
		base.setText(text_UserName, text);
	}

	public void setPassword(String text) {
		base.setText(text_Password, text);
	}

	public void clickLoginButton() {
		base.Click(button_Login);
	}

	public void clickResetButton() {
		base.Click(button_Reset);
	}

	public void clickLogoutButton() {
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(button_Logout)).perform();
		base.Click(button_Logout);

	}
}
