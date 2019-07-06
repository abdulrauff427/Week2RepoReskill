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
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.training.generics.ScreenShot;
import com.training.pom.Forgotten_password_RTTC003;
import com.training.pom.Homepage_RTTC001;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTTC_003 {
	
	static final Logger log = Logger.getLogger(RTTC_003.class);

	private WebDriver driver;
	private String baseUrl;
	private Homepage_RTTC001 homepage;
	private Forgotten_password_RTTC003 forgotpass;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		homepage = new Homepage_RTTC001(driver);
		forgotpass = new Forgotten_password_RTTC003(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		// open the browser
		driver.get(baseUrl);
	}

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}

	@Test
	public void forgotpassword() {
		
		ExtentHtmlReporter reporter = new ExtentHtmlReporter("C:\\Abdul\\RTC003_Extentreport.html");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		
		ExtentTest test = extent.createTest("Home page");
		
		test.log(Status.INFO, "User is going to click on Login/Register");
		homepage.clickLoginregister();
		log.info("User has successfulyy clicked on Login/Register");
		test.log(Status.PASS, "Login/Register option clikced on home page" );
		screenShot.captureScreenShot("RTTC003_1");
		extent.flush();
		
		ExtentTest test2 = extent.createTest("forgotten password");
		test2.log(Status.INFO, "User is going to reset his password");
		forgotpass.clickforgotlink();
		forgotpass.enteremail("manzoor@gmail.com");
		test2.log(Status.INFO, "user id entered");
		forgotpass.clickcontinuebotton();
		test2.log(Status.PASS, "user has successfully reset his password");
		screenShot.captureScreenShot("RTTC003_2");
        try
        {
		String expectedmsg = "An email with a confirmation link has been sent your email address!.";
		String actualmsg = forgotpass.confirmationmessage();
		Assert.assertEquals(actualmsg, expectedmsg);
		log.info("Title is a match");
		test2.log(Status.PASS, "Titel is a match");

	}
        catch (Error e) {
        	test2.log(Status.FAIL, "Title did not match");
        	log.error("title did not match");
	}
        extent.flush();
        

	}
}
