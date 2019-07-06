package com.training.pom;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddproducttoCartandCheckout {
	
private WebDriver driver; 
	
	public AddproducttoCartandCheckout(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
}

	@FindBy(xpath="//button[contains(text(),'Add to Cart')]")
	private WebElement btnAddtoCart; 
	
	
	@FindBy(css="i.tb_icon.ico-linea-ecommerce-bag")
	private WebElement hovershoppingcart;
	
	@FindBy(xpath="//div[@id='cart']/ul/li/div/div/div[3]/a[1]")
	private WebElement clickViewcart;
	
	@FindBy(css="a.btn.btn-primary")
	private WebElement clickCheckout;
	
	@FindBy(xpath="//ul[@class='noty_cont noty_layout_topRight']/li/div/div/div[2]")
	private WebElement popupAddtoCart;
	
	
	
	
	public void ClickAddtoCart() throws InterruptedException {
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));
		Thread.sleep(6000);
//		WebDriverWait wait = new WebDriverWait(driver, 20);
//		wait.until(ExpectedConditions.elementToBeClickable(this.btnAddtoCart));
//		@SuppressWarnings("deprecation")
//		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)							
//				.withTimeout(30, TimeUnit.SECONDS) 			
//				.pollingEvery(5, TimeUnit.SECONDS) 			
//				.ignoring(NoSuchElementException.class);
	    this.btnAddtoCart.click();  
	   // wait.until(ExpectedConditions.elementToBeClickable(this.popupAddtoCart));
	    this.popupAddtoCart.click();
        
	}
	
	public void hovershoppingcart() {
		Actions act = new Actions(driver);
		act.moveToElement(this.hovershoppingcart).build().perform();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(this.clickViewcart));
		this.clickViewcart.click();

		
	}
	public void clickcheckoutbtn() {
		this.clickCheckout.click();
	}
	
	
   
	
	
	
	
	
}
