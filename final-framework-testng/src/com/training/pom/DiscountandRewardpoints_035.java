package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DiscountandRewardpoints_035 {
private WebDriver driver; 
	
	public DiscountandRewardpoints_035(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
}
	@FindBy(xpath="//a[text()='Reward Points' and @data-toggle ='tab']") //Reward points tab
	private WebElement tabRewardPoints;
	
	@FindBy(xpath="//input[@id='input-points']") //Points text field
	private WebElement points;
	
	@FindBy(xpath="//i[@class='fa fa-save']") //Points text field
	private WebElement savebutton;
	
	@FindBy(xpath="//a[text()='Discount']") //Reward points tab
	private WebElement tabDiscount;

	@FindBy(xpath="//button[@onclick='addDiscount();']") //Add Discount button
	private WebElement addDiscountbtn;
	

	@FindBy(xpath="//input[@name='product_discount[0][quantity]']") //Quantity text box
	private WebElement quantity;
	
	@FindBy(xpath="//input[@name='product_discount[0][price]']") //Price text box
	private WebElement price;
	
	@FindBy(xpath="//table[@id='discount']/tbody/tr/td[5]//button") //Start Date Calendar
	private WebElement startDateCal;
	
	@FindBy(xpath="//table[@id='discount']/tbody/tr/td[6]//button") //Start Date Calendar
	private WebElement endDateCal;
	
	
	
	
	
	
	
	
	
	
	public void clickDiscounttab() {
		this.tabDiscount.click();
	}
	
	public void clickAddDiscountbtn() {
		this.addDiscountbtn.click();
	}
	
	public void enterquantity(String qty) {
		this.quantity.clear();
		this.quantity.sendKeys(qty);
	}
	
	public void enterprice(String price) {
		this.price.clear();
		this.price.sendKeys(price);
	}
	
	public void clickStartcal() {
		this.startDateCal.click();
		//div[@class='bootstrap-datetimepicker-widget dropdown-menu top picker-open']/div[1]/div[1]/table/tbody/tr/td  - xpath for days
	}
	
	public void clickendcal() {
		this.endDateCal.click();
	}
	
	
	
	
	public void clicktabRewardPoints(){
		this.tabRewardPoints.click();
		//Thread.sleep(3000);
	}
	
	public void enterpoints(String points) {
		this.points.clear();
		this.points.sendKeys(points);
	}
	
	public void save() {
		this.savebutton.click();
	}
}