package elements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Table {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new EdgeDriver();
		
		driver.manage().window().maximize();	
		driver.get("https://www.tutorialspoint.com/selenium/practice/webtables.php");
		
		List<WebElement> rowCount = driver.findElements(By.xpath("//div[@class=\"bd-example table-responsive\"]/table/tbody/tr"));
		System.out.println("Size of the table: "+ rowCount.size());
		
		Thread.sleep(500);
		List<WebElement> rowData = driver.findElements(By.xpath("//div[@class=\"bd-example table-responsive\"]/table/tbody/tr[3]"));
		for(WebElement row: rowData) {
			System.out.println(row.getText());
		}
		
		driver.quit();
	}

}
