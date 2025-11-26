package opencart_Project_Introduction;

//day no-49,,
//page no-1
//1st,,Hybrid_Automation_Frame_Work

public class Day_49_Hybrid_AutomationFrameWork_Introduction {

	//Hybrid Automation Frame Work flow chart or structure:-
		/*its contain mainly page object and testcase, & internally test cases 
		  is cantain utility file, test date, resourc. and test casese when we run test
		  case in testNG & XML we can generate the report's & log's files, and this is 
		  part of development and execution and once the development & execution in done
		  then we will push our code into the "git respository" which is our local reposit
		  -ory, and again we will push them into "github repository" which is a going on
		  remote or global repository & finally we will run this code on the "Jnkin" in
		  remote environment, so this is a process of developing the entire frame work of
		  Now whole thing we will develop step-by-step.
		 *Step-1.Create a new maven project why? because we can easily add dependencies
		  we can easily update our project versions we can run our project in that three
		  remote environment so thse are all possible only through maven project most of
		  thing we can automatecally do it instead of involving manually stuff, ofter
		  createing we need toa dd required depdendencies in our pom.xml file. like sel
		  -enium, java depdendency, appache poi,work with excel file, log for j, third
		  party application's depdendency and many more. 
		  
		 *Emplement Frame Work..
		  step-1,Create maven project..Go to eclips-File-new-maven project-click on check
		  box-next then provide a groupID and ArtifactID as same name now we providing"open cart"
		  and let's finish alos this both ID's will visible in our pom.xml ofter creating 
		  maven file, go to pom.xml file and.
		 *add all depdendencies like excel file,log for j. appache poi, report dependencies 
		  etc. add all required depdency its a beasic step in real time also no one feed us
		  we should do this all by our self if havy mejor difficulty there only we can infom 
		  lead elso for small things we have to handle once add all please save it and upadate 
		  it by goingo to project folder right lick scroll down and click on maven and update 
		  it one pop-up will come click on "Ok" once we done our pom.xml will get updated.
		  
		 *step-1,Create Folders and log's(package's) in "opencart" maven project.
		  earlier class we get to specially frame work is use full for maunted a folder structure
		  our projcet folder is cantain package's and floder's means which we create manually
		  like page objects, test base, testcase, utilities etc are package(log's) under src/test
		  java, and under folder we have logs, reports, sreen shot, src, target, test data,
		  pom.xml TestNG etc. thse are bydafult folder of our project folder. this is basically
		  folder stracture.
		 in our project folder there development as well as testing folder bydefault generated
		  so if wann we can delete developers starting two folders src/main/java src/main/resource.
		 
		 *check all depdendency are add or not in our depdency folder and as we seve our folder
		  structure like that create log resource file :- which are required our test case 
		  these file called resource file. Ex:-property & utility file's.
		 create some folders in project folder.'page object', 'testCases' 'utilities'.as a 
		 package 'testBase' also creat. now this packages contain multiple class and methods.
		 
		*1)testBase:-its contain common method's we create once but we use multiple times.
		*2)testCases:-create class of Accout registretion before going to login.
		*3)page object:- its contain constructor, locator's and Action method.
		*4)utility :- its all having same test case data..
		
		//1\\....noarmal data( which is not reuse of customer detail).
		*Now create some folder as like package like logs, reports shreenshots many
		 more we can creat.
		*1)logs:- contain test data 
		*2)reports:- contain reports after execution xml file generate report here.
		*3)screen shots:- it's contain screen shots of execution and updat into report.
		*4)testData :- whichever data get repeated in testcase that dat present here.
		
		*before goig to start frame work ope AXXMPP server applicaiton appache and sql make start.     
		 */
		
		/*Developement is contain common method which we use mulitple time for test
		  case so one class we will create whatever we use commonly methods so that 
		  call test base..
		  
		 *1st Test Case "openCart sign and provide custome details".
		 *Before going to login application we have to provide accout details so lets 
		 create account and Registretion 
		 *Note:-Before going use application activate xampp sever appache & my sql.
		 
		 * As we know in page object we have 3 step to creat page object.
		 * 1)Constructor- driver instance.
		 * 2)Locatiors- through locaters we can find Element.
		 * 3)Action- we will perform a action on specific elements.
		 
		 *1)Constructor- driver instance.
		 *Commonly used d to crea emthod is commonly use to creat page object of 
		  test case right so driver instance creating every time we can creat this 
		  webdriver instance method in "base page class in page object package"
		  b we can use this multiple time once creating, and this method we 
		  will call in our "homepage" class in "page object package",by suing 
		  'SUPER key' word its related to inheritence topic 1)immidiate import class
		  base page is a parent class of "homepage" so we involve this constructor
		  to every where whever constructor required by using super key we will
		  call. also this base page dont have any method or parameter only contain
		  constructor.
		  
		  *let's create a Homepage.. and extends by basepage 
		 */
		
		/*//2\\....Random Data,,(by using this key we are able chanage normal data automatically).
		 *still test not-completed now to check run one more time see now.its showing
		  "email getregistred", means our test got fail so for, acutually time we have
		  to change our email address so to handle fail issur we will "rundom data" 
		  Note:- here we will prefer two data
		  1)Static data :- what will never change & Befor test run we prepered it.
		  2)Dynamic data:-That we will reate run tie randomly.
		  
		 *So for taht create our own user defined method in Java Method it's not-built-in
		  method which will generate some test randomly some string also lets create
		  here in java on predefined method is available.
		  
		  *RandomStringUtil's.randomAlphabetic(5) //in TC001AccountRegistrationTest file.
		  *use "return" method to get return value
		  *1 to 10 any one we can provide randmoly
		  *store it in string veriable
		  *it not available directly it's available in, common library add depdendency.
		  
		 *by adding "appache common lang3" independency, we can able to achieve this
		  dynamic data, 
		 
		 * public String randomeString()
		{
			String generatedstring = RandomStringUtils.randomAlphabetic(5);
			return generatedstring;
		}
		*if we add 10 randomly 10 alphabates ads whatever A to Z we can give..
		*New every time 5 digit will change because we gave (5),eamil but to assign
		*this randome directly whenbecause both method are belonging to same classe so
		 we can directly call method by edting that method name whene we create random
		 alphabets
		*Ex:-regpage.setEmail(randomeString()+"@gamil.com")
		 *now N number of time Email will generat randomely
		 
		*Now can we apply this for other element also like first & last name? yes we
		 can but when we provide it we will gives all we have to use "toUpperCase()"
		 method. 
		 Ex:- rgepage.setFirstName(randomeSTring().toUpperCase());
		 Ex:- regpage.setLastName(randomString().toUpperCase());
		 
		*Now same thing can we do for password?Yes, but password contain random string
		 like Alphate, number, speed charecter,
		*Can we combined both method alphate+Numberic? yes we and also add special chere
		 -cter in between of string or ending this method.
		*When we add this random value into password it will generate 
		 two different password so that we will first store this random value in one
		 veriable and he assign into the password & conform password
		 Ex:-String password=randomAlphaNumberic(); 
		 regpage.setPassword(password);
		 
		 ✅NOTE:- Here day-49, in this video "OpenCart" application in customer detail
		 are different and in present "OpenCart" which is im using in that there is no
		 Telephone number and ConformPassword input not available so so only we have 
		 FirstName,LastName,Email,Password,Policy and continue button.
		 
		*Now we can run our code or test n-number of time it will give evertime diff
		 -erent value.
		 
		*here we are notgoing to use excel file ti fast we will use this is in data
		 driver test.
		 
		*Note:-can we use this for multiple test case? yes we can because common for
		 login test case so for that we have to create one more class in the test case
		 package and make these Data Whichever we use multiple time that data can store
		 in this class and class name 'Base class' it's contain all common method 
		 which is use "multiple time".
		 
		*So now remove it from here and keep it "Base Class" we will get it?by 
		 "extends" BaseClas we can get these dynamic value in to our test file("TC001
		 AccountReginstrationTest").
		 
		*what all are we use in common data?
		*1)@BeforeClass
		*2)@AfterClass
		*3)Dynamic data of all elements also that we use extends declear class name,
		*Because class is parents of all method.
		
		*By creating like this all becuase value is  our class we can avoid doublication 
		 problem we can use multiple time.
		*after adding all in one class in test page unneccerly package are there remove
		 by clicking on its "orgnize" renamed automatically.
		 
		*Now we have plan & clean test case let's execute how, result+pass.
		*WHatever we create base class for common value will store we can store that in
		 one package thath package is called "TestBase".
		 */
			
	}
