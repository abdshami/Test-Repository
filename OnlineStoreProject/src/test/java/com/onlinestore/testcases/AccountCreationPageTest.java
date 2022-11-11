package com.onlinestore.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.onlinestore.base.BaseClass;
import com.onlinestore.dataprovider.DataProviders;
import com.onlinestore.pages.AccountCreationPage;
import com.onlinestore.pages.HomePage;
import com.onlinestore.pages.IndexPage;
import com.onlinestore.utility.Log;

public class AccountCreationPageTest extends BaseClass {
	private IndexPage indexPage;
	private AccountCreationPage accountCreationPage ;
	private HomePage homePage;
	
	@Test(dataProvider = "newUserInformation" , dataProviderClass = DataProviders.class , groups = "Sanity")
	public void createAnAccountTest(String firstName1 , String lastName1 , String emailAddress1 , String password1 , String passwordConfirm1) throws InterruptedException {
		 Log.startTestCase("createAnAccountTest");
		 indexPage= new IndexPage();
		 Log.info("User will click on Create an account button");
		 accountCreationPage = indexPage.clickOnCreateAnAccount();
		 Log.info("User will enter his information and create his accoun");
		 homePage = accountCreationPage.createAnAccount(firstName1, lastName1, emailAddress1, password1, passwordConfirm1);
		 boolean result1 = accountCreationPage.validateNotLoggedIn();
		 Assert.assertTrue(!result1);
         if(!result1) {
			 boolean result2 = homePage.validateUserLoggedIn();
			 Assert.assertTrue(result2);
		 }
		 Log.info("createAnAccountTest test success");
	     Log.endTestCase("createAnAccountTest");
	}
}
