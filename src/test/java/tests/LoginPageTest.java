package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
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
import testComponents.Base;


//@Listeners(testComponents.Listeners.class)
public class LoginPageTest extends Base{
	
	LoginPage lp;
	
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void initialize() {
		launchApp();
		lp = new LoginPage();
	}
	
	
	@Test(priority=2)
	public void run_LoginTest() throws InterruptedException {
	
		lp = PageFactory.initElements(driver, LoginPage.class);
		lp.login("omitest@gmail.com", "Mytest#77!");
				
	}
	
	@Test(priority=1,retryAnalyzer=testComponents.Retry.class)
	public void run_LoginTest_VerifyTitle() throws InterruptedException {
	
	String actual = lp.verifyLoginPageTitle();
//	Assert.assertEquals(actual, "Let's Shop");
	Assert.assertTrue(false);
	
				
	}
	
	
	@AfterMethod
	public void close_Browser() {
		exitApp();
	}
	


}
