package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.InventoryPage;
import pages.LoginPage;

public class Login_Tests {
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
	public void loginBlockedUser() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.userLogin("locked_out_user", "secret_sauce");
		Assert.assertTrue(loginPage.getErrorMessage().contains("this user has been locked out"));
	}
	
	@Test
	public void loginEmptyCredentials() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.userLogin("", "");
		Assert.assertTrue(loginPage.getErrorMessage().contains("Username is required"));
	}
	
	@Test
	public void loginEmptyPassword() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.userLogin("secret_sauce", "");
		Assert.assertTrue(loginPage.getErrorMessage().contains("Password is required"));
	}
	
	@Test
	public void loginInvalidCredentials() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.userLogin("a", "secret_sauce");
		Assert.assertTrue(loginPage.getErrorMessage().contains("do not match any user"));
	}
	
	@Test
	public void loginValidCredentials() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.userLogin("standard_user", "secret_sauce");
		InventoryPage inventory = new InventoryPage(driver);
		Assert.assertTrue(inventory.validateRedirection());
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
