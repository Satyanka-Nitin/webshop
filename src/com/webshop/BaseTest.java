package com.webshop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest implements IAutoConsts {
	public static WebDriver driver; 
	
	public void openBrowser() throws Throwable
	{
		FileLib flib = new FileLib();
		String browserName = flib.getPropValue("browser");
		if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty(CHROME_KEY, CHROME_VALUE);
			driver = new ChromeDriver();
		}
		
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			System.setProperty(GECKO_KEY, GECKO_VALUE);
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		String appUrl = flib.getPropValue("url");
		driver.get(appUrl);
	}
	
	public void closeBrowser()
	{
		driver.quit();
	}

}
