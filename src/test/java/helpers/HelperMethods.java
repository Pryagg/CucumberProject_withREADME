package helpers;

import java.io.Console;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import javax.annotation.Nullable;
import javax.annotation.Nonnull;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;


import context.TestContext;
import pages.BasePage;
import managers.TestDriver;

//import ru.yandex.qatools.htmlelements.element.Link;

public class HelperMethods extends BasePage
{
    private TestContext context;
    private static double start = 0;
    private static String originalHandle;
    private final WebDriverWait wait;
    private final WebDriver driver;
//    private static final Logger logger = Logger.getLogger(ClassName.class.getName());
    private static FluentWait<WebDriver> webDriverFluentWait;

    @FindBy(xpath = "//*[contains(text(), 'Change password')]")
    private WebElement changePasswordBtn;

    public HelperMethods(TestContext context)
    {
        this.context = context;
        driver = TestDriver.getDriver();
        wait = new WebDriverWait(driver, 30);
    }

    public void waitOnPresenceOfElementLocated(By locator, int timeout)
    {
        WebDriverWait wait = (new WebDriverWait(driver, timeout));

        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void waitOnElementToBeEnabled(By locator, int timeout)
    {
        WebDriverWait wait = (new WebDriverWait(driver, timeout));

        wait.until(ExpectedConditions.and(ExpectedConditions.visibilityOfElementLocated(locator),
                (ExpectedConditions.elementToBeClickable(locator))));
    }

    public void waitOnElementToBeEnabled(WebElement locator, int timeout)
    {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.and(ExpectedConditions.visibilityOf(locator),
                (ExpectedConditions.elementToBeClickable(locator))));
    }

    public void waitOnElementToBeEnabled(List<WebElement> locator, int timeout)
    {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.and(ExpectedConditions.visibilityOf(locator.get(0)),
                (ExpectedConditions.elementToBeClickable(locator.get(0)))));
    }

    public void clickElementActions(WebElement element)
    {
        waitOnElementToBeEnabled(element, 30);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().build().perform();
    }

    public void switchToActiveElement()
    {
       driver.switchTo().activeElement();
    }

    public void waitOnElementToBeInvisible(WebElement locator, int timeout)
    {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.invisibilityOf(locator));
    }

    public void waitOnElementToBeInvisible(By locator, int timeout)
    {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public void implicitlyWait(int milliSeconds)
    {
        driver.manage().timeouts()
                .implicitlyWait(milliSeconds, TimeUnit.MILLISECONDS);
    }

    public void wait(String xpath)
    {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until((ExpectedCondition<Boolean>) d -> (
                driver.findElement(By.xpath(xpath)).isDisplayed()));
    }

    public WebElement getElementByLinkText(String text)
    {
        waitForXSeconds(2000);
        String xpathStart = "//*[contains(text(), \'";
        String xpathEnd = text + "\')]";
        return driver.findElement(By.xpath(xpathStart + xpathEnd));
    }

    public int randomNumberInRange(int min, int max)
    {
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }

    public void waitOnElementToBeClickable(WebElement htmlElement)
    {
        wait.until(ExpectedConditions.elementToBeClickable(htmlElement));
    }

    public void startTimer()
    {
        start = System.currentTimeMillis();
    }

    public double stopTimer()
    {
        double stop = System.currentTimeMillis();

        return (stop - start) / 1000;
    }


//    public static Boolean waitOnLinkToBeDisplayed(Link element) {
//
//        int i = 0;
//
//        while (i < 60) {
//
//            if (element.isDisplayed()) {
//
//                return true;
//            }
//        }
//        return null;
//    }


    public void waitForXSeconds(int milliseconds)
    {
        driver.manage().timeouts()
                .implicitlyWait(milliseconds, TimeUnit.MILLISECONDS);
    }

    public void dismissAlert()
    {

        try
        {
            //Wait 10 seconds till alert is present
            WebDriverWait wait = new WebDriverWait(driver, 10);
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());

            //Accepting alert.
            alert.accept();
            System.out.println("Accepted the alert successfully.");
        }
        catch (Throwable e)
        {
            System.err.println("Error came while waiting for the alert popup. " + e.getMessage());
        }

    }

    public boolean isAlertPresent()
    {

        try
        {
            driver.switchTo().alert();
            return true;
        }
        catch (NoAlertPresentException e)
        {
            e.printStackTrace();
            return false;
        }
    }

    public String createXFile(String fileName, String filetype) throws IOException
    {

        List<String> lines = Arrays.asList("Mr Auto Tester", "Cost to fix leak is $300");
        Path file = Paths.get(fileName + "." + filetype);
        Files.write(file, lines, Charset.forName("UTF-8"));
        return new File(String.valueOf(file)).getCanonicalPath();
    }

    @Nonnull
    public String getDate(int monthsToSubtract, String pattern)
    {

        LocalDateTime ldt = LocalDateTime.now();
        LocalDateTime lm = ldt.minus(monthsToSubtract, ChronoUnit.MONTHS);
        return DateTimeFormatter.ofPattern(pattern, Locale.ENGLISH).format(lm);
    }

    public int randomNumberGenerator(int min, int max)
    {
        Random r = new Random();
        return r.nextInt(max - min) + min;
    }

    public void browserBack()
    {
        driver.navigate().back();
    }


    public void switchNewBrowserTab()
    {
        originalHandle = driver.getWindowHandle();

        if (driver instanceof JavascriptExecutor)
        {
            ((JavascriptExecutor) driver).executeScript("window.open()");
        }
        else
        {
            throw new IllegalStateException("This driver does not support JavaScript!");
        }


        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1)); //switches to new tab
        waitForXSeconds(2000);
        driver.navigate().to(TestDriver.getBaseUrl());

    }

    public void switchDefaultBrowserTab()
    {

        for (String handle : driver.getWindowHandles())
        {
            if (!handle.equals(originalHandle))
            {
            	driver.switchTo().window(handle);
            	driver.close();
            }
        }

        driver.switchTo().window(originalHandle);
        waitForXSeconds(2000);

    }

    public void stopWebpageLoading()
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("return window.stop");
    }

    public static String getAbsoluteFromRelativePath(String path)
    {
        return FileSystems.getDefault().getPath(path).normalize().toAbsolutePath().toString();
    }

    public void waitOnElementToBeVisible(List<WebElement> locator, int timeout)
    {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.visibilityOf(locator.get(0)));
    }

    public void waitOnElementToBeVisible(WebElement locator, int timeout)
    {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.visibilityOf(locator));
    }

    public void sendKeysActions(WebElement element, String inputData)
    {
        waitOnElementToBeEnabled(element, 30);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().build().perform();

        for (int i = 0; i < inputData.length(); i++)
        {
            char c = inputData.charAt(i);
            String s = String.valueOf(c);
            driver.manage().timeouts().implicitlyWait(200, TimeUnit.MILLISECONDS);
            for (int x = 0; x < 3; x++)
            {
                try
                {
                    element.sendKeys(s);
                    break;
                }
                catch (ElementNotInteractableException e)
                {
                    e.getMessage();
                }
            }

        }
    }

    public void sendKeysWithDelay(WebElement element, String inputData)
    {
        implicitWait(2000);
        waitOnElementToBeEnabled(element, 30);

        try
        {
            element.click();
            element.sendKeys(Keys.CLEAR);
            element.sendKeys("");
        }
        catch (ElementNotInteractableException e)
        {
            e.getMessage();
            element.click();
            element.sendKeys(Keys.CLEAR);
            element.sendKeys("");
        }
        finally
        {
            element.click();
            element.sendKeys(Keys.CLEAR);

            for (int i = 0; i < inputData.length(); i++)
            {
                char c = inputData.charAt(i);
                String s = String.valueOf(c);
                implicitWait(20);
                element.sendKeys(s);
            }
        }
    }

    public void sendKeyStrokesWithDelay(WebElement element, Keys keyName)
    {
        implicitWait(2000);
        waitOnElementToBeEnabled(element, 30);

        for (int i = 0; i < 3; i++)
        {
            try
            {
                element.sendKeys(keyName);
                break;
            }
            catch (ElementNotInteractableException e)
            {
                e.getMessage();
            }
        }

    }

    public void implicitWait(int milliseconds)
    {
        try
        {
            TimeUnit.MILLISECONDS.sleep(milliseconds);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    public void fluentWait(int pollingEvery, int timeout, @Nullable WebElement element)
    {
        webDriverFluentWait.withTimeout(Duration.ofSeconds(timeout))
                .pollingEvery(Duration.ofMillis(pollingEvery))
                .ignoring(WebDriverException.class);

        try
        {
            if (element != null)
            {
                Assert.assertTrue(element.isDisplayed());
            }
        }
        catch (NoSuchElementException e)
        {
            e.getMessage();
        }
    }

    public void killProcess(String process)
    {
        try
        {
            Runtime.getRuntime().exec("taskkill /F /IM " + process);
        }
        catch (IOException e1)
        {
//            Console.severe(e1.getMessage());
        }
    }

    public void navigateTo(String unparsedPath)
    {
        Actions actions = new Actions(driver);

        String[] parsedPath = unparsedPath.split(">");
        for (String item : parsedPath)
        {
            String xpath = "//*[(text()='" + item + "')]";
            waitOnElementToBeEnabled(findElementByXpath(xpath), 30);
            actions.moveToElement(findElementByXpath(xpath)).click().build().perform();
            implicitWait(1000);
        }
    }

    public void enterTextJsExecutor(WebElement element, String text)
    {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[1].value = arguments[0]; ", text, element);
    }

    public void clickElementJsExecutor(WebElement element)
    {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }

    public void tabCells(int tabNum)
    {
        Actions actions = new Actions(driver);
        for (int i = 0; i < tabNum; i++)
        {
            actions.sendKeys(Keys.TAB).build().perform();
            implicitWait(1000);
        }
    }

    public void click(WebElement element){
        try
        {
            element.click();

        }
        catch (ElementNotInteractableException e)
        {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("window.scrollBy(0,250)");
            element.click();
        }
    }

    public void scrollUntilVisible(WebElement element){
        try
        {
            element.click();
        }
        catch (ElementNotInteractableException e)
        {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].scrollIntoView();", element);
            element.click();
        }
    }

    public void setContext(TestContext context)
    {
        this.context = context;
    }

    public TestContext getContext()
    {
        return context;
    }

    public String getCurrentUrl() {
    	return driver.getCurrentUrl();
    }
    
  //for generating letters
    public String generateRandomString(int length){
        return RandomStringUtils.randomAlphabetic(length);
    } 

    //for for generating numbers
    public String generateRandomNumber(int length){
        return RandomStringUtils.randomNumeric(length);
    }
    
	// Example use of the above generators:
	//    public void YourUniqueName(){
	//        driver.findElement(locator).sendKeys("Name" +" - "+"Test" + " - " + RandomStringUtils.randomAlphabetic(3) + RandomStringUtils.randomNumeric(3));

    public void openIncognito(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("-incognito");
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        WebDriver chromedriver=new ChromeDriver(capabilities);
        chromedriver.get(TestDriver.getBaseUrl());

        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
        }
    }
    
}


