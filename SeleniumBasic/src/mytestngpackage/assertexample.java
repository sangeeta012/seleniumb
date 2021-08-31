package mytestngpackage;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class assertexample {
	
	WebDriver driver ;
	
  @Test
  public void f() {
	  
	  String el1 = driver.findElement(By.className("challenge-heading")).getText();
	  String el2 = "Sign out";
	  
	  
	  if(el1.equals(el2)) 
		  System.out.println("match");
	  else
		  System.out.println("not a match");
		  
	  
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
