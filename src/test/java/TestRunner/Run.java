package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		//features = ".//Feature/Customers.feature",
		//features = ".//Feature/",       // to run all feature file
		features = {".//Feature/Customers.feature", ".//Feature/login.feature"},  // to run selected features
		glue="StepDefination",
		dryRun = false,   // he jar true kele tr UI run hot nahi
		monochrome = true,
		//tags = "@Sanity",
		//tags = "@Sanity and @Regression",    --- both will run
		//tags = "@Sanity or @Regression",     --- run where tag is sanity or regression
         //tags = "@Sanity and not @Regression",     ---- run only sanity
		plugin= {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
	  // plugin = {"pretty","html:target/TestReports/report1.html"}
	//	plugin = {"pretty","json:target/TestReports/report1.json"}   - to genarte report in json format
	//	plugin = {"pretty","junit:target/TestReports/report1.xml","html:target/TestReports/report1.html","json:target/TestReports/report1.json"}   - all in one reports we can generate
		)
		


public class Run 
{
// This class will be empty
}
