package pages;

import context.TestContext;
import helpers.HelperMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Shipping extends BasePage
{
    TestContext context;
    HelperMethods helperMethods;


    public Shipping(TestContext context)
    {
        this.context = context;
        helperMethods = context.getPageObjectManager().getHelperMethods();
    }

//shipping address information

    public WebElement firstNameShippingAddressShippingPage() {
        return findElementByXpath("//div[contains(@id,'ShippingAddressBlock')]//input[contains(@name,'tbFirstName')]");
    }
    public WebElement lastNameShippingAddressShippingPage() {
        return findElementByXpath("//div[contains(@id,'ShippingAddressBlock')]//input[contains(@name,'tbLastName')]");
    }
    public WebElement phoneShippingAddressShippingPage() {
        return findElementByXpath("//div[contains(@id,'ShippingAddressBlock')]//input[contains(@name,'tbPhone')]");
    }
    public WebElement companyShippingAddressShippingPage() {
        return findElementByXpath("//div[contains(@id,'ShippingAddressBlock')]//input[contains(@name,'tbCompany')]");
    }
    public WebElement address1ShippingAddressShippingPage() {
        return findElementByXpath("//div[contains(@id,'ShippingAddressBlock')]//input[contains(@name,'tbAddress1')]");
    }
    public WebElement address2ShippingAddressShippingPage() {
        return findElementByXpath("//div[contains(@id,'ShippingAddressBlock')]//input[contains(@name,'tbAddress2')]");
    }
    public WebElement cityShippingAddressShippingPage() {
        return findElementByXpath("//div[contains(@id,'ShippingAddressBlock')]//input[contains(@name,'tbCity')]");
    }

    public WebElement countryShippingAddressShippingPage() {
        return findElementByXpath("//span[@id=\"ctl00_PageContent_ShippingAddressControl_lblCounty\"]");
    }

    public WebElement countryShippingAddressShippingPagedropdown() {
        return findElementByXpath("//select[@id='ddlCountry']");
    }
    public WebElement stateShippingAddressShippingPagedropdown() {
        return findElementByXpath("//select[@name='ddlState']");
    }

    public WebElement zipcodeShippingAddressShippingPage() {
    return findElementByXpath("//div[contains(@id,'ShippingAddressBlock')]//input[contains(@name,'tbZipCode')]");
}


    public void selectCountryShippingPage(String country){
        helperMethods.implicitWait(500);
        countryShippingAddressShippingPage().click();
       // countryShippingAddressShippingPagedropdown().click();
        Select counselect = new Select(countryShippingAddressShippingPagedropdown());
        counselect.selectByVisibleText(country);
        helperMethods.implicitWait(500);
    }

    public void selectStateShippingPage(String state){
        helperMethods.implicitWait(500);
        stateShippingAddressShippingPagedropdown().click();
        Select select = new Select(stateShippingAddressShippingPagedropdown());
        select.selectByVisibleText(state);

    }

    //shipping method

    public WebElement selectshippingMethodFreeRegistered() {
        return findElementByXpath("//input[(@id='rblShippingMethodsDynamic_0')]");
    }

    public WebElement selectshippingMethodFreeStandard() {
        return findElementByXpath("//input[(@id='rblShippingMethodsDynamic_0')]");
    }

    public WebElement selectshippingMethodExpressMail() {
        return findElementByXpath("//input[(@id='rblShippingMethodsDynamic_0')]");
    }

    //billing address

    public WebElement selectBillingAddressSameAsShippingYes() {
        return findElementByXpath("//input[(@name='rblBillingEqualsShipping')][(@value='1')]");
    }

    public WebElement selectBillingAddressSameAsShippingNo() {
        return findElementByXpath("//input[(@name='rblBillingEqualsShipping')][(@value='0')]");
    }

}
