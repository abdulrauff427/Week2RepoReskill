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
import com.training.pom.Homepage_RTTC001;
import com.training.pom.Login_RTTC002;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTTC_002 {

	// Log4J code
	static final Logger log = Logger.getLogger(RTTC_002.class);

	private WebDriver driver;
	private String baseUrl;
	private Homepage_RTTC001 homepage;
	private Login_RTTC002 login;
	private static Properties properties;
	private ScreenShot screenShot;
	private static ExtentHtmlReporter reporter;
	private static ExtentReports extent;
	private ExtentTest logger;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);

		//extent report code
		reporter = new ExtentHtmlReporter("C:\\Abdul\\RTC002_Extentreport.html");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		homepage = new Homepage_RTTC001(driver);
		login = new Login_RTTC002(driver);
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
	public void Login() {
		

		logger = extent.createTest("Homepage test");
		logger.log(Status.INFO, "We are at the homepage");
		homepage.clickLoginregister();
        logger.log(Status.PASS, "Login/Register option is clicked");
		extent.flush();
		screenShot.captureScreenShot("RTTC002_1");
		ExtentTest logger2 = extent.createTest("Login test");
		logger2.log(Status.INFO, "We are going to enter username and password");
		login.enterusername("manzoor@gmail.com");
		logger2.log(Status.PASS, "username entered");
		login.enterpassword("manzoor1");
		logger2.log(Status.PASS, "Password entered");
		log.info("user id and password entered");
		log.info("Log4j message");
	
		screenShot.captureScreenShot("RTTC002_2");
		login.clickLoginbutton();
		logger2.log(Status.PASS, "Login button is clicked");
		screenShot.captureScreenShot("RTTC002_3");
		try {
			String actual_title = driver.getTitle();
			String expected_title = "My Account1";
			Assert.assertEquals(actual_title, expected_title, "My Account is not displayed as the title of the page");
			log.info("Title is a match");
			logger2.log(Status.PASS, "Title is a match");
		} catch (Error e) {
			log.error("Title did not match");
			logger2.log(Status.FAIL, "Title mismatch");
		}
		extent.flush();
	}
}
