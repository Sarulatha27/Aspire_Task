package actions;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class MoveToElement {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.com/");
		
		WebElement element = driver.findElement(By.xpath("//div[@id='nav-xshop']/a[5]"));
		
		Actions action = new Actions(driver);
		Thread.sleep(2000);
		
		action.moveToElement(element).perform();
		
		Thread.sleep(2000);
		
		driver.quit();
		
	}

}
