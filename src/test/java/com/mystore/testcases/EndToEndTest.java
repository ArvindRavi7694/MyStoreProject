/**
 * 
 */
package com.mystore.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.AddressPage;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.pageobjects.OrderConfirmationPage;
import com.mystore.pageobjects.OrderPage;
import com.mystore.pageobjects.PaymentPage;
import com.mystore.pageobjects.SearchResultPage;

/**
 * @author arvind
 *
 */
public class EndToEndTest extends BaseClass{
	IndexPage indexPage;
	SearchResultPage searchResultPage;
	AddToCartPage addToCartPage;
	OrderPage orderPage;
	LoginPage loginPage;
	HomePage homePage;
	AddressPage addressPage;
	PaymentPage paymentPage;
	OrderConfirmationPage orderConfirmationPage;
	
	@BeforeMethod
	public void setup() {
		launchApp();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void endToEndTest() {
		indexPage = new IndexPage();
		searchResultPage = indexPage.searchProduct("t-shirt");
		addToCartPage = searchResultPage.clickOnProduct();
		addToCartPage.enterQuantity("2");
		addToCartPage.clickOnAddToCartBtn();
		orderPage = addToCartPage.clickOnViewCart();
		loginPage = orderPage.clickOnCheckOut();
		homePage = loginPage.login("admin0123@gmail.com", "admin0123");
		orderPage = homePage.clickOnCart();
		addressPage = orderPage.clickOnCheckOut1();
		paymentPage = addressPage.clickOnPlaceOrder();
		orderConfirmationPage = paymentPage.clickOnPlaceOrder("admin", "7410852963", "842", "12", "2024");
		orderConfirmationPage.verifyOrderSuccess();
	}
}
