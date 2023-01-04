package testComponents;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static WebDriver driver;
	
	
	@BeforeClass
	public void launchApp() {
		
		driver = Utils.launchApplication(driver, "chrome", "https://rahulshettyacademy.com/client/");
	}
	
	@AfterClass
	public void exitApp() {
		Utils.tearDown(driver);
	}
	
	public void takeScreenShot(String testMethodName){
	   	 File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);   
	   	 
	   	 try {
					FileUtils.copyFile(scrFile, new File("/Users/spare/Documents/My Automation Workspace/pomtest/screenshots/"
							 + testMethodName + "_" + ".png"));
				} catch (IOException e) {
					e.printStackTrace();
				}

	   	 
	   }
		
}
