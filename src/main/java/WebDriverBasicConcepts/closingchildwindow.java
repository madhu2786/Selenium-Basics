package WebDriverBasicConcepts;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class closingchildwindow 
{
	@Test
	public void closewindow() 
	{
		System.setProperty("webdriver.chrome.driver", "D:\\SeleniumSoftware\\Drivers"
				+ "\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("http://demo.automationtesting.in/Register.html");
		Actions action=new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//a[text()='SwitchTo']")))
			.build().perform();
		driver.findElement(By.xpath("//a[text()='Windows']")).click();
		driver.findElement(By.xpath("//button[text()='    click   ']")).click();
		
		Set<String> handler=driver.getWindowHandles();
		Iterator<String> it=handler.iterator();
		
		String parentwindowid=it.next();
		String childwindowid=it.next();
		
		driver.switchTo().window(childwindowid).close();
		driver.switchTo().window(parentwindowid);
	}

}
