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
import org.openqa.selenium.interactions.Actions;

public class ScreenShot {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com");
		
		Actions actions = new Actions(driver);
		
		WebElement element = driver.findElement(By.xpath("//span[contains(text(),'Electronics')]"));
		
		actions.moveToElement(element).perform();
		
		Thread.sleep(1000);
		
		File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); 
		/* TakesScreenshot screenshot = (TakesScreenshot)driver; 
		 * File shot = screenshot.getScreenshotAs(OutputType.FILE); */
		
		File location = new File("./screenshots/screenshotExample.png");
		
		FileUtils.copyFile(screenshot, location);
		
		driver.quit();
	}

}

