package TestCases;

import org.testng.Assert;
import org.testng.annotations.*;

import BaseClass.BaseClass;
import DataProvider.DataProviders;
import PageObjects.AccountCreationPage;
import PageObjects.IndexPage;
import PageObjects.LoginPage;
import Utilities.Log;

public class LoginPageTest extends BaseClass{
	LoginPage loginpage;
	IndexPage indexpage;
	AccountCreationPage accoutcreationpage;
	@BeforeMethod(groups = {"Smoke", "Sanity", "Regression", "E2E"})
	@Parameters("browser")
	public void setUp(String browser) {
		launchBrowser(browser);
	}
	
	@AfterMethod(groups = {"Smoke", "Sanity", "Regression", "E2E"})
	public void TearDown() {
		getDriver().quit();
	}
	
	@Test(dataProvider ="credentials", dataProviderClass= DataProviders.class, groups = "Sanity")
	//@DataProvider(name = "credentials")
	public void LoginTest(String username, String password) {
		Log.startTestCase("LoginTest");
		indexpage = new IndexPage();

		Log.info("User is going to click on SignIn");
		loginpage = indexpage.clickOnSignIn();

		Log.info("Entering login details");
	//	indexpage = loginpage.Login(prop.getProperty("username"), prop.getProperty("password"));
		indexpage = loginpage.Login(username, password);
		String actualval = indexpage.isLoggedUserNameDisplayed();

		Log.info("verifying is user is logged in");
		Assert.assertEquals(actualval, prop.getProperty("signupname"));

		Log.info("Login Success");
		Log.endTestCase("Ended login test");
	
	}
}
