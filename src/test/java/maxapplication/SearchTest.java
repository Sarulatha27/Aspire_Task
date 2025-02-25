package maxapplication;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.SearchPage;

public class SearchTest extends DriverManager {
	SearchPage searchPage;
	ScreenShots screenShots;
	WebDriver webDriver;
	WaitManager waitManager;
	String expectedResult, actualResult;

	@BeforeMethod(groups = { "search-sanity" })
	public void setUp() {
		webDriver = setUpDriver();
		searchPage = new SearchPage(webDriver);
		screenShots = new ScreenShots(webDriver);
		waitManager = new WaitManager();
	}

//	TC_009
	@Test(groups = {
			"search-sanity" }, priority = 1, description = "Verify the search behaviour by entering a valid product name")
	public void verifyProductSearchFunctionality() {
		try {
			Reporter.log("Clicking on the search box...");
			searchPage.clickSearchBox();
			Reporter.log("Clicked the search box.");

			Reporter.log("Entering product name 'Jeans' into the search box...");
			searchPage.enterProductName("Jeans");
			Reporter.log("Product name 'Jeans' entered.");

			Reporter.log("Submitting the search box...");
			searchPage.submitSearchBox();
			Reporter.log("Submitted the search.");

			screenShots.takeScreenshot("search", "verifyProductSearchFunctionality(1)");

			Reporter.log("Getting the actual search result...");
			Reporter.log(
					"<a href= \"C:\\Users\\saru.dhavamani\\Desktop\\Selenium\\Application_Max\\screenshots\\search\\verifyProductSearchFunctionality(1).png\" target = \"_blank\">Screenshot: Seacrh Jeans</a>");

			expectedResult = "You searched for Jeans";

			actualResult = searchPage.productSearchResultName();

			Reporter.log("Comparing actual result with expected result...");
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

//	TC_010
	@Test(groups = {
			"search-sanity" }, priority = 2, description = "Verify the popular searches is displayed when clicking the search field")
	public void verifyPopularSearchVisibility() {
		try {
			Reporter.log("Clicking on the search box...");
			searchPage.clickSearchBox();
			Reporter.log("Search box clicked.");

			Reporter.log("Verifying popular searches visibility.");
			Assert.assertTrue(searchPage.checkPopularSearchIsVisible());

			screenShots.takeScreenshot("search", "verifyPopularSearchVisibility(1)");
			Reporter.log(
					"<a href= \"C:\\Users\\saru.dhavamani\\Desktop\\Selenium\\Application_Max\\screenshots\\search\\verifyPopularSearchVisibility(1).png\" target = \"_blank\">Screenshot: Visbility of popular searches</a>");

			Reporter.log("Test Passed: Popular searches are visible and screenshot captured.");
		} catch (AssertionError assertionError) {
			Reporter.log("Test Failed: Unable to find the popular searches.");
//			Reporter.log(assertionError.getMessage());

			throw assertionError;
		} catch (IOException ioException) {
			Reporter.log("Test Failed: Exception while taking screenshot.");
//			Reporter.log(ioException.getMessage());
		}
	}

//	TC_011
	@Test(groups = {
			"search-sanity" }, priority = 3, description = "Verify that the user can enter a search query and clear the search box .")
	public void clearSearchFieldAndValidate() {
		try {
			Reporter.log("Clicking on the search box...");
			searchPage.clickSearchBox();
			Reporter.log("Search box clicked.");

			Reporter.log("Enter 'shirts for woman' as search query.");
			searchPage.enterProductName("shirts for woman");
			Reporter.log("Entered search query.");

			screenShots.takeScreenshot("search", "clearSearchFieldAndValidate(1)");
			Reporter.log(
					"<a href= \"C:\\Users\\saru.dhavamani\\Desktop\\Selenium\\Application_Max\\screenshots\\search\\clearSearchFieldAndValidate(1).png\" target = \"_blank\">Screenshot: Typing in search field</a>");

			Reporter.log("Clear the search query.");
			searchPage.clearSearch();
			Reporter.log("Search query cleared.");

			screenShots.takeScreenshot("search", "clearSearchFieldAndValidate(2)");
			Reporter.log(
					"<a href= \"C:\\Users\\saru.dhavamani\\Desktop\\Selenium\\Application_Max\\screenshots\\search\\clearSearchFieldAndValidate(2).png\" target = \"_blank\">Screenshot: Cleared the search field values</a>");

			expectedResult = "";
			actualResult = searchPage.getValueOfSearch();

			Reporter.log("Verify the search field is cleared.");
			Assert.assertEquals(actualResult, expectedResult);

			Reporter.log("Test Passed: Search field cleared successfully and screenshot captured.");
		} catch (AssertionError assertionError) {
			Reporter.log("Test Failed: Unable to clear the search field.");
//			Reporter.log(assertionError.getMessage());

			throw assertionError;
		} catch (IOException ioException) {
			Reporter.log("Test Failed: Exception while taking screenshot.");
//			Reporter.log(ioException.getMessage());
		}
	}

//	TC_012
	@Test(groups = {
			"search-sanity" }, priority = 4, description = "Verify the behavior when there are no products found for the search term")
	public void searchNonExistProductAndValidateError() {
		try {
			Reporter.log("Clicking on the search box...");
			searchPage.clickSearchBox();
			Reporter.log("Search box clicked.");

			Reporter.log("Entering product name 'lipstick'...");
			searchPage.enterProductName("lipstick");
			Reporter.log("Product name entered.");

			screenShots.takeScreenshot("search", "searchNonExistProductAndValidateError(1)");
			Reporter.log(
					"<a href= \"C:\\Users\\saru.dhavamani\\Desktop\\Selenium\\Application_Max\\screenshots\\search\\searchNonExistProductAndValidateError(1).png\" target = \"_blank\">Screenshot: Searching for Lipstick</a>");

			Reporter.log("Submitting the search...");
			searchPage.submitSearchBox();
			Reporter.log("Search submitted.");

			Reporter.log("Validating error message...");
			Assert.assertTrue(searchPage.errorMsgForNonExtProduct());

			screenShots.takeScreenshot("search", "searchNonExistProductAndValidateError(2)");
			Reporter.log(
					"<a href= \"C:\\Users\\saru.dhavamani\\Desktop\\Selenium\\Application_Max\\screenshots\\search\\searchNonExistProductAndValidateError(2).png\" target = \"_blank\">Screenshot: Search result for lipstick</a>");

			Reporter.log("Test Passed: Error message validated and screenshot captured.");
		} catch (AssertionError assertionError) {
			Reporter.log("Test Failed: Searched product is available.");
//			Reporter.log(assertionError.getMessage());

			throw assertionError;
		} catch (IOException ioException) {
			Reporter.log("Test Failed: Exception while taking screenshot.");
//			Reporter.log(ioException.getMessage());
		}
	}

//	TC_013
	@Test(groups = {
			"search-sanity" }, priority = 5, description = "Verify the search with numbers and letters combined")
	public void searchInvalidProductAndValidateError() {
		try {
			Reporter.log("Clicking on the search box...");
			searchPage.clickSearchBox();
			Reporter.log("Search box clicked.");

			Reporter.log("Entering product name: hjk576");
			searchPage.enterProductName("hjk576");
			Reporter.log("Product name entered.");

			screenShots.takeScreenshot("search", "searchInvalidProductAndValidateError(1)");
			Reporter.log(
					"<a href= \"C:\\Users\\saru.dhavamani\\Desktop\\Selenium\\Application_Max\\screenshots\\search\\searchInvalidProductAndValidateError(1).png\" target = \"_blank\">Screenshot: Searching with combo of letters and numbers</a>");

			Reporter.log("Submitting search box...");
			searchPage.submitSearchBox();
			Reporter.log("Search submitted.");

			Reporter.log("Validating error message for invalid product...");
			Assert.assertTrue(searchPage.errorMsgForMixCharSearch());

			screenShots.takeScreenshot("search", "searchInvalidProductAndValidateError(2)");
			Reporter.log(
					"<a href= \"C:\\Users\\saru.dhavamani\\Desktop\\Selenium\\Application_Max\\screenshots\\search\\searchInvalidProductAndValidateError(2).png\" target = \"_blank\">Screenshot: Seach result</a>");

			Reporter.log("Error message displayed as expected and screenshot captured.");

		} catch (AssertionError assertionError) {
			Reporter.log("Test Failed: Searched product is available.");
//			Reporter.log(assertionError.getMessage());

			throw assertionError;
		} catch (IOException ioException) {
			Reporter.log("Test Failed: Exception while taking screenshot.");
//			Reporter.log(ioException.getMessage());
		}
	}

//	TC_014
	@Test(groups = {
			"search-sanity" }, priority = 6, description = "Verify search functionality with product suggestions")
	public void selectProductFromSuggestionAndValidateResult() {
		try {
			Reporter.log("Clicking on the search box...");
			searchPage.clickSearchBox();
			Reporter.log("Search box clicked.");

			Reporter.log("Entering product name 'Jeans'...");
			searchPage.enterProductName("Jeans");
			Reporter.log("Passed: Product name 'Jeans' entered.");

			Reporter.log("Clicking product from suggestion...");
			Assert.assertTrue(searchPage.clickProductFromSuggestion());

			screenShots.takeScreenshot("search", "selectProductFromSuggestionAndValidateResult(2)");
			Reporter.log(
					"<a href= \"C:\\Users\\saru.dhavamani\\Desktop\\Selenium\\Application_Max\\screenshots\\search\\selectProductFromSuggestionAndValidateResult(2).png\" target = \"_blank\">Screenshot: Search Result</a>");

			Reporter.log("Test Passed: Product selected from suggestion and screenshot captured.");

		} catch (AssertionError assertionError) {
			Reporter.log("Test Failed: Choosed product and search results are irrelevant.");
//			Reporter.log(assertionError.getMessage());
			throw assertionError;
		} catch (IOException ioException) {
			Reporter.log("Test Failed: Exception while taking screenshot.");
//			Reporter.log(ioException.getMessage());
		}
	}

//	TC_015
	@Test(groups = {
			"search-sanity" }, priority = 7, description = "Verify that search results can be filtered based on price")
	public void verifySearchAndApplyPriceFilter() {
		try {
			Reporter.log("Clicking on the search box...");
			searchPage.clickSearchBox();
			Reporter.log("Search box clicked.");

			Reporter.log("Entering product name 'Dress'...");
			searchPage.enterProductName("Dress");
			Reporter.log("Product name 'Dress' entered.");

			screenShots.takeScreenshot("search", "verifySearchAndApplyPriceFilter(1)");
			Reporter.log(
					"<a href= \"C:\\Users\\saru.dhavamani\\Desktop\\Selenium\\Application_Max\\screenshots\\search\\verifySearchAndApplyPriceFilter(1).png\" target = \"_blank\">Screenshot: Search Dress</a>");

			Reporter.log("Submitting the search...");
			searchPage.submitSearchBox();
			Reporter.log("Search submitted successfully.");

			Reporter.log("Applying price filter...");
			searchPage.applyPriceFilter();
			Reporter.log("Price filter applied successfully.");

			Reporter.log("Checking if price filter is applied...");
			Assert.assertTrue(searchPage.checkPriceFilterIsApplied());

			screenShots.takeScreenshot("search", "verifySearchAndApplyPriceFilter(4)");
			Reporter.log(
					"<a href= \"C:\\Users\\saru.dhavamani\\Desktop\\Selenium\\Application_Max\\screenshots\\search\\verifySearchAndApplyPriceFilter(4).png\" target = \"_blank\">Screenshot: Price filter is applied</a>");

			Reporter.log("Test Passed: Price filter is applied as expected and screenshot captured.");
		} catch (AssertionError assertionError) {
			Reporter.log("Test Failed: Price filter is not applied.");
//			Reporter.log(assertionError.getMessage());

			throw assertionError;
		} catch (IOException ioException) {
			Reporter.log("Test Failed: Exception while taking screenshot.");
//			Reporter.log(ioException.getMessage());
		}
	}

//	TC_016
	@Test(groups = {
			"search-sanity" }, priority = 8, description = "Verify the search behaviour by entering a * special character in the search field")
	public void verifySearchFunctionalityWithSpecialCharacter() {
		try {
			Reporter.log("Clicking on the search box...");
			searchPage.clickSearchBox();
			Reporter.log("Search box clicked.");

			Reporter.log("Entering '*' special character into the search field...");
			searchPage.enterProductName("*");
			Reporter.log("Entered * special character");

			screenShots.takeScreenshot("search", "verifySearchFunctionalityWithSpecialCharacter(1)");
			Reporter.log(
					"<a href= \"C:\\Users\\saru.dhavamani\\Desktop\\Selenium\\Application_Max\\screenshots\\search\\verifySearchFunctionalityWithSpecialCharacter(1).png\" target = \"_blank\">Screenshot: Search for *</a>");

			Reporter.log("Submitting the search box...");
			searchPage.submitSearchBox();
			Reporter.log("Search box submitted successfully.");

			expectedResult = "You searched for *";

			Reporter.log("Getting actual result from the product search...");
			actualResult = searchPage.productSearchForSpclCharacter();

			Assert.assertEquals(actualResult, expectedResult);

			screenShots.takeScreenshot("search", "verifySearchFunctionalityWithSpecialCharacter(2)");
			Reporter.log(
					"<a href= \"C:\\Users\\saru.dhavamani\\Desktop\\Selenium\\Application_Max\\screenshots\\search\\verifySearchFunctionalityWithSpecialCharacter(2).png\" target = \"_blank\">Screenshot: Search Result</a>");

			Reporter.log("Test Passed: All the products are displayed and captured screenshot");
		} catch (AssertionError assertionError) {
			Reporter.log("Test Failed: Not all products are displayed.");
//			Reporter.log(assertionError.getMessage());

			throw assertionError;
		} catch (IOException ioException) {
			Reporter.log("Test Failed: Exception while taking screenshot.");
//			Reporter.log(ioException.getMessage());
		}
	}

//	TC_017
	@Test(groups = {
			"search-sanity" }, priority = 9, description = "Verify the search behaviour by selecting option from popular searches")
	public void verifyPopularSearchFunctionality() {
		try {
			Reporter.log("Clicking on the search box...");
			searchPage.clickSearchBox();
			Reporter.log("Search box clicked.");

			Reporter.log("Clicking on a product from popular search...");
			searchPage.clickAProductFromPopularSearch();
			Reporter.log("Product clicked from popular search.");

			Reporter.log("Verifying popular search result...");
			Assert.assertTrue(searchPage.popularSearchResult());

			screenShots.takeScreenshot("search", "verifyPopularSearchFunctionality(2)");
			Reporter.log(
					"<a href= \"C:\\Users\\saru.dhavamani\\Desktop\\Selenium\\Application_Max\\screenshots\\search\\verifyPopularSearchFunctionality(2).png\" target = \"_blank\">Screenshot: Search result</a>");

			Reporter.log("Test Passed: Product matches with the popular search and screenshot captured.");
		} catch (AssertionError assertionError) {
			Reporter.log("Test Failed: Product doesn't match with the search.");
//			Reporter.log(assertionError.getMessage());

			throw assertionError;
		} catch (IOException ioException) {
			Reporter.log("Test Failed: Exception while taking screenshot.");
//			Reporter.log(ioException.getMessage());
		}
	}

//	TC_018
	@Test(groups = { "search-sanity" }, priority = 10, description = "Verify the recent search history can be erasable")
	public void clearRecentSearch() throws InterruptedException {
		try {
			Reporter.log("Attempting to clear the recent search history.");
			Assert.assertTrue(searchPage.clearRecentSearch());

			Thread.sleep(2000);

			screenShots.takeScreenshot("search", "clearRecentSearch(4)");
			Reporter.log(
					"<a href= \"C:\\Users\\saru.dhavamani\\Desktop\\Selenium\\Application_Max\\screenshots\\search\\clearRecentSearch(4).png\" target = \"_blank\">Screenshot: Recent Search is cleared</a>");

			Reporter.log("Test Passed: Recent search history cleared and screenshot captured.");

		} catch (AssertionError assertionError) {
			Reporter.log("Test Failed: Recent search is not cleared.");
//			Reporter.log(assertionError.getMessage());
			throw assertionError;
		} catch (IOException ioException) {
			Reporter.log("Test Failed: Exception while taking screenshot.");
//			Reporter.log(ioException.getMessage());
		}
	}

	@AfterMethod(groups = { "search-sanity" })
	public void closeDriver() {
		closeBrowser();
	}
}
