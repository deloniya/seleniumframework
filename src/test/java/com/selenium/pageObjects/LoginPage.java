package com.selenium.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver ldriver;
	
	public LoginPage( WebDriver rdriver)
	{
	
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	
	}
	
	@FindBy(id="username")
	@CacheLookup
	WebElement username; 
	
	@FindBy(id="password")
	@CacheLookup
	WebElement password;
	
	@FindBy(id="log-in")
	@CacheLookup
	WebElement loginButton;
	
	public void setUsername(String uname) 
	{
		
		username.sendKeys(uname);
	}

	public void setPassword (String pass)
	{
		password.sendKeys(pass);
	}
	
	public void clickLogin ()
	{
		loginButton.click();
	}
}
