package com.training.pom;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.trianing.waits.WaitTypes;

public class Register_RTTC001 {
	
	private WebDriver driver;
	public WaitTypes expwait = new WaitTypes(driver);

	public Register_RTTC001(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);

}
	
	@FindBy(xpath="//input[@name='firstname']")
	private WebElement firstname; 
	
	@FindBy(xpath="//input[@name='lastname']")
	private WebElement lastname; 
	
	@FindBy(xpath="//input[@name='email']")
	private WebElement email; 
	
	@FindBy(xpath="//input[@id='input-payment-email']")
	private WebElement guestemail; 
	
	
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
	
	@FindBy(xpath="//input[@id='button-guest']")
	private WebElement continuebilldetails; 
	
	@FindBy(xpath="//input[@id='button-payment-address']")
	private WebElement continuebilldetailspayment; 
	
	@FindBy(xpath="//input[@id='button-shipping-address']")
	private WebElement continuedeliveryaddress;
	
	@FindBy(xpath="//input[@id='button-shipping-method']")
	private WebElement continuedeliverymethod; 
	
	@FindBy(xpath="//div[@id='System_nyHsmShk']/div/p[1]")
	private WebElement confirmmsg;
	
	@FindBy(xpath="//input[@name='agree']")
	private WebElement checkboxPaymentMethod;
	
	@FindBy(xpath="//input[@id='button-payment-method']")
	private WebElement continuepaymentmethod;
	
	@FindBy(xpath="//input[@id='button-confirm']")
	private WebElement buttonConfirmOrder;
	
	@FindBy(xpath="//div[@id='System_s3bhXNDb']/div/p[1]")
	private WebElement msgSuccessfulOrder;
	

	
	
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
	    
	    public void enteremailforguest(String email) {
			this.guestemail.clear();
			this.guestemail.sendKeys(email);
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
	    
	    public void selectcountry(String country) {
	    	Select sel = new Select(this.country);
		    sel.selectByVisibleText(country);
			
		    }
	    
	    public void selectstate(String state) {
	    	Select sel = new Select(this.state);
			sel.selectByVisibleText(state);
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
	    
	    public void clickcontinuebilldetails() {
			this.continuebilldetails.click();
		    }
	    
	    public void clickcontinuebilldetailsforpayment() {
			this.continuebilldetailspayment.click();
		    }
	    
	    public void clickcontinuedeliverdetails() {
			this.continuedeliveryaddress.click();
		    }
	    
	    public void clickcontinuedeliveryMethod() {
			this.continuedeliverymethod.click();
		    }
	    
	    public void clickcheckboxpaymentmethod() {
	       // js = (JavascriptExecutor) driver;
	    	//js.executeScript("arguments[0].scrollIntoView();", this.checkboxPaymentMethod);
	    	//expwait.elementToBeClickable(this.checkboxPaymentMethod, 20);
	    	WebDriverWait wait = new WebDriverWait(driver, 20);
	    	wait.until(ExpectedConditions.elementToBeClickable(this.checkboxPaymentMethod));
	    	this.checkboxPaymentMethod.click();
	    }
	    
	    public void clickcontinuepaymentmethod() {
	    	this.continuepaymentmethod.click();
	    }
	    
	    public void clickConfirmbutton() {
	    	this.buttonConfirmOrder.click();
	    }
	    
	    
	    
	    public String verifymsg()
	    {
	    	return this.confirmmsg.getText();
	    }
	    
	    public String verifymsgSuccessfulOrder()
	    {
	    	return this.msgSuccessfulOrder.getText();
	    }
	    
	    
	   
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	
	
	
}

