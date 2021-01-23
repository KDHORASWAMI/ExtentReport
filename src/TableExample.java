import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TableExample {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Work\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.cricbuzz.com/live-cricket-scorecard/22655/rsa-vs-eng-1st-t20i-england-tour-of-south-africa-2019-20");
		int sum=0;
		WebElement table = driver.findElement(By.xpath("//div[@id='innings_1']/div[1]"));
		int rowcount = table.findElements(By
				.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms']")).size();
		//System.out.println("Rowcount : " +rowcount);
		int count = table.findElements(By
				.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms'] div:nth-child(3)")).size();
		for(int i=0;i<count-2;i++)
		{
			String score = table.findElements(By
					.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms'] div:nth-child(3)"))
					.get(i).getText();
		    int scorevalue = Integer.parseInt(score);
		    sum=sum+scorevalue;
		}
		String extra = table.findElement(By
				.xpath("//div[text()='Extras']/following-sibling::div")).getText();
		int extravalue = Integer.parseInt(extra);
		int totalscore = sum+extravalue;
		String total = table.findElement(By
				.xpath("//div[text()='Total']/following-sibling::div")).getText();
		int totalvalue = Integer.parseInt(total);
		if(totalscore == totalvalue)
		{
			System.out.println("Count Matches");
		}
		else
		{
			System.out.println("Count fails");
		}
		
	}

}
