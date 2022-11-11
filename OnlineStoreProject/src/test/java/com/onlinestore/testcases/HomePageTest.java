package com.onlinestore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.onlinestore.base.BaseClass;
import com.onlinestore.pages.HomePage;
import com.onlinestore.pages.IndexPage;
import com.onlinestore.pages.LoginPage;

public class HomePageTest extends BaseClass{
	private IndexPage indexPage;
	private LoginPage loginPage ;
	private HomePage homePage ;
	
	@Test(groups = "Smoke")
	public void verifyUserLoggedIn() {
		indexPage= new IndexPage();
		loginPage = indexPage.clickOnSignIn();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertTrue(homePage.validateUserLoggedIn());
	}
}
