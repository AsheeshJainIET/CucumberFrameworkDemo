package stepDefinitions;

import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LendingPage;
import pageObjects.OffersPage;
import pageObjects.PageObjectManager;
import utils.TestContextSetup;

public class OfferPageStepDefinition {
	public WebDriver driver;
	public String lendingPageProductName;
	public String offerPageProductName;
	TestContextSetup testContextSetup;
	PageObjectManager pageObjectManager;
	OffersPage offerPage;
	
	public OfferPageStepDefinition(TestContextSetup testContextSetup)
	{
		this.testContextSetup=testContextSetup;
		this.offerPage =testContextSetup.pageObjectManager.getOffersPage();
	}
	 
	//^in begning and $ at end are required to put in case of data parameterization 
	 @Then("^user serached for (.+) shortname in offers page$")
	  public void user_serached_for_something_shortname_in_offers_page(String shortname) throws InterruptedException {
      //testContextSetup.driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortname);
		 switchToOffersPagse();
	  Thread.sleep(2000);
	  offerPage.searchItem(shortname);
      Thread.sleep(2000);
      offerPageProductName= offerPage.getProductName();
      System.out.println(offerPageProductName);
	}
	 @And("validate product name in offers page matches with Lending page")
	    public void validate_product_name_in_offers_page_matches_with_lending_page(){
		 Assert.assertEquals(offerPageProductName,testContextSetup.lendingPageProductName);
	    }
	 public void switchToOffersPagse()
	 {
		 // to check if already switched to offers page
		    
			 LendingPage lendingPage= testContextSetup.pageObjectManager.getLendingPage();
			 lendingPage.selectTopDealsPage();
			 lendingPage.maximizeWindow();
			 testContextSetup.genericUtils.switchWindowToChild();
		 

      }

	 }

