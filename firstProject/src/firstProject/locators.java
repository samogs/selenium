package firstProject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class locators {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\browserDrivers\\chrome\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
//		Time implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
//		Getting the url
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		
//		Testing with wrong password:
		driver.findElement(By.id("inputUsername")).sendKeys("Samuel");
		driver.findElement(By.name("inputPassword")).sendKeys("Sam1234");
		driver.findElement(By.className("signInBtn")).click();
		System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
		
//		Testing the "Forget Password section"
		driver.findElement(By.linkText("Forgot your password?")).click();
		driver.findElement(By.cssSelector("input[placeholder='Name']")).sendKeys("Samuelson");
		driver.findElement(By.xpath("//input[@placeholder='Name']")).clear();
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("sam@gmail.com");
		driver.findElement(By.xpath("//input[@type='text'][2]")).clear();   // Indexing Xpath of email box
		driver.findElement(By.cssSelector("input[placeholder='Phone Number']")).sendKeys("09032145678");
		driver.findElement(By.xpath("//input[@type='text'][3]")).clear();
		driver.findElement(By.cssSelector("button[class='reset-pwd-btn']")).click();
		System.out.println(driver.findElement(By.cssSelector("form p")).getText());
		
//		Thread.sleep(2000);
//		Logging in with correct password:
		driver.findElement(By.className("go-to-login-btn")).click();
		driver.findElement(By.id("inputUsername")).sendKeys("Samuel");
		driver.findElement(By.name("inputPassword")).sendKeys("rahulshettyacademy");
		Thread.sleep(2000);
		driver.findElement(By.className("signInBtn")).click();
		
//		Getting Logged in Test
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.cssSelector("body p")).getText());
		Assert.assertEquals(driver.findElement(By.cssSelector("body p")).getText(), "You are successfully logged in.");
		driver.findElement(By.className("logout-btn")).click();
		driver.close();

	}

}
