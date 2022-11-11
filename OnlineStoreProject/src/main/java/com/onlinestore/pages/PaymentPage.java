package com.onlinestore.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.onlinestore.actiondriver.Action;
import com.onlinestore.base.BaseClass;

public class PaymentPage extends BaseClass{

	Action action= new Action();
	
	@FindBy(xpath = "//button[@class='action primary checkout']")
	WebElement placeOrderBtn;
	
	@FindBy(xpath = "//div[text() = 'Payment Method']")
	WebElement paymentMethodPageHeader;

	public PaymentPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public boolean verifyPaymentPage() throws InterruptedException {
		Thread.sleep(5000);
		return action.isDisplayed(getDriver(), paymentMethodPageHeader);
	}
	
	public boolean verifyPlaceOrderBtn() {
		return action.isDisplayed(getDriver(), placeOrderBtn);
	}
	
	public OrderConfirmationPage clickOnPlaceOrder() throws InterruptedException {
		Thread.sleep(5000);
		action.click(getDriver(), placeOrderBtn);
		return new OrderConfirmationPage();
	}
}
