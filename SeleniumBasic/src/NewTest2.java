
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class NewTest2 {
	
	WebDriver driver = new ChromeDriver();
	
  @Test
  public void f() {
	  
	  driver.findElement(By.id("createacc")).click();
	  driver.findElement(By.id("usernamereg-firstName")).sendKeys("fname");
	  driver.findElement(By.id("usernamereg-lastName")).sendKeys("lname");
	  driver.findElement(By.id("usernamereg-month")).sendKeys("March");
  }
  
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://login.yahoo.com/");
  }

  @AfterTest
  public void afterTest() {
	  driver.close();
  }

}
