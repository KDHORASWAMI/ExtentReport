import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class FaceBook 
{
	public static void main(String args[])
	{
		System.setProperty("webdriver.chrome.driver","E:\\DSK\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		// Log in page
		/*driver.findElement(By.id("email")).sendKeys("swamy.cool1");
		driver.findElement(By.id("pass")).sendKeys("Swami.munny1");
		driver.findElement(By.xpath("//input[@value='Log In']")).click();
		*/
		// Creating new Account
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Harsha");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("MMP");
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("aaaaa@gmail.com");
		driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys("Password@123");
		Select s = new Select(driver.findElement(By.id("day")));
			s.selectByValue("6");
		Select s1 = new Select(driver.findElement(By.id("month")));
			s1.selectByValue("1");
		Select s2 = new Select(driver.findElement(By.id("year")));
			s2.selectByValue("1994");
		driver.findElement(By.xpath("//label[text()='Male']")).click();
		driver.findElement(By.xpath("//button[@name='websubmit']")).click();
		
	}
}
