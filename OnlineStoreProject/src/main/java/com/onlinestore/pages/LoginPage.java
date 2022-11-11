package com.onlinestore.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.onlinestore.actiondriver.Action;
import com.onlinestore.base.BaseClass;

public class LoginPage extends BaseClass{
	
	Action action= new Action();
	
	@FindBy(id = "email")
	WebElement userName;
	
	@FindBy(id = "pass")
	WebElement password;
	
	@FindBy(id = "send2")
	WebElement signInBtn;
	
	@FindBy(xpath = "//a[@class='action create primary']")
	WebElement createNewAccountBtn;
	
	public LoginPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public HomePage login(String uName , String pswd) {
		action.type(userName, uName);
		action.type(password, pswd);
		action.click(getDriver(), signInBtn);
		return new HomePage();
	}
}
