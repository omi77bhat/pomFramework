package tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageobjects.AddProductPage;
import pageobjects.CartPage;
import pageobjects.LoginPage;
import testComponents.Base;

public class CartPageTest extends Base{
	
	LoginPage lp;
	AddProductPage ap;
	CartPage cp;
	
	public CartPageTest() {
		super();
	}
	
	
	@BeforeMethod
	public void initialize() {
		launchApp();
		lp = new LoginPage();
		ap = new AddProductPage();
		cp = new CartPage();
	}
	
	
	
	@Test
	public void run_verifyProductInCart_Checkout() throws InterruptedException {
		lp.login("omitest@gmail.com", "Mytest#77!");
		ap.addProductToCart("ADIDAS ORIGINAL", "Product Added To Cart");
		CartPage cp = PageFactory.initElements(driver, CartPage.class);
		cp.verifyProductAddedToCart("ADIDAS ORIGINAL");
		
		
	}
	
	
	@AfterMethod
	public void close_Browser() {
		exitApp();
	}

}
