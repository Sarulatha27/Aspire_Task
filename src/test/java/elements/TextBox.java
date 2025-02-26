package elements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class TextBox {

	public static void main(String[] args) throws InterruptedException {
	
		WebDriver driver = new EdgeDriver();
		
		driver.get("https://www.tutorialspoint.com/selenium/practice/text-box.php");
		
		driver.manage().window().maximize();
		
		Thread.sleep(2000);
		
		WebElement name = driver.findElement(By.id("fullname"));
		
		name.sendKeys("Sarulatha D");
		
		WebElement email = driver.findElement(By.id("email"));
		
		email.sendKeys("sarulathadhavamani@gmail.com");
		
		WebElement heading = driver.findElement(By.className("mb-3"));
		
		System.out.println(heading.getText());
		
		System.out.println(name.getAttribute("value")+"  "+email.getAttribute("value"));
		
		// finding how many tags present in a web page
		List<WebElement> input = driver.findElements(By.tagName("input"));
		
		System.out.println(input.size());
		
		Thread.sleep(2000);
		
		driver.quit();
	}

}
