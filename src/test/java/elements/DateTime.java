package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class DateTime {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new EdgeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");
		
		Thread.sleep(500);
		
		WebElement dateOfBirth = driver.findElement(By.id("dob"));
		dateOfBirth.sendKeys("27-10-2001");
		
		Thread.sleep(500);
		driver.quit();
	}
}
