package TestcasePkg;

import org.testng.annotations.Test;

import ElementRepository.login;

import org.testng.annotations.BeforeMethod;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class BaseClass {
  WebDriver driver;
  login l;
  public Properties pro;
  public FileReader file;
	
  @BeforeMethod
  public void beforeMethod() throws IOException {
  System.setProperty("webdriver.chrome.driver","D:\\Driver\\LatestChrome2.0\\chromedriver.exe");
  driver=new ChromeDriver();
  driver.get("https://www.qabible.in/payrollapp/site/login");
  driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));

l=new login(driver);
file=new FileReader("C:\\Users\\ASUS\\eclipse-workspace\\InterviewPrep\\src\\main\\resources\\properties\\config.properties");
pro=new Properties();
pro.load(file);
l.sendUserName(pro.getProperty("username"));
l.sendPassword(pro.getProperty("password"));
l.loginButtonClick();

  }
  @AfterMethod
  public void afterMethod() {
	 // driver.quit();
  }

}
