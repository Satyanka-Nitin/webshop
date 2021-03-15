package com.webshop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webshop.generic.FileLib;
import com.webshop.generic.WebDriverCommonLib;

/**
 * 
 * @author Satyanka Arava
 *
 */
public class ConfirmOrder {
	@FindBy(xpath = "//input[@onclick='ConfirmOrder.save()']")private WebElement confirmBtn;
	@FindBy(xpath = "//strong")private WebElement orderPlacedInfoMsg;
	@FindBy(xpath="//ul[@class='details']/descendant::li[1]")private WebElement orderNumber;
	@FindBy(className = "ico-logout")private WebElement logout;
	@FindBy(xpath="//input[@value='Continue']")private WebElement continueBtn;
	
	WebDriverCommonLib wdcl = new WebDriverCommonLib();
	FileLib flib = new FileLib();
	
	public ConfirmOrder(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//20. Click on “Confirm Order”
	public void confirmOrder() {
		
		wdcl.waitForVisibleText(confirmBtn);
		confirmBtn.click();
	}
	
	//21. Validate the message “Your order has been successfully processed!” and print the Order number
	public void validateOrderplacedInfoMsg()throws Throwable
	{
		wdcl.waitForVisibleText(orderPlacedInfoMsg);
		String expOrderPlacedMsg = flib.getPropValue("orderPlacedMsg");
		String actOrderPlacedMsg = orderPlacedInfoMsg.getText();
		if(actOrderPlacedMsg.equalsIgnoreCase(expOrderPlacedMsg))
		{
			System.out.println("\n\nExpected: "+expOrderPlacedMsg+"\nActual: "+actOrderPlacedMsg+"\nTest Step Passed");
			System.out.println(orderNumber.getText());
		}
		else
		{
			System.out.println("\n\nExpected: "+expOrderPlacedMsg+"\nActual: "+actOrderPlacedMsg+"\nTest Step Failed");
		}
				
	}
	
	//Click on “Continue” and log out from the application
	public void logout() 
	{
		wdcl.waitForVisibleText(continueBtn);
		continueBtn.click();
		logout.click();
	}

}
