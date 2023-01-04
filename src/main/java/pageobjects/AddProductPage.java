package pageobjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AddProductPage {
	
	
WebDriver driver;
	
	public AddProductPage(WebDriver driver) {
		
		this.driver = driver;
		
	}
	
	
	@FindBy(css=".mb-3")
	List<WebElement> productList;
	

	By addToCart = By.cssSelector(".card-body button:last-of-type");
	By toastMessage = By.cssSelector("#toast-container");

	
	
	
	public void addProductToCart(String productName, String successmessage) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		
		List<WebElement> products = productList;
		
		for(WebElement e : products) 
		{
			
			if(e.findElement(By.cssSelector("b")).getText().equalsIgnoreCase(productName)) 
				
			{
				System.out.println("product names : " + e.findElement(By.cssSelector("b")).getText());
				
				e.findElement(addToCart).click();
				
			}
			
		}
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		
		String message = driver.findElement(toastMessage).getText();
		
		Assert.assertEquals(message, successmessage);
		
	}


}
