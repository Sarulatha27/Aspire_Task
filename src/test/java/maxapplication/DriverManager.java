package maxapplication;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverManager {
	public WebDriver driver;

	// Method to initialize browser
	public WebDriver setUpDriver() {
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.maxfashion.in");
		return driver;
	}

	// Method to close the browser
	public void closeBrowser() {
		if (driver != null) {
			driver.quit();
		}
	}
}
