package com.onlinestore.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.onlinestore.actiondriver.Action;
import com.onlinestore.base.BaseClass;

public class ShippingAddressPage  extends BaseClass{
	Action action= new Action();
	
	@FindBy(xpath = "//div[text() = 'Shipping Address']")
	WebElement shippingaAddressHeader;
	
	@FindBy(name = "ko_unique_1")
	WebElement fixedShippingMethod;
	
	@FindBy(xpath = "//button[@class='button action continue primary']")
	WebElement nextBtn;
	
	public ShippingAddressPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public boolean verifyShippingAddressPage() throws InterruptedException {
		Thread.sleep(3000);
		return action.isDisplayed(getDriver(), shippingaAddressHeader);
	}
	
	public void chooseFixedShippingMethod() throws InterruptedException {
		Thread.sleep(3000);
		action.click(getDriver(), fixedShippingMethod);
	}
	
	public PaymentPage clickNextbtn() throws InterruptedException{
		Thread.sleep(3000);
		action.click(getDriver(), nextBtn);
		return new PaymentPage();
	}
}
