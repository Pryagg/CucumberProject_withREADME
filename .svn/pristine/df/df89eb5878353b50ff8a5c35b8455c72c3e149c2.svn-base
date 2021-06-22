package stepDefinitions;

import context.TestContext;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import helpers.HelperMethods;
import org.openqa.selenium.By;
import pages.Categories;
import pages.OrderConfirmation;
import pages.Payment;
import pages.Products;


public class PaymentSteps {
	TestContext testContext;
	 Categories categories;
	 Products products;
	Payment payment;
	OrderConfirmation orderConfirmation;
	HelperMethods helperMethods;
	
	public PaymentSteps(TestContext context) {
		testContext = context;
		 categories = context.getPageObjectManager().getCategories();
		 products = context.getPageObjectManager().getProducts();
		payment = context.getPageObjectManager().getPaygment();
		helperMethods = context.getPageObjectManager().getHelperMethods();
		orderConfirmation = context.getPageObjectManager().getOrderConfirmation();
	}
		
	@When("^I click on Proceed to Purchase button$")
	public void click_proceed_to_purchase() {
		try {
		if (!payment.ProceedToPurchaseButton().isDisplayed()){
			products.AddToCartButtons().get(0).click();
		}} catch (Exception e){
			System.err.println("Add to cart button is not clickable" + e.getMessage());
			}
		payment.ProceedToPurchaseButton().click();
//		helperMethods.waitOnElementToBeVisible(payment.shippingMethodHeading(), 20);;
		
	}
	
	@When("^I click on continue button on (.+) page$")
	public void click_continue(String page) {
		switch(page) {
		
		case "shipping":
			try {
			if (payment.shippingContinueButton().isDisplayed()) {
				payment.shippingContinueButton().click();
				helperMethods.waitOnElementToBeInvisible(payment.shippingContinueButton(), 10);
			}  } catch (Exception e)
		{
			System.err.println("Continue on shipping address is not displayed. " + e.getMessage());
		}
			break;
			
			
		case "shipping method": 
			helperMethods.waitOnElementToBeClickable(payment.shippingMethodContinueButton());
			payment.shippingMethodContinueButton().click();
			helperMethods.waitOnElementToBeInvisible(payment.shippingMethodContinueButton(), 10);
			break;
			
		case "billing address":
			try {
			if (payment.billingAddressContinueButton().isDisplayed()) {
			helperMethods.click(payment.billingAddressContinueButton());
			} } catch (Exception e)
			{
				System.err.println("Continue on shipping address is not displayed. " + e.getMessage());
			}
			break;
			
		case "payment":
			payment.paymentContinueButton().click();
			break;

		case "Keep in touch":
				orderConfirmation.KeepintouchContinueButton().click();
				break;
			
		case "terms":
			helperMethods.waitForXSeconds(20);
			orderConfirmation.termsContinueButton().click();
			helperMethods.waitOnElementToBeInvisible(orderConfirmation.termsContinueButton(), 10);

			break;

			case "guest user login":
			payment.guestLoginContinueButton().click();
			helperMethods.waitOnElementToBeInvisible(payment.guestLoginContinueButton(), 10);
				break;

		}
	}

	/*@When("^I select payment method as mail us a check$")
	public void select_mail_us_a_Scheck() {
		try{
		if(payment.mailUsACheckPaymentMethod().isDisplayed()) {
			payment.mailUsACheckPaymentMethod().click();
			helperMethods.waitForXSeconds(50);
			payment.mailUsACheckContinueButton().click();
		}
		else{
			helperMethods.waitForXSeconds(50);
			payment.paymentInTheProgressBar().click();
			helperMethods.waitForXSeconds(20);
			payment.paymentContinueButton().click();
		}
		} catch(Exception e) {
			System.err.println("payment details are displayed to select the payment method." +e.getMessage());

		}
	}*/

	@When("^I select payment method as (.+)$")
	public void select_payment_method(String payment_option )
	{
		switch (payment_option)
		{
			case "mail us a check":
				try{
					if(payment.mailUsACheckPaymentMethod().isDisplayed()) {
						payment.mailUsACheckPaymentMethod().click();
						helperMethods.waitForXSeconds(50);
						payment.mailUsACheckContinueButton().click();
					}
					else{
						helperMethods.waitForXSeconds(50);
						payment.paymentInTheProgressBar().click();
						helperMethods.waitForXSeconds(20);
						payment.paymentContinueButton().click();
					}
				} catch(Exception e) {
					System.err.println("payment details are displayed to select the payment method." +e.getMessage());

				}
				break;
			case "echeck":
			case "imt":
			case "fax":

		}
	}

}
