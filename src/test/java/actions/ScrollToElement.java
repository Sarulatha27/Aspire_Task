package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class ScrollToElement {
	public static void main(String [] args) throws InterruptedException {
		WebDriver driver = new EdgeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		
		WebElement element = driver.findElement(By.xpath("//div[contains(text(),'New Year Specials')]"));
		
		Actions action = new Actions(driver);
		
		Thread.sleep(1000);
		
		action.scrollToElement(element).perform();
		
		Thread.sleep(1000);
		
		driver.quit();
	}
}
