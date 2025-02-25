package pages;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import maxapplication.ScreenShots;
import maxapplication.WaitManager;

public class SearchPage {

	WebDriver driver;

	WaitManager waitManager = new WaitManager();

	@FindBy(xpath = "//input[@type='search']")
	WebElement searchBox;

	@FindBy(tagName = "h1")
	WebElement searchResultText;

	@FindBy(xpath = "//div[contains(text(),'Popular searches')]")
	WebElement popularSearchText;

	@FindBy(xpath = "//ul/li[6]/div/span[@class='MuiChip-label']")
	WebElement popularProductName;

	@FindBy(xpath = "//h1[contains(text(),'You searched for Women Tops')]")
	WebElement poularSearchResult;

	@FindBy(xpath = "//div[contains(text(),'Sorry, there are no matches for “lipstick”')]")
	WebElement nonExistanceError;

	@FindBy(xpath = "//div[contains(text(),'Sorry, there are no matches for “hjk576”')]")
	WebElement MixCharError;

	@FindBy(id = "product-list--departments")
	WebElement productSuggestList;

	@FindBy(xpath = "//input[@aria-label='minimum-input']")
	WebElement minimumPrice;

	@FindBy(xpath = "//input[@aria-label='maximum-input']")
	WebElement maximumPrice;

	@FindBy(xpath = "//button[@aria-label='right-arrow-icon']")
	WebElement priceSubmitButton;

	@FindBy(xpath = "//span[@class='MuiChip-label']")
	WebElement priceFilterAppliedConButton;

	@FindBy(xpath = "//div[@class='MuiCollapse-wrapperInner']/div/ul/div[2]/a/div")
	WebElement oneProductFromSuggesList;

	@FindBy(xpath = "//h1[contains(text(),'You searched for Jeans for Mens')]")
	WebElement verifyOneProSuggest;

	@FindBy(xpath = "//h1[contains(text(),'You searched for *')]")
	WebElement specialCharacterSearch;

	@FindBy(xpath = "//h1[contains(text(),'You searched for Tops')]")
	WebElement searchResult;

	@FindBy(xpath = "//div[contains(text(),'Recent searches')]")
	WebElement recentSearchHeading;

	@FindBy(xpath = "//form/div[2]/div/div/div/div/div[2]/button")
	WebElement clearRecentButton;

	ScreenShots screenShots;

	public SearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		screenShots = new ScreenShots(driver);
	}

	public void clickSearchBox() {
		try {
			waitManager.waitExplicit(searchBox, driver);
			searchBox.click();
		} catch (NoSuchElementException noSuchElementException) {
			Reporter.log("Test Failed: Unable to locate element.");
//			Reporter.log(noSuchElementException.getRawMessage());

			throw noSuchElementException;
		} catch (TimeoutException timeoutException) {
			Reporter.log("Test Failed: Timeout occurred while waiting for the element.");
//			Reporter.log(timeoutException.getRawMessage());

			throw timeoutException;
		}
	}

	public void enterProductName(String productName) {
		try {
			searchBox.sendKeys(productName);
		} catch (NoSuchElementException noSuchElementException) {
			Reporter.log("Test Failed: Unable to locate element.");
//			Reporter.log(noSuchElementException.getRawMessage());

			throw noSuchElementException;
		}
	}

	public void submitSearchBox() {
		try {
			searchBox.sendKeys(Keys.ENTER);
		} catch (NoSuchElementException noSuchElementException) {
			Reporter.log("Test Failed: Unable to locate element.");
//			Reporter.log(noSuchElementException.getRawMessage());

			throw noSuchElementException;
		}
	}

//	for test case 09
	public String productSearchResultName() {
		try {
			waitManager.waitImplicit(driver);
			waitManager.waitExplicit(searchResultText, driver);

			screenShots.takeScreenshot("search", "verifyProductSearchFunctionality(2)");
			Reporter.log(
					"<a href= \"C:\\Users\\saru.dhavamani\\Desktop\\Selenium\\Application_Max\\screenshots\\search\\verifyProductSearchFunctionality(2).png\" target = \"_blank\">Screenshot: Search result for Jeans</a>");
			return searchResultText.getText();
		} catch (NoSuchElementException noSuchElementException) {
			Reporter.log("Test Failed: Unable to locate element.");
//			Reporter.log(noSuchElementException.getRawMessage());

			throw noSuchElementException;
		} catch (TimeoutException timeoutException) {
			Reporter.log("Test Failed: Timeout occurred while waiting for the element.");
//			Reporter.log(timeoutException.getRawMessage());

			throw timeoutException;
		} catch (IOException ioException) {
			Reporter.log("Test Failed: Exception while taking screenshot.");
//			Reporter.log(ioException.getMessage());
		}
		return searchResultText.getText();
	}

//	for test case 10
	public boolean checkPopularSearchIsVisible() {
		try {
			waitManager.waitExplicit(popularSearchText, driver);

			if (popularSearchText.isDisplayed()) {
				return true;
			}
			return false;
		} catch (NoSuchElementException noSuchElementException) {
			Reporter.log("Test Failed: Unable to locate element.");
//			Reporter.log(noSuchElementException.getRawMessage());

			throw noSuchElementException;
		} catch (TimeoutException timeoutException) {
			Reporter.log("Test Failed: Timeout occurred while waiting for the element.");
//			Reporter.log(timeoutException.getRawMessage());

			throw timeoutException;
		}
	}

//	for test case 11
	public void clearSearch() {
		try {
			searchBox.sendKeys(Keys.CONTROL + "a");
			waitManager.waitImplicit(driver);
			searchBox.sendKeys(Keys.BACK_SPACE);
		} catch (NoSuchElementException noSuchElementException) {
			Reporter.log("Test Failed: Unable to locate element.");
//			Reporter.log(noSuchElementException.getRawMessage());

			throw noSuchElementException;
		} catch (TimeoutException timeoutException) {
			Reporter.log("Test Failed: Timeout occurred while waiting for the element.");
//			Reporter.log(timeoutException.getRawMessage());

			throw timeoutException;
		}
	}

	@SuppressWarnings("deprecation")
	public String getValueOfSearch() {
		try {
			return searchBox.getAttribute("value");
		} catch (NoSuchElementException noSuchElementException) {
			Reporter.log("Test Failed: Unable to locate element.");
//			Reporter.log(noSuchElementException.getRawMessage());

			throw noSuchElementException;
		}
	}

//	for test case 12
	public boolean errorMsgForNonExtProduct() {
		try {
			waitManager.waitImplicit(driver);
			waitManager.waitExplicit(nonExistanceError, driver);

			if (nonExistanceError.isDisplayed()) {
				return true;
			} else {
				return false;
			}
		} catch (NoSuchElementException noSuchElementException) {
			Reporter.log("Test Failed: Unable to locate element.");
//			Reporter.log(noSuchElementException.getRawMessage());

			throw noSuchElementException;
		} catch (TimeoutException timeoutException) {
			Reporter.log("Test Failed: Timeout occurred while waiting for the element.");
//			Reporter.log(timeoutException.getRawMessage());

			throw timeoutException;
		}
	}

//	for test case 13
	public boolean errorMsgForMixCharSearch() {
		try {
			waitManager.waitExplicit(MixCharError, driver);

			if (MixCharError.isDisplayed()) {
				return true;
			} else {
				return false;
			}

		} catch (NoSuchElementException noSuchElementException) {
			Reporter.log("Test Failed: Unable to locate element.");
//			Reporter.log(noSuchElementException.getRawMessage());

			throw noSuchElementException;
		} catch (TimeoutException timeoutException) {
			Reporter.log("Test Failed: Timeout occurred while waiting for the element.");
//			Reporter.log(timeoutException.getRawMessage());

			throw timeoutException;
		}
	}

//	for test case 14
	public boolean clickProductFromSuggestion() {
		try {
			waitManager.waitExplicit(productSuggestList, driver);

			screenShots.takeScreenshot("search", "selectProductFromSuggestionAndValidateResult(1)");
			Reporter.log(
					"<a href= \"C:\\Users\\saru.dhavamani\\Desktop\\Selenium\\Application_Max\\screenshots\\search\\selectProductFromSuggestionAndValidateResult(1).png\" target = \"_blank\">Screenshot: Search Jeans and choose form suggestion list</a>");

			String productName = oneProductFromSuggesList.getText().trim();

			oneProductFromSuggesList.click();

			waitManager.waitExplicit(verifyOneProSuggest, driver);

			if (verifyOneProSuggest.getText().contains(productName)) {
				return true;
			}
			return false;
		} catch (NoSuchElementException noSuchElementException) {
			Reporter.log("Test Failed: Unable to locate element.");
//			Reporter.log(noSuchElementException.getRawMessage());

			throw noSuchElementException;
		} catch (TimeoutException timeoutException) {
			Reporter.log("Test Failed: Timeout occurred while waiting for the element.");
//			Reporter.log(timeoutException.getRawMessage());

			throw timeoutException;
		} catch (IOException ioException) {
			Reporter.log("Test Failed: Exception while taking screenshot.");
//			Reporter.log(ioException.getMessage());
		}
		return false;
	}

//	for test case 15
	public void applyPriceFilter() {
		try {
			waitManager.waitExplicit(minimumPrice, driver);
			minimumPrice.sendKeys(Keys.CONTROL + "a");
			minimumPrice.sendKeys(Keys.BACK_SPACE);
			minimumPrice.sendKeys("500");

			screenShots.takeScreenshot("search", "verifySearchAndApplyPriceFilter(2)");
			Reporter.log(
					"<a href= \"C:\\Users\\saru.dhavamani\\Desktop\\Selenium\\Application_Max\\screenshots\\search\\verifySearchAndApplyPriceFilter(2).png\" target = \"_blank\">Screenshot: Entering minimum price</a>");

			maximumPrice.sendKeys(Keys.CONTROL + "a");
			maximumPrice.sendKeys(Keys.BACK_SPACE);
			maximumPrice.sendKeys("1000");

			screenShots.takeScreenshot("search", "verifySearchAndApplyPriceFilter(3)");
			Reporter.log(
					"<a href= \"C:\\Users\\saru.dhavamani\\Desktop\\Selenium\\Application_Max\\screenshots\\search\\verifySearchAndApplyPriceFilter(3).png\" target = \"_blank\">Screenshot: Entering maximum price</a>");

			priceSubmitButton.click();
		} catch (NoSuchElementException noSuchElementException) {
			Reporter.log("Test Failed: Unable to locate element.");
//			Reporter.log(noSuchElementException.getRawMessage());

			throw noSuchElementException;
		} catch (TimeoutException timeoutException) {
			Reporter.log("Test Failed: Timeout occurred while waiting for the element.");
//			Reporter.log(timeoutException.getRawMessage());

			throw timeoutException;
		} catch (IOException ioException) {
			Reporter.log("Test Failed: Exception while taking screenshot.");
//			Reporter.log(ioException.getMessage());
		}
	}

	public boolean checkPriceFilterIsApplied() {
		try {
			waitManager.waitExplicit(priceFilterAppliedConButton, driver);

			if (priceFilterAppliedConButton.isDisplayed()) {
				return true;
			} else {
				return false;
			}

		} catch (NoSuchElementException noSuchElementException) {
			Reporter.log("Test Failed: Unable to locate element.");
//			Reporter.log(noSuchElementException.getRawMessage());

			throw noSuchElementException;
		} catch (TimeoutException timeoutException) {
			Reporter.log("Test Failed: Timeout occurred while waiting for the element.");
//			Reporter.log(timeoutException.getRawMessage());

			throw timeoutException;
		}
	}

//	for test case 16
	public String productSearchForSpclCharacter() {
		try {
			waitManager.waitExplicit(specialCharacterSearch, driver);

			return specialCharacterSearch.getText();
		} catch (NoSuchElementException noSuchElementException) {
			Reporter.log("Test Failed: Unable to locate element.");
//			Reporter.log(noSuchElementException.getRawMessage());

			throw noSuchElementException;
		} catch (TimeoutException timeoutException) {
			Reporter.log("Test Failed: Timeout occurred while waiting for the element.");
//			Reporter.log(timeoutException.getRawMessage());

			throw timeoutException;
		}
	}

//	for test case 17
	String poularSearchName;

	public void clickAProductFromPopularSearch() {
		try {
			waitManager.waitExplicit(popularSearchText, driver);
			poularSearchName = popularProductName.getText();

			screenShots.takeScreenshot("search", "verifyPopularSearchFunctionality(1)");
			Reporter.log(
					"<a href= \"C:\\Users\\saru.dhavamani\\Desktop\\Selenium\\Application_Max\\screenshots\\search\\verifyPopularSearchFunctionality(1).png\" target = \"_blank\">Screenshot: Choose product from popular searches</a>");

			popularProductName.click();
		} catch (NoSuchElementException noSuchElementException) {
			Reporter.log("Test Failed: Unable to locate element.");
//			Reporter.log(noSuchElementException.getRawMessage());

			throw noSuchElementException;
		} catch (TimeoutException timeoutException) {
			Reporter.log("Test Failed: Timeout occurred while waiting for the element.");
//			Reporter.log(timeoutException.getRawMessage());

			throw timeoutException;
		} catch (IOException ioException) {
			Reporter.log("Test Failed: Exception while taking screenshot.");
//			Reporter.log(ioException.getMessage());
		}
	}

	public boolean popularSearchResult() {
		try {
			waitManager.waitExplicit(poularSearchResult, driver);

			if (poularSearchResult.getText().contains(poularSearchName)) {
				return true;
			} else {
				return false;
			}

		} catch (NoSuchElementException noSuchElementException) {
			Reporter.log("Test Failed: Unable to locate element.");
//			Reporter.log(noSuchElementException.getRawMessage());

			throw noSuchElementException;
		} catch (TimeoutException timeoutException) {
			Reporter.log("Test Failed: Timeout occurred while waiting for the element.");
//			Reporter.log(timeoutException.getRawMessage());

			throw timeoutException;
		}
	}

//	for test case 18
	public boolean clearRecentSearch() throws InterruptedException {
		try {
			clickSearchBox();

			enterProductName("Tops");

			screenShots.takeScreenshot("search", "clearRecentSearch(1)");
			Reporter.log(
					"<a href= \"C:\\Users\\saru.dhavamani\\Desktop\\Selenium\\Application_Max\\screenshots\\search\\clearRecentSearch(1).png\" target = \"_blank\">Screenshot: Search for Tops</a>");
			submitSearchBox();

			Thread.sleep(2000);

			waitManager.waitExplicit(searchResult, driver);

			screenShots.takeScreenshot("search", "clearRecentSearch(2)");
			Reporter.log(
					"<a href= \"C:\\Users\\saru.dhavamani\\Desktop\\Selenium\\Application_Max\\screenshots\\search\\clearRecentSearch(2).png\" target = \"_blank\">Screenshot: Search result</a>");

			clearSearch();
			Thread.sleep(2000);

			Actions actions = new Actions(driver);

			if (recentSearchHeading.isDisplayed()) {
				screenShots.takeScreenshot("search", "clearRecentSearch(3)");
				Reporter.log(
						"<a href= \"C:\\Users\\saru.dhavamani\\Desktop\\Selenium\\Application_Max\\screenshots\\search\\clearRecentSearch(3).png\" target = \"_blank\">Screenshot: Clearing the search field values</a>");
				actions.doubleClick(clearRecentButton).perform();
				waitManager.waitImplicit(driver);
				return true;
			}

		} catch (NoSuchElementException noSuchElementException) {
			Reporter.log("Test Failed: Unable to locate element.");
//			Reporter.log(noSuchElementException.getRawMessage());

			throw noSuchElementException;
		} catch (TimeoutException timeoutException) {
			Reporter.log("Test Failed: Timeout occurred while waiting for the element.");
//			Reporter.log(timeoutException.getRawMessage());

			throw timeoutException;
		} catch (IOException ioException) {
			Reporter.log("Test Failed: Exception while taking screenshot");

//			Reporter.log(ioException.getMessage());
		}
		return false;
	}
}
