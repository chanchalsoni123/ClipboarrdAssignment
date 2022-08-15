package amazon.listeners;

import java.io.File;
import org.testng.ITestListener;
import org.testng.ITestResult;
import amazon.utility.BaseClass;
import amazon.utility.JiraPlugIn;
import amazon.utility.Screenshot;

/**
 * This one of the TestNG Listener's implementation 
 * Here two actions will get triggered if any test case gets failed
 * 1- A screenshot will get captured and get stored in the screenshot folder 
 * 2- A ticket will get raised in JIRA
 * Note: I have left my credentials open because thats just my test account - no more using for office or personal purpose 
 */

public class TestListener extends BaseClass implements ITestListener {
	

	@Override
	public void onTestFailure(ITestResult iTestResult) {

		File screenshot = Screenshot.captureScreenshot(iTestResult, driver);

		System.out.println("Log a bug in Jira");
		JiraPlugIn jsp = new JiraPlugIn("https://csoni.atlassian.net/", "chanchal.soni@pratian.com",
				"vkUUSH4av9zPe9XiDuI2B8B6", "AM");
		String IssueSummary = "[Automation] " + iTestResult.getName() + " got failed due to some assertion or exception";
		String IssueDesc = iTestResult.getName();
		IssueDesc.concat(System.out.toString());
		jsp.createJiraTicket("Bug", IssueSummary, IssueDesc, screenshot, "Chanchal Soni");
		
	}

}
