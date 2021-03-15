package com.webshop.generic;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * This generic class contains reusable methods of WebDriver interface
 * @author Satyanka Arava
 */
public class WebDriverCommonLib extends BaseTest {
	
	/**
	 * This generic reusable method is used to get page Title
	 * @return
	 */
	public String getPageTitle()
	{
		String title = driver.getTitle();
		return title;
	}
	
	/**
	 * This generic reusable method is used to mouse hover on a particular element
	 * @param element
	 */
	public void mouseHover(WebElement element) 
	{
		Actions ac = new Actions(driver);
		ac.moveToElement(element).perform();
	}
	
	/**
	 * This generic reusable method is used to right click on particular element
	 * @param element
	 */
	public void rightClick(WebElement element)
	{
		Actions ac = new Actions(driver);
		ac.contextClick(element).perform();
	}
	
	/**
	 * This generic reusable method is used to select option by visible text from drop-down. 
	 * @param element
	 * @param text
	 */
	public void selectOption(WebElement element, String text)
	{
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}
	
	/**
	 * This generic reusable method is used to select option by value from drop-down.
	 * @param value
	 * @param element
	 */
	public void selectOption(String value, WebElement element)
	{
		Select sel = new Select(element);
		sel.selectByValue(value);
	}
	
	/**
	 * This generic reusable method is used to select option by index number from drop-down.
	 * @param element
	 * @param index
	 */
	public void selectOption(WebElement element, int index)
	{
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}
	
	/**
	 * This generic reusable method is used to give explicitly wait until the condition is satisfied or max time reached
	 * @param title
	 */
	public void waitForPageTitle(String title)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.titleContains(title));		
	}
	
	/**
	 *This generic reusable method is used to give explicitly wait until the condition is satisfied or max time reached
	 * @param element
	 */
	public void waitForVisibleText(WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(element));		
	}
	/**
	 * This generic reusable method is used to verify Title of the page
	 * @param actualTitle
	 * @param expectedTitle
	 * @param page
	 */
	public void verify(String actualTitle, String expectedTitle) 
	{
		if(actualTitle.equals(expectedTitle))
		{
			System.out.println("\n\n"+actualTitle+" is displayed, Test Step Passed\n\n");
		}
		else
		{
			System.out.println("\n\n"+actualTitle+" is not displayed, Test Step Failed\n\n");
		}
	}

}
