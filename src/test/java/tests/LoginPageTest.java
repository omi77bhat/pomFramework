package tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.AddProductPage;
import pageobjects.CartPage;
import pageobjects.CheckoutPage;
import pageobjects.ConfirmationPage;
import pageobjects.LoginPage;
import testComponents.BaseClass;


//@Listeners(testComponents.Listeners.class)
public class LoginPageTest extends BaseClass{
	

	@Test
	public void run_LoginTest() throws InterruptedException {
	
		LoginPage lp = PageFactory.initElements(driver, LoginPage.class);
		lp.login("omitest@gmail.com", "Mytest#77!");
				
	}
	
	@Test(dependsOnMethods = {"run_LoginTest"})
	public void run_addToCartTest() throws InterruptedException {
		
		AddProductPage ap = PageFactory.initElements(driver, AddProductPage.class);
		ap.addProductToCart("ADIDAS ORIGINAL","Product Added To Cart");
		
		
	}

	@Test(dependsOnMethods = {"run_addToCartTest"})
	public void run_verifyProductInCart_Checkout() throws InterruptedException {
		
		CartPage cp = PageFactory.initElements(driver, CartPage.class);
		cp.verifyProductAddedToCart("ADIDAS ORIGINAL");
		
		
	}

	@Test(dependsOnMethods = {"run_verifyProductInCart_Checkout"})
	public void run_checkout() throws InterruptedException {
		
		CheckoutPage co = PageFactory.initElements(driver, CheckoutPage.class);
		co.selectCountry("India");
		
		
	}
	
	@Test(dependsOnMethods = {"run_checkout"})
	public void run_confirmationMessage() throws InterruptedException {
		
		ConfirmationPage co = PageFactory.initElements(driver, ConfirmationPage.class);
		
		System.out.println("*******Actual confirmation message : " + co.getConfirmationMessage());
		AssertJUnit.assertTrue(co.getConfirmationMessage().equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		
		
	}
	
	
	
	

}
