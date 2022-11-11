package com.onlinestore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.onlinestore.base.BaseClass;
import com.onlinestore.dataprovider.DataProviders;
import com.onlinestore.pages.HomePage;
import com.onlinestore.pages.IndexPage;
import com.onlinestore.pages.LoginPage;
import com.onlinestore.pages.SearchResultPage;

public class SearchResultPageTest extends BaseClass{
	private IndexPage indexPage;
	private LoginPage loginPage ;
	private HomePage homePage;
	private SearchResultPage srearchResultPage;
	
	@Test(dataProvider = "searchProduct" , dataProviderClass = DataProviders.class ,groups = "Smoke")
	public void productAvailabilityTest(String productName) throws InterruptedException {
		indexPage = new IndexPage();
		loginPage = indexPage.clickOnSignIn();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		srearchResultPage = homePage.searchProduct(productName);
		Assert.assertTrue(srearchResultPage.isProductAvailable());
	}
}
