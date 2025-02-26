package testng_framework;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Module1 {

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Before Suite Module 1");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("Before Test Module 1");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("Before Class Module 1");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Before Method Module 1");
	}

	@Test(groups = "login")
	public void func1() {
		System.out.println("Function 1 Module 1");
	}

	@Test
	public void func2() {
		System.out.println("Function 2 Module 1");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("After Method Module 1");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("After Class Module 1");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("After Test Module 1");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("After Suite Module 1");
	}
}
