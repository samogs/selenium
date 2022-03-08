package firstProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class seleniumIntro {

	public static void main(String[] args) {
		// Invoke Browser
		// ChromeDriver
		
		// ChromeBrowser
		System.setProperty("webdriver.chrome.driver", "C:\\browserDrivers\\chrome\\chromedriver.exe");
		
		// WebDriver
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		driver.close();
		

	}

}
