package mytestngpackage;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class alllinks {
	
	WebDriver driver ;
  
	@Test
  public void f() {
	  
	  List<WebElement> link = driver.findElements(By.tagName("a"));
      System.out.println(link.size());

      for (WebElement link2: link) {

      //print the links i.e. http://google.com or https://www.gmail.com
     System.out.println(link2.getAttribute("href"));

     //print the links text
    System.out.println(link2.getText());
}
	  
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
      driver = new ChromeDriver();
      driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
      driver.manage().window().maximize();
      driver.get("https://www.gmail.com/");
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
