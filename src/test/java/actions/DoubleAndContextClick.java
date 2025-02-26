package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class DoubleAndContextClick {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.tutorialspoint.com/selenium/practice/resizable.php");
		
		Actions actions = new Actions(driver);
		
		WebElement element = driver.findElement(By.xpath("//header/div/h1"));
		
		Thread.sleep(2000);
		
		actions.doubleClick(element).perform();
		
		Thread.sleep(2000);
		
		actions.contextClick(element).perform();
		
		Thread.sleep(2000);
		
		driver.quit();
		
	}

}
