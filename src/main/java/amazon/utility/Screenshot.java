package amazon.utility;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

/**
 * 
 * This is my screenshot utility to capture the screenshots
 *
 */
public class Screenshot {

	public static File captureScreenshot(ITestResult result, WebDriver driver) {

		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentdir = System.getProperty("user.dir");

		try {

			FileUtils.copyFile(screenshot, new File(currentdir + "/src/main/resources/screenshot/test.png"));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return screenshot;
	}

}
