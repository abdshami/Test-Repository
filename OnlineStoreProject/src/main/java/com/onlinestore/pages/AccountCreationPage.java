package com.onlinestore.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.onlinestore.actiondriver.Action;
import com.onlinestore.base.BaseClass;
import com.onlinestore.dataprovider.DataProviders;

public class AccountCreationPage extends BaseClass {
	private IndexPage indexPage;
	private AccountCreationPage accountCreationPage;
	Action action= new Action();
	
	@FindBy(xpath = "//span[contains(text(), 'Create New Customer Account')]")
	WebElement formTitleElement;
	
	@FindBy(id = "firstname")
	WebElement firstName;
	
	@FindBy(id = "lastname")
	WebElement lastName;
	
	@FindBy(id = "email_address")
	WebElement emailAddress;
	
	@FindBy(id = "password")
	WebElement password;
	
	@FindBy(id = "password-confirmation")
	WebElement confirmPassword;
	
	@FindBy(xpath = "//button[@class='action submit primary']")
	WebElement createAccountBtn;
	
	@FindBy(xpath = "//span[@class='not-logged-in']")
	WebElement notLoggedIn;
	
	
	public AccountCreationPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public boolean validateAccountCreatePage() {
		return action.isDisplayed(getDriver(), formTitleElement);
	}
	
	public boolean validateNotLoggedIn() throws InterruptedException {
		Thread.sleep(5000);
		return action.isDisplayed(getDriver(), notLoggedIn);
	}
	
	public HomePage createAnAccount(String firstName1 , String lastName1 , String emailAddress1 , String password1 , String passwordConfirm1) {
	   action.type(firstName, firstName1);
	   action.type(lastName , lastName1);
	   action.type(emailAddress, emailAddress1);
	   action.type(password, password1);
	   action.type(confirmPassword, passwordConfirm1);
	   action.click(getDriver(), createAccountBtn);
	   return new HomePage();
	}
	
	
}
