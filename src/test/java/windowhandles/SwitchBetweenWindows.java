package windowhandles;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class SwitchBetweenWindows {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com");
		System.out.println(driver.getTitle());
		
		String mainWindow = driver.getWindowHandle();
		System.out.println(mainWindow);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.className("Pke_EE")).sendKeys("Realme mobile");
		
		driver.findElement(By.xpath("//ul/li[3]/div/a")).click();
		
		driver.findElement(By.xpath("//div[@data-id='MOBH4KZABPGTZJQA']//a[@class='CGtC98']")).click();
		
		Set<String> multipleWindows = driver.getWindowHandles();
		System.out.println(multipleWindows);
		
		for(String handle: multipleWindows) {
			
			if(!handle.equals(mainWindow)) {
				driver.switchTo().window(handle);
				System.out.println("Switched to 2nd window");
				System.out.println(driver.getTitle());
				Thread.sleep(4000);
			}
		}
		
		System.out.println("Switched to Main window");
		driver.switchTo().window(mainWindow);
		Thread.sleep(1000);
		driver.findElement(By.className("zDPmFV")).sendKeys(Keys.CONTROL+"a");
		driver.findElement(By.className("zDPmFV")).sendKeys(Keys.BACK_SPACE);
		driver.findElement(By.className("zDPmFV")).sendKeys("Sarulatha");
		System.out.println(driver.getTitle());
		Thread.sleep(2000);
		
		driver.navigate().back();
		Thread.sleep(2000);
		driver.quit();
		
	}

}
