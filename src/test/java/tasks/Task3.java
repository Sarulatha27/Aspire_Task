package tasks;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Task3 {

	/* Get any one random product name from the above list and click the item by find the product name and 
	   verify the product name in product/item details page */
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.flipkart.com");
		
		WebElement searchProduct = driver.findElement(By.className("Pke_EE"));
		searchProduct.sendKeys("Realme mobile");
		
		Thread.sleep(500);
		
		// printing the searched product suggestions
		/*
		System.out.println("Search Suggestion List");
		System.out.println("----------------");
		List<WebElement> suggestedSearch = driver.findElements(By.className("_1sFryS"));
		for(WebElement productName : suggestedSearch) {
			System.out.println(productName.getText());
		}
		System.out.println("----------------");
		*/
		
		//Clicking the 4th search suggestion
		driver.findElement(By.xpath("//ul/li[3]/div/a[@class='oleBil']")).click();	
		
		
		// Finding the name of the product in the list
		WebElement productName_1 = driver.findElement(By.xpath("//div[@class='DOjaWF gdgoEp']/div[2]//div[@class='KzDlHZ']"));
		
		String productName1 = productName_1.getText();
		
		System.out.println(productName1);

		// Getting and setting the product link in the driver
		WebElement link = driver.findElement(By.className("CGtC98"));
		
		productName_1.click();
		
		driver.get(link.getAttribute("href"));
		
		// Finding the name of the product in the product detailed page
		
		WebElement productName_2 = driver.findElement(By.className("VU-ZEz"));
		
		String productName2 = productName_2.getText();
		
		System.out.println(productName2);
		
		// Checking both the products are same
		if(productName2.contains(productName1)) {
			System.out.println("Product Matched");
		}
		else {
			System.out.println("Product Not Matched");
		}
		
		Thread.sleep(500);
		
		driver.quit();
		
	}

}
