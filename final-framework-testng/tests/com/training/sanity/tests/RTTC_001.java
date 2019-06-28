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
import com.training.pom.Homepage_RTTC001;
import com.training.pom.Register_RTTC001;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTTC_001 {

	private WebDriver driver;
	private String baseUrl;
	private Homepage_RTTC001 login;
	private Register_RTTC001 register;
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
		login = new Homepage_RTTC001(driver);
		register = new Register_RTTC001(driver);
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
	public void Register() {
		login.clickLoginregister();
		login.clickregisterbtn();
		screenShot.captureScreenShot("First");
		
		register.enterfirstname("manzoor");
		register.enterlastname("mehadi");
		register.enteremail("manzoor@gmail.com");
		register.entertelephone("9876543210");
		register.enteraddress1("yeshwanthapur");
		register.enteraddress2("bangalore");
		register.entercity("bangalore");
		register.enterpostalcode("560022");
		register.selectcountry();
		register.selectstate();
		register.enterpassword("manzoor1");
		register.confirmpassword("manzoor1");
		register.SelectNo();
		register.clickcheckbox();
		register.clickcontinue();
		
		String expectedmsg = "Congratulations! Your new account has been successfully created!";
		String actualmsg = register.verifymsg();
		Assert.assertEquals(actualmsg, expectedmsg, "Account could not be created");
		System.out.println(expectedmsg);
	}
}
