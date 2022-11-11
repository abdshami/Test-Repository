package com.onlinestore.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.onlinestore.actiondriver.Action;
import com.onlinestore.base.BaseClass;

public class AddToCartPage extends BaseClass{

	Action action= new Action();
	
	@FindBy(id = "option-label-size-143-item-166")
	WebElement size;
	
	@FindBy(id = "option-label-color-93-item-50")
	WebElement color;
	
	@FindBy(id = "qty")
	WebElement qty;

	@FindBy(id = "product-addtocart-button")
	WebElement addToCartBtn;
	
	@FindBy(xpath = "//a[text()='shopping cart']")
	WebElement shoppingCartMassage;
	
	public AddToCartPage() {
		PageFactory.initElements(getDriver(), this);
	}
	public void enterQuantity(String qty1) {
		action.type(qty, qty1);
	}
	
	public void selectSize() throws InterruptedException {
		Thread.sleep(2000);
		action.click(getDriver(), size);
	}
	
	public void selectColor() throws InterruptedException {
		Thread.sleep(2000);
		action.click(getDriver(), color);
	}
	
	public void clickOnAddToCart() throws InterruptedException {
		Thread.sleep(1000);
		action.click(getDriver(), addToCartBtn);
	}
	
	public boolean validateAddToCartMessage() {
		return action.isDisplayed(getDriver(), shoppingCartMassage);
	}
	
	public ShoppingCartPage clickOnShoppingCartMessage() {
		action.click(getDriver(), shoppingCartMassage);
		return new ShoppingCartPage();
		
	}
}
