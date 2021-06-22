package pages;

import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.picocontainer.classname.ClassName;

import managers.TestDriver;


public abstract class BasePage
{
	

    public WebDriver driver = TestDriver.getDriver();
    private WebDriverWait wait = new WebDriverWait(driver, 10);


    protected BasePage()
    {
        PageFactory.initElements(driver, this);

    }

    protected void selectOptionButton(String option) {
    
         
         // Create instance of Javascript executor
            JavascriptExecutor je = (JavascriptExecutor) driver;
            //Identify the WebElement which will appear after scrolling down
            WebElement element = findElementByXpath("//div[@class='loc-options']");
            // now execute query which actually will scroll until that element is not appeared on page.
            je.executeScript("arguments[0].scrollIntoView(true);",element);
            
        
    }

    protected void clickButton(String buttonText)
    {
        findElementByXpath("//button[contains(text(), '" + buttonText + "')]").click();
    }

    protected WebElement findElementByXpath(String xpath)
    {
        wait.withMessage(xpath);
        wait.until((ExpectedCondition<Boolean>) d -> (driver.findElement(By.xpath(xpath)).isDisplayed()));


        return driver.findElement(By.xpath(xpath));
    }

    protected WebElement findElementById(String id)
    {
        wait.withMessage(id);
        wait.until((ExpectedCondition<Boolean>) dx -> (driver.findElement(By.id(id)).isDisplayed()));
        return driver.findElement(By.id(id));
    }

    protected WebElement findElementByLinkName(String linkText)
    {
        WebElement element = driver.findElement(By.linkText(linkText));
        highlightElement(element);
        return element;
    }

    protected WebElement findElementByCssSelector(String cssSelector)
    {
        WebElement element = driver.findElement(By.cssSelector(cssSelector));
        highlightElement(element);
        return element;
    }

    protected List<WebElement> findElementsByTagName(String tagName)
    {
        List<WebElement> elements = driver.findElements(By.tagName(tagName));
        return elements;
    }

  /*  protected  ExpectedCondition<Boolean> d (string xpath)
    {
        ExpectedCondition<Boolean> condition = Objects::nonNull;

        return  condition;
    }*/

    protected List<WebElement> findElementsByXpath(String xpath)
    {
        wait.withMessage(xpath);
        wait.until((ExpectedCondition<Boolean>) d -> (driver.findElements(By.xpath(xpath)).size() > 0));
        return driver.findElements(By.xpath(xpath));
    }

    private void highlightElement(WebElement element)
    {
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid red'", element);
    }



//    public Logger getLogger()
//    {
//        return logger;
//    }
}
