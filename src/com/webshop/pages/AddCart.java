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
public class AddCart {
	@FindBy(xpath="//li[@class='inactive']/descendant::a[@href='/books']")private WebElement booksCategory;
	@FindBy(xpath="//div[@class='product-item']")private WebElement selBook;
	@FindBy(id="addtocart_13_EnteredQuantity")private WebElement quantity;
	@FindBy(id="add-to-cart-button-13")private WebElement addCart;
	@FindBy(xpath="//p[@class='content']")private WebElement confirmMsg;
	
	FileLib flib = new FileLib();
	WebDriverCommonLib wdcl = new WebDriverCommonLib();
	
	public AddCart(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void selAnyBook(String qty) throws Throwable
	{
		//7. Select “Books” from Categories
		booksCategory.click();
		
		String expCategoryPageTitle = flib.getPropValue("booksCategorypageTitle");
		wdcl.waitForPageTitle(expCategoryPageTitle);
		String actCategoryPageTitle = wdcl.getPageTitle();
		wdcl.verify(actCategoryPageTitle, expCategoryPageTitle);
		
		//8. Select a book from the list displayed
		selBook.click();
		
		//9. Get the price details and enter the quantity (more than one)
		quantity.clear();
		
		quantity.sendKeys(qty);
		
		//10. Click on “Add to cart”
		addCart.click();
		
		
		//11. Validate “The product has been added to shopping cart” message
		WebDriverCommonLib wcl = new WebDriverCommonLib();
		wcl.waitForVisibleText(confirmMsg);
		wcl.mouseHover(confirmMsg);
		FileLib flib= new FileLib();
		String successMsg = flib.getPropValue("addCartSuccessMsg");
		String cm = confirmMsg.getText();
		if(cm.equalsIgnoreCase(successMsg))
		{
			System.out.println("\n\nExpected: "+successMsg+"\nActual: "+cm+"\nTest Step Passed");
		}
		else
		{
			System.out.println("\n\nExpected: "+successMsg+"\nActual: "+cm+"\nTest Step Failed");
		}
	}
}
