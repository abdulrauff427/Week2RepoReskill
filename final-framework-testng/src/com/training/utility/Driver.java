package com.training.utility;

public interface Driver {
	// KEYS 
	String CHROME ="webdriver.chrome.driver"; 
	String FIREFOX ="webdriver.gecko.driver"; 
	String IE ="webdriver.ie.driver";
	String PHANTOM="phantomjs.binary.path";
	
	// PATH 
	String CHROME_PATH="C:\\Abdul\\chromedriver_win32\\chromedriver75.exe";
	String FIREFOX_PATH ="C:\\Abdul\\geckodriver-v0.20.1-win64\\geckodriver.exe";
	String IE_PATH ="";
	String PHANTOM_PATH="";
	
}


//System.setproperty("webdriver.chrome.driver", "PAth of the exe")