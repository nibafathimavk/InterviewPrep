package UtilityPkg;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {
	
	public void explicitWaitForText(WebDriver driver,String text) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofMillis(5000));
		WebElement element=wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(text)));
	}
	public void explicitWaitForAlert(WebDriver driver) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofMillis(5000));
		wait.until(ExpectedConditions.alertIsPresent());
	}
	public void explicitWait(WebDriver driver,WebElement element,String attribute,String value)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofMillis(5000));
		wait.until(ExpectedConditions.attributeToBe(element, attribute, value));
	}
	public void fluentWaitforClick(WebDriver driver,WebElement element) {
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
	            .withTimeout(Duration.ofSeconds(30))
	            .pollingEvery(Duration.ofSeconds(5))
	            .ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.elementToBeClickable(element));
	}

}
