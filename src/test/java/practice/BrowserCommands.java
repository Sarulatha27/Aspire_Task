package practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
/*
 * Practice Exercise - 1 Browser Commands
 * Launch a new Edge browser.Open Shop.DemoQA.com
 * Get Page Title name and Title length
 * Print Page Title and Title length on the Eclipse Console.
 * Get Page URL and verify if it is a correct page opened
 * Get Page Source (HTML Source code) and Page Source length
 * Print Page Length on Eclipse Console.
 * Close the Browser.
 */
public class BrowserCommands {

	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();
		String url = "https://demoqa.com/";
		driver.get(url);
		
		System.out.println("Title : " +driver.getTitle());
		System.out.println("Title Length : " + driver.getTitle().length());
		
		System.out.println("URL : "+ driver.getCurrentUrl());
		System.out.println("URL Length : " + driver.getCurrentUrl().length());
		
		System.out.println("Source Code : "+ driver.getPageSource());
		System.out.println("Source Code Length : " + driver.getPageSource().length());
		
		if(url.equals(driver.getCurrentUrl())) {
			System.out.println("URL matched");
		}
		else {
			System.out.println("URL not matched");
		}
		
		driver.quit(); //driver.close();
	}

}
