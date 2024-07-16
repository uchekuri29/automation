package automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pageobject.InventoryPageObject;

public class InventoryModule {
	WebDriver driver;
	public InventoryModule(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getBurgerMenuButton() {
		return driver.findElement(InventoryPageObject.btn_BurgerMenu);
	}

}
