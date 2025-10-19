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
	@BeforeMethod(groups = {"Smoke", "Sanity", "Regression", "E2E"})
	@Parameters("browser")
	public void setUp(String browser) {
		launchBrowser(browser);
	}
	@AfterMethod(groups = {"Smoke", "Sanity", "Regression", "E2E"})
	public void TearDown() {
		getDriver().quit();
	}
	
	@Test(groups = {"Regression", "Sanity"})
	public void myStoreLogo(){
		index = new IndexPage();
		Assert.assertTrue(index.isLogoDisplayed());
	}
	
	@Test(groups = {"Regression", "Sanity"})
	public void verifyTitle() {
		Assert.assertEquals(index.getDtoreTitle(), "Automation Exercise");
	}
	

}
