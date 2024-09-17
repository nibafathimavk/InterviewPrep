package TestcasePkg;

import org.testng.annotations.Test;

import ElementRepository.invoice;

public class invoiceTest extends BaseClass{
	invoice i;
  @Test
  public void tableValueCheck() {
	  i=new invoice(driver);
	  i.payslipClick();
	  i.tableDetailsChecks();
  }
}
