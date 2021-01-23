import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaAleart {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "G:\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.cssSelector("#alertbtn")).click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		driver.findElement(By.xpath("//input[@id='confirmbtn']")).click();
		Thread.sleep(2000);
		driver.switchTo().alert().dismiss();

	}

}
