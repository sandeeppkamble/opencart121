package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

//page no-1
//creating common data for test case
//like Constructor webdriver instance..

public class BasePage {

	protected WebDriver driver;
	
	public BasePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
}

//creat page no-2 HomePage_for construction, locatior and action then validation