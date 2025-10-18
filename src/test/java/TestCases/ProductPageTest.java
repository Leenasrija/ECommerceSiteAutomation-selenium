package TestCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.BeforeMethod;

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
	@BeforeMethod
	public void setUp() {
		launchBrowser();
	}
	
	@AfterMethod
	public void TearDown() {
		driver.quit();
	}
	@Test
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
