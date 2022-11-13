package pageObjects;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OffersPage {
	By search=By.xpath("//input[@type='search']");
	By productName=By.xpath("//tr/td[1]");
	public WebDriver driver;
	
	public OffersPage(WebDriver driver)
	{
		this.driver=driver;
	}
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
	  return driver.findElement(productName).getText();
	}
	
	public void maximizeWindow()
	{
		driver.manage().window().maximize();
	}
	
	
}
