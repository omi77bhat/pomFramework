package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		
		this.driver = driver;
		
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
	
	public void verifyPageTitle() {
		
		
	}

}
