package eCommerce;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/* ClickandAdd class is used to click on the item and add it to the shopping cart. */

public class ClickandAdd {

	WebDriver driver;
	WebDriverWait wait;
	
/*	The class constructor takes the driver a parameter from caller and assigns that to this classes driver variable. */

	public ClickandAdd(WebDriver driver) {
		this.driver = driver;
	}
	
/* ClickandAddItem method is used to click on a item and select the size, quantity and color and add it to the shopping cart. */

	public void ClickandAddItem() throws Exception
	{
		wait = new WebDriverWait(driver,60);
		Thread.sleep(3000);
		
		// Clicking on the first item in the page
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@id='thumbnails']/li[not(contains(@id,'grid'))][1]"))).click();
		
		// find all the available sizes and select the first one
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[starts-with(@id,'orderPanel')]/div[2]//li[@aria-disabled='false'][1]"))).click();
		System.out.println("Just selected the size");
		Select Qty = new Select(driver.findElement(By.xpath("//form[@class='standard-form']/select")));
		Qty.selectByVisibleText("2");

		try
		{
			// find all available colors and select the first one
			driver.findElement(By.xpath("//*[starts-with(@id,'orderPanel')]/div[1]//li[@aria-disabled='false'][1]")).click();
		}
		catch(Exception e)
		{

		}

		// click on "Add to Bag" button
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@id,'orderPanel')]//button"))).click();
		Thread.sleep(5000);
		
		// click on the shopping bag link to checkout
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("checkoutLink"))).click();
	}
}
