package TestcasePkg;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ElementRepository.login;
import UtilityPkg.ExcelUtility;

public class LoginTest extends BaseClass{
login l;
 public Properties pro;
 public FileReader file;
ExcelUtility eu=new ExcelUtility();
@DataProvider(name="login_credentials")
public Object[][] dpMethod(){
	return new Object[][] {{"niba","admin123"},{"munna","1234567"}};
	}
@Test(dataProvider="login_credentials",enabled=false)
public void TC_01VerifyLoginWithWrongCredentials(String name,String pass)
{
	l=new login(driver);
	l.sendUserName(name);
	l.sendPassword(pass);
	l.loginButtonClick();
	//l.userLogout();
}
@Test(enabled=false)
public void TC_02VerifyLoginWithCorrectCredentialsUsingExcel() throws IOException {
    l=new login(driver);
    System.out.println(eu.readStringData(0,0));
    System.out.println(eu.readStringData(0,1));
    System.out.println(eu.readStringData(1,0));
    System.out.println(eu.readStringData(1,1));
	l.sendUserName(eu.readStringData(1,0));
	l.sendPassword(eu.readStringData(1,1));
	l.loginButtonClick();
   // l.userLogin(eu.readStringData(1,0),eu.readStringData(1,1));
}
@Test(enabled=false)
public void TC_03VerifyLoginWithCorrectCredentialsUsingPropertyFile() throws IOException{
	l=new login(driver);
	file=new FileReader("C:\\Users\\ASUS\\eclipse-workspace\\InterviewPrep\\src\\main\\resources\\properties\\config.properties");
	pro=new Properties();
	pro.load(file);
	l.sendUserName(pro.getProperty("username"));
	l.sendPassword(pro.getProperty("password"));
	l.loginButtonClick();
	
	}
@Test
public void TC_03VerifyDropdownSelections() {
	
}
}
