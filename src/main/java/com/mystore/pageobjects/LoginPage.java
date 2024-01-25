package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class LoginPage extends BaseClass{

	@FindBy(name = "name")
	WebElement userName;
	
	@FindBy(xpath = "//div[@class='signup-form']//input[@name='email']")
	WebElement emailForNewAccount;
	
	@FindBy(xpath = "//button[normalize-space()='Signup']")
	WebElement signUpBtn;
	
	@FindBy(xpath = "//div[@class='login-form']//input[@name='email']")
	WebElement emailForLogin;
	
	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(xpath = "//button[normalize-space()='Login']")
	WebElement loginBtn;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public HomePage login(String email, String pswd) {
		Action.type(emailForLogin, email);
		Action.type(password, pswd);
		Action.click(driver, loginBtn);
		return new HomePage();
	}
	
	public AccountCreationPage createNewAccount(String uName, String mailID) {
		Action.type(userName, uName);
		Action.type(emailForNewAccount, mailID);
		Action.click(driver, signUpBtn);
		return new AccountCreationPage();
	}
}
