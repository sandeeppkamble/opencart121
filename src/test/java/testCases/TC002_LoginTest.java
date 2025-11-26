package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;

//page no-3
//after creating Login & Myaccount page object we create this testcase.

public class TC002_LoginTest extends BaseClass {

	@Test 
	public void verify_login()
	{
		logger.info("*****Starting TC002_LoginTest*****");
		try {
		//call homepage method from pageobjects package:- common data store here. 
		HomePage hp=new HomePage(driver);
		hp.ClickMyAccount();
		hp.ClickLogin();
		
		//1)call Loginpag 3method from pageobjects package
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();
		
		//2)call MyAccount pageobject 
		MyAccountPage macc = new MyAccountPage (driver);
		boolean targetpage = macc.isMyAccountPageExists();
		
		//Assert.assertEquals(targetpage, true, "Login Failed");
		Assert.assertTrue(targetpage);  //any one u can use equals or true assert.
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("*****Finished TC002_LoginTest *****");
	
		//Can you pass this test directly from here? NO because webdriver is controled
		//by xml so we have to go and run this test. 
		
	}
	
	
	
	
}
