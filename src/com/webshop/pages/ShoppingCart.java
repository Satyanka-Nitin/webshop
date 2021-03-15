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
public class ShoppingCart {
	@FindBy(id="topcartlink")private WebElement shoppingCart;
	@FindBy(name="removefromcart")private WebElement removeChkBox;
	@FindBy(name="updatecart")private WebElement updateShoppingCart;
	@FindBy(xpath="(//span[@class='product-price'])[1]")private WebElement subTotal;
	@FindBy(name="termsofservice")private WebElement termsChkBox;
	@FindBy(id="checkout")private WebElement checkout;
	@FindBy(xpath = "//a[@href='/']")private WebElement homePage;
	@FindBy(className = "order-summary-content")private WebElement emptyCart;
	
	FileLib flib = new FileLib();
	WebDriverCommonLib wdcl = new WebDriverCommonLib();
	
	public ShoppingCart(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//6. Clear the shopping cart.
	public void clearCart() throws Throwable
	{		
		shoppingCart.click();
		String expShoppingcartPageTitle = flib.getPropValue("shoppingcartpageTitle");
		wdcl.waitForPageTitle(expShoppingcartPageTitle);
		String actShoppingcartPageTitle = wdcl.getPageTitle();
		wdcl.verify(actShoppingcartPageTitle, expShoppingcartPageTitle);
		String expResult = flib.getPropValue("emptyShoppingCrt");
		String actResult = emptyCart.getText();
		if(actResult.contains(expResult))
		{
			System.out.println("\n\n"+expResult);
		}
		else
		{
		removeChkBox.click();
		updateShoppingCart.click();
		}
		homePage.click();
		
	}
	//12. Click on “shopping cart” on top right and validate the “Sub-Total” Price for selected book.
	public void validateSubTotal()
	{
		shoppingCart.click();
		System.out.println("\n\nSub Total = "+subTotal.getText());
	}
	
	//13. Click on “Check-out”
	public void checkout() throws Throwable
	{
		termsChkBox.click();
		checkout.click();
		String expCheckoutPageTitle = flib.getPropValue("checkoutpageTitle");
		wdcl.waitForPageTitle(expCheckoutPageTitle);
		String actCheckoutPageTitle = wdcl.getPageTitle();
		wdcl.verify(actCheckoutPageTitle, expCheckoutPageTitle);
	}
	

}
