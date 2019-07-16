package com.training.pom;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
	
	@FindBy(xpath="//div[@id='System_nyHsmShk']/div[1]")
	private WebElement loginfailmsg;
	
	@FindBy(xpath="//a[@id='search_button']")
	private WebElement searchicon;
	
	@FindBy(xpath="//input[@name='search']")
	private WebElement searchtextbox;
	
	
	
	
	
	
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
	
	public String Loginfailure() {
		return this.loginfailmsg.getText();
	}
	
	public void hovertoSarchbox() {
		Actions action = new Actions(driver);
		action.moveToElement(this.searchicon).click().build().perform();
		//this.searchicon.sendKeys("Eyeware");		
	}
	public void searchproduct()
	{
		this.searchtextbox.click();
		this.searchtextbox.sendKeys("Eyewares");
		this.searchtextbox.sendKeys(Keys.ENTER);
	
	}
}
