package eCommerce;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/* EmptyCart class is used to remove the item from the shopping cart.*/

public class EmptyCart {
	WebDriver driver;
	WebDriverWait wait;

	/*
	The class constructor takes the driver a parameter from caller and assigns that to this classes driver variable. 	
	 */
	
	public EmptyCart(WebDriver driver) {
		this.driver = driver;
	}
	
	/* removeItem method is used to remove the item from the shopping cart. */
	
	public void removeItem()
	{
		wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[starts-with(@id,'remove_item')])[1]"))).click();
		System.out.println("Items are removed");
	}

}
