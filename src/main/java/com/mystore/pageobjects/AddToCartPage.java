package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class AddToCartPage extends BaseClass{

	@FindBy(id = "quantity")
	WebElement quantity;
	
	@FindBy(xpath = "//button[@class='btn btn-default cart']")
	WebElement addToCartBtn;
	
	@FindBy(xpath = "//h4[normalize-space()='Added!']")
	WebElement addToCartMsg;
	
	@FindBy(xpath = "//u[normalize-space()='View Cart']")
	WebElement viewCart;
	
	public AddToCartPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void enterQuantity(String noOfQuantity) {
		Action.type(quantity, noOfQuantity);
	}
	
	public void clickOnAddToCartBtn() {
		Action.click(driver, addToCartBtn);
	}
	
	public boolean validateAddedToCart() {
//		Action.fluentWait(driver, addToCartMsg, 10); 
		return Action.isDisplayed(driver, addToCartMsg);
	}
	
	public OrderPage clickOnViewCart() {
		Action.fluentWait(driver, viewCart, 10);
		Action.click(driver, viewCart);
		return new OrderPage();
	}
}
