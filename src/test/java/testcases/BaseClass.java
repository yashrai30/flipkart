//package testcases;
//
//import java.io.File;
//import java.io.IOException;
//import java.time.Duration;
//
//import org.apache.commons.io.FileUtils;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//
//import io.github.bonigarcia.wdm.WebDriverManager;
//import utilities.ReadConfig;
//
//public class BaseClass {
//
//	ReadConfig readConfig = new ReadConfig();
//
//	String url = readConfig.getBaseUrl();
//	String browser = readConfig.getBrowser();
//
//	public static WebDriver driver;
//	public static Logger logger;
//	
//	@BeforeClass
//	public void setup()
//	{
//	
//		switch(browser.toLowerCase())
//	{
//	case "chrome":
//	WebDriverManager.chromedriver().setup();
//	driver = new ChromeDriver();
//	break;
//	
//	case "msedge": 
//	WebDriverManager.edgedriver().setup(); 
//	driver = new EdgeDriver();
//	break;
//	
//	case "firefox": WebDriverManager.firefoxdriver().setup();
//	driver = new FirefoxDriver();
//	break;
//	default:
//	driver = null;
//	break;
//	}
//		//implicitly wait 
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		//for logging
//				logger = LogManager.getLogger("Flipkart");
//				
//				//open url
//				driver.get(url);
//				logger.info("url opened");
//	}
//
//	@AfterClass
//	public void tearDown()
//	{
//		driver.close();
//		driver.quit();
//	}
//	
//	//user method to capture screen shot
//		public void captureScreenShot(WebDriver driver,String testName) throws IOException
//		{
//			//step1: convert webdriver object to TakesScreenshot interface
//			TakesScreenshot screenshot = ((TakesScreenshot)driver);
//			
//			//step2: call getScreenshotAs method to create image file
//			
//			File src = screenshot.getScreenshotAs(OutputType.FILE);
//			
//			File dest = new File(System.getProperty("user.dir") + "//Screenshots//" + testName + ".png");
//		
//			//step3: copy image file to destination
//			FileUtils.copyFile(src, dest);
//		}
//	
//}
//
package testcases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ReadConfig;

public class BaseClass {

    ReadConfig readConfig = new ReadConfig();

    String url = readConfig.getBaseUrl();
    String browser = readConfig.getBrowser();
    boolean isHeadless = readConfig.isHeadless();

    public static WebDriver driver;
    public static Logger logger;
    
    @BeforeClass
    public void setup() {
    
        switch (browser.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                if (isHeadless) {
                    chromeOptions.addArguments("--headless");
                    chromeOptions.addArguments("--disable-gpu");
                    chromeOptions.addArguments("--window-size=1920,1080");
                }
                driver = new ChromeDriver(chromeOptions);
                break;
            
            case "msedge":
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                if (isHeadless) {
                    edgeOptions.addArguments("headless");
                    edgeOptions.addArguments("disable-gpu");
                    edgeOptions.addArguments("window-size=1920,1080");
                }
                driver = new EdgeDriver(edgeOptions);
                break;
            
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                if (isHeadless) {
                    firefoxOptions.addArguments("--headless");
                    firefoxOptions.addArguments("--disable-gpu");
                    firefoxOptions.addArguments("--window-size=1920,1080");
                }
                driver = new FirefoxDriver(firefoxOptions);
                break;
            
            default:
                driver = null;
                break;
        }
        
        // Implicitly wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        // For logging
        logger = LogManager.getLogger("Flipkart");
        
        // Open URL
        driver.get(url);
        logger.info("URL opened");
    }

    @AfterClass
    public void tearDown() {
        driver.close();
        driver.quit();
    }
    
    // User method to capture screenshot
    public void captureScreenShot(WebDriver driver, String testName) throws IOException {
        // Step 1: Convert WebDriver object to TakesScreenshot interface
        TakesScreenshot screenshot = ((TakesScreenshot)driver);
        
        // Step 2: Call getScreenshotAs method to create image file
        File src = screenshot.getScreenshotAs(OutputType.FILE);
        
        File dest = new File(System.getProperty("user.dir") + "//Screenshots//" + testName + ".png");
    
        // Step 3: Copy image file to destination
        FileUtils.copyFile(src, dest);
    }
}
