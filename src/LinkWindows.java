import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinkWindows {
	public static void main(String args[]) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "G:\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice");
		driver.findElements(By.tagName("a")).size();
		WebElement footerdriver = driver.findElement(By.id("gf-BIG"));
		footerdriver.findElements(By.tagName("a")).size();
		WebElement coupendriver = footerdriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		coupendriver.findElements(By.tagName("a")).size();
		for(int i=1;i<coupendriver.findElements(By.tagName("a")).size();i++)
		{
			String clicklinks = Keys.chord(Keys.CONTROL,Keys.ENTER);
			coupendriver.findElements(By.tagName("a")).get(i).sendKeys(clicklinks);
			Thread.sleep(5000);
		}
		driver.switchTo().defaultContent();
		Set<String> abc = driver.getWindowHandles();
		Iterator<String> it = abc.iterator();
		while(it.hasNext())
		{
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
		}
		
	}

}
