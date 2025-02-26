package tasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Task1 {

	// Automate Login Page of Flipkart (Try to login and verify landed on landing page)
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new EdgeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://www.flipkart.com");
		
		Thread.sleep(1000);
		WebElement loginButton = driver.findElement(By.className("_1jKL3b"));
		loginButton.click();
		
		WebElement mobileNumber = driver.findElement(By.className("r4vIwl"));
		mobileNumber.sendKeys("7708715475");
	
		driver.findElement(By.className("QqFHMw")).click();
		Thread.sleep(2000);
		
		driver.quit();
		
	}

}
