package utils;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

import pageObjects.LendingPage;

public class GenericUtils {
	public WebDriver driver;
	public GenericUtils(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void switchWindowToChild()
	 {
		 // to check if already switched to offers page
		
	      Set<String> childWindows=driver.getWindowHandles();
	      Iterator<String> it=childWindows.iterator();
	      String parentWindow=it.next();
	      String childWindow=it.next();
	      driver.switchTo().window(childWindow);
		 
	
     }

}
