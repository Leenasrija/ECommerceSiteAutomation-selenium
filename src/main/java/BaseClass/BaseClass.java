package BaseClass;

import org.testng.annotations.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import ActionDriver.Action;

public class BaseClass{

	public static Properties prop;
	public static WebDriver driver;
	
	@BeforeTest
	public void loadConfigs() throws IOException {
		FileInputStream fs = new FileInputStream(System.getProperty("user.dir") + "\\Configuration\\config.properties");
		prop = new Properties();
		prop.load(fs);		
	}
	
	public void launchBrowser() {
		String browserName = prop.getProperty("browser");
		switch(browserName) {
		case "Chrome" : {
			driver = new ChromeDriver();
			break;
		}
		case "Edge" : {
			driver = new EdgeDriver();
			break;
		}
		case "Firefox" : {
			driver = new FirefoxDriver();
			break;
		}
		default:
			System.out.println("Invalid browser name");
			break;	
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		//
		Action.implicitWait(driver, 30);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(120));

		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(prop.getProperty("implicitWait"))));
		driver.get(prop.getProperty("url"));
	}
}
