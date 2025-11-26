package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



//page no-3
/*create a page no-2 AccoutnRegistretionpage of opencart...
* constructor
* locator
* Action
* validation..
*/

public class AccoutRegistrationPage extends BasePage {

	//1)Constructor..	
	public AccoutRegistrationPage(WebDriver driver)
	{
		super(driver);
	}
	
	//2)Locators..for AccountRegistrentionPage..customer details elements.
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement txtFirstname;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement txtLastname;
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtPassword;
	
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement chkPolicy;

	@FindBy(xpath="//button[normalize-space()='Continue']")
	WebElement bttnContinue;

	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;
	
	//3)Action for AccountRegistrentionPage..customer details elements.
	public void setFirstName(String fname) 
	{
	    txtFirstname.sendKeys(fname);
	}

	public void setLastName(String lname) 
	{
	    txtLastname.sendKeys(lname);
	}

	public void setEmail(String email) 
	{
	    txtEmail.sendKeys(email);
	}

	public void setPassword(String pwd)
	{
	    txtPassword.sendKeys(pwd);
	}
	
	public void setProvicyPolicy() 
	{
		 try {
		        // Scroll into view (just in case)
		        ((JavascriptExecutor) driver)
		            .executeScript("arguments[0].scrollIntoView({block:'center'});", chkPolicy);

		        // Wait for element to exist
		        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='agree']")));

		        // Click the hidden input using JS
		        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", chkPolicy);

		        System.out.println("✅ Privacy policy checkbox clicked successfully via JS");
		    } catch (Exception e) {
		        System.out.println("❌ Failed to click privacy checkbox: " + e.getMessage());
		    }
		}
		
	
	
	public void clickContiue()
	 {
		 try {
		        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		        // Bring button into clear view
		        ((JavascriptExecutor) driver)
		                .executeScript("arguments[0].scrollIntoView({block:'center'});", bttnContinue);
		        Thread.sleep(500);

		        // Make sure privacy policy is ticked first
		        if (!chkPolicy.isSelected()) {
		            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", chkPolicy);
		            Thread.sleep(400);
		        }

		        // Close any cookie or footer overlays if they exist
		        try {
		            WebElement cookie = driver.findElement(By.cssSelector("div.alert-dismissible, .cookie, .alert"));
		            if (cookie.isDisplayed()) {
		                ((JavascriptExecutor) driver).executeScript("arguments[0].style.display='none';", cookie);
		            }
		        } catch (Exception ignored) {}

		        // Stop Bootstrap transitions that sometimes overlay the button
		        ((JavascriptExecutor) driver).executeScript(
		                "document.querySelectorAll('*').forEach(el => {el.style.transition='none'; el.style.animation='none';});");

		        // Wait until the button is actually clickable
		        wait.until(ExpectedConditions.elementToBeClickable(bttnContinue));

		        // Perform JS click (bypasses overlay/focus hit-testing)
		        Thread.sleep(500);
		        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", bttnContinue);

		        System.out.println("✅ Continue button clicked successfully (OC 4.1.0.3)");

		    } catch (Exception e) {
		        System.out.println("❌ clickContiue failed: " + e.getMessage());
		    }
		}
		//sol
		//bttnContinue.click();
		
		//sol2
		//btnContinue.submit();
		
		//sol3
		//Actions act=new Actions(driver);
		//act.moveToElement(bttnContinue).click().perform();
	 
		//sol4
		//bttnContinue.sendKeys(keys.RETURN);
		
		//Still many methods we have to do click action for conform massege.
	
	//Validation:- in page object we con't do validation by if statement lets try catch method.
	 
	public String getConfirmactionMsg() {
			try 
			{
				return (msgConfirmation.getText());
			}
			catch (Exception e) 
			{
				return(e.getMessage());
			}
	}
	//creat page no-4, in testcase package creat TC001:AccountRegistrationTest...class and 
	//invoke thise Methods from page no-2Homepage and page no-3AccoutRegistrationPage..
	
	
	
}
