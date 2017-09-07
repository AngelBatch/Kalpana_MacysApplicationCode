package eCommerce;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
 * FillCheckOutDetails class is used to check the mandatory fields during the checkout process. The class has one constructor that takes
 * driver as the parameter and has one method checkOutDetails.
 */
public class FillCheckOutDetails {
	WebDriver driver;
	WebDriverWait wait;

	public FillCheckOutDetails(WebDriver driver) {
		this.driver = driver;
	}

	/*
	 * Method checkOutDetails checks for all the mandatory fields during the checkout process and displays the id's for the fileds. 
	 */
	public void checkOutDetails()
	{
		wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("continueCheckout"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='isWithoutProfile']/span"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='rc-shipping-continue']"))).click();
		List<WebElement> Fields = driver.findElements(By.xpath("//*[@aria-required='true']"));
		System.out.println("The number of mandatory shipping fields are :" + Fields.size());
		System.out.println("The names of the fields are : \n");
		for(int i=0;i<Fields.size();i++)
		{
			System.out.println(Fields.get(i).getAttribute("id"));
		}
	}
}