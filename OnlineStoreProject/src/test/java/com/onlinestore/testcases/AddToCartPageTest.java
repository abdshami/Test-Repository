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

public class AddToCartPageTest extends BaseClass{
	private IndexPage indexPage;
	private LoginPage loginPage;
	private HomePage homePage;
	private SearchResultPage srearchResultPage;
	private AddToCartPage addToCartPage;
	
	@Test(groups = {"Regression","Sanity"})
	public void addToCartTest() throws InterruptedException {
		indexPage = new IndexPage();
		loginPage = indexPage.clickOnSignIn();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		srearchResultPage = homePage.searchProduct("T shirt");
		addToCartPage = srearchResultPage.clickOnProduct();
		addToCartPage.selectSize();
		addToCartPage.selectColor();
		addToCartPage.enterQuantity(prop.getProperty("qty"));
		addToCartPage.clickOnAddToCart();
		Assert.assertTrue(addToCartPage.validateAddToCartMessage());
	}
}
