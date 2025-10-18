package PageObjects;
import ActionDriver.Action;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseClass.BaseClass;

public class PaymentPage extends BaseClass {

	public PaymentPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath= "//input[@name=\"name_on_card\"]") WebElement cardName;
	@FindBy(xpath= "//input[@name=\"card_number\"]") WebElement cardNumber;
	@FindBy(xpath= "//input[@name=\"cvc\"]") WebElement cvc;
	@FindBy(xpath= "//input[@name=\"expiry_month\"]") WebElement expiryMonth;
	@FindBy(xpath= "//input[@name=\"expiry_year\"]") WebElement expiryYear;
	@FindBy(xpath= "//button[contains(text(),'Pay and Confirm Order')]") WebElement submitbtn;
	
	public OrderPlacedPage addCardDetailstoSubmit(String cardname, String cardnumber, String cv, String expirymonth, String expiryyear) {
		Action.enterText(cardName, cardname);
		Action.enterText(cardNumber, cardnumber);
		Action.enterText(cvc, cv);
		Action.enterText(expiryMonth, expirymonth);
		Action.enterText(expiryYear, expiryyear);
		Action.scrollintoView(driver, submitbtn);
		Action.JSClick(driver, submitbtn);
		return new OrderPlacedPage();
	}
	
	@FindBy(xpath="//li[contains(text(),'Payment')]") WebElement paymentpagetitle;
	public boolean verifyPaymentTitle() {
		return Action.isDisplayed(paymentpagetitle);
	}
	
	
	
	
}
