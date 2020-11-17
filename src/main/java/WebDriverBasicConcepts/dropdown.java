package WebDriverBasicConcepts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class dropdown 
{
	@Test
	public void dropdown1() 
	{
		System.setProperty("webdriver.chrome.driver", "D:\\SeleniumSoftware\\Drivers"
				+ "\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.facebook.com/reg/?rs=2");
		
		String arr[]= {"Month","Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
		WebElement month=driver.findElement(By.xpath("//select[@id='month']"));
		Select select=new Select(month);
		List<WebElement> dropdownoptions=select.getOptions();
		System.out.println(dropdownoptions.size());
		for(int i=0;i<dropdownoptions.size();i++)
		{
			Assert.assertEquals(arr[i], dropdownoptions.get(i).getText());
		}
		System.out.println("Dropdown Verification Successsful");
		
		//driver.quit();
	}

}
