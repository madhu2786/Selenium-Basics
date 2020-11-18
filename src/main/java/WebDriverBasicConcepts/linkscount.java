package WebDriverBasicConcepts;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class linkscount 
{
	@Test
	public void links() 
	{
		System.setProperty("webdriver.chrome.driver", "D:\\SeleniumSoftware\\Drivers"
				+ "\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
		driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_links_w3schools");
        List<WebElement> totallinks=driver.findElements(By.tagName("a"));
        System.out.println("total links are-->"+totallinks.size());
	}

}
