package WebDriverBasicConcepts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class pageloadtimeout
{
	//pageloadtimeout:It is time taken for a particular page to get loaded.
	//If the page doesn't load in a specified time then it throws an exception.
	@Test
	public void pageloadtime() 
	{
		System.setProperty("webdriver.chrome.driver", "D:\\SeleniumSoftware\\Drivers"
				+ "\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
		driver.get("https://www.google.com/");
		driver.quit();
	}

}
