package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Files {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.tutorialspoint.com/selenium/practice/upload-download.php");
		
		Thread.sleep(500);
		WebElement file = driver.findElement(By.id("uploadFile"));
		Thread.sleep(500);
		file.sendKeys("C:/Users/saru.dhavamani/Downloads/Payslip_Nov_2024.pdf");
		Thread.sleep(1000);
		driver.close();
	}

}
