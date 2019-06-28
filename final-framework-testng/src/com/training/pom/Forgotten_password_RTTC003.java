package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Forgotten_password_RTTC003 {

	
private WebDriver driver; 
	
	public Forgotten_password_RTTC003(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
}
	
	@FindBy(xpath="//a[text()='Forgotten Password']")
	private WebElement forgotpasslink; 
	
	@FindBy(xpath="//input[@name='email']")
	private WebElement email; 
	
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement continuebutton; 
	
	@FindBy(xpath="//div[@id='System_nyHsmShk']/child::div[1]")
	private WebElement successmsg;
	
	
	
	 public void clickforgotlink() {
			this.forgotpasslink.click();
		    }
	 
	 public void enteremail(String email) {
			this.email.clear();
			this.email.sendKeys(email);
		    }
	 
	 public void clickcontinuebotton() {
			this.continuebutton.click();
		    }
	 public String confirmationmessage()
	 {
		return this.successmsg.getText();
	 }
	 
	 
	 
	
	
	
}
