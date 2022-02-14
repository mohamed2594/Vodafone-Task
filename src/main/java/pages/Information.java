package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Information {
	private WebDriver driver ;
	private WebDriverWait wait;
	private By fnameField = By.id("first-name");
	private By lnameField = By.id("last-name");
	private By zipCode = By.id("postal-code");

	private By continueButton = By.id("continue");

	public Information(WebDriver driver) {
		this.driver = driver;	
		}

	public void fillForm(String first,String last,String zip) {
		wait= new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.visibilityOfElementLocated(fnameField));
		driver.findElement(fnameField).sendKeys(first);
		driver.findElement(lnameField).sendKeys(last);
		driver.findElement(zipCode).sendKeys(zip);
		driver.findElement(continueButton).click();
	}


}
