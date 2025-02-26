package intranetautomation;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class Intranet {

	public static void main(String[] args) {
		WebDriver driver;
		
		driver = new EdgeDriver();
		
		Actions action = new Actions(driver);
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://systems.aspiresys.com/");
		
		String homepage = driver.getWindowHandle();
		
		driver.findElement(By.className("login")).click();
		
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("saru.dhavamani@aspiresys.com");
		
		driver.findElement(By.xpath("//button[contains(text(),'Next')]")).click();
		
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("@SharuSurya7708");
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		driver.findElement(By.id("allapps")).click();
		
		driver.findElement(By.xpath("//div/div[5]/a[@class='link']")).click();
		
		Set<String> windowsName = driver.getWindowHandles();
		
		for(String handle: windowsName) {
			if(!handle.equals(windowsName)) {
				driver.switchTo().window(handle);
			}
		}
		
		action.moveToElement(driver.findElement(By.className("has-sub"))).perform();
		
		driver.findElement(By.id("mnu_MyProfile")).click();
				
		
	}

}
