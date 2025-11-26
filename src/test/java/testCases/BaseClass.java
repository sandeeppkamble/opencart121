package testCases;

import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.apache.logging.log4j.LogManager; //log4j
import org.apache.logging.log4j.Logger; //log4j

//page no-1
//We will save all common data from test case class from testCases package..
public class BaseClass {

	//we will use this class for storing common data from testcase from teastcases package.
	//because of this BaseClass class our testcase clss/file looks clean.
	//Because all common data we store here.
	
	
	//1)storing method no-1 frome TC001AccountRegistrationTest.
	public WebDriver driver;
	public Logger logger; //2]log4j
	public Properties p; //4]properties file loading..
	
	 @BeforeClass
	    @Parameters({"os","browser"})
	    public void setup(String os, String br) throws IOException {

		//4]Loading config.properties file
		try 
		{
		/*FileReader file = new FileReader("src/test/resources/config.properties");
		p=new Properties();
		p.load(file);*/
			 // Load config.properties
            InputStream file = getClass()
                    .getClassLoader()
                    .getResourceAsStream("config.properties");

            p = new Properties();
            p.load(file);

            logger = LogManager.getLogger(BaseClass.class);
            logger.info("Browser launched");

            switch (br.toLowerCase()) {

                case "chrome":
                    WebDriverManager.chromedriver().setup();     // USE WDM
                    driver = new ChromeDriver();
                    break;

                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;

                default:
                    System.out.println("Invalid browser name...");
                    return;
            }

            driver.manage().deleteAllCookies();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.get("http://localhost/OpenCart/index.php");
            driver.manage().window().maximize();

        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	//2)storing method no-2 frome TC001AccountRegistrationTest.
	 @AfterClass
	    public void tearDown() {
	        driver.quit();
	    }

	    public String randomeString() {
	        return RandomStringUtils.randomAlphabetic(5);
	    }

	    public String randomeAlphaNumber() {
	        String letters = RandomStringUtils.randomAlphabetic(3);
	        String numbers = RandomStringUtils.randomNumeric(3);
	        return letters + "@" + numbers;
	    }
		
	
	
	
	
	
	
	
	
	
	
}
