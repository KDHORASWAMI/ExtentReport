
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalendarAbhibus {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Work\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.abhibus.com/");
		driver.findElement(By.xpath("//input[@id='datepicker1']")).click();
		while(!driver.findElement(By.cssSelector("[class='ui-datepicker-group ui-datepicker-group-first'] [class='ui-datepicker-month']")).getText().contains("January"))
		{
			driver.findElement(By.cssSelector("[class='ui-icon ui-icon-circle-triangle-e']")).click();
		}
		List<WebElement>days = driver.findElements(By.cssSelector("[class='ui-datepicker-group ui-datepicker-group-first'] [class='ui-state-default']"));
		int count = driver.findElements(By.cssSelector("[class='ui-datepicker-group ui-datepicker-group-first'] [class='ui-state-default']")).size();
		for(int i=0;i<count;i++)
		{
			String text = days.get(i).getText();
			if(text.equalsIgnoreCase("13"))
			{
				driver.findElements(By.cssSelector("[class='ui-datepicker-group ui-datepicker-group-first'] [class='ui-state-default']")).get(i).click();
				break;
			}
		}
		
		
	}



}
