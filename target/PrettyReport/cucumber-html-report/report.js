$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/java/Features/WeatherReporting.feature");
formatter.feature({
  "name": "Validating Weather Reporting",
  "description": "",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "name": "Verify weather reporting done by two sources",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@WeatherReporting"
    },
    {
      "name": "@Regression"
    }
  ]
});
formatter.step({
  "name": "Select browser \"\u003cbrowser\u003e\" and launch website \"\u003curl\u003e\" and click on weather",
  "keyword": "Given "
});
formatter.step({
  "name": "Select city name \"\u003ccityName\u003e\" and validate temperature information",
  "keyword": "When "
});
formatter.step({
  "name": "get the temperature information for same city \"\u003ccityName\u003e\" using Rest Api",
  "keyword": "And "
});
formatter.step({
  "name": "validate temperature information received  by two sources",
  "keyword": "And "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "browser",
        "cityName",
        "url"
      ]
    },
    {
      "cells": [
        "Chrome",
        "Ajmer",
        "https://www.ndtv.com/"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Verify weather reporting done by two sources",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@WeatherReporting"
    },
    {
      "name": "@Regression"
    }
  ]
});
formatter.step({
  "name": "Select browser \"Chrome\" and launch website \"https://www.ndtv.com/\" and click on weather",
  "keyword": "Given "
});
formatter.match({
  "location": "WeatherReportingSteps.select_browser_and_launch_website(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Select city name \"Ajmer\" and validate temperature information",
  "keyword": "When "
});
formatter.match({
  "location": "WeatherReportingSteps.select_city_name_from_and_validate_temperature_information(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "get the temperature information for same city \"Ajmer\" using Rest Api",
  "keyword": "And "
});
formatter.match({
  "location": "WeatherReportingSteps.get_the_temperature_information_for_same_city_using_Rest_Api(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "validate temperature information received  by two sources",
  "keyword": "And "
});
formatter.match({
  "location": "WeatherReportingSteps.validate_temperature_information_received_by_two_sources()"
});
formatter.result({
  "error_message": "java.lang.Exception: Test case Failed\r\n\tat pageObject.WeatherReportingPage.temperature_information_received_by_two_sources(WeatherReportingPage.java:129)\r\n\tat stepDefination.WeatherReportingSteps.validate_temperature_information_received_by_two_sources(WeatherReportingSteps.java:30)\r\n\tat ✽.validate temperature information received  by two sources(file:src/test/java/Features/WeatherReporting.feature:7)\r\n",
  "status": "failed"
});
});