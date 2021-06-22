package stepDefinitions;

import context.TestContext;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helpers.HelperMethods;
import pages.Account;
import pages.Categories;
import pages.HomePage;
import pages.Login;
import helpers.Props;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
 


public class AccountSteps {
	
	TestContext context;
	HomePage homePage;
	Login login;
	HelperMethods helperMethods;
	Props props;
	Account account;
	 
	 public AccountSteps(TestContext context) {
	 this.context = context;
	 homePage = context.getPageObjectManager().getHomePage();
	 login = context.getPageObjectManager().getLogin();
	 helperMethods = context.getPageObjectManager().getHelperMethods();
	 props = context.getPageObjectManager().getProps();
	 account = context.getPageObjectManager().getAccount();

	 } 

	
		@Then("^I enter personal information on accounts Page$")
		public void enter_personal_information() {
	 		homePage.acceptCookies();
//			account.firstNamePersonalTextInput().sendKeys(helperMethods.generateRandomString(8));
			account.firstNamePersonalTextInput().sendKeys("First"+" - "+"Test" + " - " + RandomStringUtils.randomAlphabetic(8));
			account.lastNamePersonalTextInput().sendKeys("Last"+" - "+"Test" + " - " + RandomStringUtils.randomAlphabetic(8));
			account.emailPersonalTextInput().sendKeys("AutoTest" + "_" + helperMethods.generateRandomString(6) + "@pacificict.co.nz");
			String email = account.emailPersonalTextInput().getAttribute("value");
			account.confirmEmailPersonalTextInput().sendKeys(email);
			account.createPasswordPersonalTextInput().sendKeys("abcde");
			account.reEnterPasswordPersonalTextInput().sendKeys("abcde");
			account.phonePersonalTextInput().sendKeys(helperMethods.generateRandomNumber(8));
			account.ageConfirmationCheckBox().click();
			account.selectBirthdate();

		}
	
		@And("^Verify My Account registration page opens$")
		public void view_myAccount() {
			helperMethods.implicitWait(500);
			Assert.assertEquals(account.myRegistrationPage().getText(), "My Account - Registration");
		}

		@Then("^I enter billing information on accounts Page$")
		public void enter_billing_information() {
			String firstName = account.firstNamePersonalTextInput().getAttribute("value");
			account.firstNameBillingTextInput().sendKeys(firstName);
			String lastName = account.lastNamePersonalTextInput().getAttribute("value");
			account.lastNameBillingTextInput().sendKeys(lastName);
			String phone = account.phonePersonalTextInput().getAttribute("value");
			account.phoneBillingTextInput().sendKeys(phone);
			account.address1BillingTextInput().sendKeys(props.getProperty("randomIndividual.address"));
			account.cityBillingTextInput().sendKeys(props.getProperty("randomIndividual.city"));
			account.selectCountry("United States");
			helperMethods.waitOnElementToBeEnabled(account.stateBillingDropdown(),20);
			account.selectState("Alaska");
			account.zipBillingTextInput().sendKeys(props.getProperty("randomIndividual.zip"));

		}


		@And("^I tick my shipping address is same as my billing$")
		public void Tick_shipping_same_as_billing() {
            helperMethods.clickElementActions(account.shippingIsBillingCheckBox());
			account.shippingIsBillingCheckBox().click();
		}

		@Then("^tick all privacy preferences$")
		public void tick_privacy_preferences(){
	 		account.importantChangesCheckBox().click();
	 		account.socialMediaCheckBox().click();
	 		account.discountsCheckBox().click();
		}

		@And("^I create my account$")
		public void submit_registration(){
	 		account.createAccountButton().click();
		}
		@Then("^I verify that my account page displays$")
		public void verify_my_account_page(){
	 		Assert.assertTrue(account.myAccountPageHeading().isDisplayed());
		}

}