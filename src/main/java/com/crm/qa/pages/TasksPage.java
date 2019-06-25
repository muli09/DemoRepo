package com.crm.qa.pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.crm.qa.base.TestBase;

public class TasksPage  extends TestBase{
	//page factory
	@FindBy(xpath="//td[@onclick='showExtendedSearch();']")
	WebElement advancedSearchLabelWithTasks;
	
	@FindBy(xpath="//tr[td[strong[text()='Title']]]//../td/input")
	WebElement taskTitle;
	
	@FindBy(xpath="//tr[td[strong[text()='Status']]]//../td/select")
	WebElement taskStatus;
	
	//tr[td[strong[text()='Type']]]//../td/select
//	@FindBy(xpath="//tr[td[strong[text()='Status']]]//../td[2]/select/option[@value='Complete']")
//	WebElement taskStatusComplete;
//	
	@FindBy(xpath="//tr[td[strong[text()='Type']]]//../td/select")
	WebElement taskType;
	
	@FindBy(xpath="//tr[td[strong[text()='Priority']]]//../td/select")
	WebElement taskPriority;
	
	@FindBy(xpath="//tr[td[strong[text()='Assigned to']]]//../td/select/option")
	WebElement taskOwner;
	
	@FindBy(xpath="//tr[td[strong[text()='Task No.']]]//../td/input")
	WebElement taskNumber;

	@FindBy(xpath="//input[@value='Save']")
	WebElement taskSavebtn;

	//pagefactory for createdtaskdata
	@FindBy(xpath="//tr[td[strong[text()='Title']]]//../td[@class='datafield']")
	WebElement createdTaskTitle;

	
	@FindBy(xpath="//tr[td[strong[text()='Status']]]//../td[@class='datafield']")
	WebElement createdTaskStatus;

	@FindBy(xpath="//tr[td[strong[text()='Type']]]//../td[@class='datafield']")
	WebElement createdTaskType;
	
	@FindBy(xpath="//tr[td[strong[text()='Priority']]]//../td[@class='datafield']")
	WebElement createdTaskPriority;
	
	@FindBy(xpath="//tr[td[strong[text()='Owner']]]//../td[@class='datafield']")
	WebElement createdTaskOwner;

	@FindBy(xpath="//tr[td[strong[text()='Task No.']]]//../td[@class='datafield']")
	WebElement createdTaskNO;

	
	//initializing the page objects
	public TasksPage(){
		PageFactory.initElements(driver, this);
		
	}
	
	//Actions
	public boolean verifyAdvancedSearchLabelWithTasks(){
		return advancedSearchLabelWithTasks.isDisplayed();
	}
	
	public String[] creareNewTask(String tTitle,String tStatus,String tType,String tPriority){
		
		String[] numow= new String[2];
		System.out.println("Task number"+ taskNumber.getAttribute("value"));
		 numow[0]=taskNumber.getAttribute("value");
		 
		taskTitle.sendKeys(tTitle);
		
		Select selectTaskStatus=new Select(taskStatus);
		selectTaskStatus.selectByVisibleText(tStatus);
		
		Select selectTaskType=new Select(taskType);
		selectTaskType.selectByVisibleText(tType);
		
		Select selectTaskpriority=new Select(taskPriority);
		selectTaskpriority.selectByVisibleText(tPriority);
	
		 numow[1]=taskOwner.getText();
		
		taskSavebtn.click();
		
		return numow;

	}
	
	public void verifyCreatedTaskDetails(String tTitle,String tStatus,String tType,String tPriority,String tNumber, String tOwner ){
		String cTaskNo=createdTaskNO.getText();
		Assert.assertEquals(cTaskNo.trim(), tNumber.trim());
		
		String cTaskTitle=createdTaskTitle.getText();
		Assert.assertEquals(cTaskTitle.trim(), tTitle.trim());
		
		String cTaskStatus=createdTaskStatus.getText();
		Assert.assertEquals(cTaskStatus.trim(), tStatus.trim());
		
		String cTaskType=createdTaskType.getText();
		Assert.assertEquals(cTaskType.trim(), tType.trim());
		
		String cTaskPriporty=createdTaskPriority.getText();
		Assert.assertEquals(cTaskPriporty.trim(), tPriority.trim());
		
		String cTaskOwner=createdTaskOwner.getText();
		Assert.assertEquals(cTaskOwner.trim(), tOwner.trim());
		
	}
	
	
	
	
	
	
	
	
	
	

}
