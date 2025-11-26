package opencart_Project_Introduction;

//Day_50
//page no-1
//2nd,,Adding logs to testcase..

public class Day_50_Adding_Logs_To_TestCase {

	/*After creating testing with two approach..
	 *Common data we saperate frome test case and save in base class in basepage package.
	 *1)Normal or static data which is not change its constant..
	 *2)randome or dynamic data which is we can change during run time also..
	
	 *3)Now we will add "logs" in test case which is step-2.
	 *What is logs' meas?
	 >>record all the events in the form of text
	 
	 *What is the advantage of generate logs file normally there are two type of log's
	 *1)Application log's 
	 *2)Automation alogs
	 
	 *application-logs whenever user using event gerated in logs file, Ex:-whenever
	  user do missbehavior or unwanted activities on application May organiztion will
	  take ligal action on him.
	  
	 *Main advantage of logs:-log file will be used to do track the information, whatever
	  user doing, whichever event or whichever action on the application they can track 
	  everthing into the "log file" they will maintain log files at the back end  they
	  will maintain lgo file at the bakc end they an generate every time every second
	  they can monitor the logs it's also kind of security machanisum which is pravided
	  to the application called "logs file".
	  
	 *2)Automation log's file:- automation project also we will maintain the log file
	  so because we can also logs all the event from the application through the test
	  case whatever actions we are doing on the application so every action we are 
	  doing on the application action we can log into the log file but what the bene
	  -fit of log file? >>If suppose tomarrow if any testcase called failed that info
	  -mation is also part of the log file so the benifite of the developer will ask to
	  provide the logs file because only depdenting on the UI and the steps we provided
	  to the developer they wont analyze the defects some times the defects will report
	  -able in 'Q' environment but the same defactor may not be reporduce int the dev
	  environment in thse cases developer will ask you to provide the logs file so along
	  with the defect information like test case steps then screen shots we will provide
	  empty thing right? similarly we will also provide the log file & developer an 
	  understand the log file and analyze the issue and accordingly they can fix the bug
	  so that is main advantage of using log file thats whays in our automation also we
	  create our own log file's.
	  
	 *Different level of logs :-
	 *All:-we can access all level of logs if we use "All log" accept "off".
	 *1)Trace:-If we use "Trace log level" we can access all belows leve.
	 *2)Debug:-If we use "Debug level" we can access all belows leve.
	 *3)Info:-If we use "Info log level" we can access all belows leve.
	 *4)Warn:-If we use "Warn log level" we can access all belows leve.
	 *5)Error:-If we use "Error log level" we can access all belows leve.
	 *6)Fatal:-If we use "Fatl log level" we can access all belows leve.
	 *Off:-If we access this "Off log" means we con't access these aboves logs.
	 
	 *we will do these all in log configuration...
	 *For this we have to understand two things..
	 *1)Appanders:- when to generate log's (Consol/File).
	 *2)Loggors:- what type of log generater.
	 
	 *we are not create it in consol we can create it in file because easily download
	  we can easily share log file to the devlopement and this is available parameter
	  appandent will decide whene to generate file.
	 *FOr this we need log configur folder "log4j2 xml" file we specify a information 
	  like when to generate & what level we have to generate inside the configur file
	  (log4j2) go to official page of "appache log4j2" this also third party library 
	  which is development by appache foundation just like appache poi just to understand
	  No go to MVN repository searvh "appache log4j2" copy letest version paste in pom.xml
	  and search one more "appache log4j2 core" and past it in pom.xml file.
	  
	 *Now library is ofter updating MVN file..
	 Now get a configur xml file of log4j2 xml from then official website but they
	 want provide executy from testing so we can copy one configure log4j2 xml file
	 and do same change and store that xml file in "src" folder only not any where else.
	 
	*When we open xml file from "src" then to depdency are there on appender & another
	 our one loggers. so again appenders have to two main tag
	 <console> and <RollingFile> Now in "logger" tag we have to specify a log level
	 <Root level=" " and then we have to specify whene we want to see log file that
	 have to specify.. <Appander ref="file/> using this both option it will disable
	 we have to generate and what is the level of log.
	*Now when we have to save this logs?
	*>>earlier we create "log folder"? right copy it path and come xml top side them is on
	 tag<properties> and if contain<property>tag in that we can provide and log folder
	 location path, path is so hard code so make it short by using "(./logs)" because
	 log file already avialable in our project so we can use "./log" to make path short
	 <property name="basepath">./log</property> have we specify based on veriable 
	 now go to "rolling file" tag then name = "File" fileName="$(basepath}/automation.log"
	 file pattern="$(basepath}/automation.%d(yyyy-mm-dd}.log,, wehre we create "timetamp" 
	 because everytime it will create new file.
	*Now come again <loggers>tag usually we put log level = "INfo" //because we need
	*to massage we provide so we use Info level log, some time developer ask give me aInfo
	 as a "debug log" that come to xml file change Info as "debug" and run our testcase
	 debug file will generate so send that to developer thats it whatever level developer
	 required we can give.
	*If we put  "Info" log it's enough for as become easily we can understand we can error, fatal,
	 Bu trace & debug is to detail report which we don't required it's all but clients and developer
	*This is the configure file which basically we can understand.
	*1)All=trace=Debug is a part of developer.
	*2)Info=Error is part of tester.
	
	*baseClass why we need to update?
	*>>Because the base class we need to write piece of code which will load our log4j2 xml file.
	 let's update the base class under the setup method by adding on pre defined method that is
	 "public logger;" import he right file from this method "org.oppache logging.log4j.cor" this
	 is package import it two log forj. logger we can import in constructor
	*Create a class with use of "this" method "this method" represent class..
	*Execute:-
	//Create class in Basetest
	public Logger.logger./log;
	@Before
	public void setup()
	{
		logger=logManger.getLogger(this.getclass());
	{
	//now we create logger class in basetest.
	
	*Now create a method in our testcase-1 file using "logger" veriable and this logger veriable contain
	 all level of logs:- and we can add this levl in veriable along with massage.
	*and whole test case get fail create of some reason it will through exception so handle that exception
	 we put everthing in try-catch method and writte massage with help of log's veriable and evel log logs
	 
	 @Test
	 public void verify_acout.registration()
	 {
	 logger.info("Starting TC001.AccoutRegistrationTest")
	 try
	 {
	 HomePage hp=new HomePage(driver)' //invoking
	 //Method through creating class object
	 
	 hp.clickMyAccount();
	 logger.info("clicked on MyAccount" link);
	 
	 hp.clickRegistration();
	 logger.info("click on registration link);
	 
	 //created customer details object
	 logger.info("providing Customer details");
	 //after adding first name to continue
	 //now validation massage (confomartionmsg)
	 logger.info("validating exception massage");
	 }
	  catch(Exception e)
	  {
	  logger.error(Test failed");
	  logger.debug("Debug logs");
	  Assert.fail();
	  }
	  logger.info(...finish TC001 AccountRegistrationTest...);
	  
	 *This how we can add logger veriable with it's method along with massage so we 
	 can create n number of massage with suitable method or log level.
	 
	*warning:- don't add wrong import's..
	*What did till? adding logs to test case.
	*1)add log4j2 xml file under src/test/resource
	*2)update BaseClass
	*3)add log statment AccountRegistrationTest
	
	*Result:-Run code ofter adding logs'
	*1st,,, run it's fail because of wrong webpage ofter change it's pass but file
	 & created in (log file e because we provide 5000 limi if our report cross ther limit it
	 will generate also "commont(//) the debug levl log in test case file not need now.
	 
	*Now intensionlly fail the test and run testcase also change size of file 5000
	 to multiple 50,000 and also change log level from info to "debug" 
	 and also add a if elso condition for validations
	 
	 //Validation(action)..
	 
	  *create a logger.info add massage.
	  *get a conformation massage.
	  *by adding Assert.assertTrue(true) know the created page or not.
	  *to takecare of exception add above method in try-catch method
	  *run the code.
	  
	  *Result:-its pas and error & debug also printed in report.
	  *Note:-if any exception come obviously the try-catch blobk will execute and
	   this will ail then test and if that test is got fialed become of titles are
	   not matching properly then if else condition will takecare of it.
	  *This how we create a loggs.
	  *if we run mulotiple time, timetamp will contain old report and another file
	   contain new report logs that we will is two files in logs folder.
	  *If don't need any log's just go to xml and add "off" level log it will stop
	   to run loggs in our testcase.
	  */

	 //3.]Run Test on Desired Browers/cross browser/parallel
	/*we already doone this in testNG topic so same here we can achieve inframe work.
	 *Here we have to do 1st step,is creating test exm file parameterization() method
	  but here we are using only one os right? wher use get grid connect and we are test
	  case in different window that time we need to provide browser name for now we are
	  using single 'OS' so only provide present browser name 2)adding Basecalss-setup()
	  method connecting browser. 3)maintain saperate xml to run test multiple browser lets see.
	  
	 *step-1,xml file have toc create:- in side the project we will create a xml file
	  of "testcase" right click testNG-convertTestNG click on finish no need tochange
	  file path by browser, because we create project level.
	  
	 *Copy the xml which create now and name it as a "Master.xml".
	 *Now we have to pass two parameter "operating System" and Browser name.
	 
	 *In xml add "paramerer" tag befor test tag. this paramere tag add name and value.
	  and this name contain 'OS' or browser and value contian 'window' or 'chrome'
	 *once it's done go to baseclass add annotation @parameter and add parameter{'os', 'browser'}
	  and class also maitain with sting veriable like
	 *public vaoid setup(String os, String br)
	 *then creat swatch case method for make all parameter as a lowercase.
	 *and creat a chrome, firefox, edge, driver to run multiple. also add a default
	 method because if there is dirver not available it will pass a massagl like
	 Default:System.out.println("Invalid brwoser");
	 
	*This is how we can pass parameter from xml to setup method().
	*so now we can't execute herer because now webdriver controled by xml so in xml
	 file we can run our code.
	*Suppose is do parallel testing we wont to execute all test case & multiple vrowser.
	*copy existing xml file give it name as a cross browser testing.xml[1:2} create multiple
	 tags xml this parallel testing
	*/
	 
	//4.]Create property file which is having a common data a to use multiple time's 
	/*Go to resource-right click-creat-new-file-give a name'configure-properties'.
	 * whatever data write in day49 remaining we written last of this day49..
	 
	 *property data:-email, password, search product, name, we will use these veiable
	  are commonly required in multiple test are we can keep all the veriable here,
	  in side the configur properties file we have to load this file and rad value from
	  veriable, so step by step we do.
	  
	 *Go to "testBase" package "Baseclass" clas and add loging configur properties file
	  ofter creating EX: setup() method & input properties p;
	  @BeforeClass
	  @Parameter("OS", "browser");
	  public void setup (String os, String br)
	 *login config properties file
	 *create object and provide file location
	 FileReader file=new File Reader(.\src\\test\\resource\\config.properties");
	 p.new properties();
	 p.load (file);
	 
	*also launch webdriver by adding common vlaue frame properties file ddriver.get
	(p.getproperty("appURL2")); //reading vlue url from properties file.
	*/
	
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
