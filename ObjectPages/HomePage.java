package eCommerce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
	HomePage class : This class is used to Select a department and a category for our search.
	The class has two methods selectProduct and countItems
 */

public class HomePage {
	WebDriver driver;
	WebDriverWait wait;

/*
 	The class constructor takes the driver a parameter from caller and assigns that to this classes driver variable. 	
 */
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
	}

/*
	selectProduct() : This method hovers over the department given (JUNIORS here) and hovers over a 
	category before clicking on the category
 */

	public void selectProduct() throws InterruptedException
	{
		Actions action = new Actions(driver);
		Thread.sleep(3000);
		action.moveToElement(driver.findElement(By.xpath("//*[starts-with(@id,'flexid')]/a[text()='JUNIORS']")));
		Thread.sleep(3000);		
		action.moveToElement(driver.findElement(By.xpath("//*[starts-with(@id,'flexid')]//li[8]/a[text()='Jeans']")));
		action.click();
		action.perform();
	}

/*
	countItems() : 	This method searches for search result and returns the total number of items returned. 
 				The method returns the total number extracted to the caller.
 */
	public int countItems()
	{
		wait = new WebDriverWait(driver,30);
		String expected_count = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(("productCount")))).getText();
		System.out.println("The expected number of Jeans are " + expected_count);
		int expectedCount = Integer.parseInt(expected_count);
		return expectedCount;
	}
}