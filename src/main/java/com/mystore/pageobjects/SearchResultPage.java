package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class SearchResultPage extends BaseClass {

	@FindBy(xpath = "//div[@class='features_items']/div[3]//div[@class='productinfo text-center']")
	WebElement productResult;
	
	@FindBy(xpath = "//div[@class='features_items']/div[3]//div[@class='choose']")
	WebElement viewProduct;
	
	public SearchResultPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean isProductAvaliable() {
		return Action.isDisplayed(driver, productResult);
	}
	
	public AddToCartPage clickOnProduct() {
		driver.navigate().refresh();
		Action.click(driver, viewProduct);
		return new AddToCartPage();
	}
}
