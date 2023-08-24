package com.Swaglab.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.SeleniumHelpers;

public class OverviewPo {
	@FindBy(xpath="//div[@class='inventory_item_name']")private WebElement OverViewProductName ;
	@FindBy(xpath="//div[@class='inventory_item_price']")private WebElement OverViewProductPrice;
	@FindBy(xpath="//div[@class='summary_subtotal_label']")private WebElement OverViewProductItemTotal;
	@FindBy(xpath="//div[@class='summary_tax_label']")private WebElement OverViewProductTax;
	@FindBy(xpath="//a[text()='FINISH']")private WebElement Finish;
	@FindBy(xpath="//div[@class='summary_total_label']")private WebElement OverViewProductTotalAmount ;
	SeleniumHelpers selenium;


	public OverviewPo(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		 selenium= new SeleniumHelpers(driver);	

	}

	public String getOverViewProductName()
	{ 
		return selenium.getText(OverViewProductName);
	}
	public String getOverViewProductPrice()
	{ 
		return selenium.getText(OverViewProductPrice);
	}
	public String getItemTotalOfOverViewProductItem()
	{ 
		return OverViewProductItemTotal.getText();
	}
	public String getTaxOfOverViewProductItem()
	{ 
		return OverViewProductTax.getText();
	}
	public String getTotalOfOverViewProductItem()
	{ 
		return OverViewProductTotalAmount.getText();
	}
	public void clickOnFinishButton()
	{
		Finish.click();
	}




}
