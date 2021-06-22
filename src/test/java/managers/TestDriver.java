package managers;


import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import context.TestContext;
import io.github.bonigarcia.wdm.WebDriverManager;
 
public class TestDriver extends BaseDriver {
 private static WebDriver driver       ;



private TestContext context;
 
 public TestDriver(TestContext context) {
	 this.context = context;
	 

 }
 
 public static WebDriver getDriver()
 {
	

     
         if (driver != null)
         {
             return driver;
         }
       
			  createDriver(getBrowserName());
			  if (getBrowserName().equals("TABLET-Chrome")) {
				   //tablet/ipad
				     driver.manage().window().setSize(new Dimension(1024, 1366));
//				     mobile devices
				 } else if (getBrowserName().equals("MOBILE-Chrome")){
					 driver.manage().window().setSize(new Dimension(375,812));
				 } else {
			     driver.manage().window().maximize();
				 }

			 // driver.navigate().to(getBaseUrl());

	 // wrote this code to assist in Jenkins

	           String Devurl = System.getProperty("devurl");
			  if(Devurl==null)
			  {
				  driver.navigate().to(getBaseUrl());
			  }
			  else
			  {
			  	driver.navigate().to(Devurl);
			  }
			  return driver;

}

 public static WebDriver createDriver(String type) {
         switch(type) {
	case "CHROME":
	case "TABLET-Chrome":
	case "MOBILE-Chrome":
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
 return driver;
 }

 

 public static void closeDriver() {
	 if(driver !=null) {
	 driver.close();
	 driver.quit();
	 driver = null;
 }
 }

 
}