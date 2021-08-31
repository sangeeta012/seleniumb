package mytestngpackage;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class windows {
	
	WebDriver driver ;
	
  @Test
  public void f() {
	  
	  driver.findElement(By.linkText("Create a website")).click();
	  driver.findElement(By.linkText("Yahoo")).click();
	  String parentWindowHandle = driver.getWindowHandle();
	  System.out.println("Parent window's handle -> " + parentWindowHandle);
	  Set<String> allWindowHandles = driver.getWindowHandles();
	  
	  for(String handle : allWindowHandles)
	  {
		  System.out.println("Hello1");
		  if(!handle.equals(parentWindowHandle))
		  {
			  System.out.println("Hello2");
			  System.out.println("Switching to window - > " + handle);
			  System.out.println("Navigating to google.com");
			  driver.switchTo().window(handle); //Switch to the desired window first and then execute commands using driver
			  //driver.get("http://google.com");
			  String actualt = driver.getTitle();
			  String expectedt = "Create a Website – Tips and Tricks for Website Creation";
			  if(actualt.equals(expectedt))
			  {
				  System.out.println("Hello3");
				  driver.findElement(By.linkText("Website Builder")).click();
				  //String st = driver.findElement(By.linkText("Create a website")).getText();
				 // System.out.println(st);
			  }
		  }
	  }
	  driver.switchTo().window(parentWindowHandle);
	  System.out.println("Parent Window URL: "+driver.getCurrentUrl());
	  
	  String st = driver.findElement(By.linkText("Yahoo")).getText();
	  System.out.println(st);
  }
  
  
  @BeforeTest
  public void beforeTest() {
	  
	  System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
	  	driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("file:///C:/Users/Sangeeta/Desktop/parent.html");
	  
  }

  @AfterTest
  public void afterTest() {
	  
	  driver.close();
	  driver.quit();
  }

}
