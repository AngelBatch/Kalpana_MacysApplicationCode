package eCommerce;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/*
	ProductCount class : This class is used to count the total number of selected items displayed in all pages.
	It has two methods countItems and countItemsDisplayed.
 */

public class ProductCount {
	WebDriver driver;

	/*
	The class constructor takes the driver a parameter from caller and assigns that to this classes driver variable. 	
	 */

	public ProductCount(WebDriver driver) {
		this.driver = driver;
	}

	/* CountItems : This method is used to count the total number of selected items displayed in each page */

	public int countItems()
	{
		List<WebElement> itemList = driver.findElements(By.xpath("//ul[@class='thumbnails large-block-grid-3 csg_v1']/li[@class='productThumbnail borderless']"));
		System.out.println("The number of Jeans in the page are " + itemList.size());
		return itemList.size();
	}

	/* countItemsDisplayed : This method is used to count the total number of selected items displayed in all the pages. */	

	public int countItemsDisplayed() throws InterruptedException 
	{
		boolean items = true;

		/* Using HashMap to display the page number and the number of items displayed in each page. */

		HashMap<Integer, Integer> pageItems = new HashMap<Integer, Integer>();

		int pageno = 1;
		int totalItems=0 ;

		System.out.println(driver.getTitle());
		// Boolean variables "items" is true as long as the next page arrow is present along with page numbers.

		while(items)
		{
			System.out.println("Page : " + pageno);
			System.out.println(driver.getCurrentUrl());			
			Thread.sleep(7000);									  
			pageItems.put(pageno, countItems());
			System.out.println(pageItems.get(pageno));
			totalItems=pageItems.get(pageno)+totalItems;

			try
			{
				// finding the right arrow indicator 

				driver.findElement(By.xpath("//a[@class='arrowRight arrowButton paginationSpacer']")).click();
				pageno = pageno + 1;

			}
			catch(Exception e)
			{
				items=false;
			}
		}
		System.out.println(totalItems);
		return totalItems;
	}
}
