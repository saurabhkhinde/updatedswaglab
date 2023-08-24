package com.swaglab.Tests;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Swaglab.PageObject.CartPO;
import com.Swaglab.PageObject.CheckOutPo;
import com.Swaglab.PageObject.HomepagePo;
import com.Swaglab.PageObject.LoginPo;
import com.Swaglab.PageObject.OverviewPo;
import com.Swaglab.base.BasePo;

public class HomepageTest extends BasePo
{
	LoginPo login;
	HomepagePo home;
	CartPO    cart;
	CheckOutPo checkout;
	OverviewPo over;
	@BeforeClass
	public void BrowserOpen() throws InterruptedException 
	{
		BrowserLaunch();
	    login= new LoginPo(driver);
	    home=new HomepagePo(driver);
	    cart=new CartPO(driver);
	    checkout=new CheckOutPo(driver);
	    over=new OverviewPo(driver);
	}
	
	@Test
	public void LoginToApplication()
	{
		login.EnterCredentials();
		login.ClickONLoginButton();
	}
	@Test(dependsOnMethods="LoginToApplication")
	public void VerifyUserAddedProductToCartSuccessfully()
	{
		//Add product to cart
		home.ClickOnAddCart();
		//verify remove button is displayed
		Assert.assertFalse(home.GetIconQuantity().isEmpty(), "product is not added to cart after click on cart button");
		
	    Assert.assertTrue(home.ISRemoveButtonPresent(),"Removebutton is not present");
	    //Goto Cart page	    
	}

	
	@Test(dependsOnMethods="VerifyUserAddedProductToCartSuccessfully")
	public void VerifyProductAddedToCart() 
	{
		String homePrice=home.GetHomePageProductPrice();
		String homeIconQuantity=home.GetIconQuantity();
		home.ClickOnCartIcon();
		
		Assert.assertEquals(cart.GetProductName(),home.GetHomePageProductName(),"product name doesnot matched");
		Assert.assertEquals("$"+cart.GetProductPrice(),homePrice,"product price doesnot matched");
	    Assert.assertEquals(cart.GetTotalProductAdded(),homeIconQuantity,"Product Quantity doesnot matched");
	    cart.ClickOnCheckoutButton();
	}
	
	@Test(dependsOnMethods="VerifyProductAddedToCart")
	public void VerifyErrorMessageForYourInformationPageFields() throws InterruptedException
	{
		String FirstNameError="Error: First Name is required";
		String LastNameError="Error: Last Name is required";
		String ZipCodeError="Error: Postal Code is required";
		checkout.ClickONContinueButton();
		Assert.assertEquals(checkout.GetErrorMessageforFirstName(),FirstNameError,"FirstNameError message does not matched");
		checkout.EnterFirstName();
		Thread.sleep(5000);
		checkout.ClickONContinueButton();
		Assert.assertEquals(checkout.GetErrorMessageforLastName(),LastNameError,"LastNameError message does not matched");
		checkout.EnterLastName();
		checkout.ClickONContinueButton();
		Assert.assertEquals(checkout.GetErrorMessageforZipCode(),ZipCodeError,"ZipCodeError message does not matched");
		checkout.EnterZipCode();
		checkout.ClickONContinueButton();
	}
   @AfterClass
	 public void BrowserClose() 
	    {
	    	driver.quit();
	    }
}
