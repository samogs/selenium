package firstProject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class StaticDropdown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\browserDrivers\\chrome\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
//		Getting the url
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
//		Dropdown with select tag
		WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select dropdown = new Select(staticDropdown);
		
//		Selecting an index of 3 which is USD from the static dropdown
		dropdown.selectByIndex(3);		
//		To confirm that the USD is actually selected
		System.out.println(dropdown.getFirstSelectedOption().getText());
		
//		Selecting by text, say AED
		dropdown.selectByVisibleText("AED");	
//		To confirm that the USD is actually selected
		System.out.println(dropdown.getFirstSelectedOption().getText());
		
//		Selecting by Value Attribute, say INR
		dropdown.selectByValue("INR");	
//		To confirm that the USD is actually selected
		System.out.println(dropdown.getFirstSelectedOption().getText());
		

	}

}
