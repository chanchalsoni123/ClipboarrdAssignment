package amazon.pages;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import amazon.utility.Log;
import junit.framework.Assert;

/**
 * I have used page object model factory pattern This is my object
 * repository,have made objects' visibility as Private - no class can access
 * locators directly Here i have defined all possible actions as methods, test
 * class will be able to access locator only via methods. Here I have
 * implemented Encapsulation and Abstraction OOPS concept
 */

public class AmazonHomePage {

	WebDriver driver;
	JavascriptExecutor js;
	Actions action;
	String parent;
	WebDriverWait wait;
	Set<String> s;
	Iterator<String> I1;

	/*
	 * This constructor initializes the driver This will be called from the
	 * respective test classes
	 */
	public AmazonHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		js = (JavascriptExecutor) driver;
		action = new Actions(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}

	/*
	 * Here i have listed all the locators
	 */

	@FindBy(id = "nav-hamburger-menu")
	private WebElement hamburgerMenu;

	@FindBy(xpath = "//*[text()='see all']")
	private List<WebElement> seeAll;

	@FindBy(xpath = "//*[@id=\"hmenu-content\"]/ul[1]/ul[1]/li[2]/a")
	private WebElement electronic;

	@FindBy(xpath = "//*[@id=\"hmenu-content\"]/ul[15]/li[3]/a")
	private WebElement tvNvideo;

	@FindBy(xpath = "//*[@id=\"a-page\"]/div[2]/div[2]/div[2]/div[1]/div/div[1]/ul[2]/li[1]/a")
	private WebElement shopByTelevision;

	@FindBy(xpath = "//*[text()='Featured Brands']")
	private WebElement featureBrand;

	@FindBy(xpath = "//*[@id=\"s-refinements\"]/div[20]/ul/li[4]/span/a/div/label/i")
	private WebElement samsungOption;

	@FindBy(xpath = "//*[@id=\"a-autoid-0-announce\"]/span[2]")
	private WebElement selectFilter;

	@FindBy(xpath = "//*[@id=\"s-result-sort-select_2\"]")
	private WebElement applySorting;

	@FindBy(xpath = "//*[@id=\"search\"]/div[1]/div[1]/div/span[3]/div[2]/div[3]")
	private WebElement secondItem;

	@FindBy(xpath = "/html/body/div[4]/div[2]/div[11]/div[6]/div[4]/div[37]/div/h1")
	private WebElement aboutThisItem;

	/**
	 * Below listed are the methods will be called by the test classes to achieve a
	 * particular test/scenario
	 * 
	 * @param ExtentTest parameter I have used, to log each steps into the Extent Repot
	 * Have also demonstrated the use of Log4j logger having said that, Extensively i have not used the loggers
	 * Have used for a few methods and steps
	 * I have also used JavaScript Executor and Explicit wait wherever required
	 */                

	public AmazonHomePage clickHamburgerMenu(ExtentTest Test) {
		hamburgerMenu.click();
		Test.log(Status.INFO, "Hamburger Menu clicked");
		return this;
	}

	public AmazonHomePage clickSeelAll(ExtentTest Test) {
		js.executeScript("arguments[0].scrollIntoView(true);", seeAll.get(0));

		try {
			wait.until(ExpectedConditions.visibilityOf(seeAll.get(0)));
			seeAll.get(0).click();
			Test.log(Status.INFO, "See all option clicked");
			Log.info("See all clicked");
		} catch (Exception ex) {
			Test.log(Status.WARNING, "See all option was not visible");
		}

		return this;
	}

	public AmazonHomePage selectElectronic(ExtentTest Test) {

		js.executeScript("arguments[0].scrollIntoView(true);", electronic);
		try {
			wait.until(ExpectedConditions.visibilityOf(electronic));
			electronic.click();
			Test.log(Status.INFO, "Clicked on electronics");
		} catch (Exception ex) {

			Test.log(Status.WARNING, "See all option was not visible");
		}

		return this;

	}

	public AmazonHomePage selectTvNvideo(ExtentTest Test) {
		try {
			wait.until(ExpectedConditions.visibilityOf(tvNvideo));
			tvNvideo.click();
			Test.log(Status.INFO, "Clicked on TV and Video");
		} catch (Exception ex) {
			Test.log(Status.WARNING, "TV and Video option was not visible");

		}
		return this;
	}

	public AmazonHomePage selectTelevision() {
		wait.until(ExpectedConditions.visibilityOf(shopByTelevision));
		shopByTelevision.click();
		return this;
	}

	public AmazonHomePage selectFeatureBrand() {
		js.executeScript("arguments[0].scrollIntoView(true);", featureBrand);
		featureBrand.click();
		return this;
	}

	public AmazonHomePage selectSamsung() {
		samsungOption.click();
		return this;
	}

	public AmazonHomePage clickSort() {

		wait.until(ExpectedConditions.visibilityOf(selectFilter));
		selectFilter.click();
		return this;

	}

	public AmazonHomePage applySorting() {

		applySorting.click();
		return this;
	}

	public AmazonHomePage selectSecondRecord() {
		secondItem.click();
		return this;
	}

	public AmazonHomePage AssertAboutContent(ExtentTest Test) {

		js.executeScript("arguments[0].scrollIntoView(true);", aboutThisItem);
		String actual = aboutThisItem.getText();
		String expected = "About this item";
		System.out.println(actual);
		Test.log(Status.PASS, "Actual title matches as expected=" + actual);
		Log.info("Actual Title is:" + actual);
		Assert.assertEquals(actual, expected);
		return this;

	}
}
