package stepDefinitions;

import context.TestContext;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import helpers.HelperMethods;
import helpers.Props;
import pages.*;

public class ShippingSteps extends BasePage {

    TestContext context;
    HomePage homePage;
    Login login;
    HelperMethods helperMethods;
    Props props;
    Shipping shipping;
    Account account;


    public ShippingSteps(TestContext context) {
        this.context = context;
        homePage = context.getPageObjectManager().getHomePage();
        login = context.getPageObjectManager().getLogin();
        helperMethods = context.getPageObjectManager().getHelperMethods();
        props = context.getPageObjectManager().getProps();
        shipping = context.getPageObjectManager().getShipping();
        account = context.getPageObjectManager().getAccount();

    }


    @Then("^I enter (.+) information on checkout for individual(.+)$")
    public void enter_billing_information(String addressinformation, String user)
    {

        switch(addressinformation)
        {
            case "shipping":
            {

                shipping.firstNameShippingAddressShippingPage().sendKeys(props.getProperty("individual" + user + ".firstname"));
                shipping.lastNameShippingAddressShippingPage().sendKeys(props.getProperty("individual" + user + ".lastname"));
                shipping.phoneShippingAddressShippingPage().sendKeys(props.getProperty("individual" + user + ".phonenumber"));
                shipping.companyShippingAddressShippingPage().sendKeys(props.getProperty("individual" + user + ".company"));
                shipping.address1ShippingAddressShippingPage().sendKeys(props.getProperty("individual" + user + ".address1"));
                shipping.address2ShippingAddressShippingPage().sendKeys(props.getProperty("individual" + user + ".address2"));
                shipping.cityShippingAddressShippingPage().sendKeys(props.getProperty("individual" + user + ".city"));
                shipping.selectCountryShippingPage("United States");
                //helperMethods.scrollUntilVisible(shipping.selectStateShippingPage("Alabama"));
                shipping.selectStateShippingPage("Alabama");
                shipping.zipcodeShippingAddressShippingPage().sendKeys(props.getProperty("individual" + user + ".zipcode"));
            }
            case "billing":
            {

            }
            case "personal":
            {

            }
        }

    }

    @And("^I select Shipping method (.+)$")
        public void select_shipping_method(String shipping_method)
        {
            switch(shipping_method)
            {
                case "free registered":
                    shipping.selectshippingMethodFreeRegistered();
                    break;
                case "free standard":
                    shipping.selectshippingMethodFreeStandard();
                    break;
                case "express mail":
                    shipping.selectshippingMethodExpressMail();
                    break;
            }
        }

        @And("^I select billing address same as Shipping (.+)$")
    public void select_billing_address(String billingAdress_option)
        {
            switch(billingAdress_option)
            {
                case "yes":
                    shipping.selectBillingAddressSameAsShippingYes().click();
                    break;
                case "no":
                    shipping.selectBillingAddressSameAsShippingNo().click();
                    break;
            }
        }





}

