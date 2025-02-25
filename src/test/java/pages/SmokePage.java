package pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
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

public class SmokePage {
	WebDriver driver;
	ScreenShots screenShots;
	Actions actions;
	String mainWindow;
	Set<String> multipleWindows;

	WaitManager waitManager = new WaitManager();

	@FindBy(xpath = "//div[@id='page-header']/a")
	WebElement title;

	@FindBy(xpath = "//input[@type='search']")
	WebElement searchBox;

	@FindBy(tagName = "h1")
	WebElement searchResultText;

	@FindBy(xpath = "//input[@aria-label='minimum-input']")
	WebElement minimumPrice;

	@FindBy(xpath = "//input[@aria-label='maximum-input']")
	WebElement maximumPrice;

	@FindBy(xpath = "//button[@aria-label='right-arrow-icon']")
	WebElement priceSubmitButton;

	@FindBy(xpath = "//span[@class='MuiChip-label']")
	WebElement priceFilterAppliedConButton;

	@FindBy(xpath = "//div[@id='product-5']/div/div/a/img")
	WebElement productName;

	@FindBy(xpath = "//div[@id='product-5']")
	WebElement productLink;

	@FindBy(xpath = "//h1")
	WebElement productNameInDetailedPage;

	@FindBy(xpath = "//div[@id='details-size']/div/div[3]/div/div[2]/button[@data-code='1000014825094']")
	WebElement sizeSButton;

	@FindBy(xpath = "//span[contains(text(),'Body Measurement: To Fit Chest -34 inches')]")
	WebElement sizeConfirmationText;

	@FindBy(xpath = "//div[@id='notify-quantity']/div/div/button")
	WebElement addToBasketButton;

	@FindBy(xpath = "//span[contains(text(),'GO TO BASKET')]")
	WebElement goToBasketButton;

	@FindBy(xpath = "//button[@aria-label='cart-icon-1']")
	WebElement basketButton;

	@FindBy(xpath = "//button/span[contains(text(),'Checkout now')]")
	WebElement checkOutButton;

	@FindBy(xpath = "//div[contains(text(),'Sign up or Sign in')]")
	WebElement signInFormText;

	public SmokePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		screenShots = new ScreenShots(this.driver);
		actions = new Actions(driver);
	}

//	TC_019
	@SuppressWarnings("deprecation")
	public String getAppLogoText() {
		try {
			return title.getAttribute("aria-label");
		} catch (NoSuchElementException noSuchElementException) {
			Reporter.log("Test Failed: Unable to locate element.");
//			Reporter.log(noSuchElementException.getRawMessage());

			throw noSuchElementException;
		}

	}

//	TC_020
	public void clickSearchBox() {
		try {
			waitManager.waitExplicit(searchBox, driver);
			searchBox.click();
		} catch (NoSuchElementException noSuchElementException) {
			Reporter.log("Test Failed: Unable to locate element.");
//			Reporter.log(noSuchElementException.getRawMessage());

			throw noSuchElementException;
		} catch (TimeoutException timeoutException) {
			Reporter.log(
					"Test Failed: Timeout occurred while waiting for the element.");
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

	public String productSearchResultName() {
		try {
			waitManager.waitImplicit(driver);
			waitManager.waitExplicit(searchResultText, driver);

			screenShots.takeScreenshot("smokeTest", "verifyProductSearchFunctionality(2)");
			Reporter.log(
					"<a href= \"C:\\Users\\saru.dhavamani\\Desktop\\Selenium\\Application_Max\\screenshots\\smokeTest\\verifyProductSearchFunctionality(2).png\" target = \"_blank\">Screenshot: Search result</a>");

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

//	TC_021
	public void applyPriceFilter() {
		try {
			waitManager.waitExplicit(minimumPrice, driver);
			minimumPrice.sendKeys(Keys.CONTROL + "a");
			minimumPrice.sendKeys(Keys.BACK_SPACE);
			minimumPrice.sendKeys("600");

			screenShots.takeScreenshot("smokeTest", "verifySearchAndApplyPriceFilter(1)");
			Reporter.log(
					"<a href= \"C:\\Users\\saru.dhavamani\\Desktop\\Selenium\\Application_Max\\screenshots\\smokeTest\\verifySearchAndApplyPriceFilter(1).png\" target = \"_blank\">Screenshot: Entering minimum price</a>");

			maximumPrice.sendKeys(Keys.CONTROL + "a");
			maximumPrice.sendKeys(Keys.BACK_SPACE);
			maximumPrice.sendKeys("1000");

			screenShots.takeScreenshot("smokeTest", "verifySearchAndApplyPriceFilter(2)");
			Reporter.log(
					"<a href= \"C:\\Users\\saru.dhavamani\\Desktop\\Selenium\\Application_Max\\screenshots\\smokeTest\\verifySearchAndApplyPriceFilter(2).png\" target = \"_blank\">Screenshot: Entering maximum price</a>");

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

//	TC_022
	@SuppressWarnings("deprecation")
	public String getProductName() {
		try {
			return productName.getAttribute("alt");
		} catch (NoSuchElementException noSuchElementException) {
			Reporter.log("Test Failed: Unable to locate element.");
//			Reporter.log(noSuchElementException.getRawMessage());

			throw noSuchElementException;
		}
	}

	public void clickAProduct() throws InterruptedException {
		try {
			actions.scrollToElement(productLink).perform();
			screenShots.takeScreenshot("smokeTest", "clickProduct(1)");
			Reporter.log(
					"<a href= \"C:\\Users\\saru.dhavamani\\Desktop\\Selenium\\Application_Max\\screenshots\\smokeTest\\clickProduct(1).png\" target = \"_blank\">Screenshot: Clicking a product from search result</a>");

			actions.click(productLink).perform();
			Thread.sleep(3000);
		} catch (NoSuchElementException noSuchElementException) {
			Reporter.log("Test Failed: Unable to locate element.");
//			Reporter.log(noSuchElementException.getRawMessage());

			throw noSuchElementException;
		} catch (IOException ioException) {
			Reporter.log("Test Failed: Exception while taking screenshot.");
//			Reporter.log(ioException.getMessage());
		}

	}

	public void switchWindows() {
		mainWindow = driver.getWindowHandle();
		multipleWindows = driver.getWindowHandles();
		List<String> mulWindows = new ArrayList<>(multipleWindows);
		if (mulWindows.size() > 1) {
			Reporter.log("Switching the control to the next tab");
			driver.switchTo().window(mulWindows.get(1));
			Reporter.log("Switched the control to the next tab");
		}
	}

	public String getProductNameInDetailedPage() {
		try {
			screenShots.takeScreenshot("smokeTest", "clickProduct(2)");
			Reporter.log(
					"<a href= \"C:\\Users\\saru.dhavamani\\Desktop\\Selenium\\Application_Max\\screenshots\\smokeTest\\clickProduct(2).png\" target = \"_blank\">Screenshot: Visibility of product detailed page</a>");
			return productNameInDetailedPage.getText();
		} catch (NoSuchElementException noSuchElementException) {
			Reporter.log("Test Failed: Unable to locate element.");
//			Reporter.log(noSuchElementException.getRawMessage());

			throw noSuchElementException;
		} catch (IOException ioException) {
			Reporter.log("Test Failed: Exception while taking screenshot.");
//			Reporter.log(ioException.getMessage());
		}
		return "";
	}

//	TC_023
	public boolean chooseSize() throws InterruptedException {
		try {
			Thread.sleep(2000);
			Reporter.log("Scrolling to view the size option");
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,800);");
			Reporter.log("Scrolled the page and size option is visible");
			screenShots.takeScreenshot("smokeTest", "chooseSize(1)");
			Reporter.log(
					"<a href= \"C:\\Users\\saru.dhavamani\\Desktop\\Selenium\\Application_Max\\screenshots\\smokeTest\\chooseSize(1).png\" target = \"_blank\">Screenshot: Scrolled to view sizes</a>");
			Reporter.log("Clicking the size S button");
			actions.click(sizeSButton).perform();
			Reporter.log("Cliced the size S button");
			waitManager.waitExplicit(sizeConfirmationText, driver);
			Reporter.log("Verifying size S is choosed");
			if (sizeConfirmationText.isDisplayed()) {
				screenShots.takeScreenshot("smokeTest", "chooseSize(2)");
				Reporter.log(
						"<a href= \"C:\\Users\\saru.dhavamani\\Desktop\\Selenium\\Application_Max\\screenshots\\smokeTest\\chooseSize(2).png\" target = \"_blank\">Screenshot: Clicked size S</a>");

				return true;
			}
			return false;
		} catch (NoSuchElementException noSuchElementException) {
			Reporter.log("Test Failed: Unable to locate element.");
//			Reporter.log(noSuchElementException.getRawMessage());

			throw noSuchElementException;
		} catch (IOException ioException) {
			Reporter.log("Test Failed: Exception while taking screenshot.");
//			Reporter.log(ioException.getMessage());
		}
		return false;
	}

//	TC_024
	public boolean addToBasket() throws InterruptedException {
		try {
			screenShots.takeScreenshot("smokeTest", "addProductToBasket(1)");
			Reporter.log(
					"<a href= \"C:\\Users\\saru.dhavamani\\Desktop\\Selenium\\Application_Max\\screenshots\\smokeTest\\addProductToBasket(1).png\" target = \"_blank\">Screenshot: Adding product to basket</a>");

			Reporter.log("Adding product to the basket");
			actions.click(addToBasketButton).perform();
			Reporter.log("Added product to the basket");
			waitManager.waitExplicit(goToBasketButton, driver);
			Reporter.log("Verifying product is added to the basket by checking go to basket button is visible");
			if (goToBasketButton.isDisplayed()) {
				Thread.sleep(7000);
				screenShots.takeScreenshot("smokeTest", "addProductToBasket(2)");
				Reporter.log(
						"<a href= \"C:\\Users\\saru.dhavamani\\Desktop\\Selenium\\Application_Max\\screenshots\\smokeTest\\addProductToBasket(2).png\" target = \"_blank\">Screenshot: Added product to the basket</a>");

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

//	TC_026
	public void clickBasketButton() {
		try {
			Reporter.log("Clicking basket button");
			actions.click(basketButton).perform();
			Reporter.log("Clicked basket button");
			screenShots.takeScreenshot("smokeTest", "clickBasketButton(1)");
			Reporter.log(
					"<a href= \"C:\\Users\\saru.dhavamani\\Desktop\\Selenium\\Application_Max\\screenshots\\smokeTest\\clickBasketButton(1).png\" target = \"_blank\">Screenshot: Opening basket page</a>");
		} catch (NoSuchElementException noSuchElementException) {
			Reporter.log("Test Failed: Unable to locate element.");
//			Reporter.log(noSuchElementException.getRawMessage());

			throw noSuchElementException;
		} catch (IOException ioException) {
			Reporter.log("Test Failed: Exception while taking screenshot.");
//			Reporter.log(ioException.getMessage());
		}

	}

	public boolean checkOutNow() throws InterruptedException {
		try {
			waitManager.waitExplicit(checkOutButton, driver);
			Reporter.log("Scrolling to view the checkout option");
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,250);");
			Reporter.log("Scrolled the page and checkout option is visible");
			screenShots.takeScreenshot("smokeTest", "checkOutNow(1)");
			Reporter.log(
					"<a href= \"C:\\Users\\saru.dhavamani\\Desktop\\Selenium\\Application_Max\\screenshots\\smokeTest\\checkOutNow(1).png\" target = \"_blank\">Screenshot: Clicking checkout button</a>");

			Reporter.log("Clicking the checkout now button");
			actions.click(checkOutButton).perform();
			Reporter.log("Clicked the checkout now button");
			waitManager.waitExplicit(signInFormText, driver);
			if (signInFormText.isDisplayed()) {
				Thread.sleep(1000);
				screenShots.takeScreenshot("smokeTest", "checkOutNow(2)");
				Reporter.log(
						"<a href= \"C:\\Users\\saru.dhavamani\\Desktop\\Selenium\\Application_Max\\screenshots\\smokeTest\\checkOutNow(2).png\" target = \"_blank\">Screenshot: Sign in form visibility after clicking checkout</a>");
				Thread.sleep(2000);
				return true;
			}
			return false;
		} catch (NoSuchElementException noSuchElementException) {
			Reporter.log("Test Failed: Unable to locate element.");
//			Reporter.log(noSuchElementException.getRawMessage());

			throw noSuchElementException;
		} catch (IOException ioException) {
			Reporter.log("Test Failed: Exception while taking screenshot.");
//			Reporter.log(ioException.getMessage());
		}
		return false;
	}
}
