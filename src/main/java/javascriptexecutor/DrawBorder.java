package javascriptexecutor;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DrawBorder 
{
	public static void main(String[] args) throws IOException 
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
		drawBorder(loginButton,driver);
		File srcfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String currentdir=System.getProperty("user.dir");
		File destfile=new File(currentdir+"/screenshot"+".jpg");
		FileUtils.copyFile(srcfile, destfile);
		//driver.quit();
	} 
	public static void drawBorder(WebElement element,WebDriver driver)
	{
		JavascriptExecutor js=((JavascriptExecutor)driver);
		js.executeScript("arguments[0].style.border='3px solid red'", element);
	}

}
