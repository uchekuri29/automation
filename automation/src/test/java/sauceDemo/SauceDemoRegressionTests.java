package sauceDemo;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.InventoryModule;
import automation.LoginModule;
import io.github.bonigarcia.wdm.WebDriverManager;
import sauceDemo.SauceDemoLoginTest;

public class SauceDemoRegressionTests {
	WebDriver driver;
	InventoryModule inventory;
	LoginModule ilogin;
	
	@BeforeMethod
	public void inventory_test() {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		ilogin = new LoginModule(driver);
		ilogin.login("", "");		
	}

	@Test
	public void verify_userabl_to_add_data_in_cart() {
		
	}
	

}
