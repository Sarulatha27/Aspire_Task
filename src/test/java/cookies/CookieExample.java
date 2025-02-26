package cookies;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class CookieExample {

	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/automation-practice-form");
		
		Cookie userdata = new Cookie("Name","Sarulatha D");
		driver.manage().addCookie(userdata);
		
		Set<org.openqa.selenium.Cookie> cookie = driver.manage().getCookies();
		for(Cookie c: cookie) {
			System.out.println("Values" + c.getValue());
		}
		
		Cookie data = driver.manage().getCookieNamed("Name");
		System.out.println("one cookie value" +data.getValue());

		driver.manage().deleteCookieNamed("Name");
		driver.manage().deleteAllCookies();
		
		System.out.println(driver.manage().getCookies());
		
		driver.quit();
	}

}
