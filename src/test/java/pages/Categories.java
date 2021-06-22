package pages;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import managers.TestDriver;
import org.openqa.selenium.WebElement;

import context.TestContext;
import helpers.HelperMethods;



public class Categories extends BasePage {

	
		private TestContext context;
	    private final HelperMethods helperMethods;


	    public Categories(TestContext context)
	    {
	        this.context = context;
	        helperMethods = context.getPageObjectManager().getHelperMethods();
	    }
	    
	    public WebElement Category(String title) {
	    	return findElementByXpath("//div[@class='header-nav']//a[contains(text(), '" + title + "')]");
	    }

		public List<WebElement> categoriesList(){
	    	return findElementsByXpath("//div[@class='header-nav']//nav[@class='nav']//div[@class='nav-item']");
		}

	    

}
