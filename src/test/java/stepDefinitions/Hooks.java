package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import managers.TestDriver;

public class Hooks {

	@Before
	public static void beforeScenario(Scenario scenario) {

		TestDriver.getDriver();
	}



	//@After
	public static void afterScenario(Scenario scenario) {


		TestDriver.closeDriver();
	}


}
