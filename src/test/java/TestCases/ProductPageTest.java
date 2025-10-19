package TestCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.*;

import BaseClass.BaseClass;
import PageObjects.AccountCreationPage;
import PageObjects.IndexPage;
import PageObjects.*;

public class ProductPageTest extends BaseClass{
	LoginPage loginpage;
	IndexPage indexpage;
	ProductPage productpage;
	AccountCreationPage accoutcreationpage;
	ViewCartPage viewcartpage;
	@BeforeMethod(groups = {"Smoke", "Sanity", "Regression", "E2E"})
	@Parameters("browser")
	public void setUp(String browser) {
		launchBrowser(browser);
	}
	
	@AfterMethod(groups = {"Smoke", "Sanity", "Regression", "E2E"})
	public void TearDown() {
		getDriver().quit();
	}
	@Test(groups = "Smoke")
	public void validateProduct() {
		indexpage = new IndexPage();
		if(indexpage.isProductDisplayed()) {
			productpage= indexpage.clickOnProduct();
			Assert.assertTrue(productpage.verifyIfProductDisplayed());
			if(productpage.clickAddtoCart()) {
			 viewcartpage=	productpage.clickViewCart();
			 Assert.assertTrue(viewcartpage.shippingCartDisplayed());
				
			}
		}
		
		else {
			System.out.println("Element is not found");
			Assert.assertTrue(false);
			
		}
	}
}
