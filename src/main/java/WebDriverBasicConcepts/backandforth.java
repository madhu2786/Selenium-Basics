package WebDriverBasicConcepts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class backandforth 
{
	@Test
	public void backandforth1() 
	{
		System.setProperty("webdriver.chrome.driver", "D:\\SeleniumSoftware\\Drivers"
				+ "\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

		driver.navigate().to("http://demo.automationtesting.in/Index.html");
		driver.findElement(By.xpath("//img[@id='enterimg']")).click();
		driver.navigate().forward();
		driver.navigate().back();
		driver.navigate().refresh();
		//driver.quit();
	}

}
