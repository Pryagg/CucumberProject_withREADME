package stepDefinitions;

import java.util.concurrent.TimeUnit;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import context.TestContext;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helpers.HelperMethods;
import pages.*;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CategoriesSteps extends BasePage {
	
	TestContext testContext;
	 HomePage homePage;
	 Categories categories;
	 HelperMethods helperMethods;
	 Products products;
	 
	 public CategoriesSteps(TestContext context) {
	 testContext = context;
	 homePage = context.getPageObjectManager().getHomePage();
	 categories = context.getPageObjectManager().getCategories();
	 helperMethods = context.getPageObjectManager().getHelperMethods();
	 products = context.getPageObjectManager().getProducts();
	 }

	 String categorySelected;
	 
	 
		 @Then("^I verify category for (.+) is displayed$")
		 public void verify_category_elements(String category) {
			 helperMethods.implicitWait(500);
		 	 		Assert.assertTrue(categories.Category(category).isDisplayed());

		 }	

		 @When("^I  click on (.+) category$")
		 public void click_category(String category) {
		 	categorySelected = categories.Category(category).getText();
			 categories.Category(category).click();
				
		 }

	@Then("^I verify the urls are correct for the category$")
	 public void verify_categories_links() {

		for (int i = 0; i < categories.categoriesList().size(); i++)
			System.out.println(categories.categoriesList().get(i).getText());

		for (int i = 0; i < categories.categoriesList().size(); i++) {

			String selectedCategory = categories.categoriesList().get(i).getText().toLowerCase();
			String sc;
			if (selectedCategory.contains("/")) {

				sc = (selectedCategory.lastIndexOf(" ") > -1) ? selectedCategory.substring(0, selectedCategory.indexOf(" ", 0)) : selectedCategory;
			} else {
				 sc = selectedCategory.toLowerCase().replaceAll("\\s+", "-");
			}
				categories.categoriesList().get(i).click();

				String url = driver.getCurrentUrl();
				Assert.assertTrue(url.contains(sc));

				driver.navigate().back();
			}
			}


	@Then("^I see the products of that category are displayed$")
	public void verify_category_related_products_page(){
		Assert.assertEquals(products.categoryHeading().getText(), categorySelected  );
	}
}
