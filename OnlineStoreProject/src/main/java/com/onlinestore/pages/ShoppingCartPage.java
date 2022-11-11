package com.onlinestore.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.onlinestore.actiondriver.Action;
import com.onlinestore.base.BaseClass;

public class ShoppingCartPage extends BaseClass{
	
	Action action= new Action();
	
	@FindBy(xpath = "//table[@id='shopping-cart-table']//td[@class='col price']//span[@class='price']")
	WebElement  unitPrice;
	
	@FindBy(xpath = "//span[@data-th='Subtotal']")
	WebElement  totalPrice;
	
	@FindBy(xpath = "//input[@title='Qty']")
	WebElement productQuantity;
	
	@FindBy(xpath = "//span[text()='Proceed to Checkout']")
	WebElement proceedToCheckoutBtn;

	public ShoppingCartPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public double getTotalUintsPrice() {
		String unitPrice1 = unitPrice.getText();
		String unitPrice2 = unitPrice1.replaceAll("[^a-zA-Z0-9]", "");
		double finalUnitPrice = (Double.parseDouble(unitPrice2)/100) * getProductQuantity();
		return finalUnitPrice;
	}
	
	public double getTotalPrice() {
		String totalPrice1 = totalPrice.getText();
		String totalPrice2 = totalPrice1.replaceAll("[^a-zA-Z0-9]", "");
		double TotalPrice3 = Double.parseDouble(totalPrice2);
		double finalTotalPrice = TotalPrice3/100;
		return finalTotalPrice;
	}
	
	public ShippingAddressPage proceedToCheckOut() throws InterruptedException {
	   Thread.sleep(5000);
	   action.click(getDriver(), proceedToCheckoutBtn);
	   return new ShippingAddressPage();
	}
	
	public double getProductQuantity() {
		return Double.parseDouble(action.getInputValue(productQuantity));
	}
}
