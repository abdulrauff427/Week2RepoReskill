package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.Forgotten_password_RTTC003;
import com.training.pom.Homepage_RTTC001;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTTC_003 {

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
		homepage.clickLoginregister();
		screenShot.captureScreenShot("RTTC003_1");
		forgotpass.clickforgotlink();
		forgotpass.enteremail("manzoor@gmail.com");
		forgotpass.clickcontinuebotton();
		screenShot.captureScreenShot("RTTC003_2");

		String expectedmsg = "An email with a confirmation link has been sent your email address.";
		String actualmsg = forgotpass.confirmationmessage();
		Assert.assertEquals(actualmsg, expectedmsg);

	}

}
