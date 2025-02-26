package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class ClickAndHold_Release {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.guru99.com/keyboard-mouse-events-files-webdriver.html");
		
		Actions actions = new Actions(driver);
		
		WebElement element = driver.findElement(By.xpath("//strong[contains(text(),'clickAndHold()')]"));
		
		Thread.sleep(1000);
		
		actions.scrollToElement(driver.findElement(By.xpath("//strong[contains(text(),'contextClick()')]")));
		
		Thread.sleep(1000);
		
		actions.clickAndHold(element).perform();
		
		Thread.sleep(1000);
		
		actions.release(element).perform();
		
		Thread.sleep(1000);
		
		driver.quit();

	}

}
