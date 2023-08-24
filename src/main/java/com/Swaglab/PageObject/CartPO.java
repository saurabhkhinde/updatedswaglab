package com.Swaglab.PageObject;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPO {

	@FindBy(xpath="//div[@class='cart_quantity']") private static WebElement TotalProductAdded;
	@FindBy(xpath="//div[text()='Sauce Labs Backpack']") private WebElement CartProductName;
	@FindBy(xpath="//div[@class='inventory_item_price']") private WebElement CartProductPrice;
	@FindBy(xpath="(//a)[8]") private WebElement CheckoutButton;
	@FindBy(xpath="(//span)[8]")private WebElement IconQuantityShown;
	public CartPO(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	public String GetTotalProductAdded()
	{
		return TotalProductAdded.getText();	 
	}
	public String GetProductName()
	{
		return CartProductName.getText();
	}
	public String GetProductPrice()
	{
		return CartProductPrice.getText();
	}
	public void ClickOnCheckoutButton()
	{
		CheckoutButton.click();
	}
	public String GetIconQuantity()
	{
		 return IconQuantityShown.getText();
	}
	
	
	
	
	
	
	
	
	
}
