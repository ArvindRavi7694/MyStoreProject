package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class OrderConfirmationPage extends BaseClass {

	@FindBy(xpath = "//h2[@class='title text-center']")
	WebElement orderConfirmation;
	
	@FindBy(xpath = "//a[@class='btn btn-default check_out']")
	WebElement dwnldInvoice;
	
	@FindBy(xpath = "//a[@class='btn btn-primary']")
	WebElement continueBtn;
	
	public OrderConfirmationPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyOrderSuccess() {
		String confirmmsg = orderConfirmation.getText();
		return confirmmsg;
	}
	
	public HomePage continueShopping() {
		Action.click(driver, dwnldInvoice);
		Action.click(driver, continueBtn);
		return new HomePage();
	}
}
