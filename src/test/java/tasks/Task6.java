package tasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Task6 {

	/* Launch the site https://demoqa.com/radio-button. Print the status (enabled/disabled) of the Radio button. 
	   Click the Radio button 'Yes' and print the status of the Radio button 'Yes'. */
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new EdgeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://demoqa.com/radio-button");
		
		Thread.sleep(500);
		
		WebElement yesRadio = driver.findElement(By.xpath("//label[@for='yesRadio']"));
		if(yesRadio.isEnabled()) {
			System.out.println("Radio button yes is enabled");
		}
		else {
			System.out.println("Radio button yes is disabled");
		}
		
		yesRadio.click();
		
		Thread.sleep(1000);
		
		if(driver.findElement(By.id("yesRadio")).isSelected()) {
			System.out.println("Yes radio button is selected");
		}
		else {
			System.out.println("Yes radio button is not selected");
		}
		
		driver.quit();
	}

}
