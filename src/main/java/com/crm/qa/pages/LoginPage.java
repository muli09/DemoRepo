package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	//page factory -OR:
	@FindBy(name="username")
	WebElement userName;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement LoginBtn;
	
	//initializing the page object
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	
	//Actions
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	
	public HomePage login(String us,String pwd){
		userName.sendKeys(us);
		password.sendKeys(pwd);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		LoginBtn.click();
		HomePage hom = new HomePage();
		return hom;
//		HomePage h = new HomePage();
//		return h;
	}
	
	
}
