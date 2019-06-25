package com.crm.qa.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.TasksPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactPage;
	DealsPage dealsPage;
	TasksPage tasksPage; 
	TestUtil testUtil;
	public HomePageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUP(){
		initialization();
		 loginPage=new LoginPage();
		 testUtil = new TestUtil();
		 homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));	 
}
	@Test(priority=1)
	public void verifyHomePageTitleTest(){
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String homePageTitle=homePage.verifyHomePageTitle();
		System.out.println(homePageTitle);
		Assert.assertEquals(homePageTitle,"CRMPRO","Home page title is not matched");
	}
	
	@Test(priority=2)
	public void verifyUserLableTest(){
		testUtil.switchToFrame();
		AssertJUnit.assertTrue(homePage.verifyUserLable());
	}
	
	@Test(priority=3)
	public void clickOnContactsLinkTest(){
		testUtil.switchToFrame();
		contactPage=homePage.clickOnContactsLink();
	}
	@Test(priority=4)
	public void clickOnDealsLinkTest(){
		testUtil.switchToFrame();
		dealsPage=homePage.clickOnDealsLink();	
	}
	@Test(priority=5)
	public void clickonTaskslinkTest(){
		testUtil.switchToFrame();
		tasksPage=homePage.clickonTaskslink();	
	}

	
	
	

	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
	
}