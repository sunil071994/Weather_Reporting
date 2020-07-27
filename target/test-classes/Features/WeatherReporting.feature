Feature: Validating Weather Reporting
@WeatherReporting @Regression
Scenario Outline: Verify weather reporting done by two sources 
Given Select browser "<browser>" and launch website "<url>" and click on weather
When Select city name "<cityName>" and validate temperature information
And get the temperature information for same city "<cityName>" using Rest Api 
And validate temperature information received  by two sources 
	
Examples:
	|browser 	 | cityName   | url 					|
	|Chrome 	 | Ajmer	  |https://www.ndtv.com/    |