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
import com.training.pom.EditPersonaldetails_RTTC005;
import com.training.pom.Homepage_RTTC001;
import com.training.pom.Login_RTTC002;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTTC_005 {
	
	private WebDriver driver;
	private String baseUrl;
	private Homepage_RTTC001 homepage;
	private Login_RTTC002 login;
	private EditPersonaldetails_RTTC005 editdetails;
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
		login = new Login_RTTC002(driver);
		editdetails = new EditPersonaldetails_RTTC005(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(5000);
		driver.quit();
	}
	@Test
	public void myaccountdetails() {
		
		homepage.clickLoginregister();
		login.enterusername("manzoor@gmail.com");
		login.enterpassword("manzoor1");
		login.clickLoginbutton();
		
		editdetails.clickonEditbutton();
		editdetails.EnterFirstName("Abdul");
		editdetails.EnterlastName("Mohammed");
		editdetails.EnterEmail("abdul3@gmail.com");
		editdetails.EnterTelephone("9847898789");
		screenShot.captureScreenShot("RTTC005_01");
		editdetails.Clickcontinuebutton();
		screenShot.captureScreenShot("RTTC005_02");
		
		String expected_msg = "Success: Your account has been successfully updated.";
		String Actual_msg = editdetails.successmsg();
		Assert.assertEquals(Actual_msg, expected_msg);
		System.out.println("Message displayed is "+"Success: Your account has been successfully updated.");
		
		
	}
}





