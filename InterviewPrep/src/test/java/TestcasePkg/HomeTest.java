package TestcasePkg;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import Constants.constants;
import ElementRepository.home;
import ElementRepository.login;

public class HomeTest extends BaseClass {
	home h;
  @Test
  public void TC01_VerifyClientClickAndCreate() throws InterruptedException {
	  h=new home(driver);
	  h.clientButtonClick();
	  h.createClientClick();
	  h.invoiceOrderDropDown();
  }
  @Test
  public void TC02_verifyTimeSheetClickForAlertCheck() throws InterruptedException {
	  h=new home(driver);
	  h.timeSheetClick();
	  h.generateInvoiceButtonClick();
//	  h.manageAlertAccept();
//	  h.generatePaySlipButtonClick();
//	  h.mangeAlertCancel();
	  String actual="TIMESHEETS";
	  String expected=h.assertionMsg();
	  System.out.println(expected);
	  Assert.assertEquals(actual, expected,  constants.h_TC02_verifyTimeSheetClickForAlertCheck_Errormsg);
  }
}
