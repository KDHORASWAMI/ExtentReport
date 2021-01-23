import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.*;

public class Ecommers {

	public static void main(String args[]) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Work\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		String[] itemsNeeded = { "Brocolli", "Cucumber", "Beetroot" };
		driver.get("https://rahulshettyacademy.com/seleniumPractise");
		//ImplicitWait ........
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		// explicit wait....
		WebDriverWait w = new WebDriverWait(driver,5);
				
		Thread.sleep(3000);
		addItems(driver,itemsNeeded);
		driver.findElement(By.xpath("//img[@alt='Cart']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
		//Explicit wait
		w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//input[@class='promoCode']")));
		driver.findElement(By.xpath("//input[@class='promoCode']")).sendKeys("rahulshettyacdemy");
		// Explicit wait 
		driver.findElement(By.xpath("//button[@class='promoBtn']")).click();
		w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("span.promoInfo")));
		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
	}
	public static void addItems(WebDriver driver, String[] itemsNeeded)
	{
		int j = 0;
		List<WebElement> products = driver.findElements(By.xpath("//h4[@class='product-name']"));
		for (int i = 0; i < (products).size(); i++) {
			String[] name = products.get(i).getText().split("-");
			String formattedName = name[0].trim();
			java.util.List<String> itemsNeededList = Arrays.asList(itemsNeeded);
			if (itemsNeededList.contains(formattedName)) {
				j++;
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				if (j == itemsNeeded.length) {
					break;
				}
			}
		}
	}
	
}
