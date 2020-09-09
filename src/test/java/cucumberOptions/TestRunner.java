package cucumberOptions;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

//import io.cucumber.testng.CucumberOptions;

@RunWith(Cucumber.class) // if u running with junit u need to add this otherwise u need to extend the
							// abstract testng class

@CucumberOptions(features = { "src/test/java/features" },
glue = {"stepDefinations" }, 
monochrome = true, 
tags = {"@Smoke","@Regression"}, 
plugin = { "pretty", "html:CucumberReport/cucumber-html-reports","json:target/cucumber.json","junit:target/cucumber.xml","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})

public class TestRunner {

}
