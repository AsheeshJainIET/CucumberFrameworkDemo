package pageObjects;

import org.openqa.selenium.WebDriver;
import pageObjects.LendingPage;
import pageObjects.PageObjectManager;
import utils.TestContextSetup;
public class PageObjectManager {
	public WebDriver driver;
	public LendingPage lendingPage;
	public OffersPage  offersPage;
	public CheckoutPage checkoutPage;

	public PageObjectManager(WebDriver driver)
	{
		
		this.driver=driver;
	}
	public LendingPage getLendingPage()
	{
		lendingPage=new LendingPage(driver);
		return lendingPage;
	}
	public OffersPage getOffersPage()
	{
		offersPage=new OffersPage(driver);
		return offersPage;
	}
	public CheckoutPage getCheckoutPage()
	{
		checkoutPage = new CheckoutPage(driver);
		return checkoutPage;
	}
}
