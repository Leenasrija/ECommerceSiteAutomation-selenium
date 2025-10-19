package BaseClass;

import org.testng.annotations.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import ActionDriver.Action;
import Utilities.ExtentManager;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass{

	public static Properties prop;
	//public static WebDriver driver;
	public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
	
	@BeforeSuite(groups = {"Smoke", "Sanity", "Regression", "E2E"})
	public void LoadConfigs() throws IOException {
		ExtentManager.setExtent();
		DOMConfigurator.configure("log4j.xml");
		FileInputStream fs = new FileInputStream(System.getProperty("user.dir") + "\\Configuration\\config.properties");
		prop = new Properties();
		prop.load(fs);	
	}
	
	public static WebDriver getDriver() {
		return driver.get();
	}
	public void launchBrowser(String browserName) {
		//String browserName = prop.getProperty("browser");
		switch(browserName) {
		case "Chrome" : {
			WebDriverManager.chromedriver().setup();
			driver.set(new ChromeDriver());
			break;
		}
		case "Edge" : {
			WebDriverManager.edgedriver().setup();
			driver.set(new EdgeDriver());
			//System.setProperty("webdriver.edge.driver", "C:\\Drivers\\msedgedriver.exe");
			//driver.set(new EdgeDriver());
			break;
		}
		case "Firefox" : {
			WebDriverManager.firefoxdriver().setup();
			driver.set(new FirefoxDriver());
			break;
		}
		default:
			System.out.println("Invalid browser name");
			break;	
		}
		
		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		//
		Action.implicitWait(getDriver(), 30);
		getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(120));

		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(prop.getProperty("implicitWait"))));
		getDriver().get(prop.getProperty("url"));
	}
	@AfterSuite
	public void extentmangerEndReport() {
		ExtentManager.endReport();
	}
}
