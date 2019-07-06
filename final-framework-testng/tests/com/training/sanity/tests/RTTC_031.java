package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.training.generics.ScreenShot;
import com.training.pom.Homepage_RTTC001;
import com.training.pom.Login_RTTC002;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTTC_031 {

	// Log4J code
	static final Logger log = Logger.getLogger(RTTC_031.class);

	private WebDriver driver;
	private String baseUrl;
	private Homepage_RTTC001 homepage;
	private Login_RTTC002 login;
	private static Properties properties;
	private ScreenShot screenShot;
	//private static ExtentHtmlReporter reporter;
	private static ExtentReports extent;
	private ExtentTest logger;

	@BeforeSuite
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);

		//extent report code
		//reporter = new ExtentHtmlReporter("C:\\Abdul\\RTC002_Extentreport.html");
		//extent = new ExtentReports();
		//extent.attachReporter(reporter);
		extent = new ExtentReports("C:\\Abdul\\RTC031_Extentreport.html");
		
	}

	@BeforeTest
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		homepage = new Homepage_RTTC001(driver);
		login = new Login_RTTC002(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		// open the browser
		driver.get(baseUrl);
	}

	
	
	@Test(priority=1)
public void clicklogin()
	{
		
	logger = extent.startTest("Homepage test");
		logger.log(LogStatus.INFO, "We are at the homepage");
		homepage.clickLoginregister();
        logger.log(LogStatus.PASS, "Login/Register option is clicked");
        extent.endTest(logger);
		extent.flush();
		screenShot.captureScreenShot("RTTC002_1");
}

	@Test(priority=2,dataProvider="dp")
	public void Login(String Uname, String pass) {
		
		

		
		//ExtentTest logger2 = extent.createTest("Login test");
		logger = extent.startTest("Login test");
		logger.log(LogStatus.INFO, "We are going to enter username and password");
		login.enterusername(Uname);
		logger.log(LogStatus.PASS, "username entered");
		login.enterpassword(pass);
		logger.log(LogStatus.PASS, "Password entered");
		log.info("user id and password entered");
		screenShot.captureScreenShot();
		login.clickLoginbutton();
		logger.log(LogStatus.PASS, "Login button is clicked");
		screenShot.captureScreenShot();
		try {
			String actual_title = login.Loginfailure();
			String expected_title = "Warning: No match for E-Mail Address and/or Password.";
			Assert.assertEquals(actual_title, expected_title, "My Account is not displayed as the title of the page");
			log.info("Login Failure error message displayed is a match");
			logger.log(LogStatus.PASS, "Login Failure error message displayed is a match");
		} catch (Error e) {
			log.error("Login Failure error message displayed did not match");
			logger.log(LogStatus.FAIL, "Login Failure error message displayed did not match");
		}
		extent.endTest(logger);
		extent.flush();
	}
	
@Test(priority=3)
public void tearDown() throws Exception {
	Thread.sleep(2000);
	driver.quit();
     }
	
	@DataProvider(name="dp")
	public Object[][] getDataFromDataprovider()
	{
		//return new Object[][] { {"manzoor", "abcd"}, {"abdul", "abdul"}, {"monday", "pass"} };
		return new Object[][]
				{
			{"abc@gmail.com", "pass"},
			{"asdsau@g.com", "pass"},
			{"adssda", "adasdsa"}
				};
					
	}
	
}
