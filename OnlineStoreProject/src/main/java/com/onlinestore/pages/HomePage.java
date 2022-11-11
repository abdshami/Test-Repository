package com.onlinestore.pages;

import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.onlinestore.actiondriver.Action;
import com.onlinestore.base.BaseClass;

public class HomePage extends BaseClass {
	
	Action action= new Action();
	public static Properties prop;
	
	@FindBy(xpath = "//span[@class='logged-in']")
	WebElement LoggedInUserName;
	
	@FindBy(id = "search")
	WebElement searchProductBox;
	
	@FindBy(xpath = "//button[@class='action search']")
	WebElement searchBtnElement;
	
	
	public HomePage() {
		prop = new Properties();
		PageFactory.initElements(getDriver(), this);
	}
	
	public boolean validateUserLoggedIn(){
		action.fluentWait(getDriver(), LoggedInUserName, 10);
		return action.isDisplayed(getDriver(), LoggedInUserName);
	}
	
	public String getCurrUrl() {
		return getDriver().getCurrentUrl();
	}
	
	public SearchResultPage searchProduct(String productName) throws InterruptedException {
		action.fluentWait(getDriver(), searchProductBox, 10);
		action.type(searchProductBox, productName);
		action.fluentWait(getDriver(), searchBtnElement, 10);
		action.click(getDriver(), searchBtnElement);
		return new SearchResultPage();
	}
}
