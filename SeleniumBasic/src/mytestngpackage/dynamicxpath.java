package mytestngpackage;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class dynamicxpath {
	WebDriver driver;
	
	@BeforeMethod
	public void Setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
	  	driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.google.com/");
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
		
	}
	
	@Test
	public void test1() {
		driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys("mumbai");
		//driver.findElement(By.xpath("//div[@class='aypzV']")).click();
		
		List<WebElement> listli = driver.findElements(By.xpath("//ul[@role='listbox']//li//descendant::div[@class='aypzV']"));
		System.out.println(listli.size());
		
		for(int i=0;i<listli.size();i++) {
			String s1 = listli.get(i).getText();
			System.out.println(s1);
			if(s1.contains("Mumbai")) {
				listli.get(i).click();
				break;
			}
			
		}
		
//		Actions action = new Actions(driver);
//		action.moveToElement(driver.findElement(By.xpath("//div[@class='aypzV']"))).build().perform().click()
//		
		
		
	}

}
