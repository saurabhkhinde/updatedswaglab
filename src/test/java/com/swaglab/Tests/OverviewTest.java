package com.swaglab.Tests;
	
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
	
	public class OverviewTest extends BasePo
	{	LoginPo login;
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
	public void VerifyProductAddedOnOverViewPage()
	{
		login.EnterCredentials();
		login.ClickONLoginButton();
		String homePrice=home.GetHomePageProductPrice();
		home.ClickOnAddCart();
		home.ClickOnCartIcon();
		cart.ClickOnCheckoutButton();
		checkout.EnterFirstName();
		checkout.EnterLastName();
		checkout.EnterZipCode();
		checkout.ClickONContinueButton();
		Assert.assertEquals(over.getOverViewProductName(),home.GetHomePageProductName(),"product name dose not match");
		Assert.assertEquals(over.getOverViewProductPrice(),homePrice,"product price not match");
		Assert.assertEquals(over.getItemTotalOfOverViewProductItem(),"Item total: "+homePrice,"price not match" );
	//	Assert.assertEquals(over.getTotalOfOverViewProductItem(),over.getTaxOfOverViewProductItem()+homePrice,"totalprice does not match");
		over.clickOnFinishButton();
	}
	 @AfterClass
	    public void BrowserClose() 
	    {
	    	driver.quit();
	    }
	
	
	}
