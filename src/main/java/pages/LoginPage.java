package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	private WebDriver driver ;
	private WebDriverWait wait;
	private By userNameField = By.id("user-name");
	private By passwordField = By.id("password");
	private By loginButton = By.id("login-button");
	private By errorMessageContainer = By.tagName("h3");
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public void userLogin(String userName,String password) {
		wait= new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.visibilityOfElementLocated(userNameField));
		WebElement emailField= driver.findElement(userNameField);
		emailField.sendKeys(userName);
		driver.findElement(passwordField).sendKeys(password);
		driver.findElement(loginButton).click();
	}
	
	public String getErrorMessage() {
		wait= new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessageContainer));
		return driver.findElement(errorMessageContainer).getText();
	}
	
}
