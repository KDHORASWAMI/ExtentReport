import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowsAction {
	public static void main(String args[])
	{
		System.setProperty("webdriver.chrome.driver", "G:\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in");
		driver.findElement(By.xpath("//a[text()='Books']")).click();
		Set<String> ids = driver.getWindowHandles();
		Iterator<String> its = ids.iterator();
		String parent=its.next();
		String child=its.next();
		System.out.println(driver.getTitle());
		driver.switchTo().window(parent);
		
	}

}
