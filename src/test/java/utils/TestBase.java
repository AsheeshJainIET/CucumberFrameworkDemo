package utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
public WebDriver driver;
public String baseURL;

	public WebDriver WebDriverManger()
	{   
		
		if (driver==null)
	     {
			
		ConfigReader configReader=new ConfigReader();
		String browser_properties = configReader.property.getProperty("browser");
		String browser_maven=System.getProperty("browser");
		// result = testCondition ? value1 : value2
		String browser = browser_maven!=null ? browser_maven : browser_properties;
		if(browser.equalsIgnoreCase("chrome"))
		{
		System.setProperty("webdriver.chrome.driver", configReader.property.getProperty("driverPath"));
		driver=new ChromeDriver();
		}
		if(browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver",configReader.property.getProperty("driverPath"));
			driver = new FirefoxDriver();
		}
		if(browser.equalsIgnoreCase("Edge"))
		{
			System.setProperty("webdriver.edge.driver",configReader.property.getProperty("driverPathEdge"));
			driver = new EdgeDriver();
		}
		String implicitWaitTime=configReader.property.getProperty("implicitWait");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(implicitWaitTime)));
		baseURL=configReader.property.getProperty("baseURL");
		driver.get(baseURL);
		driver.manage().window().maximize();
	    }
		return driver;
	}
	
}
