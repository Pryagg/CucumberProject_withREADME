package managers;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import dataProviders.PropertiesHandler;
import enums.BrowserType;
import configuration.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;


public abstract class BaseDriver {

	protected String url = null;
	protected WebDriver webDriver = null;
	private static PropertiesHandler properties;
	protected static BaseDriver browser = null;
	private static WebDriver driver;
	private static Configuration configuration;


	public BaseDriver() {

	}

	public String getSessionID() {
		return this.webDriver == null ? null : ((RemoteWebDriver) this.webDriver).getSessionId().toString();
	}

	public WebDriver driver() {
		return this.webDriver;
	}

	public void quit() {
		if (this.webDriver != null) {
			this.webDriver.quit();
			this.webDriver = null;
		}

		this.url = null;

	}


	public static WebDriver setBrowser(String type) {
		if (driver == null) {
			switch (type) {
				case "CHROME":
					WebDriverManager.chromedriver().setup();
					driver = new ChromeDriver();
					break;
				case "FIREFOX":
					WebDriverManager.firefoxdriver().setup();
					driver = new FirefoxDriver();
					break;
				case "EDGE":
					WebDriverManager.edgedriver().setup();
					driver = new EdgeDriver();
					break;
				case "OPERA":
					WebDriverManager.operadriver().setup();
					driver = new OperaDriver();
					break;
				case "INTERNETEXPLORER":
					WebDriverManager.iedriver().setup();
					driver = new InternetExplorerDriver();
					break;

			}
		}

		return driver;
	}


	public void removeBrowser() {
		if (browser != null) {
			browser.quit();
			browser = null;
		}
	}

	public void switchToDefaultTab() {
		List<String> browserTabs = new ArrayList(this.webDriver.getWindowHandles());
		this.webDriver.switchTo().window((String) browserTabs.get(0));
	}

	public void switchToTab(int index) {
		List<String> browserTabs = new ArrayList(this.webDriver.getWindowHandles());
		this.webDriver.switchTo().window((String) browserTabs.get(index));
	}

	public void closeTab(int index) {
		List<String> browserTabs = new ArrayList(this.webDriver.getWindowHandles());
		this.webDriver.switchTo().window((String) browserTabs.get(index));
		this.webDriver.close();
		this.switchToDefaultTab();
	}

	public void goToUrl(String url) {
		this.webDriver.get(url);
	}

	public String getUrl() {
		return this.webDriver.getCurrentUrl();
	}

	public void navigateToHomepage() {
		this.webDriver.get(this.getUrl());
	}

	public String getCurrentPageUrl() {
		return this.webDriver.getCurrentUrl();
	}

	public void clickBrowserBackButton() {
		this.webDriver.navigate().back();
	}

	public void pressF5() {
		this.webDriver.findElement(By.xpath("//html")).sendKeys(new CharSequence[]{Keys.F5});
	}

	public void setImplicitTimeouts(int seconds) {
		this.webDriver.manage().timeouts().implicitlyWait((long) seconds, TimeUnit.SECONDS);
	}

	public void maximiseWindow() {
		this.webDriver.manage().window().maximize();
	}

	public byte[] saveScreenshot() {
		TakesScreenshot driver = (TakesScreenshot) this.webDriver;
		return (byte[]) driver.getScreenshotAs(OutputType.BYTES);
	}


	public static String getBaseUrl() {
		return FileReaderManager.getInstance().getConfiguration().getApplicationUrl();
	}

	public static String getBrowserName() {

		return FileReaderManager.getInstance().getConfiguration().getBrowserName();
       /*  Configuration con = new Configuration();
         con.getBrowserName();
*/
	}

	public static Properties getProperties() {
		return properties.getProperties();
	}

	public static void setProperties(PropertiesHandler handler) {
		properties = handler;
	}

}
