package ElementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class login {
	WebDriver driver;
	public login(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);// with page factory
	}
	@FindBy(xpath="//input[@id='loginform-username']")
	WebElement userName;
	@FindBy(id="loginform-password")
	WebElement password;
	@FindBy(xpath="//button[text()='Login']")
	WebElement loginButton;
	@FindBy(xpath="//a[@class='dropdown-toggle']")
	WebElement logout;
	@FindBy(xpath="//a[@class='logout-btn']")
	WebElement logoutButton;
	
	
	public void sendUserName(String name) {
		userName.sendKeys(name);
	}
	public void sendPassword(String pass) {
		password.sendKeys(pass);
	}
	public void loginButtonClick() {
		loginButton.click();
	}
//	public void userLogin(String name,String pass)
//	{
//		userName.sendKeys(name);
//		password.sendKeys(pass);
//		loginButton.click();
//	}
	public void userLogout() {
		logout.click();
		logoutButton.click();
	}

}
