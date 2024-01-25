package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class PaymentPage extends BaseClass{

	@FindBy(name = "name_on_card")
	WebElement nameOnCard;
	
	@FindBy(name = "card_number")
	WebElement cardNumber;
	
	@FindBy(name = "cvc")
	WebElement cvc;
	
	@FindBy(name = "expiry_month")
	WebElement expirationMonth;
	
	@FindBy(name = "expiry_year")
	WebElement expirationYear;
	
	@FindBy(id = "submit")
	WebElement placeOrder;
	
	public PaymentPage() {
		PageFactory.initElements(driver, this);
	}
	
	public OrderConfirmationPage clickOnPlaceOrder(String name, String number, String cvcNumber, String expMonth, String expYear) {
		Action.type(nameOnCard, name);
		Action.type(cardNumber, number);
		Action.type(cvc, cvcNumber);
		Action.type(expirationMonth, expMonth);
		Action.type(expirationYear, expYear);
		Action.click(driver, placeOrder);
		return new OrderConfirmationPage();
	}
}
