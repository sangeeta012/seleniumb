
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class seleniumscript {
	public static void main(String[] args) throws InterruptedException{
		
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.selenium.dev/downloads/");
		WebElement tbldetails = driver.findElement(By.xpath("/html/body/div[3]/table"));
		List<WebElement> rows = tbldetails.findElements(By.tagName("tr"));
		System.out.println("Number of rows :"+rows.size());
		for (WebElement row:rows) {
			List<WebElement> cols = row.findElements(By.tagName("td"));
			
			for (WebElement col:cols) {
				System.out.println("Column value : "+col.getText());
			}
		}
		System.out.println("table found");
		Thread.sleep(2000);
		driver.close();
		
		}
	
}
