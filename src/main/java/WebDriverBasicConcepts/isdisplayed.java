package WebDriverBasicConcepts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class isdisplayed 
{
	@Test
	public void isdisplayed1() 
	{
		System.setProperty("webdriver.chrome.driver", "D:\\SeleniumSoftware\\Drivers"
				+ "\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("\"http://demo.automationtesting.in/Index.html");
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("jira");
		driver.findElement(By.xpath("//img[@id='enterimg']")).click();
		
		driver.quit();
	}

}
