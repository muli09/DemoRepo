package com.crm.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.CasesPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.TasksPage;
import com.crm.qa.util.TestUtil;

public class CasesPageTest extends TestBase {
	
	LoginPage loginPage;
	TestUtil testUtil;
	HomePage homePage;
	CasesPage casesPage;
	String sheetName="cases";
	

	public CasesPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUP(){
		initialization();
		 loginPage=new LoginPage();
		 testUtil = new TestUtil();
		 casesPage=new CasesPage();
		 homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		 testUtil.switchToFrame();
		  homePage.clickOnCaseLink();
	}
	
	@Test(priority=1)
    public void validateAdvancedSearchPage(){
	 Assert.assertTrue(casesPage.verifyAdvancedSearchLabel());
	}
	@DataProvider
	public Object[][] getCRMTestData(){
		Object data[][]=TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority=2,dataProvider="getCRMTestData")
	public void validateCreateNewCases(String cTitle,String cStatus,String cState,String cType,String cPriority,String cContact){
		//Stpe -1 Click on New Case
		homePage.clickOnTheNewCase();
		
//		Step -2 Create new case
		String[] Cnumow=casesPage.createNewCase(cTitle, cStatus, cState, cType, cPriority, cContact);
		String CNumber=Cnumow[0];
		String COwner=Cnumow[1];
	
//	Step -3Verify created case
		casesPage.VerifyCreatedCaseDetails(cTitle, cStatus, cState,cType,cPriority,cContact,CNumber,COwner);
	}


	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
}
