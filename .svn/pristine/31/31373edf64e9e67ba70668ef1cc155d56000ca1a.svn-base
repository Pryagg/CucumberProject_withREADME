package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import context.TestContext;
import helpers.HelperMethods;
import managers.TestDriver;
import org.openqa.selenium.support.ui.Select;


public class Account extends BasePage {
	
	TestContext context;
	HelperMethods helperMethods;


    public Account(TestContext context)
    {
        this.context = context;
        helperMethods = context.getPageObjectManager().getHelperMethods();
    }
    
    public WebElement myRegistrationPage() {
		return findElementByXpath("//div[@class='caHeading']");
		}

    //Personal
	public WebElement firstNamePersonalTextInput() {
		return findElementByXpath("//input[@name='ctl00$PageContent$ctrlAccount$txtFirstName']");
	}
	public WebElement lastNamePersonalTextInput() {
		return findElementByXpath("//input[@name='ctl00$PageContent$ctrlAccount$txtLastName']");
	}
	public WebElement emailPersonalTextInput() {
		return findElementByXpath("//input[@name='ctl00$PageContent$ctrlAccount$txtEmail']");
	}
	public WebElement confirmEmailPersonalTextInput() {
		return findElementByXpath("//input[@name='ctl00$PageContent$ctrlAccount$ctl08']");
	}
	public WebElement createPasswordPersonalTextInput() {
		return findElementByXpath("//input[@name='ctl00$PageContent$ctrlAccount$txtPassword']");
	}
	public WebElement reEnterPasswordPersonalTextInput() {
		return findElementByXpath("//input[@name='ctl00$PageContent$ctrlAccount$txtPasswordConfirm']");
	}
	public WebElement phonePersonalTextInput() {
		return findElementByXpath("//input[@name='ctl00$PageContent$ctrlAccount$txtPhone']");
	}		
	public WebElement ageConfirmationCheckBox() {
		return findElementByXpath("//input[@name='ctl00$PageContent$ctrlAccount$chkOver13']");
	}

	public WebElement birthYear(){
    	return findElementByXpath("//select[@name='ctl00$PageContent$ctrlAccount$ddlBirthYear']");
	}

	public WebElement birthMonth(){
		return findElementByXpath("//select[@name='ctl00$PageContent$ctrlAccount$ddlBirthMonth']");
	}

	public WebElement birthDay(){
		return findElementByXpath("//select[@name='ctl00$PageContent$ctrlAccount$ddlBirthDay']");
	}

	
	//Billing
	
	public WebElement sameAsAccountBillingCheckBox() {
		return findElementByXpath("//input[@name='ctl00$PageContent$BillingEqualsAccount']");
	}
	public WebElement nickNameBillingTextInput() {
		return findElementByXpath("//input[@name='ctl00$PageContent$ctrlBillingAddress$NickName']");
	}
	public WebElement firstNameBillingTextInput() {
		return findElementByXpath("//input[@name='ctl00$PageContent$ctrlBillingAddress$FirstName']");
	}
	public WebElement lastNameBillingTextInput() {
		return findElementByXpath("//input[@name='ctl00$PageContent$ctrlBillingAddress$LastName']");
	}
	public WebElement phoneBillingTextInput() {
		return findElementByXpath("//input[@name='ctl00$PageContent$ctrlBillingAddress$Phone']");
	}
	public WebElement companyBillingTextInput() {
		return findElementByXpath("//*[@id=\"ctl00_PageContent_ctrlBillingAddress_Company\"]");
	}
	public WebElement address1BillingTextInput() {
		return findElementByXpath("//input[@name='ctl00$PageContent$ctrlBillingAddress$Address1']");
	}
	public WebElement address2BillingTextInput() {
		return findElementByXpath("//input[@name='ctl00$PageContent$ctrlBillingAddress$Address2']");
	}
	public WebElement cityBillingTextInput() {
		return findElementByXpath("//input[@name='ctl00$PageContent$ctrlBillingAddress$City']");
	}
	public WebElement countryBillingDropdown() {
		return findElementByXpath("//select[@name='ctl00$PageContent$ctrlBillingAddress$Country']");
	}
	//Select Country action needed	

	public WebElement stateBillingDropdown() {
		return findElementByXpath("//select[@name='ctl00$PageContent$ctrlBillingAddress$State']");
	}
	//Select State action needed	

	public WebElement zipBillingTextInput() {
		return findElementByXpath("//input[@name='ctl00$PageContent$ctrlBillingAddress$Zip']");
	}
	public WebElement currencyBillingDropdown() {
		return findElementByXpath("//select[@name='ctl00$PageContent$AccountBillingCurrency$BillingCurrency']");
	}
	//Select Currency action needed	

	//Shipping
	public WebElement shippingIsBillingCheckBox() {
		return findElementByXpath("//input[contains(@name,'$btnShppingEqBilling')]");
	}
	public WebElement nickNameShippingTextInput() {
		return findElementByXpath("//input[@name='ctl00$PageContent$ctrlShippingAddress$NickName']");
	}

	public WebElement firstNameShippingTextInput() {
		return findElementByXpath("//div[contains(@id,'ShippingAddressBlock')]//input[contains(@name,'tbFirstName')]");
	}
	public WebElement lastNameShippingTextInput() {
		return findElementByXpath("//div[contains(@id,'ShippingAddressBlock')]//input[contains(@name,'tbLastName')]");
	}
	public WebElement phoneShippingTextInput() {
		return findElementByXpath("//div[contains(@id,'ShippingAddressBlock')]//input[contains(@name,'tbPhone')]");
	}
	public WebElement companyShippingTextInput() {
		return findElementByXpath("//div[contains(@id,'ShippingAddressBlock')]//input[contains(@name,'tbCompany')]");
	}
	public WebElement address1ShippingTextInput() {
		return findElementByXpath("//div[contains(@id,'ShippingAddressBlock')]//input[contains(@name,'tbAddress1')]");
	}
	public WebElement address2ShippingTextInput() {
		return findElementByXpath("//div[contains(@id,'ShippingAddressBlock')]//input[contains(@name,'tbAddress2')]");
	}
	public WebElement cityShippingTextInput() {
		return findElementByXpath("//div[contains(@id,'ShippingAddressBlock')]//input[contains(@name,'tbCity')]");
	}
	public WebElement countryShippingDropdown() {
		return findElementByXpath("//select[@name='ctl00$PageContent$ctrlShippingAddress$Country']");
	}
	//Select Country action needed
	
	public WebElement stateShippingDropdown() {
		return findElementByXpath("//select[@name='ctl00$PageContent$ctrlShippingAddress$State']");
	}
	//Select State action needed
	
	public WebElement zipShippingTextInput() {
		return findElementByXpath("//input[@name='ctl00$PageContent$ctrlShippingAddress$Zip']");
	}
		
	//Privacy	
	public WebElement importantChangesCheckBox() {
		return findElementByXpath("//label[contains(text(),'I would like to be notified about any important ch')]//input[@class='editconsent_chkbx_list_accept_terms']");
	}	
	public WebElement discountsCheckBox() {
		return findElementByXpath("//label[contains(text(),'Please keep me informed about discounts and new pa')]//input[@class='editconsent_chkbx_list_accept_terms']");
	}
	public WebElement socialMediaCheckBox() {
		return findElementByXpath("//label[contains(text(),'I would like to receive promotions about special o')]//input[@class='editconsent_chkbx_list_accept_terms']");
	}
	
	public WebElement createAccountButton() {
		return findElementByXpath("//input[@name='ctl00$PageContent$btnContinueCheckout']");
	}

	public WebElement myAccountPageHeading(){
    	return findElementByXpath("//span[@id='ctl00_PageContent_AccountText']");

	}

	public WebElement accountButton(){
    	return findElementByXpath("//div[@class='nvtools-content']//a[contains(text(),'My account')]");
	}

	public WebElement receiptLink(){
    	return findElementByXpath("//a[contains(text(),'TGC')]");
	}

//	mobile specific elements


	public void selectCountry(String country){
		countryBillingDropdown().click();
		Select select = new Select(countryBillingDropdown());
		select.selectByVisibleText(country);
		helperMethods.implicitWait(500);

	}

	public void selectState(String state){
    	helperMethods.implicitWait(500);
    	stateBillingDropdown().click();
		Select select = new Select(stateBillingDropdown());
		select.selectByVisibleText(state);

	}

	public void selectBirthdate(){
    	birthYear().click();
    	Select select = new Select(birthYear());
    	select.selectByVisibleText("1980");

    	birthMonth().click();
		Select select1 = new Select(birthMonth());
		select1.selectByVisibleText("February");

		birthDay().click();
		Select select2 = new Select(birthDay());
		select2.selectByVisibleText("7");

	}
}
