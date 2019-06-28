package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.Homepage_RTTC001;
import com.training.pom.Login_RTTC002;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTTC_002_FF {

	private WebDriver driver;
	private String baseUrl;
	private Homepage_RTTC001 homepage;
	private Login_RTTC002 login;
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
		driver = DriverFactory.getDriver(DriverNames.FIREFOX);
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
		//driver.quit();
	}
	@Test
	public void Register() {
		homepage.clickLoginregister();
		screenShot.captureScreenShot("RTTC002_1");
		
		login.enterusername("manzoor@gmail.com");
		login.enterpassword("manzoor1");
		screenShot.captureScreenShot("RTTC002_2");
		login.clickLoginbutton();
		screenShot.captureScreenShot("RTTC002_3");
		String actual_title = driver.getTitle();
		String expected_title= "My Account";
		Assert.assertEquals(actual_title, expected_title, "My Account is not displayed as the title of the page");
		
		
		
		
	}
}
