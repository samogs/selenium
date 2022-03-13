package firstProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UpdatedDropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\browserDrivers\\chrome\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
//		Maximising the url
		driver.manage().window().maximize();
		
//		Getting the url
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(2000L);
		
//		Using "While Loop" to make the cursor increment 4 times
		int i = 1;
		while(i < 5)
		{
			driver.findElement(By.id("hrefIncAdt")).click();
			i++;
		}
		
		driver.findElement(By.id("btnclosepaxoption")).click();

	}

}
