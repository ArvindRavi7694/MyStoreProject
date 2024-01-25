package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class HomePage extends BaseClass{

	@FindBy(xpath = "//a[normalize-space()='Men']")
	WebElement men;
	
	@FindBy(xpath = "//a[normalize-space()='Tshirts']")
	WebElement tShirt;
	
	@FindBy(xpath = "//a[normalize-space()='Women']")
	WebElement women;
	
	@FindBy(xpath = "//div[@id='Women']//a[normalize-space()='Dress']")
	WebElement dress;
	
	@FindBy(xpath = "//ul[@class='nav navbar-nav']/li[3]/a")
	WebElement cartBtn;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public OrderPage clickOnCart() {
		Action.click(driver, cartBtn);
		return new OrderPage();
	}
	
	public boolean validateT_Shirt() {
		Action.click(driver, men);
		return Action.isDisplayed(driver, tShirt);
	}
	
	public boolean validateDress() {
		Action.click(driver, women);
		return Action.isDisplayed(driver, dress);
	}
	
	public String getCurrentURL() {
		String homePageURL = driver.getCurrentUrl();
		return homePageURL;
	}
}
