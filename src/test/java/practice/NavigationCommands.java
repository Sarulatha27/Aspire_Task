package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

/*
 * Practice Exercise - 2 Navigation Commands
 * Launch new Browser
 * Open https://www.flipkart.com/ website
 * Click on Registration link using "driver.findElement(By.xpath(".//[@id='menu-item-374']/a")).click();"
 * Come back to Home page (Use 'Back' command)
 * Again go back to Registration page (This time use 'Forward' command)
 * Again come back to Home page (This time use 'To' command)
 * Refresh the Browser (Use 'Refresh' command)
 * Close the Browser
 */

public class NavigationCommands {

	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		
		WebElement login = driver.findElement(By.className("_1TOQfO"));
		login.click();
		driver.navigate().back(); 
		
		driver.navigate().forward();
		driver.navigate().to("https://www.flipkart.com/");
		
		driver.navigate().refresh();
		driver.quit();
		
	}

}
