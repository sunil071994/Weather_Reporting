package pageObject;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

//import static com.jayway.restassured.RestAssured.given;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import genericUtilities.CommonMethods;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class WeatherReportingPage extends CommonMethods {
	public static WebDriver driver;

	List<Double> listUI = new ArrayList<>();
	List<Double> listAPI = new ArrayList<>();

	By subMenu = By.xpath("//a[@id='h_sub_menu']");
	By WeatherlinkText = By.xpath("//a[text()='WEATHER']");
	By searchBox = By.xpath("//input[@id='searchBox']");
	By Condition = By.xpath("//b[contains(text(),'Condition')]");
	By Wind = By.xpath("//b[contains(text(),'Wind')]");
	By Humidity = By.xpath("//b[contains(text(),'Humidity')]");
	By tempInDegrees = By.xpath("//b[contains(text(),'Temp in Degrees')]");
	By tempInFahrenheit = By.xpath("//b[contains(text(),'Temp in Fahrenheit')]");

	public static void implicitWait(WebDriver driver, int time) {

		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);

	}

	public static void explicitWait(WebElement element, WebDriver driver, int time) {

		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.elementToBeClickable(element));

	}

	public void launch_website(String browser, String url) throws InterruptedException {
		System.out.println("Opening Browser:- " + browser);
		switch (browser) {

		case "Chrome":
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "/src/test/java/Browsers/chromedriver.exe");

			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			driver = new ChromeDriver(options);
			driver.get(url);
			driver.manage().window().maximize();
			break;

		}

		driver.findElement(subMenu).click();
		driver.findElement(WeatherlinkText).click();

	}

	public void select_city_name(String cityName) {

		driver.findElement(searchBox).sendKeys(cityName);

		if (!driver.findElement(By.xpath("//input[@id='" + cityName + "']")).isSelected()) {
			driver.findElement(By.xpath("//input[@id='" + cityName + "']")).click();
		}
		WebElement element = driver.findElement(By.xpath("//div[text()='" + cityName + "']"));
		explicitWait(element, driver, 10);
		element.click();
		System.out.println("Weather details");

		String HumidityUI = driver.findElement(Humidity).getText();
		String tempInDegreesUI = driver.findElement(tempInDegrees).getText();

		System.out.println(driver.findElement(Condition).getText());
		System.out.println(driver.findElement(Wind).getText());
		System.out.println(HumidityUI);
		System.out.println(tempInDegreesUI);
		System.out.println(driver.findElement(tempInFahrenheit).getText());

		listUI.add(stringToDoubleConversion(tempInDegreesUI));
		listUI.add(stringToDoubleConversion(HumidityUI));

		driver.quit();

	}

	public void temperature_information_for_same_city_using_Rest_Api(String cityName) {
		RestAssured.baseURI = "https://api.openweathermap.org";
		Response response = given().log().all().queryParam("q", cityName)
				.queryParam("appid", "7fe67bf08c80ded756e598d6f8fedaea").queryParam("units", "metric").when()
				.get("/data/2.5/weather");

		String strResponse = response.asString();
		System.out.println(strResponse);
		JsonPath jsonPath = new JsonPath(strResponse);
		double temperature = jsonPath.getDouble("main.temp");
		double humidity = jsonPath.getDouble("main.humidity");
		System.out.println("temperature value from API response - " + temperature);
		System.out.println("humidityvalue from API response - " + humidity);

		listAPI.add(temperature);
		listAPI.add(humidity);

	}

	public void temperature_information_received_by_two_sources() throws Exception {
		System.out.println("Validating temperature and humidity difference");
		if (compareWeatherObjects(listUI, listAPI)) {
			System.out.println("Test case Passed");
		} else {
			throw new Exception("Test case Failed");
		}

	}

}
