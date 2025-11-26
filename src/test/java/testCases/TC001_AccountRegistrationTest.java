package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccoutRegistrationPage;
import pageObjects.HomePage;




//page no-4
//as per package page no-1

/*Testcase of opencart...
*setup()method
*tearDown()method
*Verify_account_registration()
*/

public class TC001_AccountRegistrationTest extends BaseClass {

	/*package "PageObject" we created two class 1)HomePage and 2)AccountRegistration, so now from 
	  here we will get Constructor Method, Locator Method, and Action Method.  
	 */

	//NOTE:- we store common data like @BeforeClass which is contain "constructor",
	//and also @AfterClass which is contain "driver.quiet()".
	//Because of this our test page will looks clean.
	//also we are storing our "randome/dynamic data class in BaseClass because this
	//this data also we use multiple time entire our project.
	@Test
	public void Verify_accout_registration() 
	{
		logger.info("****Starting TC001_AccountRegistrationTest****"); //log4j topic whatever massage want to print just add this method
		try
		{
	    HomePage hp = new HomePage(driver);
	    
	    hp.ClickMyAccount();
	    logger.info("Clicked on MyAccount Link");
	    hp.ClickRegister();
	    logger.info("Clicked on Register Link");
	    
	    AccoutRegistrationPage regPage = new AccoutRegistrationPage(driver);
	    logger.info("Providing customer detail....");
	    //1)Normal data which is not repeated during run
	    
	    /*regPage.setFirstName("Narendrad");
	    regPage.setLastName("modiji");
	    regPage.setEmail("modiji00@gmail.com");
	    regPage.setPassword("India@123");
	    */
	    
	    //2)/Randome/Dynamic data which is automatically get change during run time.
	    regPage.setFirstName(randomeString().toUpperCase());
	    regPage.setLastName(randomeString().toUpperCase());
	    regPage.setEmail(randomeString()+"@gmail.com");
	    regPage.setPassword(randomeAlphaNumber());
	    
	    regPage.setProvicyPolicy();
	    regPage.clickContiue();
	    
	    logger.info("Validating expecting Massage...");
		String confmsg=regPage.getConfirmactionMsg();
		if(confmsg.equals("Your Account Has Been Created!"))
		{
			Assert.assertTrue(true);
		}
		else
		{ 
			logger.error("Test Failed..."); //if wann change level also change in logs4j2.xml file then only we can able to access
			logger.debug("Debug logs..."); 
			Assert.assertTrue(false);
		}
		}
	  catch(Exception e)
		{ 
		  Assert.fail();
		}
		logger.info("****Finished TC001_AccountRegistrationTest****");
	}
		//day50-loggers everything is fine and test also successfully pass but we
		//are not able to generate log files may log4j2 xml file have some issue.
}

	
	
	
	
	
	

