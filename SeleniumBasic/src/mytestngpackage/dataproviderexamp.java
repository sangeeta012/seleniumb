package mytestngpackage;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class dataproviderexamp {
	
	WebDriver driver ;
	SoftAssert softassert = new SoftAssert();
	SoftAssert softassert2 = new SoftAssert();
	
	
  @Test(dataProvider="SearchProvider", priority=1)
  public void f(String fname,String lname) {
	  
	  driver.findElement(By.id("createacc")).click();
	  driver.findElement(By.id("usernamereg-firstName")).sendKeys(fname);
	  driver.findElement(By.id("usernamereg-lastName")).sendKeys(lname);
	  driver.findElement(By.linkText("Sign in")).click();
	  System.out.println("Priority1");
	  
  }
  
  @Test(priority=2)
  public void f1() {
	  
	  String el1 = driver.findElement(By.className("challenge-heading")).getText();
	  String el2 = "Sign in";
	  
	  
	  if(el1.equals(el2)) 
		  System.out.println("match");
	  else
		  System.out.println("not a match");
	  
	  System.out.println("Priority2");
	  
	  softassert.assertEquals(el2, el1, "match");
	  softassert.assertAll();
	  softassert2.assertNotEquals(el2, el1, "not a match");
	  softassert2.assertAll();
	  
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
  
  
  @DataProvider(name="SearchProvider")
  public Object[][] getDataFromDataprovider(){
  return new Object[][] 
  	{
          { "Guru99", "India" },
          { "Krishna", "UK" },
          { "Bhupesh", "USA" }
      };

  }

}
