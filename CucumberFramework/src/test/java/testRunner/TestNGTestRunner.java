package testRunner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(  
	    features = "src/test/resources/Features",
	    glue="stepDefinitions",
	    monochrome=true,
	    plugin= {"pretty","html:target/cucumber.html", "json:target/cucumber.json",
	    		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:","rerun:target/failed_scenario.txt"},
	    tags= "@Sanity or @Regression"
	    )
public class TestNGTestRunner extends AbstractTestNGCucumberTests {
	// To run all scenarios of features in parallel mode
	@Override
	@DataProvider(parallel=true)
	public Object[][] scenarios()
	{
		return super.scenarios();
	}
        
}
