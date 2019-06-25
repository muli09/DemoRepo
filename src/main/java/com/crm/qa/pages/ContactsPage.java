package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {
	
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement contactsLabel;
	
	@FindBy(id="first_name")
	WebElement firstName;
	
	@FindBy(id="surname")
	WebElement surName;
	
	@FindBy(name="client_lookup")
	WebElement company;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement saveBtn;
	
	
	
	//initializing the page object
		public ContactsPage(){
			PageFactory.initElements(driver, this);
		}
//Actions
		public boolean verifyContactsLabel(){
			return contactsLabel.isDisplayed();
		}

		public void selectcontactsPageByName(String name){
			String xpath_Value="//tr[td[a[text()='%s' and @_name='%s']]]//following-sibling::td/input";
			System.out.println(String.format(xpath_Value,name,name));
			WebElement selectcontactsPageByName=driver.findElement(By.xpath(String.format(xpath_Value,name,name)));
		
			selectcontactsPageByName.click();
			
		}
		
		public void createNewContact(String title,String fName,String sName,String comp){
			Select select=new Select(driver.findElement(By.name("title")));
			select.selectByVisibleText(title);
			firstName.sendKeys(fName);
			surName.sendKeys(sName);
			company.sendKeys(comp);
			saveBtn.click();
			
			
			
			
			
		}
		
		
		
		
}
