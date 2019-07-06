package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.AddproducttoCartandCheckout;
import com.training.pom.EditPersonaldetails_RTTC005;
import com.training.pom.Homepage_RTTC001;
import com.training.pom.Login_RTTC002;
import com.training.pom.Register_RTTC001;
import com.training.pom.Returning_NewCusomter;
import com.training.pom.Shop_earrings;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTTC_033 {
	
	public WebDriver driver;
	private String baseUrl;
	private Shop_earrings shop;
	private static Properties properties;
	private ScreenShot screenShot;
	private AddproducttoCartandCheckout addtocart;
	private Returning_NewCusomter returningcust;
	private Homepage_RTTC001 homepage;
	private Login_RTTC002 login;
	private Register_RTTC001 personaldetails;
	
	@BeforeTest
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeClass
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		shop = new Shop_earrings(driver);
		addtocart = new AddproducttoCartandCheckout(driver);
		returningcust = new Returning_NewCusomter(driver);
		homepage = new Homepage_RTTC001(driver);
		login = new Login_RTTC002(driver);
		personaldetails = new Register_RTTC001(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterTest
	public void tearDown() throws Exception {
		Thread.sleep(5000);
		//driver.quit();
	}
	@Test
	public void myaccountdetails() throws InterruptedException {
    
		homepage.clickLoginregister();
		login.enterusername("manzoor@gmail.com");
		login.enterpassword("manzoor1");
		login.clickLoginbutton();
		shop.clickShopEarrnigs();
		shop.productClick();
		
		addtocart.ClickAddtoCart();
		addtocart.hovershoppingcart();
		addtocart.clickcheckoutbtn();
		
		personaldetails.clickcontinuebilldetailsforpayment();
		personaldetails.clickcontinuedeliverdetails();
		personaldetails.clickcontinuedeliveryMethod();
		personaldetails.clickcheckboxpaymentmethod();
		personaldetails.clickcontinuepaymentmethod();
		personaldetails.clickConfirmbutton();
		
		String exp = "Your order has been successfully processed!";
		String act = personaldetails.verifymsgSuccessfulOrder();
		Assert.assertEquals(act, exp);
		System.out.println(act);
		
		
	}
}





