package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CompletePage {
	private WebDriver driver ;
	private WebDriverWait wait;
	private By result = By.tagName("h2");
	
	public CompletePage(WebDriver driver) {
		this.driver = driver;	
		}
	public String getResult() {
		wait= new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.visibilityOfElementLocated(result));
		return driver.findElement(result).getText();
	}
}
