import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Autosuggetion {
	public static void main(String args[]) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "E:\\COURSES\\Selenium \\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.apsrtconline.in");
		int i=0;
		driver.findElement(By.xpath("//input[@id='fromPlaceName']")).sendKeys("AMAR");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='fromPlaceName']")).sendKeys(Keys.DOWN);
		
		//Javascript executer
		JavascriptExecutor jr = (JavascriptExecutor)driver;
		String script = "return document.getElementById(\"fromPlaceName\").value;";
		String text = (String) jr.executeScript(script);
		System.out.println(text);
		while(!text.equalsIgnoreCase("AMARAVATI(GNT)"))
		{
			i++;
			driver.findElement(By.xpath("//input[@id='fromPlaceName']")).sendKeys(Keys.DOWN);
			text = (String) jr.executeScript(script);
			System.out.println(text);
			if(i>10)
			{
				break;
			}
		}
		if(i>10)
		{
			System.out.println("Element not found");
		}
		else
		{
			System.out.println("Element found");
		}
	}

}
