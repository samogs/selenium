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
		
//		Dynamically calling the getPassword method
		String password = getPassword(driver);
		String name = "Samuel";
		driver.findElement(By.className("go-to-login-btn")).click();
		driver.findElement(By.id("inputUsername")).sendKeys(name);
		driver.findElement(By.name("inputPassword")).sendKeys(password);
		Thread.sleep(2000);
		driver.findElement(By.className("signInBtn")).click();
		
//		Getting Logged in Test
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.cssSelector("body p")).getText());
		Assert.assertEquals(driver.findElement(By.cssSelector("body p")).getText(), "You are successfully logged in.");
		
//		Getting greeting after logged in
		Assert.assertEquals(driver.findElement(By.tagName("h2")).getText(), "Hello "+name+",");
		driver.findElement(By.className("logout-btn")).click();
		driver.close();

	}
	
	public static String getPassword(WebDriver driver) throws InterruptedException
	
	{
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("button[class='reset-pwd-btn']")).click();
		
//		Creating a variable for the password text
		String passwordText = driver.findElement(By.cssSelector("form p")).getText();
		
//		Splitting the text to get just the password text (Please use temporary password 'rahulshettyacademy' to Login.)
//		First, split from the single quote
//		Note: After split, it will create an array of 2 index (0 and 1). 1st section of the text is 0 index while the other is 1 index.
//		E.g:
//		0th index => Please use temporary password '
//		1st index => rahulshettyacademy' to Login.
		String[] passwordArray = passwordText.split("'");
		String password = passwordArray[1].split("'")[0];
		return password;
		
		
	}

}
