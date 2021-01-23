import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FramesExample {
	public static void main(String args[])
	{
		System.setProperty("webdriver.chrome.driver", "E:\\COURSES\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/draggable");
		WebDriverWait w = new WebDriverWait(driver,5);
		w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("iframe[class='demo-frame']")));
		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[class='demo-frame']")));
		Actions a= new Actions(driver);
		a.dragAndDropBy(driver.findElement(By.id("draggable")), 317, 11).build().perform();
	}

}
