package com.webshop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCart {
	@FindBy(id="topcartlink")private WebElement shoppingCart;
	@FindBy(name="removefromcart")private WebElement removeChkBox;
	@FindBy(name="updatecart")private WebElement updateShoppingCart;
	@FindBy(xpath="(//span[@class='product-price'])[1]")private WebElement subTotal;
	@FindBy(name="termsofservice")private WebElement termsChkBox;
	@FindBy(id="checkout")private WebElement checkout;
	@FindBy(xpath = "//a[@href='/']")private WebElement homePage;
	@FindBy(className = "order-summary-content")private WebElement emptyCart;
	
	public ShoppingCart(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clearCart()
	{
		shoppingCart.click();
		if(emptyCart.getText().contains("Your Shopping Cart is empty!"))
		{
			System.out.println("Cart is empty");
		}
		else
		{
		removeChkBox.click();
		updateShoppingCart.click();
		}
		homePage.click();
		
	}
	
	

}
