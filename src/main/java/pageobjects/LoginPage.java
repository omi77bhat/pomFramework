package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import testComponents.Base;

public class LoginPage extends Base {
	
	public LoginPage() {
		
	PageFactory.initElements(driver, this);
		
	}
	
	
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement passwordEle;
	
	@FindBy(id="login")
	WebElement submit;
	
	

	public void login(String username, String password) throws InterruptedException {
		
		userEmail.sendKeys(username);
		passwordEle.sendKeys(password);
		submit.click();
		Thread.sleep(5000);
	}
	
	public String verifyLoginPageTitle() {
		return driver.getTitle();

	}

}
