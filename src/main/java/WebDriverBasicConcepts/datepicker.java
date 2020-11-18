package WebDriverBasicConcepts;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class datepicker 
{
	@Test
	public void datepickerdemo()  
	{
		System.setProperty("webdriver.chrome.driver", "D:\\SeleniumSoftware\\Drivers"
				+ "\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.booking.com/");
		
		driver.findElement(By.xpath("//span[@class='sb-date-field__icon sb-date-field__icon-btn bk-svg-wrapper calendar-restructure-sb']")).click();
		String checkinmonth="December 2020";
		String checkindate="27";
		while(true)
		{
		 String month=driver.findElement(By.xpath("(//div[@class='bui-calendar__month'])[1]")).getText();
		 if(month.equals(checkinmonth))
		 {
			 break;
		 }
		 else
		 {
			 driver.findElement(By.xpath("//div[@class='bui-calendar__control bui-calendar__control--next']")).click();
		 }
		 List <WebElement> ele= driver.findElements(By.xpath("(//tbody)[1]//tr//td/span"));
		 for(WebElement element:ele)
		 {
			 String date=element.getText();
			 if(date.equals(checkindate))
			 {
				 element.click();
				 break;
			 }
		 }
		}
	}
}
