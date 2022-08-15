package amazon.utility;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import amazon.config.EnvFactory;
import amazon.factories.DriverFactory;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.typesafe.config.Config;


/**
 * This is the base class 
 * Here i have setup some pre-requisite actions like setting up the browser 
 * and intentiating the extent report object
 * And some post execution actions like closing the browser 
 * Every test class needs to extend this base class in order to get the driver object
 */

public class BaseClass {
	
	private static Config config = EnvFactory.getInstance().getConfig();
    private static final String HOME_PAGE_URL = config.getString("HOME_PAGE_URL");
    public static WebDriver driver = DriverFactory.getDriver();
    public static ExtentReports extent;
	public static ExtentSparkReporter spark;

    @BeforeSuite
	public static void setup()
	{
		  driver.get(HOME_PAGE_URL);
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		  driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		  
		  extent = new ExtentReports();
		  spark = new ExtentSparkReporter("./src/main/resources/report/ExtentReport.html");
		  extent.attachReporter(spark);	  
		  
	}
    
    @AfterSuite
    public void tearDown()
    {
    	extent.flush();
    	driver.quit();
    }
    
}
