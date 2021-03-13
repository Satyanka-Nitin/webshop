package com.webshop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCart {
	@FindBy(xpath="//li[@class='inactive']/descendant::a[@href='/books']")private WebElement booksCategory;
	@FindBy(xpath="//div[@class='product-item']")private WebElement selBook;
	@FindBy(id="addtocart_13_EnteredQuantity")private WebElement quantity;
	@FindBy(id="add-to-cart-button-13")private WebElement addCart;
	//@FindBy(xpath="(//a[@href='/cart'])[1]")private WebElement confirmMessage;
	@FindBy(xpath="//p[@class='content']")private WebElement confirmMessage;
	
	
	public AddCart(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void selAnyBook(String qty)
	{
		booksCategory.click();
		selBook.click();
		quantity.clear();
		quantity.sendKeys(qty);
		addCart.click();
		//confirmMessage.click();
		WebDriverCommonLib wcl = new WebDriverCommonLib();
		wcl.waitForVisibleText(confirmMessage);
		if(confirmMessage.getText().equalsIgnoreCase("The product has been added to your "))
		{
			System.out.println("Test Step Passed");
		}
		else
		{
			System.out.println("Test Step Failed");
		}
	}
}
