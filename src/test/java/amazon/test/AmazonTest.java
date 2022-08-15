package amazon.test;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import amazon.pages.AmazonHomePage;
import amazon.utility.BaseClass;

/**
 * This the test class Here I have used Extent report logger, extent report
 * object is being passed as parameters to individual page object methods I have
 * also used listener for capturing screenshot or for raising a ticket into jira
 * for failed case
 */

@Listeners(amazon.listeners.TestListener.class)
public class AmazonTest extends BaseClass {

	AmazonHomePage hp = new AmazonHomePage(driver);

	@Test
	public void navigateToElectronicsNValidateTitle() {

		ExtentTest test = extent.createTest("Amazon exercise to validate selected television <About This Item> heading");

		hp.clickHamburgerMenu(test).clickSeelAll(test)
		.selectElectronic(test).selectTvNvideo(test)
		.selectTelevision().selectFeatureBrand()
		.selectSamsung().clickSort()
		.applySorting().selectSecondRecord()
		.AssertAboutContent(test);

	}

}