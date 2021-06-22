package stepDefinitions;

import context.TestContext;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helpers.HelperMethods;
import pages.HomePage;
import pages.Login;
import helpers.Props;
import managers.BaseDriver;

import org.junit.Assert;
import org.openqa.selenium.Dimension;
 


public class LoginSteps extends BaseDriver {

	private TestContext context;
	private final HomePage homePage;
	private final Login login;
	private final HelperMethods helperMethods;
	private final Props props;

	public LoginSteps(TestContext context) {
		this.context = context;
		homePage = context.getPageObjectManager().getHomePage();
		login = context.getPageObjectManager().getLogin();
		helperMethods = context.getPageObjectManager().getHelperMethods();
		props = context.getPageObjectManager().getProps();

	}

	@Given("^I click on Sign In button on homepage$")
	public void click_on_login() {
		if (getBrowserName().equals("MOBILE-Chrome")) {
			login.mobileMenuIcon().click();
		} else {
			login.clickOnLogin();
		}
	}

	@When("^I enter (.+) as email$")
	public void enter_email(String email) {
		login.emailTextInput().sendKeys(email);
	}

	@When("^I enter (.+) as password$")
	public void enter_password(String password) {
		login.passwordTextInput().sendKeys(password);
	}

	@And("^I click on login button$")
	public void click_submit() {
		login.submitButton().click();
	}

	@Then("^I verify that I am successfully logged in$")
	public void verify_successful_login() {
		helperMethods.waitOnElementToBeVisible(login.myAccountHeading(), 20);
		Assert.assertTrue(login.myAccountHeading().isDisplayed());

	}

	@When("^I enter invalid password$")
	public void enter_invalid_password() {
		login.passwordTextInput().sendKeys(props.getProperty("user.invalidPassword"));
	}

	@Then("^I verify that an error is displayed as (.+)$")
	public void verify_error(String error) {
		Assert.assertTrue(login.signInError().isDisplayed());
	}

	@Then("^I verify the errors to enter username and password are displayed$")
	public void verify_errors() {
		Assert.assertTrue(login.inlineUserNameError().isDisplayed());
		Assert.assertTrue(login.inlinePasswordError().isDisplayed());

	}

	//Need to remove this and put somewhere else as code is repeating may times
	@And("^I click on accept cookies$")
	public void accept_cookies()
	{
		homePage.acceptCookies();
	}


	@Given("^I login as an individual (.+)$")
	public void login_as_individual(String user) {
		homePage.acceptCookies();
		System.out.println("Hello");

		if (getBrowserName().equals("MOBILE-Chrome")) {
			login.mobileMenuIcon().click();
			login.MobileSignInButton().click();

		} else if (getBrowserName().equals("TABLET-Chrome")) {
			login.tabletSignIn().click();
			login.TabletSignInButton().click();
		} else {
			login.webSignIn().click();
			login.WebSignInButton().click();
		}
		//login.signInButton().click();
		login.emailTextInput().sendKeys(props.getProperty("individual" + user + ".email"));
		login.passwordTextInput().sendKeys(props.getProperty("individual" + user + ".password"));
		login.submitButton().click();
		helperMethods.waitOnElementToBeEnabled(homePage.homeImage(), 20);
	}




	@And("^I enter email for guestuser (.+)$")
	public void EnterInputforGuestUser(String user)
	{
		//login.emailInputGuestUser().clear();
		login.emailInputGuestUser().sendKeys(props.getProperty("guestuser" + user + ".email"));
	}


}