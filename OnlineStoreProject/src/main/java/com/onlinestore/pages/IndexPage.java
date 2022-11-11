package com.onlinestore.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.onlinestore.actiondriver.Action;
import com.onlinestore.base.BaseClass;

public class IndexPage extends BaseClass{
	
	Action action= new Action();

	@FindBy(xpath = "//a[contains(text(), 'Create an Account')]")
	WebElement createAnAccountBtn;

	@FindBy(xpath = "//img[@src='https://magento.softwaretestingboard.com/pub/static/version1666447838/frontend/Magento/luma/en_US/images/logo.svg']")
	WebElement onLineStoreLogo;
	
	@FindBy(xpath = "//a[contains(text(), 'Sign In')]")
	WebElement signInBtn;
	
//	@FindBy(id = "search")
//	WebElement searchProductBox;
//	
//	@FindBy(xpath = "//button[@class='action search']")
//	WebElement searchBtnElement;
	
	public IndexPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public LoginPage clickOnSignIn()  {
		action.click(getDriver(), signInBtn);
		return new LoginPage();
	}
	
	public AccountCreationPage clickOnCreateAnAccount(){
		action.click(getDriver(), createAnAccountBtn);
		return new AccountCreationPage();
	}
	
	
	public boolean validateLogo()   {
		return action.isDisplayed(getDriver(), onLineStoreLogo);
	}
	
	public String getOnlineStoreTitle(){
		return getDriver().getTitle();
	}
}
