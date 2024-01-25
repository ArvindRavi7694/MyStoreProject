package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class IndexPage extends BaseClass {

	@FindBy(xpath = "//i[@class='fa fa-lock']")
	WebElement signInBtn;
	
	@FindBy(xpath = "//div[@class='logo pull-left']")
	WebElement myStoreLogo;
	
	@FindBy(xpath = "//i[@class='material-icons card_travel']")
	WebElement productsPg;
	
	@FindBy(id = "search_product")
	WebElement searchProductBox;
	
	@FindBy(id = "submit_search")
	WebElement searchButton;
	
	public IndexPage() {
		PageFactory.initElements(driver, this);
	}
	
	public LoginPage clickOnSignIn() {
		Action.click(driver, signInBtn);
		return new LoginPage();
	}
	
	public boolean validateLogo() {
		return Action.isDisplayed(driver, myStoreLogo);
	}

	public String getMyStoreTitle() {
		return driver.getTitle();
	}
	
	public SearchResultPage searchProduct(String productName) {
		Action.click(driver, productsPg);
		driver.navigate().refresh();
		Action.click(driver, productsPg);
		Action.type(searchProductBox, productName);
		Action.click(driver, searchButton);
		return new SearchResultPage();
	}
		
}
