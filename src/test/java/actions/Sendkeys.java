package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class Sendkeys {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		
		Actions actions = new Actions(driver);
		
		WebElement element = driver.findElement(By.className("Pke_EE"));
		
		Thread.sleep(1000);
		
		actions.sendKeys(element,"Mobile").perform();
		
		Thread.sleep(1000);
		
		driver.quit();
	}

}
