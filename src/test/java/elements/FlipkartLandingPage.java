package elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FlipkartLandingPage{

	public static void main(String[] args) throws InterruptedException{
		
		// creating driver for edge 
		WebDriver driver = new ChromeDriver();
		
		// loads the flipkart page
		driver.get("https://www.flipkart.com");
		
		//maximizing the window
		driver.manage().window().maximize();
		
		Thread.sleep(3000);
		
		// closes the browser window
		driver.quit();
	}

}
