package com.onlinestore.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.onlinestore.actiondriver.Action;
import com.onlinestore.base.BaseClass;

public class OrderConfirmationPage extends BaseClass{
	
	Action action= new Action();
	
	@FindBy(xpath = "//span[text() = 'Thank you for your purchase!']")
	WebElement thankYouMessage;	

	public OrderConfirmationPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public boolean validatOrderConfirmation() throws InterruptedException{
		return action.isDisplayed(getDriver(), thankYouMessage);
	}
	
	public String getOrderConfirmationMessage() {
		String msg = thankYouMessage.getText();
		return msg;
	}
}
