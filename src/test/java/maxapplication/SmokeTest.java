package maxapplication;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.SmokePage;

public class SmokeTest extends DriverManager {
	SmokePage smokePage;
	ScreenShots screenShots;
	String expectedResult, actualResult;

	@BeforeClass(groups = { "smokeTest" })
	public void setUp() {
		WebDriver webDriver = setUpDriver();
		smokePage = new SmokePage(webDriver);
		screenShots = new ScreenShots(webDriver);
	}

	// TC_019
	@Test(groups = { "smokeTest" }, priority = 1, description = "Ensures the max fashions website loads properly.")
	public void verifyAppLaunch() {
		try {
			String expectedResult = "max";
			String actualResult = smokePage.getAppLogoText();

			Reporter.log("Expected result: " + expectedResult);
			Reporter.log("Actual result: " + actualResult);

			Assert.assertEquals(actualResult, expectedResult);

			screenShots.takeScreenshot("smokeTest", "verifyAppLaunch(1)");
			Reporter.log(
					"<a href=\"C:\\Users\\saru.dhavamani\\Desktop\\Selenium\\Application_Max\\screenshots\\smokeTest\\verifyAppLaunch(1).png\" target=\"_blank\">Screenshot: App is launched</a>");

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

	// TC_020
	@Test(groups = {
			"smokeTest" }, priority = 2, dependsOnMethods = "verifyAppLaunch",description = "Verifies that the search functionality returns relevant results.")
	public void verifyProductSearchsFunctionality() {
		try {
			Reporter.log("Clicking on the search box.");
			smokePage.clickSearchBox();

			Reporter.log("Entering product name 'Women Top Wear' in the search box.");
			smokePage.enterProductName("Women Top Wear");

			Reporter.log("Submitting the search query.");
			smokePage.submitSearchBox();

			screenShots.takeScreenshot("smokeTest", "verifyProductSearchFunctionality(1)");
			Reporter.log(
					"<a href= \"C:\\Users\\saru.dhavamani\\Desktop\\Selenium\\Application_Max\\screenshots\\smokeTest\\verifyProductSearchFunctionality(1).png\" target = \"_blank\">Screenshot: Searching Women Top Wear</a>");

			expectedResult = "You searched for Women Top Wear";
			actualResult = smokePage.productSearchResultName();

			Reporter.log("Verifying the search result.");
			Assert.assertEquals(actualResult, expectedResult);

			Reporter.log("Test Passed: Product search result matches the expected result and screenshot captured.");
		} catch (AssertionError assertionError) {
			Reporter.log("Test Failed: Product search result does not match the expected result.");
//			Reporter.log(assertionError.getMessage());
			throw assertionError;
		} catch (IOException ioException) {
			Reporter.log("Test Failed: Exception while taking screenshot.");
//			Reporter.log(ioException.getMessage());
		}
	}

	// TC_021
	@Test(groups = { "smokeTest" }, priority = 3,  dependsOnMethods = "verifyProductSearchsFunctionality",description = "Verifies that the price filter works correctly.")
	public void verifySearchAndApplyPriceFilter() {
		try {
			Reporter.log("Applying the price filter.");
			smokePage.applyPriceFilter();

			Reporter.log("Verifying if the price filter is applied.");
			Assert.assertTrue(smokePage.checkPriceFilterIsApplied());

			screenShots.takeScreenshot("smokeTest", "verifySearchAndApplyPriceFilter(3)");
			Reporter.log(
					"<a href= \"C:\\Users\\saru.dhavamani\\Desktop\\Selenium\\Application_Max\\screenshots\\smokeTest\\verifySearchAndApplyPriceFilter(3).png\" target = \"_blank\">Screenshot: Price filter is applied</a>");

			Reporter.log("Test Passed: Price filter is successfully applied and screenshot captured.");
		} catch (AssertionError assertionError) {
			Reporter.log("Test Failed: Price filter is not applied.");
//			Reporter.log(assertionError.getMessage());

			throw assertionError;
		} catch (IOException ioException) {
			Reporter.log("Test Failed: Exception while taking screenshot.");
//			Reporter.log(ioException.getMessage());
		}
	}

	// TC_022
	@Test(groups = { "smokeTest" }, priority = 4, dependsOnMethods = "verifySearchAndApplyPriceFilter", description = "Verifies that the product detail page is accessible.")
	public void clickProduct() {
		try {
			Reporter.log("Fetching the product name");
			String actualResult = smokePage.getProductName();
			Reporter.log("Scrolling to the product");
			Reporter.log("Clicking a product");
			smokePage.clickAProduct();
			Reporter.log("Clicked a product");
			smokePage.switchWindows();
			Reporter.log("Fetching the product name in the product detailed page");
			String expectedResult = smokePage.getProductNameInDetailedPage();
			Reporter.log("Comparing the actual and the expected result");
			Assert.assertEquals(actualResult, expectedResult);
			Reporter.log(
					"Test Passed: Product detailed page is accessible, product is relevent and screenshot captured.");
		} catch (AssertionError assertionError) {
			Reporter.log("Test Failed: Product title is not matched.");
//			Reporter.log(assertionError.getMessage());

			throw assertionError;
		} catch (InterruptedException interruptedException) {
			Reporter.log("Test Failed: Element click interupted.");
//			Reporter.log(interruptedException.getMessage());
		}
	}

//	TC_023
	@Test(groups = {
			"smokeTest" }, priority = 5 ,description = "Ensure that a user can choose the size of the product", dependsOnMethods = "clickProduct")
	public void chooseSize() throws InterruptedException {
		try {
			Assert.assertTrue(smokePage.chooseSize());
			Reporter.log("Test Passed: Size is choosed for a product.");
		} catch (AssertionError assertionError) {
			Reporter.log("Test Failed: Size is not choosed.");
//			Reporter.log(assertionError.getMessage());

			throw assertionError;
		}

	}

//	TC_024
	@Test(groups = {
			"smokeTest" }, priority = 6, description = "Ensures that a product can be added to the shopping basket.", dependsOnMethods = "chooseSize")
	public void addProductToBasket() throws InterruptedException {
		try {
			boolean goToBasketVisibility = smokePage.addToBasket();
			Assert.assertTrue(goToBasketVisibility);
			Reporter.log("Test Passed: Product is added to the basket.");
		} catch (AssertionError assertionError) {
			Reporter.log("Test Failed: Product is not added to the basket.");
//			Reporter.log(assertionError.getMessage());

			throw assertionError;
		}

	}

//	TC_026
	@Test(groups = {
			"smokeTest" }, priority = 7, description = "Verify that the user can proceed to the checkout page.", dependsOnMethods = "addProductToBasket")
	public void checkOutNow() throws InterruptedException {
		try {
			smokePage.clickBasketButton();
			boolean siginInFormVisible = smokePage.checkOutNow();
			Assert.assertTrue(siginInFormVisible);
			Reporter.log("Test Passed: Sign in form is visible");
		} catch (AssertionError assertionError) {
			Reporter.log("Test Failed: Sign in form is invisible.");
//			Reporter.log(assertionError.getMessage());

			throw assertionError;
		} catch (InterruptedException interruptedException) {
			Reporter.log("Test Failed: Sign in form is invisible.");
//			Reporter.log(interruptedException.getMessage());

			throw interruptedException;
		}

	}

	@AfterClass(groups = { "smokeTest" })
	public void closeDriver() {
		closeBrowser();
	}

}
