package testng_framework;

	 import org.openqa.selenium.By;
	 import org.openqa.selenium.WebDriver;
	 import org.openqa.selenium.chrome.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

	 public class Parallel {
	 	public WebDriver driver;
	         @Test
	         public void EdgeTest() {	 
	             //Initializing the firefox driver (Gecko)
//	 	    driver = new EdgeDriver();	  
//	 	    driver.get("https://demoqa.com/"); 
//	 	    driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[1]/div/div[1]")).click();
//	 	    driver.quit();
	        	 System.out.println("Hi Sarulatha");
	          }
	  
	         @Test
	  	public void ChromeTest()
	  	{ 
	 	  //Initialize the chrome driver
//	 	  driver = new ChromeDriver();
//	 	  driver.get("https://demoqa.com/"); 
//	 	  driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[1]/div/div[1]")).click();
//	 	  driver.quit();
	        	 System.out.println("Hi Saru");
	  	}
	 }


