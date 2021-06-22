package stepDefinitions;

import context.TestContext;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helpers.HelperMethods;
import helpers.Props;
import managers.BaseDriver;
import managers.TestDriver;
import org.openqa.selenium.WebDriver;
import pages.Account;
import pages.HomePage;
import pages.Login;


public class MiscellaneousSteps extends BaseDriver {

    private TestContext context;
    private final HomePage homePage;
    private final Login login;
    private final HelperMethods helperMethods;
    private final Props props;
    private final Account account;


    public MiscellaneousSteps(TestContext context) {
        this.context = context;
        homePage = context.getPageObjectManager().getHomePage();
        login = context.getPageObjectManager().getLogin();
        helperMethods = context.getPageObjectManager().getHelperMethods();
        props = context.getPageObjectManager().getProps();
        account = context.getPageObjectManager().getAccount();

    }

    @Given("^I login as an individual (.+) and click on my account$")
    public void user_login_to_my_account(String user){
        login.tabletSignIn().click();
        login.WebSignInButton().click();
        login.emailTextInput().sendKeys(props.getProperty("individual"+ user + ".email"));
        login.passwordTextInput().sendKeys(props.getProperty("individual"+ user +".password"));
        login.submitButton().click();
        helperMethods.waitOnElementToBeEnabled(homePage.homeImage(), 20);
        login.tabletSignIn().click();
        account.accountButton().click();
    }

    @Then("^I click on receipt$")
    public void click_receipt(){
        account.receiptLink().click();

    }

    @When("^I switch to new browser tab$")
    public void switch_to_another_tab(){
        helperMethods.openIncognito();
    }

    @And("^I switch to default browser tab$")
    public void switch_to_default_tab(){
        helperMethods.switchDefaultBrowserTab();
    }
}