package maxapplication;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShots {

	public WebDriver webDriver;

	public ScreenShots(WebDriver driver) {
		webDriver = driver;
	}

	public void takeScreenshot(String folderName,String fileName) throws IOException {
		File source = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
		File destination = new File("./screenshots/" + folderName + "/"+  fileName + ".png");
		FileUtils.copyFile(source, destination);
	}
}
