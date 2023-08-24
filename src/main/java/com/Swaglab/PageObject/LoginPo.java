package com.Swaglab.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.SeleniumHelpers;

public class LoginPo 
{
	@FindBy(xpath="//input[@placeholder='Username']")private WebElement Username ;
	@FindBy(xpath="//input[@placeholder='Password']")private WebElement Password;
	@FindBy(xpath="//input[@type='submit']")private WebElement LoginButton;
	@FindBy(xpath="//h3[contains(text(),'Epic')]")private WebElement ErrorMessage;

	
	SeleniumHelpers selenium;
	 public LoginPo(WebDriver driver) 
	 {	   
	  PageFactory.initElements(driver,this);
	  selenium= new SeleniumHelpers(driver);	
	}

	public void EnterCredentials() 
	{
		selenium.enterText(Username,"standard_user",true);
	 	selenium.enterText(Password,"secret_sauce", true);
	}
	public void ClickONLoginButton() 
	{
		LoginButton.click();
	}
	public void EnterInvalidCredentials() 
	{
		selenium.enterText(Username,"standard_use",true);
		Password.sendKeys("secret_sauce");
	}
	public String IsErrorMessageDisplayed() 
	{
	    return ErrorMessage.getText();
	}

}
