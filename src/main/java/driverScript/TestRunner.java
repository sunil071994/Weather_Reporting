package driverScript;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/Features/WeatherReporting.feature", plugin = {
		"json:target/jsonReports/cucumber-report.json", "pretty",
		"html:target/PrettyReport/cucumber-html-report" }, glue = { "stepDefination" }, tags = { "@WeatherReporting" })

public class TestRunner {

}