import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandles {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Work\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/#");
		driver.findElement(By.cssSelector("a.blinkingText")).click();
		Set<String> windows = driver.getWindowHandles();	
		//System.out.println(windows);
		Iterator<String> itr  = windows.iterator();
		String parent = itr.next();
		//System.out.println(parent);
		String child = itr.next();
		Thread.sleep(5);
		driver.switchTo().window(child);
		String text = driver.findElement(By.xpath("//p[@class='im-para red']")).getText();
		//System.out.println(text);
		String email = text.split("at")[1].trim().split(" ")[0];
		//System.out.println(email);
		driver.switchTo().window(parent);
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("password");
		
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		

	}

}
