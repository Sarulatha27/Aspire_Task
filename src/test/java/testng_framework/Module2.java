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

public class Module2 {

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Before Suite Module 2");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("Before Test Module 2");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("Before Class Module 2");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Before Method Module 2");
	}

	@Test(priority = 1,groups = "login")
	public void func1() {
		System.out.println("Function 1 Module 2");
	}

	@Test
	public void func2() {
		System.out.println("Function 2 Module 2");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("After Method Module 2");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("After Class Module 2");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("After Test Module 2");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("After Suite Module 2");
	}
}
