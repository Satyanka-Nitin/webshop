package com.webshop.generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * 
 * @author Satyanka Arava
 *
 */
public class BaseTest implements IAutoConsts {
	public static WebDriver driver; 
	
	/**
	 * This generic reusable method is used to open required browser and enter required Test URL
	 * @throws Throwable
	 */
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
		String expHomePageTitle = flib.getPropValue("homepageTitle");
		WebDriverCommonLib wdcl = new WebDriverCommonLib();
		wdcl.waitForPageTitle(expHomePageTitle);
		String actHomePageTitle = wdcl.getPageTitle();
		wdcl.verify(actHomePageTitle, expHomePageTitle);
		
		
	}
	
	/**
	 * This generic reusable method is used to close the browser
	 */
	public void closeBrowser()
	{
		driver.quit();
	}

}
