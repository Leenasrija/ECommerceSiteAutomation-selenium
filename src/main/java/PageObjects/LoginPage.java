package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ActionDriver.Action;
import BaseClass.BaseClass;

public class LoginPage extends BaseClass{
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@data-qa='login-password']") WebElement password;
	@FindBy(xpath="//input[@data-qa='login-email']") WebElement email;
	@FindBy(xpath="//button[@data-qa='login-button']") WebElement loginBtn;
	
	@FindBy(xpath="//*[@id=\"form\"]//div[3]//input[3]") WebElement signupEmail;
	@FindBy(xpath="//*[@id=\"form\"]//div[3]//input[2]") WebElement name;
	@FindBy(xpath="//button[contains(text(),\"Signup\")]") WebElement createAccBtn;
	
	public IndexPage Login(String userName, String passWord) {
		Action.enterText(email, userName);
		Action.enterText(password, passWord);
		Action.click(driver, loginBtn);
		return new IndexPage();
	}
	
	public AccountCreationPage CreateAccount(String userName, String email) {
		Action.enterText(name, userName);
		Action.enterText(signupEmail, email);
		Action.click(driver, createAccBtn);
		return new AccountCreationPage();
	}
}
