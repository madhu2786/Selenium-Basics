package WebDriverBasicConcepts;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Pagination 
{
	@Test
	public void paginationdemo() throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "D:\\SeleniumSoftware\\Drivers"
				+ "\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.myntra.com/boys-tshirts?f=Brand%3AAllen%20Solly%20Junior");
		
	    String displayedcount=driver.findElement(By.xpath("//span[@class='title-count']")).getText().split(" ")[1];
	    WebElement nextButton=driver.findElement(By.xpath("//li[@class='pagination-next']"));
	    JavascriptExecutor js=(JavascriptExecutor)driver;
	    js.executeScript("window.scrollBy(0,5000);");
	    
	    List<WebElement> products=driver.findElements(By.xpath("//li[@class='product-base']//a//descendant::div[@class='product-productMetaInfo']//h4[@class='product-product']"));
        List<String> productnames=new ArrayList();
        for(WebElement names:products)
        {
        	productnames.add(names.getText());
        	System.out.println(names.getText());
        }
        System.out.println("*********************************");
        while(true)
        {
        	 Thread.sleep(2000);
        	 nextButton.click();
        	 Thread.sleep(3000);
        	 js.executeScript("window.scrollBy(0,5000);");
        	 Thread.sleep(3000);
        	 products=driver.findElements(By.xpath("//li[@class='product-base']//a//descendant::div[@class='product-productMetaInfo']//h4[@class='product-product']"));
        	 for(WebElement names:products)
             {
             	productnames.add(names.getText());
             	System.out.println(names.getText());
             }
        	 System.out.println("*********************************");
        	 try
        	 {
        		 nextButton=driver.findElement(By.xpath("//li[@class='pagination-next']"));
        	 }
        	 catch(Exception e)
        	 {
        		 System.out.println("NO MORE PRODUCTS NOW");
        		 break;
        	 }
        }
        System.out.println("*********************************");
        
        System.out.println("My number of products are: "+productnames.size());
        System.out.println("The total number of products on webpage: "+displayedcount);
        
}
}

