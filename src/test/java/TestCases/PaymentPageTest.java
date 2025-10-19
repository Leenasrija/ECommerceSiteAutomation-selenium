package TestCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import BaseClass.BaseClass;
import PageObjects.AccountCreationPage;
import PageObjects.CheckoutPage;
import PageObjects.IndexPage;
import PageObjects.LoginPage;
import PageObjects.PaymentPage;
import PageObjects.ProductPage;
import PageObjects.*;


public class PaymentPageTest extends BaseClass{
	LoginPage loginpage;
	IndexPage indexpage;
	ProductPage productpage;
	AccountCreationPage accoutcreationpage;
	ViewCartPage viewcartpage;
	PaymentPage paymentpage;
	CheckoutPage checkoutpage;
	OrderPlacedPage orderplacedpage;
	@BeforeMethod(groups = {"Smoke", "Sanity", "Regression", "E2E"})
	@Parameters("browser")
	public void setUp(String browser) {
		launchBrowser(browser);
	}
	
	@AfterMethod(groups = {"Smoke", "Sanity", "Regression", "E2E"})
	public void TearDown() {
		getDriver().quit();
	}
	@Test(groups = "Regression")
	public void TillPlaceOrder() throws InterruptedException {
		indexpage = new IndexPage();
		SoftAssert assertt = new SoftAssert();
		if(indexpage.isProductDisplayed()) {
			productpage= indexpage.clickOnProduct();
			assertt.assertTrue(productpage.verifyIfProductDisplayed());
			if(productpage.clickAddtoCart()) {
				viewcartpage = productpage.clickViewCart();
				assertt.assertTrue(viewcartpage.shippingCartDisplayed());
				Thread.sleep(3000);
				loginpage = viewcartpage.clickonProceedtoCheckoutWithoutLogin();
				Thread.sleep(3000);
				indexpage = loginpage.Login(prop.getProperty("username"), prop.getProperty("password"));
				Thread.sleep(2000);
				viewcartpage = indexpage.clickOncart();
				Thread.sleep(3000);
				checkoutpage =viewcartpage.clickonProceedtoCheckoutWithLogin();
				assertt.assertTrue(checkoutpage.verifyCheckoutPageTitle());
				paymentpage= checkoutpage.clickplaceOrderButton();
				assertt.assertTrue(paymentpage.verifyPaymentTitle());
				orderplacedpage = paymentpage.addCardDetailstoSubmit("len", "123", "543", "09", "2027");
				assertt.assertTrue(orderplacedpage.orderConfirmation());
				try {
					Thread.sleep(4000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				assertt.assertAll();
			}
			else {
				System.out.println("Shipping cart page is not displayed");
			}
		}
		else {
			System.out.println("Productpage is not displayed");
			
		}
		
	}
}
