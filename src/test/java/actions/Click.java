package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class Click {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		
		Actions actions = new Actions(driver);
		
		WebElement element = driver.findElement(By.xpath("//div[@class='_38VF5e']//a[@class='_3RX0a- _3jeYYh']//img[@class='_1XmrCc']"));
		
		// To click a become a seller button
		actions.click(element).perform();
		
		driver.navigate().back();
		
		Thread.sleep(1000);
		
		driver.quit();
	}

}
