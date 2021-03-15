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
public class LoginPage {
	
    @FindBy(className="ico-login")private WebElement login;
    @FindBy(tagName = "h1")private WebElement loginMsg;
	@FindBy(id="Email")private WebElement untb;
	@FindBy(id="Password")private WebElement pwtb;
	@FindBy(xpath="//input[@class='button-1 login-button']")private WebElement loginbtn;
	@FindBy(className = "account")private WebElement accountId;
	
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	FileLib flib = new FileLib();
	WebDriverCommonLib wdcl = new WebDriverCommonLib();
	public void login(String un, String pw)throws Throwable
	{
		
		//2. Click on Login button
		login.click();
		String expLoginPageTitle = flib.getPropValue("loginpageTitle");
		wdcl.waitForPageTitle(expLoginPageTitle);
		String actLoginPageTitle = wdcl.getPageTitle();
		wdcl.verify(actLoginPageTitle, expLoginPageTitle);
		
		//3. Validate “Welcome, Please Sign In!” message
		String signinMsg = flib.getPropValue("signinMsg");
		String ActSigninMsg = loginMsg.getText();
		if(ActSigninMsg.equalsIgnoreCase(signinMsg))
		{
			System.out.println("\n\nExpected : "+signinMsg+"\nActual : "+ActSigninMsg +"\nTest case Passed");
		}
		else
		{
			System.out.println("\n\nExpected : "+signinMsg+"\nActual : "+ActSigninMsg +"\nTest case Failed");
		}
		
		//4. Log in with credentials
		untb.sendKeys(un);
		pwtb.sendKeys(pw);
		loginbtn.click();
		
		
		//5. Validate the user account ID on top right
		String expId = flib.getPropValue("username");
		String actId = accountId.getText();
		if(actId.equalsIgnoreCase(expId))
		{
			System.out.println("\n\nExpected: "+expId+"\nActual: "+actId+"\naccount ID is displayed");
		}
		else
		{
			System.out.println("\n\nExpected: "+expId+"\nActual: "+actId+"\nIncorrect account ID is displayed");
		}
	}	
}
