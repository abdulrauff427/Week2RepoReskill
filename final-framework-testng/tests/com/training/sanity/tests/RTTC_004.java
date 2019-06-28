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
import com.training.pom.Login_RTTC002;
import com.training.pom.MyOrders_RTTC004;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTTC_004 {

	private WebDriver driver;
	private String baseUrl;
	private Homepage_RTTC001 homepage;
	private Login_RTTC002 login;
	private MyOrders_RTTC004 myorders;
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
		myorders = new MyOrders_RTTC004(driver);
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
	public void myorders() {
		homepage.clickLoginregister();
		screenShot.captureScreenShot("RTTC004_1");
		
		login.enterusername("manzoor@gmail.com");
		login.enterpassword("manzoor1");
		login.clickLoginbutton();
		screenShot.captureScreenShot("RTTC004_2");
		
		myorders.hovermouse();
		myorders.clickmyorders();
		screenShot.captureScreenShot("RTTC004_3");
		myorders.clickview();
		screenShot.captureScreenShot("RTTC004_4");
		
		String expmsg = "Your order has been successfully processed!";
		String actmsg = myorders.verifysuccessmsg();
		Assert.assertEquals(actmsg, expmsg);
		
	}
}


