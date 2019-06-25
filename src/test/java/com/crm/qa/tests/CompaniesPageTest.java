package com.crm.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.CompaniesPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class CompaniesPageTest extends TestBase {
	HomePage homePage;
	LoginPage loginPage;
	CompaniesPage companiesPage;
	TestUtil testUtil;
	String sheetName="companies";
	
	
	//intilizing the pageproperties
	public CompaniesPageTest(){
		super();
	}
	
	//inilizing the method
	@BeforeMethod
	public void setUP(){
	initialization();
	loginPage=new LoginPage();
	 testUtil = new TestUtil();
	 companiesPage=new CompaniesPage();
	homePage =loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	testUtil.switchToFrame();
	homePage.clickOnCompaniesLink();
	
	}
	
	@Test(priority=1)
	public void validateAdvancedSearchCompanies(){
		Assert.assertTrue(companiesPage.verifyAdvancedSearchLabelCompanies());
	}
	
	
	@DataProvider
	public Object[][] getCRMTestData(){
		Object data[][]=TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority=2,dataProvider="getCRMTestData")
	public void createNewCompany(String comCompany,String comEmployee,String comIndustry,String comStatus,
			String comCategory,String comSource,String comPhone,String comEmail){
		//Step1 : Click on the Companies  and New Comapny link
		homePage.clickOnNewCompaniesLink();
		//Step2 : Create new company
		companiesPage.createNewCompanies(comCompany, comEmployee, comIndustry, comStatus, comCategory, comSource, 
				comPhone, comEmail);
		
		//Step3: Verifying the data
		companiesPage.verifyCompaniesDetails(comCompany, comEmployee, comIndustry, comStatus, comCategory, comSource, comPhone, comEmail);
		
		
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
