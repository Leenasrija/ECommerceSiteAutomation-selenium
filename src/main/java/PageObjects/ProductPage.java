package PageObjects;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import ActionDriver.Action;
import BaseClass.BaseClass;

public class ProductPage extends BaseClass{
	
	@FindBy(xpath= "//h2[contains(text(), \"Blue Top\")]") WebElement bluetop;

	public ProductPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public boolean verifyIfProductDisplayed() {
		return Action.isDisplayed(bluetop);
	}
	
	@FindBy(xpath= "//button[normalize-space()='Add to cart']") WebElement addtoCartbtn;
	@FindBy(xpath= "//h4[normalize-space()='Added!']") WebElement productAdded;
	@FindBy(xpath= "//u[contains(text(),'View Cart')]") WebElement clicktoViewCart;

	public boolean clickAddtoCart() {
		Action.JSClick(getDriver(), addtoCartbtn);
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Action.isDisplayed(productAdded);
	}
	public ViewCartPage clickViewCart() {
		Action.JSClick(getDriver(), clicktoViewCart);
		return new ViewCartPage();
	}
}
