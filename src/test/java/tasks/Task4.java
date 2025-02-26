package tasks;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Task4 {

	/* Get and print the product specification details in console for the particular product from the product details page. 
	   Write reusable to get the particular specification by specification name.
	   Example: When given specification name is "Network Type" the method should return "4G, 3G, 2G". Refer Diagram. */
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new EdgeDriver();
//		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		
		WebElement searchProduct = driver.findElement(By.className("Pke_EE"));
		searchProduct.click();
		searchProduct.sendKeys("Realme mobile");
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//ul//li[3]/div/a[@class='oleBil']")).click();
		
		WebElement productLink = driver.findElement(By.xpath("//div[@class=\"DOjaWF gdgoEp\"]/div[2]//a[@class='CGtC98']"));
		productLink.click();
		driver.get(productLink.getAttribute("href"));
		
		WebElement nameOfTheProduct = driver.findElement(By.className("VU-ZEz"));
		
		System.out.println("Product Name : "+nameOfTheProduct.getText());
		
		driver.findElement(By.xpath("//button[@class='_4FgsLt']")).click();
		Thread.sleep(3000);
		
//		List<WebElement> specificationName = driver.findElements(By.xpath("//div[@class='_4BJ2V+']"));
//		System.out.println(specificationName.get(4).getText());
		
		
//		List<WebElement> specificationDetails = driver.findElements(By.xpath("//div[@class='GNDEQ-'][4]//table/tbody/tr[1]/td[1]"));
//		System.out.println(specificationDetails);
//		Thread.sleep(500);
//		driver.quit();
		
	}

}
