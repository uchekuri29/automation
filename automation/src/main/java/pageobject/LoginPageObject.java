package pageobject;

import org.openqa.selenium.By;

public class LoginPageObject {
	public static By txt_username = By.id("user-name");
	public static By txt_password = By.id("password");
	public static By btn_login = By.id("login-button");
	public static By heading_applogo = By.xpath("//div[@class='login_logo' and text()='Swag Labs']");
}
