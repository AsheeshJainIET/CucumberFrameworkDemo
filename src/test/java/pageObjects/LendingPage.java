package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.TestContextSetup;

public class LendingPage {
	public WebDriver driver;
	public LendingPage(WebDriver driver)
	{
		this.driver=driver;
	}
	By search=By.xpath("//input[@type='search']");
	By productname=By.cssSelector("h4.product-name");
	By topdeals=By.linkText("Top Deals");
	By increment=   By.cssSelector("a.increment");
	By addToCart = By.cssSelector(".product-action button");
	
	public void searchItem(String name)
	{
	  driver.findElement(search).sendKeys(name);
	}
	
	public void getText()
	{
	  driver.findElement(search).getText();
	}
	
	public String getProductName()
	{
	  return driver.findElement(productname).getText();
	}
	public void selectTopDealsPage()
	{
		driver.findElement(topdeals).click();
	}
	public String getTitleLandingPage()
	{
		return driver.getTitle();
    }
	
	public void maximizeWindow()
	{
		driver.manage().window().maximize();
	}
	
	public void incrementQuantity(int quantity)
	{
		int i = quantity-1;
		while(i>0)
		{
			driver.findElement(increment).click();
			i--;
		}
		
	}
	
	public void addToCart()
	{
		driver.findElement(addToCart).click();
	}
}
  

