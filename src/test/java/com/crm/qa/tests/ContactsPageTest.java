package com.crm.qa.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {
	LoginPage loginPage;
	TestUtil testUtil;
	HomePage homePage;
	ContactsPage contactPage;
	String sheetName="contacts";
	

	public ContactsPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUP(){
		initialization();
		 loginPage=new LoginPage();
		 testUtil = new TestUtil();
    	 contactPage=new ContactsPage();
		 homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		 testUtil.switchToFrame();
		 contactPage = homePage.clickOnContactsLink();
		
}
	@Test(priority=1)
	public void verifyContactsLabelTest(){
		Assert.assertTrue(contactPage.verifyContactsLabel());
	}
	@Test(priority=2)
	public void selectcontactsPageByNameTest(){
		contactPage.selectcontactsPageByName("Test test2");
		Assert.assertEquals("Test test2", "Test test2","checkbox is selected successfully");
		
	}
	
	@DataProvider
	public Object[][] getCRMTestData(){
		Object data[][]=TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority=3,dataProvider="getCRMTestData")
	public void validateCreateNewContact(String title,String firstName,String lastName,String company){
		homePage.clickOnNewContactLink();
		contactPage.createNewContact(title, firstName, lastName, company);
	}
	

	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
}