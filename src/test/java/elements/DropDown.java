package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDown {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new EdgeDriver();
		
		driver.get("https://demo.guru99.com/test/newtours/register.php");
		
		driver.manage().window().maximize();
		Thread.sleep(1000);
		WebElement country = driver.findElement(By.name("country"));
		Select countrySelect = new Select(country);
		
		countrySelect.selectByValue("SWEDEN");
		System.out.println(countrySelect.getFirstSelectedOption().getText());
		countrySelect.selectByVisibleText("ALBANIA");
		System.out.println(countrySelect.getFirstSelectedOption().getText());
		
		driver.quit();
	}

}
