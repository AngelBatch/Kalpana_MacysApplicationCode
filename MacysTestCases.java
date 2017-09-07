package eCommerce;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MacysTestCases {
	public WebDriver driver;
	HomePage hPage;
	ClickandAdd myCart;
	ProductCount pCount;
	EmptyCart emptyCart;
	FillCheckOutDetails checkOut;
	@Parameters({"url"})
	@BeforeTest
	public void setUp(String url)
	{
		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get(url);
		hPage = new HomePage(driver);
		myCart = new ClickandAdd(driver);
		pCount = new ProductCount(driver);
		emptyCart = new EmptyCart(driver);
		checkOut = new FillCheckOutDetails(driver);
		
		System.out.println("In Beforetest");
	}
	
	@Test(priority = 1, description = "Verifying the Product Count")
	public void VerifyProductCount() throws InterruptedException
	{
		hPage.selectProduct();
		int expectedCount = hPage.countItems();
		int totalItems = pCount.countItemsDisplayed();
		assertEquals(expectedCount,totalItems);
		System.out.println("Test Case 1 is Completed Successfully");
	}

	@Test(priority = 2, description = "Adding the Product to the cart and removing it")
	public void AddandRemoveProduct() throws Exception
	{
		hPage.selectProduct();
		System.out.println("The item is selected");
		myCart.ClickandAddItem();
		emptyCart.removeItem();
		System.out.println("Test Case 2 is Completed Successfully");
	}

	@Test(priority = 3, description = "Verifying the mandatory fields in Checkout")
	public void VerifyCheckOutDetails() throws Exception
	{
		hPage.selectProduct();
		myCart.ClickandAddItem();		
		checkOut.checkOutDetails();
		System.out.println("Test Case 3 is Completed Successfully");
	}
}
