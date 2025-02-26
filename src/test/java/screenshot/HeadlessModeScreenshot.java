package screenshot;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;

public class HeadlessModeScreenshot {

	public static void main(String[] args) throws IOException, InterruptedException {
		EdgeOptions options = new EdgeOptions();
		
		options.addArguments("--headless");
		
		WebDriver driver = new EdgeDriver(options);
		
		driver.get("https://www.flipkart.com/");
		
		Actions actions = new Actions(driver);
		
		WebElement element = driver.findElement(By.className("Pke_EE"));
		
		actions.sendKeys(element,"Apple Iphone").perform();
		
		Thread.sleep(2000);
		
		File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File destination = new File("./screenshots/headlessScreenshot.png");
		
		FileUtils.copyFile(screenshot, destination);
		System.out.println("Screenshot saved successfully");
		
		Thread.sleep(500);
		
		driver.quit();
	}

}
