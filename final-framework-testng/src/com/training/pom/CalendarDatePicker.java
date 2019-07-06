package com.training.pom;

import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalendarDatePicker {
private WebDriver driver; 
	
	public CalendarDatePicker(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
}

	@FindBy(xpath="//table[@id='discount']/tbody/tr/td[5]//button") //Start Date Calendar
	private WebElement startDateCal;
	
	@FindBy(xpath="//table[@id='discount']/tbody/tr/td[6]//button") //End Date Calendar
	private WebElement endDateCal;
	
	  //button to click in center of calendar header
	@FindBy(xpath="//div[@id='container']/following-sibling::div[4]/div[1]/div[1]/table/thead/tr[1]/th[2]") //middle link in  Calendar
	private WebElement midLink;
	
	//div[@class='bootstrap-datetimepicker-widget dropdown-menu bottom picker-open']/div[1]/div[1]/table/thead/tr[1]/th[2]
	
	//button to click on previous of calendar header
	@FindBy(xpath="//div[@id='container']/following-sibling::div[4]/div[1]/div[2]/table/thead/tr/th[1]") //previous link in  Calendar
	private WebElement previousLink;
	
	//button to click on Next of calendar header
	@FindBy(xpath="//div[@id='container']/following-sibling::div[4]/div[1]/div[2]/table/thead/tr/th[3]") //Next link in  Calendar
	private WebElement nextLink;
	
	 //Get all months from calendar to select correct one
	@FindAll(@FindBy(xpath="//div[@id='container']/following-sibling::div[4]/div[1]/div[2]/table/tbody/tr/td/span")) //Months in  Calendar
	List<WebElement> list_AllMonths;
	
	//Get all dates from calendar to select correct one
	@FindAll(@FindBy(xpath="//div[@id='container']/following-sibling::div[4]/div[1]/div[1]/table/tbody/tr/td[@class!='day old' and @class!='day new']")) //Days in  Calendar
	List<WebElement> list_AllDays;
	
	
	
	
	public void selectStartDate(String date) throws InterruptedException {
	         
		
		String dateTime = date;
		this.startDateCal.click();
		//printing size of months and dislaying it
		System.out.println(list_AllMonths.size());
		for(WebElement months:list_AllMonths) {
			//Displays the inner text coz getText() was displaying no value... both step 62 and 63 are working
			String month = months.getAttribute("innerHTML");
			//String month = months.getAttribute("innerText");
			System.out.println("Month is "+month);
		}
		
		//printing number of days and listing them all
		System.out.println("Size of Days " +list_AllDays.size());
		for(WebElement days:list_AllDays) {
			String days1 = days.getText();
			System.out.println("Date is "+days1);
		}
		/*
		 * for(WebElement ele:list_AllMonths) {
		 * 
		 * String date1=ele.getText(); System.out.println("Months " +date1.getV); }
		 */
		//
		//for(int i=1;i<=list_AllMonths.size();i++)
		//{
		
			//	}
		
		
		 
		
		//Split the date time to get only the date part
		String date_yyyy_mm_dd[] = (dateTime.split("-"));
		System.out.println("year is " +date_yyyy_mm_dd[0]);
		
		  //get the year difference between current year and year to set in calender
		int yearDiff = 	Integer.parseInt(date_yyyy_mm_dd[0])-Calendar.getInstance().get(Calendar.YEAR);
		System.out.println("year difference is " +yearDiff);
		Thread.sleep(1000);
		this.midLink.click();
		
		if(yearDiff!=0) {
			//if you have to move next year
			if(yearDiff>0) {
				for (int i=0;i<yearDiff;i++) {
					System.out.println("Year Diff ->" +i);
					this.nextLink.click();
				}
			}
			
			//if you have to move previous year
			else if(yearDiff<0) {
				for (int i=0;i<(yearDiff*(-1)); i++) {
					System.out.println("Year Diff ->" +i);
					this.previousLink.click();
				}
			}
		}
			
		//Get all months from calendar to select correct one
		list_AllMonths.get(Integer.parseInt(date_yyyy_mm_dd[1])-1).click();
		//get all dates from calendar to select correct one
		list_AllDays.get(Integer.parseInt(date_yyyy_mm_dd[2])-1).click();
        
	}
	
	
}
