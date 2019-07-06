package com.training.pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Returning_NewCusomter {
	
private WebDriver driver; 
	
	public Returning_NewCusomter(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
}

	@FindBy(css="legend")
	private WebElement ReturningCustomer; 
	
	@FindAll(@FindBy(xpath="//input[@type='radio']"))
	private List<WebElement> radio;
	
	@FindBy(css="input#button-account.btn.btn-primary")
	private WebElement continuebtn; 
	
	
	
	
	public String verifyreturningcustomer() {
		
		return this.ReturningCustomer.getText();
	}
		
	public void clickonguest() {
		this.radio.get(1).click();
	}
	
	public void clickcontinuebtn() {
		this.continuebtn.click();
	}
	
	
	
	
	
	
}
