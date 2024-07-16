package automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pageobject.LoginPageObject;

public class LoginModule {
	WebDriver driver;
	public LoginModule(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getUserNameTextBox() {
		return driver.findElement(LoginPageObject.txt_username);
	}
	
	public WebElement getPasswordTextBox() {
		return driver.findElement(LoginPageObject.txt_password);
	}
	
	public WebElement getLoginButton() {
		return driver.findElement(LoginPageObject.btn_login);
	}
	
	public WebElement getPageLogoName() {
		return driver.findElement(LoginPageObject.heading_applogo);
	}
	
	public void login(String username, String password) {
		getUserNameTextBox().sendKeys(username);
		getPasswordTextBox().sendKeys(password);
		getLoginButton().click();
	}

}
