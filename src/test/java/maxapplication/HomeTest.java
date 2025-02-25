package maxapplication;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.HomePage;
import retry.RetryAnalyzer;

public class HomeTest extends DriverManager {
	HomePage homePage;
	ScreenShots screenShots;

	@BeforeMethod(groups = { "home-sanity" })
	public void setUp() {
		WebDriver webDriver = setUpDriver();
		homePage = new HomePage(webDriver);
		screenShots = new ScreenShots(webDriver);
	}

//	TC_001
	@Test(retryAnalyzer = RetryAnalyzer.class,groups = {
			"home-sanity" }, priority = 1, description = "Verifies user can launch Max application with valid URL")
	public void verifyAppLaunch() {
		try {
			String expectedResult = "max";
			String actualResult = homePage.getAppLogoText();

			Reporter.log("Expected result: " + expectedResult);
			Reporter.log("Actual result: " + actualResult);

			Assert.assertEquals(actualResult, expectedResult);

			screenShots.takeScreenshot("home", "verifyAppLaunch(1)");
			Reporter.log(
					"<a href=\"C:\\Users\\saru.dhavamani\\Desktop\\Selenium\\Application_Max\\screenshots\\home\\verifyAppLaunch(1).png\" target=\"_blank\">Screenshot: App is launched</a>");

			Reporter.log("Test Passed: Application launched successfully and screenshot captured.");
		} catch (AssertionError assertionError) {
			Reporter.log("Test Failed: Application did not launch as expected.");
//			Reporter.log(assertionError.getMessage());

			throw assertionError;
		} catch (IOException ioException) {
			Reporter.log("Test Failed: Exception while taking screenshot.");
//			Reporter.log(ioException.getMessage());
		}
	}

	@AfterMethod(groups = { "home-sanity" })
	public void closeDriver() {
		closeBrowser();
	}
}
