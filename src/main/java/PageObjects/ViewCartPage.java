package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ActionDriver.Action;
import BaseClass.BaseClass;

public class ViewCartPage extends BaseClass{
	
	public ViewCartPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(xpath= "//*[@id=\"do_action\"]/div[1]//a") WebElement checkoutbtn;
	@FindBy(xpath= "//*[@id=\"checkoutModal\"]//div[2]/p[2]/a") WebElement RegisterorLogin;
	@FindBy(xpath= "//*[@id=\"cart_items\"]///div[7]/a") WebElement Placeorderbtn;
	
	
	public LoginPage clickCheckout() {
		Action.isDisplayed(checkoutbtn);
		Action.click(getDriver(), checkoutbtn);
		Action.JSClick(getDriver(), RegisterorLogin);
		return new LoginPage();
	}
	
	public PaymentPage clickOnPlaceOrder() {
		Action.scrollintoView(getDriver(), Placeorderbtn);
		Action.JSClick(getDriver(), Placeorderbtn);
		return new PaymentPage();
	}
	@FindBy(xpath= "//li[contains(text(),'Shopping Cart')]") WebElement shoppingcart;
	public boolean shippingCartDisplayed() {
		return Action.isDisplayed(shoppingcart);
	}
	
	@FindBy(xpath= "//a[contains(text(), \"Proceed To Checkout\")]") WebElement proceedtoCheckout;
	
	public CheckoutPage clickonProceedtoCheckoutWithLogin() {
		 Action.isDisplayed(proceedtoCheckout);
		 Action.JSClick(getDriver(), proceedtoCheckout);
		 return new CheckoutPage();
	}
	
	@FindBy(xpath= "//p[contains(text(),'Register / Login account to proceed on checkout.')]") WebElement reuqestLogin;
	@FindBy(xpath= "//u[contains(text(),'Register / Login')]") WebElement loginregisterlink;
	
	public LoginPage clickonProceedtoCheckoutWithoutLogin() {
		 Action.isDisplayed(proceedtoCheckout);
		 Action.JSClick(getDriver(), proceedtoCheckout);
		 if(Action.isDisplayed(reuqestLogin)) {
			 Action.JSClick(getDriver(), loginregisterlink);
			 return new LoginPage();
		 }
		 else {
			 System.out.println("didn't notify user to login/register as he/she as not logged in");
			 return null;
		 }
	}
	
	
	
	
	
	
	
}
