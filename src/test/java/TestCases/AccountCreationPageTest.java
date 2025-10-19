package TestCases;

import org.testng.Assert;
import org.testng.annotations.*;

import BaseClass.BaseClass;
import PageObjects.IndexPage;
import PageObjects.*;

public class AccountCreationPageTest extends BaseClass{
	LoginPage loginpage;
	IndexPage indexpage;
	AccountCreationPage accoutcreationpage;
	@BeforeMethod(groups = {"Smoke", "Sanity", "Regression", "E2E"})
	@Parameters("browser")
	public void setUp(String browser) {
		launchBrowser(browser);
	}
	
	@AfterMethod(groups = {"Smoke", "Sanity", "Regression", "E2E"})
	public void tearDown() {
		getDriver().quit();
	}
	
	//@Test
	public void verifyIfAccoutsPageisDiaplayed() {
		indexpage = new IndexPage();
		loginpage = indexpage.clickOnSignIn();
		accoutcreationpage = loginpage.CreateAccount(prop.getProperty("signupname"), prop.getProperty("signupmail"));
		Assert.assertEquals(accoutcreationpage.validateAccountCreatePage(), "ENTER ACCOUNT INFORMATION");
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test(groups = "Sanity")
	public void enterAccountcreationDetails() {
		indexpage = new IndexPage();
		loginpage = indexpage.clickOnSignIn();
		accoutcreationpage = loginpage.CreateAccount(prop.getProperty("signupname"), prop.getProperty("signupmail"));
		Assert.assertEquals(accoutcreationpage.validateAccountCreatePage(), "ENTER ACCOUNT INFORMATION");
		
		accoutcreationpage.enterAccountCreationdetails(prop.getProperty("password"), prop.getProperty("day"), prop.getProperty("month"), prop.getProperty("year"));
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
