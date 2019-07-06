package com.training.pom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Admin_RTTC {
	
	private WebDriver driver; 
	
	public Login_Admin_RTTC(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="input-username")
	private WebElement userName; 
	
	@FindBy(id="input-password")
	private WebElement password;
	
	
	@FindBy(xpath="//*[@id=\"content\"]/div/div/div/div/div[2]/form/div[3]/button")
	private WebElement loginBtn;
	
	//xpath("span[.='Customers']")
	//@FindBy(xpath="span[.='Customers']")
	//private WebElement Cus;
	
	@FindBy(xpath="//*[@id=\"menu-customer\"]/a")
	private WebElement Cus;
	
	
	@FindBy(linkText="Customers")
	private WebElement clickCustomer;
	
	//@FindBy(xpath="//*[@id=\"form-customer\"]/div/table/tbody/tr[2]/td[1]/input")
	//private WebElement cusNameCheckbox;
	
	@FindBy(xpath="//*[contains(text(),'manzoor mehadi')][1]")
	private WebElement cusNameCheckbox;
	
	@FindBy(xpath="//*[@id=\"content\"]/div[1]/div/div/button")
	private WebElement deleteButton;
	
	
	
	public void sendUserName(String userName) throws InterruptedException 
	{
		this.userName.clear();
		this.userName.sendKeys(userName);
		//Thread.sleep(1000);
	}
	
	public void sendPassword(String password) throws InterruptedException 
	{
		this.password.clear(); 
		this.password.sendKeys(password); 
		//Thread.sleep(1000);
	}
	
	public void clickLoginBtn() throws InterruptedException 
	{
		this.loginBtn.click(); 
		//Thread.sleep(1000);
	}
	
	public void clickCustomerIcon() throws InterruptedException 
	{
		this.Cus.click();
		//Thread.sleep(2000);
	}
	public void clickCustomerLink() throws InterruptedException 
	{
		this.clickCustomer.click();
		//Thread.sleep(3000);
	}
	public void clickCheckbox() throws InterruptedException
	{
		this.cusNameCheckbox.click();
		//cusNameCheckbox.isSelected();
		//Thread.sleep(2000);
		}
	public void clickDeleteButton() throws InterruptedException {
		this.deleteButton.click();
		
		//Thread.sleep(3000);
		Alert alert = driver.switchTo().alert();
		alert.accept();

	}
		
	}

	


