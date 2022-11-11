package com.onlinestore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.onlinestore.base.BaseClass;
import com.onlinestore.pages.AddToCartPage;
import com.onlinestore.pages.HomePage;
import com.onlinestore.pages.IndexPage;
import com.onlinestore.pages.LoginPage;
import com.onlinestore.pages.SearchResultPage;
import com.onlinestore.pages.ShoppingCartPage;
import com.onlinestore.utility.Log;

public class ShoppingCartPageTest extends BaseClass{
	private IndexPage indexPage;
	private SearchResultPage srearchResultPage;
	private HomePage homePage;
	private LoginPage loginPage;
	private AddToCartPage addToCartPage;
	private ShoppingCartPage shoppingCartPage;
	
	@Test(groups = "Regression")
	public void verifyTotalPrice() throws InterruptedException {
		Log.startTestCase("verifyTotalPrice");
		indexPage = new IndexPage();
		loginPage = indexPage.clickOnSignIn();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		srearchResultPage = homePage.searchProduct("T shirt");
		addToCartPage = srearchResultPage.clickOnProduct();
		addToCartPage.selectSize();
		addToCartPage.selectColor();
		addToCartPage.enterQuantity(prop.getProperty("qty"));
		addToCartPage.clickOnAddToCart();
		shoppingCartPage = addToCartPage.clickOnShoppingCartMessage();
		double totalUnitsPrice = shoppingCartPage.getTotalUintsPrice();
		double totalPrice = shoppingCartPage.getTotalPrice();
		Log.info("totalUnitsPrice  = " + totalUnitsPrice);
		Log.info("totalPrice  = " + totalPrice);
		Assert.assertEquals(totalPrice, totalUnitsPrice);
		Log.info("Verify Total Price Test is success");
	    Log.endTestCase("verifyTotalPrice");
	}
}
