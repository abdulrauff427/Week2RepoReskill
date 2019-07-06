package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Shop_earrings {
	
private WebDriver driver; 
	
	public Shop_earrings(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
}

	@FindBy(xpath="//li[@id='menu_all_categories_Menu_VIfWm2LT_VLHXC']/a")
	private WebElement shoplink; 
	
	
	@FindBy(xpath="//li[@id='menu_all_categories_Menu_VIfWm2LT_VLHXC']/ul/li[1]/a/span")
	private WebElement earrings_option;
	
	@FindBy(xpath="//*[@id='ProductsSystem_QQI8r357']/div/div[2]/div[1]/div[3]/div/div/div/h4/a")
	private WebElement product_Donec;

	
	
	public void clickShopEarrnigs() {
		
		Actions action = new Actions(driver);
		action.moveToElement(this.shoplink).build().perform();
        this.earrings_option.click();
        
        
	}
	
	public void productClick() {
		this.product_Donec.click();
	}
	
	
	
	
	
}
