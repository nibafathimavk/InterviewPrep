package ElementRepository;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class home {
	WebDriver driver;
  public home(WebDriver driver) {
	  this.driver = driver;
		PageFactory.initElements(driver, this);   
  }
  @FindBy(xpath="//a[text()='Clients']")
  WebElement clientClick;
  //client page elements for dropdown
  @FindBy(xpath="//a[text()='Create Client']")
  WebElement createClientButton;
  @FindBy(id="client-invoice_order")
  WebElement clientInvoiceOrder;
 //timesheet page for alert
  @FindBy(xpath="//a[text()='TimeSheet']")
  WebElement timeSheet;
  @FindBy(xpath="//button[text()='Generate Invoice']")
  WebElement generateInvoiceButton; 
  @FindBy(xpath="//button[text()='Generate Playslip']")
  WebElement generatePayslip;
  @FindBy(xpath="//h1[text()='Timesheets']")
  WebElement timesheetCheck;
  
  
  
  public void clientButtonClick() {
	  clientClick.click();
  }
public void createClientClick() {
	createClientButton.click();
}
public void invoiceOrderDropDown() throws InterruptedException {
	Select invOrd=new Select(clientInvoiceOrder);
	//invOrd.selectByIndex(1);
	invOrd.selectByValue("Invoice per week");
	//invOrd.selectByVisibleText("Multi timesheet per client");
//	for(int i=0;i<10;i++) {
//		invOrd.selectByIndex(i);
//		Thread.sleep(1000);
//	}
//	List<WebElement> list=invOrd.getAllSelectedOptions();
//	for(int j=0;j<list.size();j++) {
//		Thread.sleep(1000);
//		System.out.println(list.get(j).getText());
//	}
		
	}
public void timeSheetClick() {
	JavascriptExecutor executor=(JavascriptExecutor)driver;
	executor.executeScript("arguments[0].click();",timeSheet);
}  
public void generateInvoiceButtonClick() {
	JavascriptExecutor executor=(JavascriptExecutor)driver;
	executor.executeScript("arguments[0].click();", generateInvoiceButton);
	}
public void manageAlertAccept() throws InterruptedException {
	String alertText=driver.switchTo().alert().getText();
	System.out.println(alertText);
	Thread.sleep(2000);
	driver.switchTo().alert().accept();
	Thread.sleep(7000);
	String invoiceGeneratedAlert=driver.switchTo().alert().getText();
	System.out.println(invoiceGeneratedAlert);
	Thread.sleep(2000);
	driver.switchTo().alert().accept();

}
public void generatePaySlipButtonClick() throws InterruptedException {
	Thread.sleep(2000);
	JavascriptExecutor executor=(JavascriptExecutor)driver;
	executor.executeScript("arguments[0].click();", generatePayslip);
}
public void mangeAlertCancel() throws InterruptedException {
	Thread.sleep(2000);
	String alertMsg=driver.switchTo().alert().getText();
	System.out.println(alertMsg);
	driver.switchTo().alert().dismiss();
	
}
public String assertionMsg() {
	return timesheetCheck.getText();
}
}
