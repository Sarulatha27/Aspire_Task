package frames;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class IFrameExample {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.tutorialspoint.com/selenium/practice/frames.php");
		
		Actions action = new Actions(driver);
		
		System.out.println(driver.findElement(By.xpath("//h1[contains(text(),'Frames')]")).getText());
		
		System.out.println(driver.findElement(By.xpath("//h2[contains(text(),'Iframe 1')]")).getText());
		
		driver.switchTo().frame(0);
		action.scrollToElement(driver.findElement(By.xpath("//h1[contains(text(),'New Tab')]"))).perform();
		driver.switchTo().defaultContent();
		
		System.out.println(driver.findElement(By.xpath("//h2[contains(text(),'Iframe 2')]")).getText());
		driver.switchTo().frame(1);
		action.scrollToElement(driver.findElement(By.xpath("//h1[contains(text(),'New Tab')]"))).perform();
		
		Thread.sleep(1000);
		driver.quit();
	}

}
