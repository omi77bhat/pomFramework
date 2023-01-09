package tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageobjects.AddProductPage;
import pageobjects.CartPage;
import pageobjects.CheckoutPage;
import pageobjects.LoginPage;
import testComponents.Base;

public class CheckoutPageTest extends Base{
	
	LoginPage lp;
	AddProductPage ap;
	CartPage cp;
	CheckoutPage co;
	
	public CheckoutPageTest() {
		super();
	}
	
	
	@BeforeMethod
	public void initialize() {
		launchApp();
		lp = new LoginPage();
		ap = new AddProductPage();
		cp = new CartPage();
		co = new CheckoutPage();
		
	}
	
	
	
	@Test
	public void run_checkout() throws InterruptedException {
		lp.login("omitest@gmail.com", "Mytest#77!");
		ap.addProductToCart("ADIDAS ORIGINAL", "Product Added To Cart");
		cp.verifyProductAddedToCart("ADIDAS ORIGINAL");
		CheckoutPage co = PageFactory.initElements(driver, CheckoutPage.class);
		co.selectCountry("India");
		
		
	}
	
	@AfterMethod
	public void close_Browser() {
		exitApp();
	}


}
