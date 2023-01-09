package testComponents;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestUtils extends Base {

	public static WebDriver launchApplication(WebDriver driver, String browserName, String url) {
		
		if (browserName.contains("chrome")) {
			 WebDriverManager.chromedriver().setup();
			   driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.chromedriver().setup();
			 driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.chromedriver().setup();
			 driver = new EdgeDriver();
		}else if (browserName.equalsIgnoreCase("safari")) {
			WebDriverManager.chromedriver().setup();
			 driver = new SafariDriver();
		}
		
		driver.get(url);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;

	}
	
//	@AfterMethod(alwaysRun=true)
	
	@AfterMethod
	public static void tearDown(WebDriver driver)
	{
		driver.quit();
	}



}
