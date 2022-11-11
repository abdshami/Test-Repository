package com.onlinestore.testcases;


import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.onlinestore.dataprovider.DataProviders;
import com.onlinestore.base.BaseClass;
import com.onlinestore.pages.HomePage;
import com.onlinestore.pages.IndexPage;
import com.onlinestore.pages.LoginPage;

public class LoginPageTest extends BaseClass{
	private IndexPage indexPage;
	private LoginPage loginPage ;
	private HomePage homePage ;
	
	@Test(dataProvider = "credentials" , dataProviderClass = DataProviders.class , groups = {"Smoke","Sanity"})
	public void loginTest(String userName , String Password) throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		indexPage= new IndexPage();
		loginPage = indexPage.clickOnSignIn();
		homePage = loginPage.login(userName , Password);
		boolean result = homePage.validateUserLoggedIn();
		String expectedUrl = "https://magento.softwaretestingboard.com/";
		softAssert.assertTrue(result);
		softAssert.assertEquals(homePage.getCurrUrl() , expectedUrl);
		softAssert.assertAll();
	}
	
	

}
