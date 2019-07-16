package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.pom.LoginPOM;
import com.training.pom.Login_Admin_RTTC;
import com.training.pom.Login_RTTC002;
import com.training.pom.Medium_035;
import com.training.pom.CalendarDatePicker;
import com.training.pom.DiscountandRewardpoints_035;
import com.training.pom.Homepage_RTTC001;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTTC_065 {
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private Login_RTTC002 login;
	private Homepage_RTTC001 homepage;
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
		login = new Login_RTTC002(driver);
		homepage = new Homepage_RTTC001(driver);
		catalogManufacture = new Medium_035(driver);
		rewards = new DiscountandRewardpoints_035(driver);
		cal = new CalendarDatePicker(driver);		
		baseUrl = properties.getProperty("baseURL");
		//screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterClass
	public void verifyproduct() {
		driver.get("http://retailm1.upskills.in");
		homepage.clickLoginregister();
		login.enterusername("abdullah@gmail.com");
		login.enterpassword("manzoor1");
		login.clickLoginbutton();
		login.hovertoSarchbox();
		login.searchproduct();
		
	}
	@AfterMethod
	public void tearDown() throws Exception {
			
		Thread.sleep(1000);
		//driver.quit();
	}
	@Test
	public void validLoginTest() throws InterruptedException 
	{
		
		
		loginAdmin.sendUserName("admin");
		loginAdmin.sendPassword("admin@123");
		loginAdmin.clickLoginBtn();
		
		//catalogManufacture.clickCatalogIcon();
		//catalogManufacture.clickManufacturersLink();
		//catalogManufacture.clickAddNewButton();
		//catalogManufacture.enterManufactureName("sasmitaSelenium13");
		//catalogManufacture.clickSaveButton();
		
		catalogManufacture.clickCatalogIcon();
		catalogManufacture.clickProducts();
		catalogManufacture.clickAddButton();
		catalogManufacture.addPrdouctName("Eyewares");
		catalogManufacture.enterMetaTagTitle("eye frames12");
		catalogManufacture.clickOnDataTab();
		catalogManufacture.enterModelTextBox("SKU-022");
		catalogManufacture.enterPriceTextBox("20");
		catalogManufacture.enterQuantityTextBox("5");
		catalogManufacture.clickOnLinksTab();
		
		//catalogManufacture.enterManufactureTextBox("sasmitaSelenium13");
		catalogManufacture.clickOnCatagories();
		catalogManufacture.clickCategoriesEarring();
		//catalogManufacture.clickSaveOption();
		
		//Discouts and Rewards tab
		rewards.clickDiscounttab();
		rewards.clickAddDiscountbtn();
		rewards.enterquantity("10");
		rewards.enterprice("20");
		//Setting Start Date in the calendar
		cal.selectStartDate("2018-06-05");
		rewards.clicktabRewardPoints();
		rewards.enterpoints("20");
		rewards.save();
		
		
}
	}
