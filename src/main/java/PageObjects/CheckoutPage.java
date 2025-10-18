package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ActionDriver.Action;
import BaseClass.BaseClass;

public class CheckoutPage extends BaseClass{

	public CheckoutPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//li[contains(text(),'Checkout')]") WebElement checkoutpageTitle;
	public boolean verifyCheckoutPageTitle() {
		return Action.isDisplayed(checkoutpageTitle);
	}
	
	@FindBy(xpath="//a[contains(text(),'Place Order')]") WebElement placeOrderButton;
	
	public PaymentPage clickplaceOrderButton() {
		Action.scrollintoView(driver, placeOrderButton);
		Action.click(driver, placeOrderButton);
		return new PaymentPage();
	}
	
}
