package ActionDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import BaseClass.BaseClass;

public class Action extends BaseClass{

	public static void implicitWait(WebDriver driver, int timeOut) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeOut));
	}
	public static void explicitWait(WebDriver driver, WebElement element, int timeOut ) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public static void click(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).click().build().perform();
	}
	
	public static boolean isDisplayed(WebElement element) {
		
		boolean ele  = false;
		ele = element.isDisplayed();
		if(ele) {
			System.out.println("Element is displayed");
		}
		else {
			System.out.println("Element is not displayed");
		}
		return ele;
	}
	public static String getTitle(WebDriver driver) {
		return driver.getTitle();
	}
	
	public static String getText(WebElement element) {
		return element.getText();
	}
	
	public static void enterText(WebElement ele, String text) {
		ele.sendKeys(text);
	}
	
	public static boolean scrollintoView(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
		return element.isDisplayed();
	}
	
	public static boolean JSClick(WebDriver driver, WebElement element) {
		boolean flag = false;
		try{
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click()", element);
			flag= true;
		}
		catch(Exception e) {
			throw e;
		}
		return flag;
	}
	
	public static void selectDropdown(WebElement element, String
			name) {
		Select sel= new Select(element);
		sel.selectByVisibleText(name);
	}
}
