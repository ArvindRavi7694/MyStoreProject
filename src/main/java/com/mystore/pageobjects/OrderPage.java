package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class OrderPage extends BaseClass {
	
	@FindBy(xpath = "//td[@class='cart_price']")
	WebElement unitPrice;
	
	@FindBy(xpath = "//p[@class='cart_total_price']")
	WebElement totalPrice;
	
	@FindBy(xpath = "//a[normalize-space()='Proceed To Checkout']")
	WebElement proceedToCheckoutBtn;
	
	@FindBy(xpath = "//u[normalize-space()='Register / Login']")
	WebElement reLoginBtn;
	
	public OrderPage() {
		PageFactory.initElements(driver, this);
	}
	
	public Double getUnitPrice() {
		String unitPrice1 = unitPrice.getText();
		String unit = unitPrice1.replaceAll("[^a-zA-Z0-9]", "");
		Double finalUnitPrice = Double.parseDouble(unit);
		return finalUnitPrice;
	}
	
	public Double getTotalPrice() {
		String totalPrice1 = totalPrice.getText();
		String total = totalPrice1.replaceAll("[^a-zA-Z0-9]", "");
		Double finaltotalPrice = Double.parseDouble(total);
		return finaltotalPrice;
	}
	
	public LoginPage clickOnCheckOut() {
		Action.click(driver, proceedToCheckoutBtn);
		Action.JSClick(driver, reLoginBtn);
		return new LoginPage();
	}
	
	public AddressPage clickOnCheckOut1() {
		Action.JSClick(driver, proceedToCheckoutBtn);
		return new AddressPage();
	}
}
