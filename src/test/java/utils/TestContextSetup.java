package utils;

import org.openqa.selenium.WebDriver;

import pageObjects.PageObjectManager;
import stepDefinitions.Hooks;

public class TestContextSetup {
	public WebDriver driver;
	public String lendingPageProductName;
	public PageObjectManager pageObjectManager;
	public TestBase testBase;
	public GenericUtils genericUtils;
	public TestContextSetup()
	{   
		testBase=new TestBase();
		pageObjectManager=new PageObjectManager(testBase.WebDriverManger());
		genericUtils=new GenericUtils(testBase.WebDriverManger());
		
		
	}
}
