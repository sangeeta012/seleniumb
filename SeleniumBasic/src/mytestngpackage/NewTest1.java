package mytestngpackage;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class NewTest1 {
	
	 WebDriver driver ;
	  
  
  @Test
  @Parameters({"fname","lname"})
  public void f(String fname, String lname) {
	  
	  driver.findElement(By.id("createacc")).click();
	  driver.findElement(By.id("usernamereg-firstName")).sendKeys(fname);
	  driver.findElement(By.id("usernamereg-lastName")).sendKeys(lname);
	  
	}

  
  @BeforeTest
  public void beforeTest() {
	  
	  System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
	  	driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://login.yahoo.com/");
  }

  @AfterTest
  public void afterTest() {
	  
	  driver.close();
  }

}
