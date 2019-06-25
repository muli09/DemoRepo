package com.crm.qa.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.TasksPage;
import com.crm.qa.util.TestUtil;

public class TaskPageTest extends TestBase{
	LoginPage loginPage;
	TestUtil testUtil;
	HomePage homePage;
	TasksPage tasksPage;
	String sheetName="tasks";
	

	public TaskPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUP(){
		initialization();
		 loginPage=new LoginPage();
		 testUtil = new TestUtil();
		 tasksPage=new TasksPage();
		 homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		 testUtil.switchToFrame();
		  homePage.clickonTaskslink();
	}
		  
	@Test(priority=1)
	public boolean verifySearchPageWithTask(){
		return tasksPage.verifyAdvancedSearchLabelWithTasks();
	}
	
	@DataProvider
	public Object[][] getCRMTestData(){
		Object data[][]=TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority=2,dataProvider="getCRMTestData")	
	public void validateCreateNewTask(String tTitle, String tStatus,String tType,String tPriority){
		//Stpe -1 Click on New task
		homePage.clickOnTheNewTask();
		
//		Step -2 Create new task
		String[] numow=tasksPage.creareNewTask(tTitle,tStatus,tType,tPriority);
	    
		String tNumber=numow[0];
		String tOwner=numow[1];
		System.out.println("ffdfdffd"+tOwner);
//		Step -3Verify created task
		tasksPage.verifyCreatedTaskDetails(tTitle, tStatus, tType, tPriority, tNumber, tOwner);
		}
		
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	}
	
	
	
	
	

	
	

