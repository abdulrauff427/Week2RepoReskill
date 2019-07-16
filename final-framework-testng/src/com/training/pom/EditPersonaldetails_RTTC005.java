package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.trianing.waits.WaitTypes;

public class EditPersonaldetails_RTTC005 {
	
private WebDriver driver; 
public WaitTypes wait = new WaitTypes(driver);
	
	public EditPersonaldetails_RTTC005(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
}

	@FindBy(xpath="//a[text()='Edit your account information']")
	private WebElement clickonEditlink; 
		
	@FindBy(id ="input-firstname")
	private WebElement FirstName;
	
	@FindBy(name ="lastname")
	private WebElement lastName;
	
	@FindBy(name ="email")
	private WebElement email;
	
	@FindBy(name ="telephone")
	private WebElement telephone;
	
	@FindBy(xpath ="//input[@type='submit']")
	private WebElement continuebtn;
	
	@FindBy(xpath="//*[@id=\"System_nyHsmShk\"]/div")
	private WebElement successmsg;
	
	
	public void clickonEditbutton() {
			this.clickonEditlink.click();
        
	}
	
	public void EnterFirstName(String firstname) {
		this.FirstName.clear();
		wait.presenceElementLocated("input-firstname", 20);
		this.FirstName.sendKeys(firstname);
		
	}
	
    public void EnterlastName(String lastname) {
		this.lastName.clear();
		this.lastName.sendKeys(lastname);
		
	}
    
    public void EnterEmail(String email) {
    	this.email.clear();
    	//wait.presenceElementLocated(this.email, 20);
    	this.email.sendKeys(email);
    	
		
		
	}
    
    public void EnterTelephone(String telephone) {
		this.telephone.clear();
		this.telephone.sendKeys(telephone);
		
	}
    
    public void Clickcontinuebutton() {
    	this.continuebtn.click();
    }
    
    public String successmsg()
    {
    	return this.successmsg.getText();
    }
	
	

}
