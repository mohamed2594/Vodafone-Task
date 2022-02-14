package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InventoryPage {

	private WebDriver driver ;
	private WebDriverWait wait;
	private Select dropDown ;
	private By firstProduct = By.xpath("(//div[@class='inventory_item'])[1]");
	private By sortDropDown = By.className("product_sort_container");
	private By addFirstItemToCart = By.xpath("(//div[@class='inventory_item'])[1]//button");
	private By cartButton = By.id("shopping_cart_container");

	
	public InventoryPage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	public boolean validateRedirection() {
		return driver.getCurrentUrl().contains("inventory");
	}
	
	public void SortProducts(int option) {
		wait= new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.visibilityOfElementLocated(sortDropDown));
		dropDown = new Select(driver.findElement(sortDropDown));
		dropDown.selectByIndex(option);
	}
	
	public void addItemToCart() {
		wait= new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.visibilityOfElementLocated(addFirstItemToCart));
		driver.findElement(addFirstItemToCart).click();
	}
	
	public String getTextOfButton() {
		wait= new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.visibilityOfElementLocated(addFirstItemToCart));
		return driver.findElement(addFirstItemToCart).getText();
	}
	
	public void goToCart() {
		driver.findElement(cartButton).click();
	}
	
	
	public String getDescriptionOfFirstProduct() {
		return driver.findElement(firstProduct).getText();
	}
	
	
}
