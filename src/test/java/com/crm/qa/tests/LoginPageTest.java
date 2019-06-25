package com.crm.qa.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUP(){
		initialization();
		 loginPage=new LoginPage();
		
	}
	@Test(priority=1)
	public void loginTest(){
		//Assert.assertEquals("CRM", loginPage.validateLoginPageTitle());
		homePage=loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		
		//Assert.assertEquals(homePage, expected);
		
	}
	
	
	
	


	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
}
