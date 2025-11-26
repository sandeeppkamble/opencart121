package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import utilities.DataPriders;

//page no-4
//now create Data provider..testing

public class TC003_LoginDDT extends BaseClass {
	
	@Test(dataProvider="LoginData", dataProviderClass=DataPriders.class) //here we creat a 'logindata' which avail in 'dataProviderClass' DataPriders actully its 'provider' but its save as prividers. 
	public void verify_loginDDT(String email, String pwd, String exp) //exp means expected result.
	{
		logger.info("*****starting TC003_LoginDDT*****");
		//HomePage
		try 
		{
		HomePage hp=new HomePage(driver);
		hp.ClickMyAccount();
		hp.ClickLogin();
		
		//Login
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(email);
		lp.setPassword(pwd);
		lp.clickLogin();	
	
		//MyAccount
		MyAccountPage macc=new MyAccountPage(driver);
		boolean targetPage=macc.isMyAccountPageExists();
		
		/*Data is valid :- login success - test pass - logout
		 				   login faild - test fail
		 				   
		 *Data is Invalid:- login success - test fail - logout
		 				   login faild - test pass
		 * 
		 */
		
		if(exp.equalsIgnoreCase("Valid"))
		{
			if(targetPage==true)
			{
				macc.clickLogout();
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false );
			}
		}
		if(exp.equalsIgnoreCase("Invalid"))
		{
			if(targetPage==true)
			{
				macc.clickLogout();
				Assert.assertTrue(false);
			}
			else
			{
				Assert.assertTrue(true);	
			}
		}
		}catch(Exception e)
		{
			Assert.fail();
		}
	{
		
		logger.info("*****Finished TC003_LoginDDT*****");
	}	
	
	}
	}
