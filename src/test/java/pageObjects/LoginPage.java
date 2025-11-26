package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

//page no-4
//5]login page //which is contain 3 elements
//1)User name, 2)Password, 3)submit button..

public class LoginPage extends BasePage
{
	//1)add constructor which controled by "BasePage".
	public LoginPage(WebDriver driver) {
		super(driver);	
	}
	
	//2)add Element Locators..
	@FindBy(xpath = "//input[@id='input-email']")
	WebElement  txtEmailAddress;		//email for user name.
	
	@FindBy(xpath = "//input[@id='input-password']")
	WebElement  txtPassword; 		//password for provide a password
	
	@FindBy(xpath = "//input[@value='Login']")
	WebElement btnLogin;				//submit button after username password.
	
	//3)Action on Element..
	public void setEmail(String email)
	{
		txtEmailAddress.sendKeys(email);
	}
	
	public void setPassword(String pwd)
	{
		txtPassword.sendKeys(pwd);
	}
	
	public void clickLogin()
	{
		btnLogin.click();
	}
	
	//next page no-5 we have to create a "My Account" page object class..
}
