package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class RadioButton {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new EdgeDriver();
		
		driver.get("https://www.tutorialspoint.com/selenium/practice/radio-button.php");
		
		driver.manage().window().maximize();
		
		WebElement yes = driver.findElement(By.xpath("//input[@class=\"form-check-input\" and @value=\"igottwo\"]"));
		WebElement impressive = driver.findElement(By.xpath("//input[@class=\"form-check-input\" and @value=\"igotthree\"]"));
		WebElement disabledButton = driver.findElement(By.xpath("//input[@class=\"form-check-input\" and @value=\"option3\"]"));
		
		Thread.sleep(500);
		yes.click();
		System.out.println("Yes: "+ yes.isSelected()+"   "+"Impressive: "+ impressive.isSelected());
		
		Thread.sleep(500);
		impressive.click();
		System.out.println("Yes: "+ yes.isSelected()+"   "+"Impressive: "+ impressive.isSelected());
		System.out.println(disabledButton.isEnabled());
		
		Thread.sleep(500);
		driver.quit();
		
	}

}
