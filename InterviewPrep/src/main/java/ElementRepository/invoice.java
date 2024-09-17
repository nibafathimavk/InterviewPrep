package ElementRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class invoice {
	WebDriver driver;
	public invoice(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//a[text()='Invoice']")
	WebElement payslipButton;
	
	public void payslipClick() {
		payslipButton.click();
	}
	public void tableDetailsChecks() {
		List<WebElement> headers=driver.findElements(By.xpath("//div[@id='w0']//thead//tr//th"));
		//System.out.println(list);
		for(int i=0;i<headers.size();i++) {
			String head=headers.get(i).getText();
			System.out.print(head+"");
		}
//		List<WebElement> body=driver.findElements(By.xpath("//div[@id='w0']//tbody//tr[5]//td"));
//		for(int i=0;i<body.size();i++) {
//			System.out.println(body.get(i).getText());
//		}
		System.out.println();
		List<WebElement>tableRowsColumns=driver.findElements(By.xpath("//div[@id='w0']//tbody//tr//td"));
		for(int j=0;j<tableRowsColumns.size();j++)
		{
		for(int k=0;k<tableRowsColumns.size();k++)
		{
			String rows=tableRowsColumns.get(j).getText();
			String columns=tableRowsColumns.get(k).getText();
			System.out.print(rows+" ");
			System.out.println(columns+" ");
			System.out.println();				
		}
		}
	}
}
