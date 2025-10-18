package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ActionDriver.Action;
import BaseClass.BaseClass;

public class IndexPage extends BaseClass{

	@FindBy(xpath="//a[@href='/login']") WebElement loginbtn;
	@FindBy(xpath="//img[@alt='Website for automation practice']") WebElement logo;
	
	
	public IndexPage() {
		PageFactory.initElements(driver, this);
	}
	
	public LoginPage clickOnSignIn() {
		Action.click(driver, loginbtn);
		return new LoginPage();
	}
	
	public boolean isLogoDisplayed() {
		return Action.isDisplayed(logo);	
	}
	
	public String getDtoreTitle() {
		return Action.getTitle(driver);
	}
	@FindBy(xpath="//*[@id=\"header\"]//b") WebElement loggedinName;
	@FindBy(xpath="//a[@href='/product_details/1']") WebElement productLink;
	
	public String isLoggedUserNameDisplayed() {
		Action.isDisplayed(loggedinName);
		return Action.getText(loggedinName);
	}
	
	public boolean isProductDisplayed() {
		return Action.scrollintoView(driver, productLink);
	}
	
	public ProductPage clickOnProduct() {
		if(Action.scrollintoView(driver, productLink)) {
			Action.click(driver, productLink);
			return new ProductPage();
		}
		else {
			System.out.println("Product could not be clicked");
			return null;
		}
	}
	
	@FindBy(xpath="//a[contains(text(), ' Cart')]") WebElement cartButton;
	public ViewCartPage clickOncart() {
		Action.click(driver, cartButton);
		return new ViewCartPage();
		
	}
}
