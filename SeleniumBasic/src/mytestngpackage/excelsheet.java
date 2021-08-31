package mytestngpackage;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.concurrent.TimeUnit;
import java.util.logging.FileHandler;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class excelsheet {
	
	WebDriver driver ;
	
  @Test
  public void f() throws Exception{
	  
	  String filePath = "D://Sangeeta/eclipse/details.xlsx";
	  
	  FileInputStream fileStream = new FileInputStream(filePath);
	  
	  XSSFWorkbook workbook = new XSSFWorkbook(fileStream);
	  
	  XSSFSheet sheet = workbook.getSheet("Sheet1");
	  
	  int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
	  
	  for (int i=0; i<=rowCount; i++)
	  {
	      driver.findElement(By.id("createacc")).click();
	      //Thread.sleep(5000);
		  driver.findElement(By.id("usernamereg-firstName")).sendKeys(sheet.getRow(i).getCell(0).getStringCellValue());
		  driver.findElement(By.id("usernamereg-lastName")).sendKeys(sheet.getRow(i).getCell(1).getStringCellValue());
		  driver.findElement(By.id("usernamereg-yid")).sendKeys(sheet.getRow(i).getCell(2).getStringCellValue());
		  driver.findElement(By.id("usernamereg-password")).sendKeys(sheet.getRow(i).getCell(3).getStringCellValue());
		  driver.findElement(By.id("usernamereg-phone")).sendKeys(sheet.getRow(i).getCell(4).getStringCellValue());
		  driver.findElement(By.id("usernamereg-freeformGender")).sendKeys(sheet.getRow(i).getCell(5).getStringCellValue());
		  
		  //Screenshots
		  //File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		  //FileHandler.copy(srcFile, new File("/D://eclipse//screensts/image.png"));
		  //FileHandler.copy(srcFile, new File("/D://eclipse//screensts/screenshots.png"));
		  
		  
		  String st = driver.findElement(By.linkText("Sign in")).getText();
		  
		  Row newRow = sheet.getRow(i);
		  Cell cell = newRow.createCell(6);
		  cell.setCellValue(st);
		  driver.findElement(By.linkText("Sign in")).click();
		  //Thread.sleep(5000);
		  
	 }
	  
	  FileOutputStream fileOut = new FileOutputStream(filePath);
	  workbook.write(fileOut);
	  workbook.close();
	  
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
