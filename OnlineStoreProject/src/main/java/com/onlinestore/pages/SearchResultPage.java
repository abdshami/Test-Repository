package com.onlinestore.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.onlinestore.actiondriver.Action;
import com.onlinestore.base.BaseClass;

public class SearchResultPage extends BaseClass {
	
	Action action= new Action();
	
	@FindBy(xpath = "//*[@id='maincontent']/div[3]/div[1]/div[2]/div[2]/ol/li[1]/div/a/span/span/img")
	WebElement searchedProduct;
	
	public SearchResultPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public boolean isProductAvailable() throws InterruptedException {
		Thread.sleep(8000);
		return action.isDisplayed(getDriver(), searchedProduct);
	}
	
	public AddToCartPage clickOnProduct() throws InterruptedException {
	   Thread.sleep(5000);
	   action.click(getDriver(),searchedProduct);
	   return new AddToCartPage();
	}
}   