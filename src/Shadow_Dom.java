import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Shadow_Dom {
	
	public static void main(String args[])	{
		
	System.setProperty("webdriver.chrome.driver", "C:\\Work\\Selenium\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("https://shop.polymer-project.org/");
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	WebElement root = driver.findElement(By.tagName("shop-app"));
	// shadow dom 
	WebElement shadowdom1 = getShadow_dom(root,driver);
	WebElement ironpages =shadowdom1.findElement(By.tagName("iron-pages"));
	WebElement shophome =ironpages.findElement(By.tagName("shop-home"));
	//System.out.println(shophome.getTagName());
	// shadow dom  2
	
	WebElement shadowdom2 = getShadow_dom(shophome, driver);
	//System.out.println(shadowdom2.getTagName());
	shadowdom2.findElement(By.cssSelector("div:nth-child(2) > shop-button > a")).click();
	
	}
	
	public static WebElement getShadow_dom(WebElement element, WebDriver driver) {
		JavascriptExecutor jr = (JavascriptExecutor) driver;
		WebElement shadowDom =(WebElement) jr.executeScript("return arguments[0].shadowRoot" , element);
		return shadowDom;
			
	}
}
