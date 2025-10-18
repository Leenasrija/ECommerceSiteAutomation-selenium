package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ActionDriver.Action;
import BaseClass.BaseClass;

public class AccountCreationPage extends BaseClass{
	public AccountCreationPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath= "//b[contains(text(),'Enter Account Information')]") WebElement formTitle;
	@FindBy(xpath= "//input[@id='id_gender1']") WebElement genderselection;
	@FindBy(xpath= "//input[@id='password']") WebElement password;
	@FindBy(xpath= "//select[@id='days']") WebElement date;
	@FindBy(xpath= "//select[@id='months']") WebElement months;
	@FindBy(xpath= "//select[@id='years']") WebElement years;
	
	public String validateAccountCreatePage() {
		if(Action.isDisplayed(formTitle)) {
			return Action.getText(formTitle);
		}
		return null;
	}
	
	public void enterAccountCreationdetails(String passWord, String day, String month, String year) {
		Action.click(driver, genderselection);
		Action.enterText(password, passWord);
		Action.selectDropdown(date, day);
		Action.selectDropdown(months, month);
		Action.selectDropdown(years, year);
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
	}
}
