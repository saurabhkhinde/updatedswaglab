package com.Swaglab.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPo {
	@FindBy(xpath="//input[@placeholder='First Name']")private WebElement First_Name;
	@FindBy(xpath="//input[@placeholder='Last Name']")private WebElement Last_Name ;
	@FindBy(xpath="//input[@placeholder='Zip/Postal Code']")private WebElement Zip_Code;
	@FindBy(xpath="//input[@type='submit']")private WebElement Continue;
	@FindBy(xpath="//a[text()='CANCEL']")private WebElement CancelButton;
	@FindBy(xpath="//h3[contains(text(),'Error: ')]")private WebElement FirstNameErrorMsg;
	@FindBy(xpath="//h3[contains(text(),'Error: ')]")private WebElement LastNameErrorMsg;
	@FindBy(xpath="//h3[contains(text(),'Error: ')]")private WebElement ZipCodeErrorMsg;
	public CheckOutPo(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public void EnterFirstName() 
	{  
		First_Name.clear();
		First_Name.sendKeys("bharati");
	}
	public void EnterLastName() 
	{  
		Last_Name.clear();
		Last_Name.sendKeys("Aher");
	}
	public void EnterZipCode() 
	{  
		Zip_Code.clear();
		Zip_Code.sendKeys("132432");
	}

	public void ClickONContinueButton() 
	{
		Continue.click();
	}

	public String GetErrorMessageforFirstName() 
	{
		return FirstNameErrorMsg.getText();
	}
	public String GetErrorMessageforLastName() 
	{
		return LastNameErrorMsg.getText();
	}
	public String GetErrorMessageforZipCode() 
	{
		return ZipCodeErrorMsg.getText();
	}
	
	public void ClickOnCancelButton()
	{
		CancelButton.click();
	}

}
