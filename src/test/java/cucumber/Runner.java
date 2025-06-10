package cucumber;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features="src/test/resources/FeatureFiles",
				 glue="stepDefinitions",
				 monochrome=true,
				 tags = "@createUser",
						 plugin = {
								    "pretty",
								    "html:target/cucumber-reports.html",
								    "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
		
				)
public class Runner extends AbstractTestNGCucumberTests {
	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios(){
		return super.scenarios();
	}

	
	

}