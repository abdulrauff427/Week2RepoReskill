package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Medium_035 {
private WebDriver driver; 
	
	public Medium_035(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
}
	@FindBy(xpath="//i[@class='fa fa-tags fw']") //catalog icon
	private WebElement catalogIcon;
	@FindBy(xpath="//a[text()='Manufacturers']") //catalog icon
	private WebElement manufacturers;
	@FindBy(xpath="//i[@class='fa fa-plus']") // addnew button
	private WebElement addNewButton;
	@FindBy(id="input-name")	//manufacture text box
	private WebElement manufactureName; 
	@FindBy(xpath="//i[@class='fa fa-save']")
	private WebElement saveButton;
	@FindBy(xpath="//*[@id=\"menu-catalog\"]/ul/li[2]/a") //products
	private WebElement products;
	@FindBy(xpath="//li[@id='menu-catalog']/ul/li[1]/a") //products
	private WebElement categories;
	@FindBy(xpath="//i[@class='fa fa-plus']")
	private WebElement addButton;		//addbutton
	@FindBy(id="input-name1")	//product-name
	private WebElement productName;
	@FindBy(id="input-meta-title1")	//metaTagTitle
	private WebElement metaTagTitle; 
	@FindBy(xpath="//div[@class='note-editable panel-body']")
	private WebElement product_description;
	@FindBy(id="input-meta-description1")
	private WebElement megatag_description;
	@FindBy(linkText="Data")
	private WebElement dataTab;	//datatab -- need to check
	@FindBy(id="input-model") //modeltextbox
	private WebElement modelTextBox;
	@FindBy(id="input-price")
	private WebElement priceTextBox; //price textbox
	@FindBy(id="input-quantity")		//quantity tab
	private WebElement quantityTextBox;
	@FindBy(linkText="Links")
	private WebElement links;	//links tab
	@FindBy(id="input-manufacturer")
	private WebElement manufactureTextBox;
	
	//click on catagories
	@FindBy(id="input-category")
	private WebElement catagories;
	
	@FindBy(xpath="//div[@id='tab-links']/div[2]/div[1]/ul/li/a[contains(text(),'Accessories')]") // catagories-earring			---checking
	private WebElement catagoriesEarring;
	
	@FindBy(xpath="//i[@class='fa fa-save']") //savebutton
	private WebElement saveOption;
	@FindBy(xpath="//option[contains(text(),'India')][2]")
	private WebElement country;
	@FindBy(xpath="//option[contains(text(),'Karnataka')]")
	private WebElement state; 
	@FindBy(id="button-payment-address")
	private WebElement continueAddress;
	@FindBy(xpath="//*[@id='input-payment-method']")
	private WebElement paymentMethod;
	@FindBy(id="button-save")
	private WebElement saveButton1;
	
	//methods
	public void clickCatalogIcon() throws InterruptedException {
		this.catalogIcon.click();
		//Thread.sleep(3000);
	}
	public void clickManufacturersLink() throws InterruptedException {
		this.manufacturers.click();
		//Thread.sleep(3000);
	}
	public void clickAddNewButton() throws InterruptedException {
		this.addNewButton.click();
		//Thread.sleep(3000);
	}
	public void enterManufactureName(String manufactureName) throws InterruptedException {
		this.manufactureName.sendKeys(manufactureName);
		//Thread.sleep(3000);
	}
	public void clickSaveButton() throws InterruptedException {
		this.saveButton.click();
		//Thread.sleep(3000);
	}
	public void clickProducts() throws InterruptedException {
		this.products.click();
		//Thread.sleep(3000);
	}
	
	public void clickCatefories() throws InterruptedException {
		this.categories.click();
		//Thread.sleep(3000);
	}
	
	public void clickAddButton() throws InterruptedException {
		this.addButton.click();
		//Thread.sleep(3000);
	}
	public void addPrdouctName(String productName) throws InterruptedException {
		this.productName.sendKeys(productName);
		//Thread.sleep(3000);
		
	}
	public void addproddesc(String desc) {
		this.product_description.sendKeys(desc);
	}
	public void enterMetaTagTitle(String metaTagTitle) throws InterruptedException {
		this.metaTagTitle.sendKeys(metaTagTitle);
		//Thread.sleep(3000);
	}
	public void addMegaTagDesc(String megatagdesc) {
		this.megatag_description.sendKeys(megatagdesc);
	}
	public void clickOnDataTab() throws InterruptedException {
		this.dataTab.click();
		//Thread.sleep(3000);
	}
	public void enterModelTextBox(String modelTextBox) throws InterruptedException {
		this.modelTextBox.sendKeys(modelTextBox);
		//Thread.sleep(3000);
	}
	public void enterPriceTextBox(String priceTextBox) throws InterruptedException {
		this.priceTextBox.sendKeys(priceTextBox);
		//Thread.sleep(3000);
	}
	public void enterQuantityTextBox(String quantityTextBox) throws InterruptedException {
		this.quantityTextBox.sendKeys(quantityTextBox);
		//Thread.sleep(3000);
	}
	public void clickOnLinksTab() throws InterruptedException {
		this.links.click();
		//Thread.sleep(3000);
	}
	public void enterManufactureTextBox(String manufactureTextBox) throws InterruptedException {
		this.manufactureTextBox.sendKeys(manufactureTextBox);
		this.manufactureTextBox.click();
		//Thread.sleep(3000);
	}
	public void clickOnCatagories() {
		this.catagories.click();
	}
	public void clickCategoriesEarring() throws InterruptedException {
		this.catagoriesEarring.click();
		//Thread.sleep(3000);
	}
	public void clickSaveOption() throws InterruptedException {
		this.saveOption.click();
		//Thread.sleep(3000);
	}
	
}