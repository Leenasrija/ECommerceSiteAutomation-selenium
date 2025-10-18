package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ActionDriver.Action;
import BaseClass.BaseClass;

public class AddtoCartPage extends BaseClass
{
	public AddtoCartPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//button[@class='btn btn-default cart']") WebElement addtoCartbtn;
	@FindBy(xpath="//input[@id='quantity']") WebElement quantity;
	@FindBy(xpath="//*[@id=\"cartModal\"]//a") WebElement clickPopup;
	@FindBy(xpath="//*[@id=\"checkoutModal\"]//div[2]/p[2]/a") WebElement login;
	
	public void selectQuantity(String quantityno) {
		Action.enterText(quantity, quantityno);
	}
	
	public ViewCartPage addProductToCart() {
		Action.click(driver, addtoCartbtn);
		if(Action.isDisplayed(clickPopup)) {
			Action.JSClick(driver, addtoCartbtn);
		}
		return new ViewCartPage();
	}
	
	public LoginPage registerorLogin() {
		Action.JSClick(driver, login);
		return new LoginPage();
	}
	
}
