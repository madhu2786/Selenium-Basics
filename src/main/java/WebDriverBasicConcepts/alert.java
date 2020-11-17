package WebDriverBasicConcepts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.Alert;

public class alert 
{
	@Test
	public void Alert() 
	{
		System.setProperty("webdriver.chrome.driver", "D:\\SeleniumSoftware\\Drivers"
				+ "\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("http://demo.automationtesting.in/Alerts.html");
		driver.findElement(By.xpath("//button[@onclick='alertbox()']")).click();
		Alert alert=driver.switchTo().alert();
		String ActualText=alert.getText();
		String ExpectedText="I am an alert box!";
		Assert.assertEquals(ActualText, ExpectedText);
		if(ActualText.equals(ExpectedText))
		{System.out.println("Alert message verified successfully");}
		else
		{System.out.println("ERROR HERE!!!!!!!!!!!");}
		//driver.quit();
	}
}
