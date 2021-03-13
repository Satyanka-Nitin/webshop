package com.webshop;

public class AutoWebShop extends BaseTest{

	public static void main(String[] args) throws Throwable {
		
		//Open the browser and Enter the URL
		BaseTest bt = new BaseTest();
		bt.openBrowser();
		
		
		
		//Login to App
		LoginPage lp = new LoginPage(driver);
		FileLib flib = new FileLib();
		String un = flib.getPropValue("username");
		String pw = flib.getPropValue("password");
		lp.login(un, pw);
		
		//Clear the shopping cart
		 ShoppingCart sc = new ShoppingCart(driver);
		 sc.clearCart();
		 
		//Select any Book and Add to Cart
		AddCart ac = new AddCart(driver);
		String qty = flib.getPropValue("quantity");
		ac.selAnyBook(qty);

	}

}
