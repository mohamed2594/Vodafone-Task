package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {

	private WebDriver driver ;
	private WebDriverWait wait;
	private By checkout = By.id("checkout");
	
	public CartPage(WebDriver driver) {
		this .driver=driver;
	}

	

	public void proceedToCheckout() {
		wait= new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.visibilityOfElementLocated(checkout));
		driver.findElement(checkout).click();
	}
}
