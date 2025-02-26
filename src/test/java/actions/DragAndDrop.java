package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://jqueryui.com/resources/demos/droppable/default.html");
		
		WebElement draggable = driver.findElement(By.id("draggable"));
		
		WebElement droppable = driver.findElement(By.id("droppable"));
		
		Actions actions = new Actions(driver);
		 
		Thread.sleep(500); 
		
		actions.dragAndDrop(draggable, droppable).perform();
		
		Thread.sleep(500);
		
		driver.quit();
		
	}

}
