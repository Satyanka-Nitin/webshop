package com.webshop;

import com.webshop.generic.BaseTest;
import com.webshop.generic.FileLib;
import com.webshop.pages.AddCart;
import com.webshop.pages.BillingAddress;
import com.webshop.pages.ConfirmOrder;
import com.webshop.pages.LoginPage;
import com.webshop.pages.Payment;
import com.webshop.pages.ShoppingCart;


/**
 *  
 * @author Satyanka Arava
 *
 */
public class AutoWebShop extends BaseTest{

	public static void main(String[] args) throws Throwable {
		
		//1. Navigate to URL : http://demowebshop.tricentis.com/
		BaseTest bt = new BaseTest();
		bt.openBrowser();		
		
		//2. Click on Login button
		//3. Validate “Welcome, Please Sign In!” message
		//4. Log in with given credentials
		//5. Validate the user account ID on top right
		LoginPage lp = new LoginPage(driver);
		FileLib flib = new FileLib();
		String un = flib.getPropValue("username");
		String pw = flib.getPropValue("password");
		lp.login(un, pw);
		
		//6. Clear the shopping cart
		 ShoppingCart sc = new ShoppingCart(driver);
		 sc.clearCart();
		 
		//7. Select “Books” from Categories
		//8. Select a book from the list displayed
		//9. Get the price details and enter the quantity (more than one)
		//10. Click on “Add to cart”
		//11. Validate “The product has been added to shopping cart” message
		AddCart ac = new AddCart(driver);
		String qty = flib.getPropValue("quantity");
		ac.selAnyBook(qty);
		
		//12. Click on “shopping cart” on top right and validate the “Sub-Total” Price for selected book
		sc.validateSubTotal();
		
		//13. Click on “Check-out”
		sc.checkout();
		
		//14. Select “New Address” From “Billing Address” drop down.
		BillingAddress ba = new BillingAddress(driver);
		ba.newAddr();
		
		//15. Fill all mandatory fields in “Billing Address” and click “Continue”
		ba.fillAddr();
		
		//16. Select the “Shipping Address” as same as “Billing Address” from “Shipping Address” drop down and click on “Continue”.
		ba.shippingAddr();
		
		//17. Select the shipping method as “Next Day Air” and click on “Continue”
		ba.shippingMethod();
		
		//18. Choose the payment method as COD (Cash on delivery) and click on “Continue”
		Payment py = new Payment(driver);
		py.paymentMethod();
		
		//19. Validate the message “You will pay by COD” and click on “Continue”
		py.paymentInfo();
		
		//20. Validate the message “Your order has been successfully processed!” and print the Order number
		ConfirmOrder co= new ConfirmOrder(driver);
		co.confirmOrder();
		
		//21. Validate the message “Your order has been successfully processed!” and print the Order number
		co.validateOrderplacedInfoMsg();
		
		//22. Click on “Continue” and log out from the application
		co.logout();

	
	}

}
