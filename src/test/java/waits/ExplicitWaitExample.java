package waits;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitExample {

	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://leafground.com/waits.xhtml");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("//button[@id='j_idt87:j_idt89']")).click();
		
		WebElement visibleElement = driver.findElement(By.xpath("//span[contains(text(),'I am here')]"));
		wait.until(ExpectedConditions.visibilityOf(visibleElement));
		
		System.out.println(visibleElement.getText());
		
		driver.quit();
	}

}

