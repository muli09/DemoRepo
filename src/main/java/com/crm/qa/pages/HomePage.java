package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	//page factory -OR:
	@FindBy(xpath="//*[contains(text(),'User: nagalakshmi raavi')]")
	WebElement userNameLabel;
	
	@FindBy(xpath="//a[text()='Contacts']")
	WebElement contactsLink;
	
	@FindBy(xpath="//a[@title='New Contact']")
	WebElement newContactLink;

	@FindBy(xpath="//a[text()='Deals']")
	WebElement dealsLink;
	@FindBy(xpath="//a[@title='New Deal']")
	WebElement newDealLink;
	@FindBy(xpath="//a[@title='New Task']")
	WebElement newTaskLink;
	@FindBy(xpath="//a[text()='Cases']")
	WebElement caseLink;
	@FindBy(xpath="//a[text()='New Case']")
	WebElement newCaseLink;
	@FindBy(xpath="//a[text()='Companies']")
	WebElement companiesLink;
	@FindBy(xpath="//a[text()='New Company']")
	WebElement newCompanyLink;

	
	
	
	
	

	@FindBy(xpath="//a[text()='Tasks']")
	WebElement tasksLink;

	//initializing the page object
		public HomePage(){
			PageFactory.initElements(driver, this);
		}
		
		//Actions
		public String verifyHomePageTitle(){
			return driver.getTitle();
		}
		
		public boolean verifyUserLable(){
			return userNameLabel.isDisplayed();
			  
		}
		
		public ContactsPage clickOnContactsLink(){
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		contactsLink.click();
		return new ContactsPage();
		}
		public DealsPage clickOnDealsLink(){
			dealsLink.click();
			return new DealsPage();
			}

		public TasksPage clickonTaskslink(){
			tasksLink.click();
			return new TasksPage();
			
		}
		
		public CasesPage clickOnCaseLink(){
			caseLink.click();
			return new CasesPage();
		}
			
		public CompaniesPage clickOnCompaniesLink(){
		companiesLink.click();
		return new CompaniesPage();
		}
			
			
		public void clickOnNewCompaniesLink(){
			Actions action=new Actions(driver);
			action.moveToElement(companiesLink).build().perform();
			newCompanyLink.click();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		

		public void clickOnNewContactLink(){
			Actions action=new Actions(driver);
			action.moveToElement(contactsLink).build().perform();
			newContactLink.click();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		public void clickOnNewDealLink(){
			Actions action=new Actions(driver);
			action.moveToElement(dealsLink).build().perform();
			newDealLink.click();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		public void clickOnTheNewTask(){
		Actions action=new Actions(driver);
		action.moveToElement(tasksLink).build().perform();
		newTaskLink.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
}
		
		public void clickOnTheNewCase(){
			Actions action=new Actions(driver);
			action.moveToElement(caseLink).build().perform();
			newCaseLink.click();
		}
		
}


