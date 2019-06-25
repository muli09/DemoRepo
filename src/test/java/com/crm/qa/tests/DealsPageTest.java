package com.crm.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class DealsPageTest extends TestBase {
	LoginPage loginPage;
	TestUtil testUtil;
	HomePage homePage;
	DealsPage dealsPage;
	String sheetName="deals";
	
public DealsPageTest(){
	super();
}

@BeforeMethod
public void setUP(){
	initialization();
	loginPage=new LoginPage();
	 dealsPage =new DealsPage();
	 homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	 testUtil = new TestUtil();
	 testUtil.switchToFrame();
	 homePage.clickOnDealsLink();
}

@Test(priority=1)
public void VerifyDealsPageWithAdvancedSerachTest(){
	Assert.assertTrue(dealsPage.verifyAdvancedSearchLabel());
}
@DataProvider
public Object[][] getCRMTestData(){
	Object data[][]=TestUtil.getTestData(sheetName);
	return data;
}


@Test(priority=2,dataProvider="getCRMTestData")
public void validateCreateNewDealTest(String title,String company,String value,String source,String Status){
	//dealsPage.createNewDeal("naga", "google", "Old", "Online", "Closed")
	homePage.clickOnNewDealLink();
	String d =dealsPage.createNewDeal(title, company, value, source, Status);	
	dealsPage.verifyCreatedDeal(title, company, value, source, d);
	
}
@AfterMethod
public void tearDown(){
	driver.quit();
}


 


	

}
