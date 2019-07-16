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

import com.training.dataproviders.RegisterDataProvider;
import com.training.generics.ScreenShot;
import com.training.pom.Homepage_RTTC001;
import com.training.pom.Register_RTTC001;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTTC_061 {

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
	@Test(dataProvider="db-inputs", dataProviderClass=RegisterDataProvider.class)
	public void Register(String fname, String lname, String email, String telephone, String add1, String add2, String city, String postal, String country, String region, String pass, String confirmpass) {
		login.clickLoginregister();
		login.clickregisterbtn();
		screenShot.captureScreenShot("First");
		
		register.enterfirstname(fname);
		register.enterlastname(lname);
		register.enteremail(email);
		register.entertelephone(telephone);
		register.enteraddress1(add1);
		register.enteraddress2(add2);
		register.entercity(city);
		register.enterpostalcode(postal);
		register.selectcountry(country);
		register.selectstate(region);
		register.enterpassword(pass);
		register.confirmpassword(confirmpass);
		register.SelectNo();
		register.clickcheckbox();
		register.clickcontinue();
		
	}
}
