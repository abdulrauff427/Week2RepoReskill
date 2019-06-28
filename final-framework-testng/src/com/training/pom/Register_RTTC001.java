package com.training.pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Register_RTTC001 {
	
	private WebDriver driver;

	public Register_RTTC001(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);

}
	
	@FindBy(xpath="//input[@id='input-firstname']")
	private WebElement firstname; 
	
	@FindBy(xpath="//input[@id='input-lastname']")
	private WebElement lastname; 
	
	@FindBy(xpath="//input[@id='input-email']")
	private WebElement email; 
	
	@FindBy(xpath="//input[@name='telephone']")
	private WebElement telephone; 
	
	@FindBy(xpath="//input[@name='address_1']")
	private WebElement address1; 
	
	@FindBy(xpath="//input[@name='address_2']")
	private WebElement address2; 
	
	@FindBy(xpath="//input[@name='city']")
	private WebElement city; 
	
	@FindBy(xpath="//input[@name='postcode']")
	private WebElement postalcode; 
	
	@FindBy(xpath="//select[@name='country_id']")
	private WebElement country; 
	
	@FindBy(xpath="//select[@name='zone_id']")
	private WebElement state; 
	
	@FindBy(xpath="//input[@name='password']")
	private WebElement password; 
	
	@FindBy(xpath="//input[@name='confirm']")
	private WebElement confirmpassword; 
	
	@FindAll(@FindBy(xpath="//input[@type='radio']"))
	List<WebElement> radio; 
	
	@FindBy(xpath="//input[@type='checkbox']")
	private WebElement checkbox; 
	
	@FindBy(xpath="//input[contains(@value,'Cont')]")
	private WebElement continuebutton; 
	
	@FindBy(xpath="//div[@id='System_nyHsmShk']/div/p[1]")
	private WebElement confirmmsg;

	
	    public void enterfirstname(String firstname) {
		this.firstname.clear();
		this.firstname.sendKeys(firstname);
	    }
	   
	    public void enterlastname(String lastname) {
			this.lastname.clear();
			this.lastname.sendKeys(lastname);
		    }
	    
	    public void enteremail(String email) {
			this.email.clear();
			this.email.sendKeys(email);
		    }
	    
	    public void entertelephone(String telephone) {
			this.telephone.clear();
			this.telephone.sendKeys(telephone);
		    }
	    
	    public void enteraddress1(String address1) {
			this.address1.clear();
			this.address1.sendKeys(address1);
		    }
	    
	    public void enteraddress2(String address2) {
			this.address2.clear();
			this.address2.sendKeys(address2);
		    }
	    
	    public void entercity(String city) {
			this.city.clear();
			this.city.sendKeys(city);
		    }
	    
	    public void enterpostalcode(String postcode) {
			this.postalcode.clear();
			this.postalcode.sendKeys(postcode);
		    }
	    
	    public void selectcountry() {
	    	Select sel = new Select(this.country);
		    sel.selectByVisibleText("India");
			
		    }
	    
	    public void selectstate() {
	    	Select sel = new Select(this.state);
			sel.selectByVisibleText("Karnataka");
		    }
	    
	    public void enterpassword(String password) {
			this.password.clear();
			this.password.sendKeys(password);
		    }
	    
	    public void confirmpassword(String confirmpass) {
			this.confirmpassword.clear();
			this.confirmpassword.sendKeys(confirmpass);
		    }
	    
	    public void SelectNo() {
			this.radio.get(2).click();
		    }
	    
	    public void clickcheckbox() {
			this.checkbox.click();
		    }
	    
	    public void clickcontinue() {
			this.continuebutton.click();
		    }
	    
	    public String verifymsg()
	    {
	    	return this.confirmmsg.getText();
	    }
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	
	
	
}

