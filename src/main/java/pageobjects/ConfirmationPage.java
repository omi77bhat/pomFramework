package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ConfirmationPage {
	
WebDriver driver;
	
	public ConfirmationPage(WebDriver driver) {
		
		this.driver = driver;
		
	}
	
	@FindBy(css = ".hero-primary")
	WebElement confirmationMessage;
	
	public String getConfirmationMessage()
	{
		
		return confirmationMessage.getText();
	}
	

}
