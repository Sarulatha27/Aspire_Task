package pages;

import java.io.IOException;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import maxapplication.ScreenShots;
import maxapplication.WaitManager;

public class LoginPage {
	WebDriver driver;
	WaitManager waitManager = new WaitManager();
	ScreenShots screenShots;

	@FindBy(id = "account-actions-signup")
	WebElement signInButton;

	@FindBy(xpath = "//div[contains(text(),'Sign up or Sign in')]")
	WebElement signInHeading;

	@FindBy(id = "mobileNumber")
	WebElement mobileNumber;

	@FindBy(id = "signup-form-submit")
	WebElement continueButton;

	@FindBy(xpath = "//span[contains(text(),'sent to +917708715475')]")
	WebElement otpReceivedMsg;

	@FindBy(xpath = "//span[@id='mobile']")
	WebElement errorMobileNumber;

	@FindBy(xpath = "//input[@name='otp1']")
	WebElement otp;

	@FindBy(xpath = "//div[contains(text(),'Please enter the correct 5-digit verification code to continue')]")
	WebElement errorOtpNumber;

	@FindBy(xpath = "//button[@aria-label='user-icon']")
	WebElement accountButton;

	@FindBy(xpath = "//a/span[contains(text(),'Sign Out']")
	WebElement signOutButton;

	@FindBy(xpath = "//span[contains(text(),'Change?')]")
	WebElement changeMobileNumButton;

	@FindBy(xpath = "//span[contains(text(),\"Didn't get it? resend\")]")
	WebElement resendOTPButton;

	@FindBy(xpath = "//div[contains(text(),\"We've re-sent your code. please try again in\")]")
	WebElement otpResentText;

	@FindBy(xpath = "//span[contains(text(),'sent to +916381616938')]")
	WebElement numberCheck;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		screenShots = new ScreenShots(driver);
	}

	public void clickSignInButton() {
		try {
			signInButton.click();
		} catch (NoSuchElementException noSuchElementException) {
			Reporter.log("Test Failed: Unable to locate element.");
//			Reporter.log(noSuchElementException.getRawMessage());
			throw noSuchElementException;
		}
	}

	public void enterMobileNumber(String mobileNum) {
		try {
			waitManager.waitExplicit(mobileNumber, driver);
			mobileNumber.sendKeys(mobileNum);
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

//	for test case 2
	public boolean returnSignInFormTitle() {
		try {
			waitManager.waitExplicit(signInHeading, driver);
			if (signInHeading.isDisplayed()) {
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

//	for test case 3 and 4
	public boolean errorMobileMsg() {
		try {
			waitManager.waitExplicit(errorMobileNumber, driver);
			if (errorMobileNumber.isDisplayed()) {
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

//	for test case 4
	public void clickContinueButton() {
		try {
			continueButton.click();
		} catch (NoSuchElementException noSuchElementException) {
			Reporter.log("Test Failed: Unable to locate element.");
//			Reporter.log(noSuchElementException.getRawMessage());
			throw noSuchElementException;
		}
	}

//	for test case 5
	public boolean returnOtpConfirMsg() {
		try {
			waitManager.waitExplicit(otpReceivedMsg, driver);
			if (otpReceivedMsg.isDisplayed()) {
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

//	for test case 6
	public void enterOtp(String otp) {
		try {
			waitManager.waitExplicit(this.otp, driver);
			this.otp.sendKeys(otp);
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

	public String errorOtpMsg() {
		try {
			waitManager.waitExplicit(errorOtpNumber, driver);
			screenShots.takeScreenshot("login", "verifyIncorrectOtpErrorMsg(2)");
			Reporter.log(
					"<a href= \"C:\\Users\\saru.dhavamani\\Desktop\\Selenium\\Application_Max\\screenshots\\login\\verifyIncorrectOtpErrorMsg(2).png\" target = \"_blank\">Screenshot: Incorrect OTP message</a>");
			return errorOtpNumber.getText();
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
		return null;
	}

//	for test case 7
	public void clickChangeButton() {
		try {
			waitManager.waitExplicit(changeMobileNumButton, driver);
			screenShots.takeScreenshot("login", "VerifyMobileNumChangeAndOtpVerification(2)");
			Reporter.log(
					"<a href= \"C:\\Users\\saru.dhavamani\\Desktop\\Selenium\\Application_Max\\screenshots\\login\\VerifyMobileNumChangeAndOtpVerification(2).png\" target = \"_blank\">Screenshot: Visibility of OTP page</a>");
			changeMobileNumButton.click();
		} catch (NoSuchElementException noSuchElementException) {
			Reporter.log("Test Failed: Unable to locate element.");
//			Reporter.log(noSuchElementException.getRawMessage());
			throw noSuchElementException;
		} catch (TimeoutException timeoutException) {
			Reporter.log("Test Failed: Timeout occurred while waiting for the element.");
//			Reporter.log(timeoutException.getRawMessage());
			throw timeoutException;
		} catch (IOException ioException) {
			Reporter.log("Test Failed: Exception while taking scree+nshot.");
//			Reporter.log(ioException.getMessage());
		}
	}

	public boolean checkOtpReceivedNewNumber() {
		try {
			waitManager.waitExplicit(numberCheck, driver);
			if (numberCheck.isDisplayed()) {
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

//	for test case 8
	public void resendOTP() {
		try {
			waitManager.waitExplicit(resendOTPButton, driver);
			screenShots.takeScreenshot("login", "verifyResendOtpFunctionality(2)");
			Reporter.log(
					"<a href = \"C:\\Users\\saru.dhavamani\\Desktop\\Selenium\\Application_Max\\screenshots\\login\\verifyResendOtpFunctionality(2).png\" target = \"_blank\">Screenshot: Visibility of OTP page</a>");
			resendOTPButton.click();
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
			Reporter.log(ioException.getMessage());
		}
	}

	public boolean checkOtpResent() {
		try {
			waitManager.waitExplicit(otpResentText, driver);
			screenShots.takeScreenshot("login", "verifyResendOtpFunctionality(3)");
			Reporter.log(
					"<a href = \"C:\\Users\\saru.dhavamani\\Desktop\\Selenium\\Application_Max\\screenshots\\login\\verifyResendOtpFunctionality(3).png\" target = \"_blank\">Screenshot: Resent OTP page</a>");
			if (otpResentText.isDisplayed()) {
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

}
