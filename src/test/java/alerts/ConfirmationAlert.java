package alerts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class ConfirmationAlert {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.tutorialspoint.com/selenium/practice/alerts.php");
		
		driver.findElement(By.xpath("//div[3]/button")).click();
		Thread.sleep(1000);
		Alert alert = driver.switchTo().alert();
		
		//alert.accept();
		alert.dismiss();
		Thread.sleep(1000);
		
	}

}
