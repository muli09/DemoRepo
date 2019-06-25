package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.qa.util.TestUtil;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	public static int num;
	 
	public TestBase(){
		try{
			prop=new Properties();
			FileInputStream ip =new FileInputStream("/Users/nishit/Documents/NagalakshmiWorkspace/FreeCRMTest/src/main/java/com/crm/qa/config/Config.properties");
			prop.load(ip);
		}catch (FileNotFoundException e){
			e.printStackTrace();
		}catch (IOException e){
			e.printStackTrace();
		}
		
	}
	
	//intilization method
	public static void initialization(){
	String BrowserName=prop.getProperty("Browser");
	System.out.println(BrowserName);
	if (BrowserName.equals("chrome")){
		System.setProperty("webdriver.chrome.driver", "/Users/nishit/Documents/chromedriver/chromedriver");
//		Step -1 Creating the driver object
		 driver = new ChromeDriver();
	} else if(BrowserName.equals("FireFox")){
		System.setProperty("webdriver.gecko.driver", "/Users/nishit/Documents/geckodriver/geckodriver");
//		Step -1 Creating the driver object
		 //driver = new FireFoxDriver();
	}
   driver.manage().window().maximize();
   driver.manage().deleteAllCookies();
   driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
   driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
	driver.get(prop.getProperty("url"));
   
	}
	
	

}
