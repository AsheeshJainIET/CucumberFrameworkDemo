package stepDefinitions;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import utils.TestContextSetup;
import org.apache.commons.io.FileUtils;

public class Hooks {
public WebDriver driver;
TestContextSetup testContextSetup;
   public Hooks(TestContextSetup testContextSetup)
   {
	   this.testContextSetup=testContextSetup;
   }

  
    @After
	public void closeBrowser() throws IOException
	{
    	testContextSetup.testBase.WebDriverManger().quit();
		
	}
    
    @AfterStep
    public void getScreenshot(Scenario scenario) throws IOException
	{
    	driver=testContextSetup.testBase.WebDriverManger();
    	if(scenario.isFailed())
    	{
    	TakesScreenshot scrShot =(TakesScreenshot)driver;
    	File src=scrShot.getScreenshotAs(OutputType.FILE);
    	byte[] screenShot=FileUtils.readFileToByteArray(src);
		scenario.attach(screenShot, "image/png",scenario.getName() );
    	}
	}

	
}
