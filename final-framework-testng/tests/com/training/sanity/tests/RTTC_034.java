package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
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

public class RTTC_034 extends RTTC_032{
	
	//private WebDriver driver;
	private Returning_NewCusomter guest;
	private Register_RTTC001 personaldetails;
	
	@Test(priority=2)
	public void GuestCustomer() throws InterruptedException {
		guest = new Returning_NewCusomter(driver);
		personaldetails = new Register_RTTC001(driver);
		guest.clickonguest();
		guest.clickcontinuebtn();
		
		personaldetails.enterfirstname("Abdul");
		personaldetails.enterlastname("Mohammed2");
		personaldetails.enteremailforguest("abcd123@gmail.com");
		personaldetails.entertelephone("9856434567");
		personaldetails.enteraddress1("Address1");
		personaldetails.enteraddress2("Address2");
		personaldetails.entercity("Hyderabad");
		personaldetails.enterpostalcode("500001");
		personaldetails.selectcountry("India");
		personaldetails.selectstate("Telangana");
		personaldetails.clickcontinuebilldetails();
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





