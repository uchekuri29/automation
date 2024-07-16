package sauceDemo;


import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import automation.LoginModule;
import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ExcelReader;

public class SauceDemoLoginTest {

	WebDriver driver;
	LoginModule login;
	
	@BeforeMethod
	public void launchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		login = new LoginModule(driver);
	}
	
	@Test	
	public void verify_username_password_availability() {
		Assert.assertEquals(driver.getTitle(), "Swag Labs");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(login.getPageLogoName().getText(),"Swag Labs");
		softAssert.assertTrue(login.getUserNameTextBox().isDisplayed());
		softAssert.assertTrue(login.getPasswordTextBox().isDisplayed());
		softAssert.assertTrue( login.getLoginButton().isDisplayed());	
		softAssert.assertAll();
	}
	
	@DataProvider(name="login-data")
	public static Object[][] data(){
		return ExcelReader.readExcel();
	}
	
	@Test(dataProvider = "login-data")
	public void verify_user_able_to_login(String username, String password) {
		// Enter valid data in username and password
		login.getUserNameTextBox().sendKeys(username);
		login.getPasswordTextBox().sendKeys(password);
		login.getLoginButton().click();
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
		}

	@AfterClass
	public void tearDown() {
	driver.quit();
	}
}
