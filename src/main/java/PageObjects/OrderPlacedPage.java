package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ActionDriver.Action;
import BaseClass.BaseClass;

public class OrderPlacedPage extends BaseClass{

	public OrderPlacedPage() {
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//b[contains(text(),'Order Placed!')]") WebElement orderplaced;
	
	public boolean orderConfirmation() {
		return Action.isDisplayed(orderplaced);
	}
	@FindBy(xpath= "//a[contains(text(),'Continue')]") WebElement continuebtn;
	
	public IndexPage clickOnContinue() {
		Action.JSClick(driver, continuebtn);
		return new IndexPage();
	}
}
