package com.webshop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.webshop.generic.FileLib;
import com.webshop.generic.WebDriverCommonLib;

/**
 * 
 * @author Satyanka Arava
 *
 */
public class BillingAddress {
	@FindBy(id="billing-address-select")private WebElement billingAddr;
	@FindBy(id="BillingNewAddress_FirstName")private WebElement firstName;
	@FindBy(id="BillingNewAddress_LastName")private WebElement lastName;
	@FindBy(id="BillingNewAddress_CountryId")private WebElement country;
	@FindBy(id="BillingNewAddress_City")private WebElement city;
	@FindBy(id="BillingNewAddress_Address1")private WebElement address1;
	@FindBy(id="BillingNewAddress_ZipPostalCode")private WebElement zip;
	@FindBy(id="BillingNewAddress_PhoneNumber")private WebElement mobileNum;
	@FindBy(xpath = "//input[@onclick='Billing.save()']")private WebElement continueBtn;
	@FindBy(id="shipping-address-select")private WebElement shippingAddrDropdown;
	@FindBy(xpath="//input[@onclick='Shipping.save()']")private WebElement ShippingAddrContinueBtn;
	@FindBy(id="shippingoption_1")private WebElement nextDayAirOptn;
	@FindBy(xpath="//input[@onclick='ShippingMethod.save()']")private WebElement ShippingMethodContinueBtn;
		
	
	WebDriverCommonLib wdcl = new WebDriverCommonLib();
	
	public BillingAddress(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//14. Select “New Address” From “Billing Address” drop down.
	public void newAddr()
	{
		billingAddr.click();
		Select sel = new Select(billingAddr);
		sel.selectByVisibleText("New Address");
	}
	
	FileLib flib= new FileLib();
	
	//15. Fill all mandatory fields in “Billing Address” and click “Continue”
	public void fillAddr()throws Throwable
	{
		firstName.clear();
		String fName = flib.getPropValue("firstname");
		firstName.sendKeys(fName);
		lastName.clear();
		String lName = flib.getPropValue("lastname");
		lastName.sendKeys(lName);
		Select sel = new Select(country);
		sel.selectByVisibleText("India");
		String cityAddr = flib.getPropValue("city");
		city.sendKeys(cityAddr);
		String addr = flib.getPropValue("address1");
		address1.sendKeys(addr);
		String zipCode = flib.getPropValue("zip");
		zip.sendKeys(zipCode);
		String mobNum = flib.getPropValue("mobileNum");
		mobileNum.sendKeys(mobNum);
		continueBtn.click();
	}
	public void shippingAddr() throws Throwable
	{
		wdcl.waitForVisibleText(shippingAddrDropdown);
		shippingAddrDropdown.click();
		Select sel = new Select(shippingAddrDropdown);
		String shippingAddr = flib.getPropValue("shippingAddr");
		sel.selectByValue(shippingAddr);
		ShippingAddrContinueBtn.click();
	}
	
	//17. Select the shipping method as “Next Day Air” and click on “Continue”
	 public void shippingMethod()
	 {
		 wdcl.waitForVisibleText(nextDayAirOptn);
		 nextDayAirOptn.click();
		 ShippingMethodContinueBtn.click();
	 }
	

}
