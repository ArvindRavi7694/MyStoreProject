package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class AddressPage extends BaseClass {

	@FindBy(xpath = "//a[@class='btn btn-default check_out']")
	WebElement placeOrderBtn;
	
	public AddressPage() {
		PageFactory.initElements(driver, this);
	}
	
	public PaymentPage clickOnPlaceOrder() {
		Action.click(driver, placeOrderBtn);
		return new PaymentPage();
	}
}
