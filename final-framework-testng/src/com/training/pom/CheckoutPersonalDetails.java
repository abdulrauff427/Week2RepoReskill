package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPersonalDetails {
	
private WebDriver driver; 
	
	public CheckoutPersonalDetails(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
}

	@FindBy(css="button#button-cart.btn")
	private WebElement btnAddtoCart; 
	
	
	
	
	
	
	public void ClickAddtoCart() {
	   this.btnAddtoCart.click();      
        
	}
	
	
	
	
	
	
	
}
