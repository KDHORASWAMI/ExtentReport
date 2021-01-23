import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TableSort {
	public static void main(String args[])
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Work\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers/");
		driver.findElement(By.cssSelector("tr th:nth-child(2)")).click();
		driver.findElement(By.cssSelector("tr th:nth-child(2)")).click();
		List<WebElement> firstarray = driver.findElements(By.cssSelector("tr td:nth-child(2)"));
		ArrayList<String> originalList = new ArrayList<String>();
		for(int i=0;i<firstarray.size();i++)
		{
			originalList.add(firstarray.get(i).getText());
		}
		ArrayList<String> secondcopy = new ArrayList<String>();
		for(int i=0;i<originalList.size();i++)
		{
			secondcopy.add(originalList.get(i));
		}
		Collections.sort(secondcopy);
		Assert.assertTrue(secondcopy.equals(originalList));
	}

}
