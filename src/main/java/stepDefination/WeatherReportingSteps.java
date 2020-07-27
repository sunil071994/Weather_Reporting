package stepDefination;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageObject.WeatherReportingPage;

public class WeatherReportingSteps {

	WeatherReportingPage weatherReportingPage = new WeatherReportingPage();

	@Given("Select browser {string} and launch website {string} and click on weather")
	public void select_browser_and_launch_website(String browser, String url) throws Throwable {

		weatherReportingPage.launch_website(browser, url);
	}

	@When("Select city name {string} and validate temperature information")
	public void select_city_name_from_and_validate_temperature_information(String cityName) throws Throwable {
		weatherReportingPage.select_city_name(cityName);
	}

	@And("get the temperature information for same city {string} using Rest Api")
	public void get_the_temperature_information_for_same_city_using_Rest_Api(String cityName) throws Throwable {
		weatherReportingPage.temperature_information_for_same_city_using_Rest_Api(cityName);
	}

	@And("validate temperature information received  by two sources")
	public void validate_temperature_information_received_by_two_sources() throws Throwable {
		weatherReportingPage.temperature_information_received_by_two_sources();
	}
}
