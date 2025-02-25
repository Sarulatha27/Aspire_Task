package maxapplication;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitManager extends DriverManager {

	public void waitImplicit(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
	}

	public void waitExplicit(WebElement element, WebDriver driver) {
		WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(40));
		webDriverWait.until(ExpectedConditions.visibilityOf(element));
	}
}
