package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyOrders_RTTC004 {
	
private WebDriver driver; 
	
	public MyOrders_RTTC004(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
}
	
	@FindBy(xpath="//*[@id=\"Menu_Wmt3OMY3\"]/nav/ul/li[2]/a")
	private WebElement hover; 
	
	@FindBy(xpath="//*[@id=\"Menu_Wmt3OMY3\"]/nav/ul/li[2]/ul/li[3]")
	private WebElement myorders; 
	
	@FindBy(xpath="//*[@id=\"System_s3bhXNDb\"]/div[1]/table/tbody/tr/td[7]/a")
	private WebElement view; 
	
	@FindBy(xpath="//div[@id='System_s3bhXNDb']/child::div[1]/p[1]")
	private WebElement successmsg;
	
	
	 public void hovermouse() {
		 
		 Actions action = new Actions(driver);
			action.moveToElement(this.hover).build().perform();
	        		
		    }
	 
	 public void clickmyorders() {
		 
		 this.myorders.click();
	 }
	 
	 public void clickview()
	 {
		 this.view.click();
	 }
	 
	 public String verifysuccessmsg() {
		return this.successmsg.getText();
	 }
	
	

}
