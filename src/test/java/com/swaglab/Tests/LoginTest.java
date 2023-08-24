package com.swaglab.Tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Swaglab.PageObject.CartPO;
import com.Swaglab.PageObject.HomepagePo;
import com.Swaglab.PageObject.LoginPo;
import com.Swaglab.base.BasePo;

public class LoginTest extends BasePo
{
	LoginPo login;
	HomepagePo home;
	CartPO    cart;
    String ExpectedErrorMessage="Epic sadface: Username and password do not match any user in this service";
	
    @BeforeClass
	public void BrowserOpen() throws InterruptedException 
	{
    	BrowserLaunch();
	    login= new LoginPo(driver);
	    home=new HomepagePo(driver);
//	    cart=new CartPO(driver);
	}

		
	
	@Test
	public void VerifyErrorMessageAfterEnterInvalidCredential() 
    {
		login.EnterInvalidCredentials();
		login.ClickONLoginButton();
    	Assert.assertEquals(login.IsErrorMessageDisplayed(),ExpectedErrorMessage,"Error message does not matched with expected");
	
    	//System.out.println(login.IsErrorMessageDisplayed());
    }
    @Test(dependsOnMethods="VerifyErrorMessageAfterEnterInvalidCredential") 
	public void VerifyUserLoginSuccessfully()
	{
		login.EnterCredentials();
		login.ClickONLoginButton();
	//verify user Login
		
		Assert.assertTrue(home.IsLogoDisplayed(),"Logo is not displayed so that user is not successfully login to application");
	}
   
    @AfterClass
    public void BrowserClose() 
    {
    	driver.quit();
    }
}
