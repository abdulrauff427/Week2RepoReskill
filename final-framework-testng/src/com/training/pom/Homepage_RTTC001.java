package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage_RTTC001 {
	
private WebDriver driver; 
	
	public Homepage_RTTC001(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
}

	@FindBy(xpath="//*[@id=\"Menu_Wmt3OMY3\"]//following::i[2]")
	private WebElement login_regist; 
	
	
	@FindBy(xpath="//*[@id=\"Menu_Wmt3OMY3\"]/nav/ul/li[2]/ul/li[1]")
	private WebElement login_regist_click;
	
	@FindBy(xpath="//*[@id=\"new_customer\"]/following::a[1]")
	private WebElement clickRegisterbtn;
	
	
	public void clickLoginregister() {
		
		Actions action = new Actions(driver);
		action.moveToElement(this.login_regist).build().perform();
        this.login_regist_click.click();
        
        
	}
	
	public void clickregisterbtn() {
		this.clickRegisterbtn.click();
		
	}
	
	
	
	
}
