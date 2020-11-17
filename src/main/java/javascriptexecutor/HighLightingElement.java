package javascriptexecutor;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HighLightingElement 
{
	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "D:\\SeleniumSoftware\\Drivers"
				+ "\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("http://demo.automationtesting.in/Index.html");
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("Madhu");
		WebElement loginButton=driver.findElement(By.xpath("//img[@id='enterimg']"));
		flash(loginButton,driver);
		//driver.quit();
	}
	public static void flash(WebElement element,WebDriver driver)
	{
		JavascriptExecutor js=((JavascriptExecutor)driver);
		String bgcolor=element.getCssValue("backgroundColor");
		for(int i=0;i<200;i++) {
		js.executeScript("arguments[0].style.backgroundColor='rgb(300,0,0)'", element);
		js.executeScript("arguments[0].style.backgroundColor='"+bgcolor+"'", element);
	}
		}
}
