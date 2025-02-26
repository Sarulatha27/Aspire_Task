package tasks;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class Task7 {

	// Launch the site https://demoqa.com/date-picker and handle the date time picker
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/date-picker");
		Thread.sleep(1000);
		
		// Select date using keys 
		WebElement datePicker = driver.findElement(By.id("datePickerMonthYearInput"));
		datePicker.click();
		datePicker.sendKeys(Keys.CONTROL+"a");
		datePicker.sendKeys(Keys.BACK_SPACE);
		datePicker.sendKeys("03/25/2002");
		datePicker.sendKeys(Keys.TAB);
		System.out.println("Entered Date : " + datePicker.getAttribute("value"));
		
		
		// Select date using drop down list
		WebElement month = driver.findElement(By.className("react-datepicker__month-select"));
		Select monthDropDown = new Select(month);
		monthDropDown.selectByValue("9");
		WebElement year = driver.findElement(By.className("react-datepicker__year-select"));
		Select yearDropDown = new Select(year);
		yearDropDown.selectByValue("2001");
		WebElement chooseDate = driver.findElement(By.className("react-datepicker__day--027"));
		chooseDate.click();
		System.out.println("Selected Date : " + datePicker.getAttribute("value"));
		
		// Select Date And Time using keys
		WebElement dateTime = driver.findElement(By.id("dateAndTimePickerInput"));
		dateTime.click();
		dateTime.sendKeys(Keys.CONTROL+"a");
		dateTime.sendKeys(Keys.BACK_SPACE);
		dateTime.sendKeys("October 27, 2001 5:30 PM");
		System.out.println(dateTime.getAttribute("value"));
	
		Thread.sleep(1000);
		
		driver.quit();
	}

}
