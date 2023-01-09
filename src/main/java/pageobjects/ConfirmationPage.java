package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testComponents.Base;


public class ConfirmationPage extends Base{
	
	
	public ConfirmationPage() {
		
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css = ".hero-primary")
	WebElement confirmationMessage;
	
	
	public String getConfirmationMessage(){
		
		return confirmationMessage.getText();
	}
	

}
