import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Calendar {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "G:\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.path2usa.com/travel-companions");
		driver.findElement(By.id("travel_date")).click();
		while(!driver.findElement(By.cssSelector("[class='datepicker-days'] [class='datepicker-switch']")).getText().contains("November"))
			{
				driver.findElement(By.cssSelector("[class=' table-condensed'] [class='next']")).click();
			}
		List<WebElement> days = driver.findElements(By.className("day"));
		int count = driver.findElements(By.cssSelector("td[class='day']")).size();
		for(int i=0;i<count;i++)
		{
			//String text = driver.findElements(By.cssSelector("td[class='day']")).get(i).getText();
			String text = days.get(i).getText();
			if(text.equalsIgnoreCase("26"))
			{
				driver.findElements(By.cssSelector("td[class='day']")).get(i).click();
				break;
			}
		}

	}

}
