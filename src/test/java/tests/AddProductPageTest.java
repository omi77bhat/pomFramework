package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;


import pageobjects.AddProductPage;
import pageobjects.LoginPage;
import testComponents.Base;

public class AddProductPageTest extends Base{
	
	LoginPage lp;
	AddProductPage ap;
	
	public AddProductPageTest() {
		super();
	}
	
	
	@BeforeMethod
	public void initialize() {
		launchApp();
		lp = new LoginPage();
		ap = new AddProductPage();
	}
	
	
	@Test(priority=2)
	public void run_addToCartTest() throws InterruptedException {
		
		lp.login("omitest@gmail.com", "Mytest#77!");
		AddProductPage ap = PageFactory.initElements(driver, AddProductPage.class);
		ap.addProductToCart("ADIDAS ORIGINAL", "Product Added To Cart");
		
		
	}
	
	@Test(priority=1)
	public void run_verifyHomePageTitle() throws InterruptedException {
		lp.login("omitest@gmail.com", "Mytest#77!");
		Assert.assertTrue(ap.verify_HomePage_Text());
		
	}
	
	
	
	@AfterMethod
	public void close_Browser() {
		exitApp();
	}
	
}
