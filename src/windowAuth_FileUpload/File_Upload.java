package windowAuth_FileUpload;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class File_Upload {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Work\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.ilovepdf.com/pdf_to_jpg");
		driver.findElement(By.cssSelector("[class*='uploader__btn']")).click();
		Thread.sleep(5000);
		// Get the exe file using AutoIT software...
		
		Runtime.getRuntime().exec("C:\\Work\\AutoIT\\File_Upload.exe"); 

	}

}
