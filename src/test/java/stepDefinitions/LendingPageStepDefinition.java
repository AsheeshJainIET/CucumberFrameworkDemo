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
import pageObjects.PageObjectManager;
import utils.TestContextSetup;
import utils.logs.Log;

public class LendingPageStepDefinition {
	public WebDriver driver;
	public String lendingPageProductName;
	public String offerPageProductName;
	TestContextSetup testContextSetup;
	LendingPage lendingPage;

	
	public LendingPageStepDefinition(TestContextSetup testContextSetup)
	{
	
		this.testContextSetup=testContextSetup;
		this.lendingPage =testContextSetup.pageObjectManager.getLendingPage();
	}
	
	@Given("User is on Greenkart Lending Page")
	public void user_is_on_greenkart_lending_page() {
		Log.info("Entering on lending page");
		Assert.assertTrue(lendingPage.getTitleLandingPage().contains("GreenKart"));
		
	}
	
	//^in begning and $ at end are required to put in case of data parameterization 
	@When("^user serached with Shortname (.+) and extracted the actual product name$")
	public void user_serached_with_shortname_and_extracted_the_actual_product_name(String shortname) throws InterruptedException {
		lendingPage.searchItem(shortname);
		Thread.sleep(1000);
		testContextSetup.lendingPageProductName=lendingPage.getProductName().split("-")[0].trim();
		System.out.println("Product Name extracted from Home Page is:"+testContextSetup.lendingPageProductName);

	}
	
	@When("Added {string} items of the selected product to cart")
	public void Added_items_product(String quantity)
	{
		
		lendingPage.incrementQuantity(Integer.parseInt(quantity));
		lendingPage.addToCart();
		
	}

}