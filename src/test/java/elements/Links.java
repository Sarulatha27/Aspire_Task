package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Links {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new EdgeDriver();
		
		driver.get("https://www.tutorialspoint.com/selenium/practice/links.php");
		
		driver.manage().window().maximize();
		
		Thread.sleep(500);
		
		driver.findElement(By.linkText("Created")).click();
		
		Thread.sleep(500);
		
		driver.findElement(By.partialLinkText("Found")).click();
		
        System.out.println("Is moved link selected : " + driver.findElement(By.linkText("Moved")).isSelected());
		
		Thread.sleep(500);
		
		driver.quit();
		
	}

}
