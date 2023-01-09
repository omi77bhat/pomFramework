package tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageobjects.AddProductPage;
import pageobjects.CartPage;
import pageobjects.CheckoutPage;
import pageobjects.ConfirmationPage;
import pageobjects.LoginPage;
import testComponents.Base;

public class ConfirmationPageTest extends Base{
	
	
	LoginPage lp;
	AddProductPage ap;
	CartPage cp;
	CheckoutPage co;
	ConfirmationPage cop;
	
	
	public ConfirmationPageTest() {
		super();
	}
	
	
	@BeforeMethod
	public void initialize() {
		launchApp();
		lp = new LoginPage();
		ap = new AddProductPage();
		cp = new CartPage();
		co = new CheckoutPage();
		cop = new ConfirmationPage();
		
	}
	
	@Test
	public void run_confirmationMessage() throws InterruptedException {
		lp.login("omitest@gmail.com", "Mytest#77!");
		ap.addProductToCart("ADIDAS ORIGINAL", "Product Added To Cart");
		cp.verifyProductAddedToCart("ADIDAS ORIGINAL");
		co.selectCountry("India");
		
		cop = PageFactory.initElements(driver, ConfirmationPage.class);
		
		System.out.println("*******Actual confirmation message : " + cop.getConfirmationMessage());
		AssertJUnit.assertTrue(cop.getConfirmationMessage().equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		
	}
	
	
	@AfterMethod
	public void close_Browser() {
		exitApp();
	}

}
