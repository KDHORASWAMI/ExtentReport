
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.sun.tools.javac.util.Assert;


public class RadioButton
{
	public static void main(String args[]) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Work\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.spicejet.com");
		driver.findElement(By.xpath("//*[contains(@id,'originStation1_CTXTaction')]")).click();
		driver.findElement(By.xpath("//*[contains(@id,'originStation1_CTNR')] //a[@value='BLR']"
				+ "")).click();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS );
		driver.findElement(By.xpath("//*[contains(@id,'destinationStation1_CTNR')] //a[@value='MAA']")).click();
		driver.findElement(By.cssSelector("[class$='ui-datepicker-today']")).click();
//		//date.click();
//		boolean isSelecte = date.isSelected();
//		Assert.check(isSelecte);
		driver.findElement(By.xpath("//div[@id='divpaxinfo']")).click();
		Select s= new Select(driver.findElement(By.cssSelector("[id$='Content_ddl_Adult']")));
			s.selectByValue("3");
		Select s1 = new Select(driver.findElement(By.cssSelector("[id$='Content_ddl_Child']")));
			s1.selectByIndex(2);
		Select s2 = new Select(driver.findElement(By.cssSelector("[id$='Content_ddl_Infant']")));
			s2.selectByValue("2");
		driver.findElement(By.cssSelector("[id$='Content_btn_FindFlights']")).click();
	}
}
