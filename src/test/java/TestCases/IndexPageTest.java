package TestCases;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.*;

import ActionDriver.Action;
import BaseClass.BaseClass;
import PageObjects.*;
import PageObjects.IndexPage;

public class IndexPageTest extends BaseClass{
	IndexPage index;
	ProductPage product;
	@BeforeMethod
	public void setUp() {
		launchBrowser();
	}
	
	@AfterMethod
	public void TearDown() {
		driver.quit();
	}
	
	@Test
	public void myStoreLogo(){
		index = new IndexPage();
		Assert.assertTrue(index.isLogoDisplayed());
	}
	
	@Test
	public void verifyTitle() {
		Assert.assertEquals(index.getDtoreTitle(), "Automation Exercise");
	}
	

}
