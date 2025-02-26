package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class CheckBox {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new EdgeDriver();
		driver.get("https://www.tutorialspoint.com/selenium/practice/check-box.php");
		
		driver.manage().window().maximize();
		
		Thread.sleep(500);
		WebElement mainLevel1 = driver.findElement(By.xpath("//input[@id=\"c_bs_1\"]"));
		
		mainLevel1.click();
		
		WebElement mainLevel2 = driver.findElement(By.xpath("//input[@id=\"c_bs_2\"]"));
		
		System.out.println("Is Checkbox1 selected: " + mainLevel1.isSelected());
		System.out.println("Is Checkbox2 selected: " + mainLevel2.isSelected());
		
		Thread.sleep(500);
		driver.quit();
	}

}
