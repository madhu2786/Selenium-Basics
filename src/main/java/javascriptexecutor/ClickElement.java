package javascriptexecutor;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ClickElement
{
	public static void main(String[] args) throws IOException, InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "D:\\SeleniumSoftware\\Drivers"
				+ "\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("http://demo.automationtesting.in/Index.html");
		WebElement email=driver.findElement(By.xpath("//input[@id='email']"));
		WebElement loginButton=driver.findElement(By.xpath("//button[@id='btn2']"));
		
		
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].value='madhu'",email);
		js.executeScript("arguments[0].click();",loginButton);
		
		WebElement switchTo=driver.findElement(By.xpath("//a[text()='SwitchTo']"));
		WebElement Windows=driver.findElement(By.xpath("//a[text()='Windows']"));
		Thread.sleep(2000);
		js.executeScript("arguments[0].onmouseover()",switchTo );
		
		/*
		 * Actions action=new Actions(driver);
		 * action.moveToElement(switchTo).build().perform(); Windows.click();
		 */		//refresh browser
		js.executeScript("history.go(0)");
		
		String title=js.executeScript("return document.title;").toString();
	    System.out.println("The title is "+title);
		
	}
}
