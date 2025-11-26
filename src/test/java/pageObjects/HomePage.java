package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

//page no-2
/*create a page no-1 Homepage of opencart...
 * constructor
 * locator
 * Action
 * validation..
 */

public class HomePage extends BasePage {

	
	//1)Constructor..HomePage
	
	public HomePage(WebDriver driver)
	{
		super(driver);
		
	}
	
	//2)LocatorsL:-HomePage, we have to locators one My Account and Registration..
	@FindBy(xpath="//span[normalize-space()='My Account']")
	WebElement InkMyaccount;
	
	@FindBy(xpath="//a[normalize-space()='Register']")
	WebElement InkRegister;
	
	@FindBy(linkText="Login") //5]login link add in step-5.
	WebElement linklogin;
	
	
	//3)Acations:-HomePage, on this both elements
	
	public void ClickMyAccount()
	{
		InkMyaccount.click();
	}
	
	public void ClickRegister()
	{
	        InkRegister.click();
	}
	
	public void ClickLogin()
	{
		linklogin.click(); //5]
	}
//creat page no-3 AccountRegistrationPage_for construction, locatior and action then validation	
//creat page no-4 LoginPage which is contain My account.	
	
	
	
	
	
	
	
	
	
}
