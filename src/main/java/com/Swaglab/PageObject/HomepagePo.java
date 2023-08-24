package com.Swaglab.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomepagePo {

	String ProductName;
	@FindBy(xpath="//div[@class='peek']")private WebElement Logo;
	@FindBy(xpath="//div[text()='Sauce Labs Backpack']")private WebElement HomepageProductName;
	@FindBy(xpath="((((//div[text()='Sauce Labs Backpack'])/ancestor::div)[8])/following-sibling::div)/div")private WebElement HomepageProductPrice;
	@FindBy(xpath="((((//div[text()='Sauce Labs Backpack'])/ancestor::div)[8])/following-sibling::div)/button")private WebElement AddToCartButton;
	@FindBy(xpath="//div[@class='shopping_cart_container']")private WebElement CartIcon;
	@FindBy(xpath="(((//div[text()='Sauce Labs Backpack'])//ancestor::div)[8]//following-sibling::div)[2]//button[text()='REMOVE']")private WebElement RemoveButtton;
	@FindBy(xpath="//div[@id='shopping_cart_container']/descendant::span")private WebElement IconQuantityShown;
	
	public HomepagePo(WebDriver driver) 
	{
		PageFactory.initElements(driver,this);
	}
	public String GetHomePageProductName() 
	{
		return HomepageProductName.getText();
	}
	public String GetHomePageProductPrice() 
	{
		return HomepageProductPrice.getText();
	}
	public void ClickOnAddCart()
	{
		AddToCartButton.click();
	}
	public boolean ISRemoveButtonPresent()
	{
		return RemoveButtton.isDisplayed();
	}
	public void ClickOnCartIcon() 
	{
		CartIcon.click();
	}
	public boolean IsLogoDisplayed() 
 	{
		return Logo.isDisplayed();
		
	}
	public String GetIconQuantity()
	{
		 return IconQuantityShown.getText();
	}
	public boolean IconQuantity()
	{
		 return IconQuantityShown.isDisplayed();
	}
	
}
