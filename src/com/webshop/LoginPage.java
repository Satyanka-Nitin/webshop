package com.webshop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
    @FindBy(className="ico-login")private WebElement login;
	@FindBy(id="Email")private WebElement untb;
	@FindBy(id="Password")private WebElement pwtb;
	@FindBy(xpath="//input[@class='button-1 login-button']")private WebElement loginbtn;
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void login(String un, String pw)
	{
		login.click();
		untb.sendKeys(un);
		pwtb.sendKeys(pw);
		loginbtn.click();
		
	}
	
}
