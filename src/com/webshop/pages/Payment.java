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
public class Payment {
	@FindBy(xpath = "//input[@onclick='PaymentMethod.save()']")private WebElement paymentContinueBtn;
	@FindBy(xpath="//td/descendant::p")private WebElement paymentInfoMsg;
	@FindBy(xpath = "//input[@onclick='PaymentInfo.save()']")private WebElement paymentInfoContinueBtn;
	WebDriverCommonLib wdcl = new WebDriverCommonLib();
	FileLib file = new FileLib();

	public Payment(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
    //Choose the payment method as COD (Cash on delivery) and click on “Continue”
	public void paymentMethod()
	{
		wdcl.waitForVisibleText(paymentContinueBtn);
		paymentContinueBtn.click();
	}
	
	//Validate the message “You will pay by COD” and click on “Continue”
	public void paymentInfo()throws Throwable {
		wdcl.waitForVisibleText(paymentInfoContinueBtn);
		String expPaymentMsg = file.getPropValue("paymentMsg");
		String actPaymentMsg = paymentInfoMsg.getText();
		if(actPaymentMsg.equalsIgnoreCase(expPaymentMsg))
		{
			System.out.println("\n\nExpected: "+expPaymentMsg+"\nActual: "+actPaymentMsg+"\nTestStep Passed");
		}
		else
		{
			System.out.println("\n\nExpected: "+expPaymentMsg+"\nActual: "+actPaymentMsg+"\nTestStep Failed");
		}
		paymentInfoContinueBtn.click();
	}
	

}


