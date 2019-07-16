package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.pom.LoginPOM;
import com.training.pom.Login_Admin_RTTC;
import com.training.pom.Medium_035;
import com.training.dataproviders.LoginDataProviders;
import com.training.pom.CalendarDatePicker;
import com.training.pom.DiscountandRewardpoints_035;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTTC_064 {
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private Login_Admin_RTTC loginAdmin;  //newly added
	private Medium_035 catalogManufacture;
	private DiscountandRewardpoints_035 rewards;
	private CalendarDatePicker cal;
	
	private static Properties properties;
	//private ScreenShot screenShot;
	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver); 
		loginAdmin = new Login_Admin_RTTC(driver); 
		catalogManufacture = new Medium_035(driver);
		rewards = new DiscountandRewardpoints_035(driver);
		cal = new CalendarDatePicker(driver);		
		baseUrl = properties.getProperty("baseURL");
		//screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		//driver.quit();
	}
	@Test(dataProvider="excel-inputsRTTC_064",dataProviderClass = LoginDataProviders.class)
	public void validLoginTest(String prodname, String proddesc, String Metatagname, String Metatagdesc) throws InterruptedException 
	{
		
		
		loginAdmin.sendUserName("admin");
		loginAdmin.sendPassword("admin@123");
		loginAdmin.clickLoginBtn();
		
		catalogManufacture.clickCatalogIcon();
		catalogManufacture.clickCatefories();
		catalogManufacture.clickAddButton();
		catalogManufacture.addPrdouctName(prodname);
		catalogManufacture.addproddesc(proddesc);
		catalogManufacture.enterMetaTagTitle(Metatagname);
		catalogManufacture.addMegaTagDesc(Metatagdesc);
		
		rewards.save();
		
		
}
	}
