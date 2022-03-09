package firstProject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class windowsMaximise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\browserDrivers\\chrome\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
//		Time implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
//		Getting the url
		driver.manage().window().maximize();
		
//		To navigate web pages
		driver.get("https://google.com/");
		driver.navigate().to("https://rahulshettyacademy.com/");
		driver.navigate().back();
		driver.navigate().forward();

	}

}
