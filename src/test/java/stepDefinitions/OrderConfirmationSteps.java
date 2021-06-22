package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helpers.HelperMethods;
import org.junit.Assert;

import context.TestContext;
import pages.OrderConfirmation;

public class OrderConfirmationSteps {
	TestContext testContext;
	OrderConfirmation orderConfirmation;
	HelperMethods helperMethods;
	
	public OrderConfirmationSteps(TestContext context) {
		testContext = context;
		orderConfirmation = context.getPageObjectManager().getOrderConfirmation();
		helperMethods = context.getPageObjectManager().getHelperMethods();
	}
	
	@When("^I select all the terms$")
	public void select_terms() {
		orderConfirmation.personalUseTerm().click();
		orderConfirmation.prescribedMedicinesTerm().click();
//		orderConfirmation.covidTerm().click();

		if(orderConfirmation.over18Term().isDisplayed())
		{
			orderConfirmation.over18Term().click();
			//select DOB- year,month and date

			if(orderConfirmation.clickDOB().isDisplayed())
			{
				orderConfirmation.clickDOB().click();
			}
			orderConfirmation.selectYearofDOB().click();
			orderConfirmation.selectYearofDOB().sendKeys("1985");
			orderConfirmation.selectMonthofDOB().click();
			orderConfirmation.selectMonthofDOB().sendKeys("January");
			orderConfirmation.selectDateofDOB().click();
			orderConfirmation.selectDateofDOB().sendKeys("2");
		}
	}

	@And("^I enter doctor's name$")
	public void enter_doctor_name(){ orderConfirmation.doctortNameTextInput().clear();
	orderConfirmation.doctortNameTextInput().sendKeys("Greg Barter");}
	
	@And("^I enter patient's name$")
	public void enter_patient_name() {
		orderConfirmation.patientNameTextInput().sendKeys("Anna Bek");
	}

	@And("^I select to create account for guest user (.+)$")
			public void create_account_guest_user(String account_creation)
	{
		switch(account_creation) {
			case "yes":
				helperMethods.waitOnElementToBeVisible(orderConfirmation.createAccountGuestUserYes(),10);
				orderConfirmation.createAccountGuestUserYes().click();
				break;

			case "no":
				helperMethods.waitOnElementToBeVisible(orderConfirmation.createAccountGuestUserNo(),10 );
				orderConfirmation.createAccountGuestUserNo().click();
				break;
		}
	}
	
	@Then("^I click on Complete Order Now$")
	public void click_complete_order() {
		helperMethods.waitOnElementToBeVisible(orderConfirmation.completeOrderButton(), 07);
		helperMethods.waitForXSeconds(03);
		orderConfirmation.completeOrderButton().click();
	}
	
	@Then("^I verify that the order is successfully placed$")
	public void verify_successful_order() {
		helperMethods.waitOnElementToBeVisible(orderConfirmation.orderConfirmationHeading(), 20);
		Assert.assertTrue(orderConfirmation.orderConfirmationHeading().isDisplayed());
	}

}
