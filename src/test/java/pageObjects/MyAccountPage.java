package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


//page no-5
//one element we add here that is "Header massage" of MyAccount page..

public class MyAccountPage extends BasePage {

	//1) Constructore which is controled by BasePage.
	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	
	//2)Add Element Locatore	 of header massage:- My Account is displayed or not
		@FindBy(xpath = "//h2[text()='My Account']")
		WebElement msgHeading;
		
	//3)Add log out locatore because after complision of login we have to log out right so add logout also
		@FindBy(xpath = "//div[@class='list-group']//a[text()='Logout']")
		WebElement InkLogout; 	//6] add in 6th step 
		
	//4)Action on Element:- 
		/*in this just we have to do validation whether MyAccount is visible or not, 
		  but we con't do validation in pageobject class so that we use "boolean"
		  data type to validating and keep it in try-catch block.
		*/
		
	public boolean isMyAccountPageExists()
	{
		try
		{
			return (msgHeading.isDisplayed());
		}
		catch(Exception e)
		{
			return false;
		}
	}
		public void clickLogout()
		{
			InkLogout.click();
		}
	
	//no2 go to TestCase package create 2nd TestCase (TC002_LoginTest).. 
}		
	


