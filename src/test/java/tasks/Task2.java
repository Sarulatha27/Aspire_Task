package tasks;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Task2 {
	// Search the particular product on Flipkart, get all the list of product name from the search result and print on console
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new EdgeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://www.flipkart.com/");
		
		WebElement searchProduct = driver.findElement(By.className("Pke_EE"));
		searchProduct.sendKeys("Samsung watch");
		
		List<WebElement> listOfProducts = driver.findElements(By.className("_1sFryS"));
		Thread.sleep(3000);
		
		System.out.println("Search Suggestion list");
		System.out.println("-----------------------");
		for(WebElement productName : listOfProducts) {
			System.out.println(productName.getText());
		}
		
		driver.quit();
	}

}
