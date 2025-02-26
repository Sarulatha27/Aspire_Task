package alerts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class SimpleAlert {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.tutorialspoint.com/selenium/practice/alerts.php");
		
		driver.findElement(By.xpath("//div[1]/button")).click();
		
		Alert alert = driver.switchTo().alert();
		Thread.sleep(1000);
		alert.accept();
		Thread.sleep(2000);
		
		
		driver.findElement(By.xpath("//div[2]/button")).click();
		Thread.sleep(5000);
		alert.accept();
		Thread.sleep(2000);
		driver.quit();
	}

}
