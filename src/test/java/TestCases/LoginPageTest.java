package TestCases;

import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.BeforeMethod;

import BaseClass.BaseClass;
import PageObjects.AccountCreationPage;
import PageObjects.IndexPage;
import PageObjects.LoginPage;

public class LoginPageTest extends BaseClass{
	LoginPage loginpage;
	IndexPage indexpage;
	AccountCreationPage accoutcreationpage;
	@BeforeMethod
	public void setUp() {
		launchBrowser();
	}
	
	@AfterMethod
	public void TearDown() {
		driver.quit();
	}
	
	//@Test
	public void LoginTest() {
		indexpage = new IndexPage();
		loginpage = indexpage.clickOnSignIn();
		indexpage = loginpage.Login(prop.getProperty("username"), prop.getProperty("password"));
		String actualval = indexpage.isLoggedUserNameDisplayed();
		Assert.assertEquals(actualval, prop.getProperty("signupname"));
	
	}
}
