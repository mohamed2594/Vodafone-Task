package tests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.CartPage;
import pages.CompletePage;
import pages.Information;
import pages.InventoryPage;
import pages.LoginPage;
import pages.OverviewPage;

public class Buy_Scenario {
	WebDriver driver ;
	@BeforeClass
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@BeforeMethod
	public void visitTestPage() {
		driver.get("https://www.saucedemo.com/");
	}
	@Test
	public void BuyTest() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.userLogin("standard_user", "secret_sauce");
		
		InventoryPage inventory = new InventoryPage(driver);
		inventory.addItemToCart();
		inventory.goToCart();
		
		CartPage cart = new CartPage(driver);
		cart.proceedToCheckout();
		
		Information info = new Information(driver);
		info.fillForm("Mohamed", "Mobarak", "12345");
		
		OverviewPage overview = new OverviewPage(driver);
		overview.finish();
		
		CompletePage complete = new CompletePage(driver);
		assertEquals(complete.getResult(), "THANK YOU FOR YOUR ORDER");
	}
	
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
