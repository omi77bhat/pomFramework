package testComponents;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Base {
	
public static WebDriver driver;
	
	
	public void launchApp() {
		
		driver = TestUtils.launchApplication(driver, "chrome", "https://rahulshettyacademy.com/client/");
	}
	
	public void exitApp() {
		TestUtils.tearDown(driver);
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
