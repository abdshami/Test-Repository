package com.onlinestore.testcases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.onlinestore.base.BaseClass;
import com.onlinestore.dataprovider.DataProviders;
import com.onlinestore.pages.AddToCartPage;
import com.onlinestore.pages.HomePage;
import com.onlinestore.pages.IndexPage;
import com.onlinestore.pages.LoginPage;
import com.onlinestore.pages.OrderConfirmationPage;
import com.onlinestore.pages.PaymentPage;
import com.onlinestore.pages.SearchResultPage;
import com.onlinestore.pages.ShippingAddressPage;
import com.onlinestore.pages.ShoppingCartPage;
import com.onlinestore.utility.Log;


public class EndToEndTest extends BaseClass{
	
	private IndexPage indexPage;
	private LoginPage loginPage;
	private HomePage homePage;
	private SearchResultPage srearchResultPage;
	private AddToCartPage addToCartPage;
	private ShoppingCartPage shoppingCartPage;
	private ShippingAddressPage shippingAddressPage;
	private PaymentPage paymentPage;
	private OrderConfirmationPage orderConfirmationPage;
	
	@Test(dataProvider = "credentials" , dataProviderClass = DataProviders.class , groups = "Regression")
	public void endToEndTest(String userName , String Password) throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		Log.startTestCase("endToEndTest");
		indexPage = new IndexPage();
		Log.info("Verify Index Page");
		softAssert.assertTrue(indexPage.validateLogo());
		softAssert.assertEquals(indexPage.getOnlineStoreTitle() , "Home Page - Magento eCommerce - website to practice selenium | demo website for automation testing | selenium practice sites | selenium demo sites | best website to practice selenium automation | automation practice sites Magento Commerce - website to practice selenium | demo website for automation testing | selenium practice sites");
		Log.info("User is going to click on signIn");
		loginPage = indexPage.clickOnSignIn();
		Log.info("User is going to Enter UserName and Password");
		homePage = loginPage.login(userName, Password);
		Log.info("Verify Home Page");
		softAssert.assertTrue(homePage.validateUserLoggedIn());
		softAssert.assertEquals(homePage.getCurrUrl() , "https://magento.softwaretestingboard.com/");
		Log.info("User will search T Shirt");
		srearchResultPage = homePage.searchProduct("T shirt");
		Log.info("Verify if the product is available");
		softAssert.assertTrue(srearchResultPage.isProductAvailable());
		Log.info("user will Click on the selected product");
		addToCartPage = srearchResultPage.clickOnProduct();
		Log.info("User will choose the size of the product");
		addToCartPage.selectSize();
		Log.info("User will choose the color of the product");
		addToCartPage.selectColor();
		Log.info("User will enter the quantity");
		addToCartPage.enterQuantity(prop.getProperty("qty"));
		Log.info("User will click on Add To Cart");
		addToCartPage.clickOnAddToCart();
		Log.info("Verify the add to cart message");
		softAssert.assertTrue(addToCartPage.validateAddToCartMessage());
		Log.info("User will click on shopping cart message");
		shoppingCartPage = addToCartPage.clickOnShoppingCartMessage();
		double totalUnitsPrice = shoppingCartPage.getTotalUintsPrice();
		double totalPrice = shoppingCartPage.getTotalPrice();
		Log.info("Verify if the totalPrive is equal to totalUnitsPrice");
		softAssert.assertEquals(totalPrice, totalUnitsPrice);
		Log.info("User will proceed to checkOut");
		shippingAddressPage = shoppingCartPage.proceedToCheckOut();
		Log.info("Verify Shipping Address Page");
		softAssert.assertTrue(shippingAddressPage.verifyShippingAddressPage());
		Log.info("User will choose Fixed Shipping Method");
		shippingAddressPage.chooseFixedShippingMethod();
		Log.info("User will click Next button");
		paymentPage = shippingAddressPage.clickNextbtn();
		Log.info("Verify the Payment Page and Place Order Button");
		softAssert.assertTrue(paymentPage.verifyPaymentPage());
		softAssert.assertTrue(paymentPage.verifyPlaceOrderBtn());
		Log.info("User will click on Place Order Button");
		orderConfirmationPage = paymentPage.clickOnPlaceOrder();
		Log.info("Verify Order Confirmation Page and Order Confirmation Message");
		softAssert.assertTrue(orderConfirmationPage.validatOrderConfirmation());
		softAssert.assertEquals(orderConfirmationPage.getOrderConfirmationMessage() , "Thank you for your purchase!");
	    softAssert.assertAll();
		Log.info("End To End Test is success");
	    Log.endTestCase("EndToEndTest");
	}
}
