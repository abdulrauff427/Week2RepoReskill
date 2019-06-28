package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_RTTC002 {

private WebDriver driver; 
	
	public Login_RTTC002(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
}
	
	@FindBy(xpath="//input[@id='input-email']")
	private WebElement username; 
	
	@FindBy(xpath="//input[@id='input-password']")
	private WebElement password; 
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement loginbutton; 
	
	
	 public void enterusername(String username) {
			this.username.clear();
			this.username.sendKeys(username);
		    }
	 
	 public void enterpassword(String password) {
			this.password.clear();
			this.password.sendKeys(password);
		    }
	 
	 public void clickLoginbutton() {
			this.loginbutton.click();
		    }
	
	
	
}
