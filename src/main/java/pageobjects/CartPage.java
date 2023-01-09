package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import testComponents.Base;

public class CartPage extends Base{
	
	
	public CartPage() {
		
		PageFactory.initElements(driver, this);
		
	}
	
	
	@FindBy(xpath="//button[@routerlink='/dashboard/cart']")
	WebElement cartHeaderButton;
	
	@FindBy(css=".cartSection h3")
	List<WebElement> cartProductList;
	
	@FindBy(css=".totalRow button")
	WebElement checkoutButton;
	
	@FindBy(xpath="//h1")
	WebElement myCartPageText;
	
	
	public void verifyProductAddedToCart(String productName) throws InterruptedException 
	{
		
		Thread.sleep(5000);
		
		cartHeaderButton.click();
		
		List<WebElement> cartProducts = cartProductList;
		
		for(WebElement e : cartProducts) 
		{
			
			if(e.getText().equalsIgnoreCase(productName)) 
				
			{
				System.out.println("product names in cart : " + e.getText());
				
				String actualProductName = e.getText();
				
				Assert.assertTrue(actualProductName.equalsIgnoreCase(productName));
				
			}
			
		}
		
		checkoutButton.click();
		
	}

}
