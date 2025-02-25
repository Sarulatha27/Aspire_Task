package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class HomePage {

	@FindBy(xpath = "//div[@id='page-header']/a")
	WebElement title;

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

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
}
