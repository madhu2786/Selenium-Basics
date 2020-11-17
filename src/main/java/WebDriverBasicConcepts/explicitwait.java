package WebDriverBasicConcepts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class explicitwait
{
	//Explicitwait timeout is specific to elements.
	//applied using WebDriverWait class using some ExpectedConditions 
	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "D:\\SeleniumSoftware\\Drivers"
				+ "\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/");
		WebElement Name=driver.findElement(By.xpath("//input[@name='email']"));
		WebElement PassWord=driver.findElement(By.xpath("//input[@name='pass']"));
		WebElement Button=driver.findElement(By.xpath("//button[@name='login']"));
		sendkeys(driver,Name,20,"madhuri15269@gmail.com");
		sendkeys(driver,PassWord,20,"shobha");
		Button.click();
		//driver.quit();
	}
	public static void sendkeys(WebDriver driver,WebElement element,int timeout,
			String value)
	{
		WebDriverWait w1=new WebDriverWait(driver,20);
		w1.until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(value);
	}
	public static void click(WebDriver driver,WebElement element,int timeout)
	{
		WebDriverWait w2=new WebDriverWait(driver,20);
		w2.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}

}
