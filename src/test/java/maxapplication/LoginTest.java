package maxapplication;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.LoginPage;

public class LoginTest extends DriverManager {
	LoginPage loginPage;
	ScreenShots screenShots;
	WebDriver webDriver;
	String expectedResult, actualResult;

	@BeforeMethod(groups = { "login-sanity" })
	public void setUp() {
		webDriver = setUpDriver();
		loginPage = new LoginPage(webDriver);
		screenShots = new ScreenShots(webDriver);
	}

//	TC_002
	@Test(groups = {
			"login-sanity" }, priority = 1, description = "Verifies that clicking the sign-in button redirects the user to the sign-in page")
	public void verifySignInForm() {
		try {
			Reporter.log("Attempting to click the sign-in button.");
			loginPage.clickSignInButton();
			Reporter.log("Sign-in button clicked successfully.");

			Reporter.log("Verifying if the sign-in form is displayed.");
			Assert.assertTrue(loginPage.returnSignInFormTitle());

			screenShots.takeScreenshot("login", "verifySignInForm(1)");
			Reporter.log(
					"<a href= \"C:\\Users\\saru.dhavamani\\Desktop\\Selenium\\Application_Max\\screenshots\\login\\verifySignInForm(1).png\" target = \"_blank\">Screenshot: Sign in form</a>");

			Reporter.log("Test passed: Sign-in form is displayed and screenshot captured.");
		} catch (AssertionError assertionError) {
			Reporter.log("Test Failed: Unable to open the sign in form.");
//			Reporter.log(assertionError.getMessage());

			throw assertionError;
		} catch (IOException ioException) {
			Reporter.log("Test Failed: Exception while taking screenshot.");
//			Reporter.log(ioException.getMessage());
		}
	}

//  TC_003
	@Test(groups = {
			"login-sanity" }, priority = 2, description = "Verifies user can sign in without entering nothing in mobile number field ")
	public void verifyMobileNumErrorMsg() {
		try {
			Reporter.log("Attempting to click the sign-in button.");
			loginPage.clickSignInButton();
			Reporter.log("Sign-in button clicked successfully.");

			screenShots.takeScreenshot("login", "verifyMobileNumErrorMsg(1)");
			Reporter.log(
					"<a href= \"C:\\Users\\saru.dhavamani\\Desktop\\Selenium\\Application_Max\\screenshots\\login\\verifyMobileNumErrorMsg(1).png\" target = \"_blank\">Screenshot: Sign in form</a>");
		
			Reporter.log("Clicking the continue button.");
			loginPage.clickContinueButton();
			Reporter.log("Clicked continue button.");

			Assert.assertTrue(loginPage.errorMobileMsg());
			screenShots.takeScreenshot("login", "verifyMobileNumErrorMsg(2)");
			Reporter.log(
					"<a href= \"C:\\Users\\saru.dhavamani\\Desktop\\Selenium\\Application_Max\\screenshots\\login\\verifyMobileNumErrorMsg(2).png\" target = \"_blank\">Screenshot: Mobile number error</a>");

			Reporter.log("Test Passed: Mobile number error message is displayed as expected and screenshot captured.");
		} catch (AssertionError assertionError) {
			Reporter.log("Test Failed: Please enter mobile number error message is not displayed as expected.");
//			Reporter.log(assertionError.getMessage());

			throw assertionError;
		} catch (IOException ioException) {
			Reporter.log("Test Failed: Exception while taking screenshot.");
//			Reporter.log(ioException.getMessage());
		}
	}

//	TC_004
	@Test(groups = {
			"login-sanity" }, priority = 3, description = "Verifies user can sign in with invalid mobile number")
	public void verifyInvalidMobileNumErrorMsg() {
		try {
			Reporter.log("Attempting to click the sign-in button.");
			loginPage.clickSignInButton();
			Reporter.log("Sign-in button clicked successfully.");

			Reporter.log("Entering invalid mobile number: 77087");
			loginPage.enterMobileNumber("77087");
			Reporter.log("Entered mobile number : 77087");

			screenShots.takeScreenshot("login", "verifyInvalidMobileNumErrorMsg(1)");
			Reporter.log(
					"<a href= \"C:\\Users\\saru.dhavamani\\Desktop\\Selenium\\Application_Max\\screenshots\\login\\verifyInvalidMobileNumErrorMsg(1).png\" target = \"_blank\">Screenshot: Entering mobile number</a>");
			Reporter.log("Clicking the continue button.");
			loginPage.clickContinueButton();
			Reporter.log("Clicked continue button.");

			Assert.assertTrue(loginPage.errorMobileMsg());

			screenShots.takeScreenshot("login", "verifyInvalidMobileNumErrorMsg(2)");
			Reporter.log(
					"<a href= \"C:\\Users\\saru.dhavamani\\Desktop\\Selenium\\Application_Max\\screenshots\\login\\verifyInvalidMobileNumErrorMsg(2).png\" target = \"_blank\">Screenshot: Mobile number error</a>");

			Reporter.log(
					"Test passed: Error message displayed as expected for invalid mobile number and screenshot captured.");
		} catch (AssertionError assertionError) {
			Reporter.log("Test Failed: Please enter a valid 10-digit mobile number is not displayed as expected.");
//			Reporter.log(assertionError.getMessage());

			throw assertionError;
		} catch (IOException ioException) {
			Reporter.log("Test Failed: Exception while taking screenshot.");
//			Reporter.log(ioException.getMessage());
		}
	}

//  TC_005
	@Test(groups = { "login-sanity" }, priority = 4, description = "Verifies user can sign in with valid mobile number")
	public void verifyOtpConfirmationMsg() {
		try {
			Reporter.log("Attempting to click the sign-in button.");
			loginPage.clickSignInButton();
			Reporter.log("Sign-in button clicked successfully.");

			Reporter.log("Entering mobile number: 7708715475");
			loginPage.enterMobileNumber("7708715475");
			Reporter.log("Entered mobile number : 7708715475");

			screenShots.takeScreenshot("login", "verifyOtpConfirmationMsg(1)");
			Reporter.log(
					"<a href= \"C:\\Users\\saru.dhavamani\\Desktop\\Selenium\\Application_Max\\screenshots\\login\\verifyOtpConfirmationMsg(1).png\" target = \"_blank\">Screenshot: Entering mobile number</a>");

			Reporter.log("Clicking the continue button.");
			loginPage.clickContinueButton();
			Reporter.log("Clicked continue button.");

			Reporter.log("Verifying OTP confirmation message.");
			Assert.assertTrue(loginPage.returnOtpConfirMsg());
			Reporter.log("OTP confirmation message is displayed successfully.");

			screenShots.takeScreenshot("login", "verifyOtpConfirmationMsg(2)");
			Reporter.log(
					"<a href= \"C:\\Users\\saru.dhavamani\\Desktop\\Selenium\\Application_Max\\screenshots\\login\\verifyOtpConfirmationMsg(2).png\" target = \"_blank\">Screenshot: Visibility of OTP page</a>");

			Reporter.log("Test Passed: OTP confirmation message displayed as expected and screenshot captured.");
		} catch (AssertionError assertionError) {
			Reporter.log("Test Failed: OTP confirmation message is not displayed as expected.");
//			Reporter.log(assertionError.getMessage());

			throw assertionError;
		} catch (IOException ioException) {
			Reporter.log("Test Failed: Exception while taking screenshot.");
//			Reporter.log(ioException.getMessage());
		}
	}

//	TC_006
	@Test(groups = {
			"login-sanity" }, priority = 5, description = "Verifies user can sign in by entering valid mobile number and invalid OTP number")
	public void verifyIncorrectOtpErrorMsg() {
		try {
			Reporter.log("Attempting to click the sign-in button.");
			loginPage.clickSignInButton();
			Reporter.log("Sign-in button clicked successfully.");

			Reporter.log("Entering mobile number: 7708715475");
			loginPage.enterMobileNumber("7708715475");
			Reporter.log("Entered mobile number : 7708715475");

			screenShots.takeScreenshot("login", "verifyIncorrectOtpErrorMsg(1)");
			Reporter.log(
					"<a href= \"C:\\Users\\saru.dhavamani\\Desktop\\Selenium\\Application_Max\\screenshots\\login\\verifyIncorrectOtpErrorMsg(1).png\" target = \"_blank\">Screenshot: Entering mobile number</a>");
			Reporter.log("Clicking the continue button.");
			loginPage.clickContinueButton();
			Reporter.log("Clicked continue button.");

			Reporter.log("Entering OTP: 12345");
			loginPage.enterOtp("12345");

			expectedResult = "Please enter the correct 5-digit verification code to continue";

			Reporter.log("Retrieving actual OTP error message.");
			actualResult = loginPage.errorOtpMsg();

			Assert.assertEquals(actualResult, expectedResult);
			Reporter.log(
					"Test passed: Please enter the correct 5-digit verification code to continue is displayed as expected and screenshot captured.");

		} catch (AssertionError assertionError) {
			Reporter.log(
					"Test Failed: Please enter the correct 5-digit verification code to continue is not displayed as expected.");
//			Reporter.log(assertionError.getMessage());

			throw assertionError;
		} catch (IOException ioException) {
			Reporter.log("Test Failed: Exception while taking screenshot.");
//			Reporter.log(ioException.getMessage());
		}
	}

//	TC_007
	@Test(groups = {
			"login-sanity" }, priority = 6, description = "Verifies user can change the mobile number during signin and sign in to the website")
	public void VerifyMobileNumChangeAndOtpVerification() {
		try {
			Reporter.log("Attempting to click the sign-in button.");
			loginPage.clickSignInButton();
			Reporter.log("Sign-in button clicked successfully.");

			Reporter.log("Entering mobile number: 7708715475");
			loginPage.enterMobileNumber("7708715475");
			Reporter.log("Entered mobile number : 7708715475");

			screenShots.takeScreenshot("login", "VerifyMobileNumChangeAndOtpVerification(1)");
			Reporter.log(
					"<a href= \"C:\\Users\\saru.dhavamani\\Desktop\\Selenium\\Application_Max\\screenshots\\login\\VerifyMobileNumChangeAndOtpVerification(1).png\" target = \"_blank\">Screenshot: Entering mobile Number</a>");
			Reporter.log("Clicking the continue button.");
			loginPage.clickContinueButton();
			Reporter.log("Clicked continue button.");

			Reporter.log("Clicking the change button.");
			loginPage.clickChangeButton();
			Reporter.log("Clicked change button.");

			Reporter.log("Entering a new mobile number: 6381616938");
			loginPage.enterMobileNumber("6381616938");
			Reporter.log("Entered a new mobile number : 6381616938");

			screenShots.takeScreenshot("login", "VerifyMobileNumChangeAndOtpVerification(3)");
			Reporter.log(
					"<a href= \"C:\\Users\\saru.dhavamani\\Desktop\\Selenium\\Application_Max\\screenshots\\login\\VerifyMobileNumChangeAndOtpVerification(3).png\" target = \"_blank\">Screenshot: Entering new mobile number</a>");

			Reporter.log("Clicking the continue button after entering new mobile number.");
			loginPage.clickContinueButton();
			Reporter.log("Clicked continue button.");

			Reporter.log("Verifying if OTP is received for the new mobile number.");
			Assert.assertTrue(loginPage.checkOtpReceivedNewNumber());

			screenShots.takeScreenshot("login", "VerifyMobileNumChangeAndOtpVerification(4)");
			Reporter.log(
					"<a href= \"C:\\Users\\saru.dhavamani\\Desktop\\Selenium\\Application_Max\\screenshots\\login\\VerifyMobileNumChangeAndOtpVerification(4).png\" target = \"_blank\">Screenshot: Visibility of OTP page</a>");

			Reporter.log(
					"Test Passed: Mobile number is changed and otp is not sent for the new mobile number as expected and screenshot captured");

		} catch (AssertionError assertionError) {
			Reporter.log(
					"Test Failed: Mobile number is not changed and otp is not sent for the new mobile number as expected");
//			Reporter.log(assertionError.getMessage());

			throw assertionError;
		} catch (IOException ioException) {
			Reporter.log("Test Failed: Exception while taking screenshot.");
//			Reporter.log(ioException.getMessage());
		}
	}

//	TC_008
	@Test(groups = {
			"login-sanity" }, priority = 7, description = "Verifies OTP resend functionality for valid mobile number")
	public void verifyResendOtpFunctionality() {
		try {
			Reporter.log("Attempting to click the sign-in button.");
			loginPage.clickSignInButton();
			Reporter.log("Sign-in button clicked successfully.");

			Reporter.log("Entering mobile number: 7708715475");
			loginPage.enterMobileNumber("7708715475");
			Reporter.log("Entered mobile number : 7708715475");

			screenShots.takeScreenshot("login", "verifyResendOtpFunctionality(1)");
			Reporter.log(
					"<a href = \"C:\\Users\\saru.dhavamani\\Desktop\\Selenium\\Application_Max\\screenshots\\login\\verifyResendOtpFunctionality(1).png\" target = \"_blank\">Screenshot: Entering mobile number</a>");

			Reporter.log("Clicking the continue button.");
			loginPage.clickContinueButton();
			Reporter.log("Clicked continue button.");

			Reporter.log("Clicking the resend otp button");
			loginPage.resendOTP();
			Reporter.log("Clicked the resend otp button");

			Reporter.log("Verifying if OTP is resent for the mobile number.");
			Assert.assertTrue(loginPage.checkOtpResent());

			Reporter.log("Test Passed: Resent OTP is sent for the mobile number as expected and screenshot captured.");

		} catch (AssertionError assertionError) {
			Reporter.log("Test Failed: Resent otp is not sent for the mobile number as expected");
//			Reporter.log(assertionError.getMessage());

			throw assertionError;
		} catch (IOException ioException) {
			Reporter.log("Test Failed: Exception while taking screenshot.");
//			Reporter.log(ioException.getMessage());
		}
	}

	@AfterMethod(groups = { "login-sanity" })
	public void closeDriver() {
		closeBrowser();
	}
}
