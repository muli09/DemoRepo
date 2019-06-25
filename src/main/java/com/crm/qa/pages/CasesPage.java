package com.crm.qa.pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.crm.qa.base.TestBase;

public class CasesPage extends TestBase {
	@FindBy(xpath="//td[@onclick='showExtendedSearch();']")
	WebElement advancedSerachWithCase;
	
	@FindBy(xpath="//tr[td[strong[text()='Case No.']]]//../td/input")
	WebElement caseNo;
	
	@FindBy(xpath="//tr[td[strong[text()='Title']]]//../td/input")
	WebElement caseTitle;

	@FindBy(xpath="//tr[td[strong[text()='Status']]]//../td/select")
	WebElement caseStatus;
	
	@FindBy(xpath="//tr[td[strong[text()='State']]]//../td/input[1]")
	WebElement caseOpenState;
	
	@FindBy(xpath="//tr[td[strong[text()='State']]]//../td/input[2]")
	WebElement caseClosedState;
	
	@FindBy(xpath="//tr[td[strong[text()='Type']]]//../td/select")
	WebElement caseType;
	
	@FindBy(xpath="//tr[td[strong[text()='Priority']]]//../td/select")
	WebElement casePriority;
	
	@FindBy(xpath="//tr[td[strong[text()='Assigned to']]]//../td/select/option")
	WebElement caseAssignedTo;
	
	@FindBy(xpath="//strong[text()='Contact']")
	WebElement caseContact;
	
	@FindBy(xpath="//input[@value='Save']")
	WebElement caseSaveBtn;
	
	//Created data Page Factory
	@FindBy(xpath="//tr[td[strong[text()='Case No.']]]//../td[@class='datafield']")
	WebElement createdCaseNo;
	
	@FindBy(xpath="//tr[td[strong[text()='Status']]]//../td[@class='datafield']")
	WebElement createdCaseStatus;

	@FindBy(xpath="//tr[td[strong[text()='State']]]//../td[@class='datafield']")
	WebElement createdState;

	@FindBy(xpath="//tr[td[strong[text()='Type']]]//../td[@class='datafield']")
	WebElement createdType;

	@FindBy(xpath="//tr[td[strong[text()='Priority']]]//../td[@class='datafield']")
	WebElement createdPriority;

	@FindBy(xpath="//tr[td[strong[text()='Owner']]]//../td[@class='datafield']")
	WebElement createdOwner;

	@FindBy(xpath="//tr[td[strong[text()='Contact']]]//../td[@class='datafield']")
	WebElement createdContact;
	@FindBy(xpath="//tr[td[strong[text()='Title']]]//../td[@class='datafield']")
	WebElement createdTitle;
	
	
	
	//initializing the page objects
	public CasesPage(){
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	
	public boolean verifyAdvancedSearchLabel(){
		return advancedSerachWithCase.isDisplayed();
	}
	
	
	public String[] createNewCase(String cTitle,String cStatus,String cState,String cType,String cPriority,String cContact){
		String[] Cnumow= new String[2];
		//System.out.println("Task number"+ taskNumber.getAttribute("value"));
		Cnumow[0]=caseNo.getAttribute("Value");	
		
		caseTitle.sendKeys(cTitle);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("cPriority =="+driver.findElement(By.xpath("//tr[td[strong[text()='Priority']]]//../td/select/option[@value='Low']")).getText()+"=D");
		Select caseStatusSelect= new Select(caseStatus);
		caseStatusSelect.selectByVisibleText(cStatus.trim());
		
		if (cState.equals("Open")){
			caseOpenState.click();
			Assert.assertEquals("Open", "Open");
		}
		else if (cState.equals("Closed")){
			caseClosedState.click();
			Assert.assertEquals("Closed", "Closed");
			}else {
				Assert.assertFalse(false, "both are not selected");
			}
	
    	Select selectType=new Select(caseType);
    	selectType.selectByVisibleText(cType.trim());
    	try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	Select selectPriority=new Select(casePriority);
    	
    	selectPriority.selectByVisibleText(cPriority.trim());
//    	selectType.selectByValue(cPriority.trim());
    	
    	Cnumow[1]=caseAssignedTo.getText();
    	
//    	caseContact.sendKeys(cContact);
    	
    	caseSaveBtn.click();
    	
    	return Cnumow;
	
	}
	
	public void VerifyCreatedCaseDetails(String cTitle,String cStatus,String cState,
			String cType,String cPriority,String cContact,String CNumber,String COwner){
		
		
		String ccCaseNumber= createdCaseNo.getText();
		Assert.assertEquals(ccCaseNumber.trim(),CNumber.trim());
		
		String ccTitle=createdTitle.getText();
		Assert.assertEquals(ccTitle.trim(), cTitle.trim());
		
		String ccCaseStatus=createdCaseStatus.getText();
		Assert.assertEquals(ccCaseStatus.trim(), cStatus.trim());
		
//		String ccContact=createdContact.getText();
//		Assert.assertEquals(ccContact.trim(), cContact.trim());
		
		String ccState=createdState.getText();
		if(ccState.equalsIgnoreCase(cState)){
			Assert.assertEquals(ccState.trim(), cState.trim());
		}else if(ccState.equalsIgnoreCase(cState)){
			Assert.assertEquals(ccState.trim(), cState.trim());
		}
		
		String ccType=createdType.getText();
		Assert.assertEquals(ccType.trim(), cType.trim());

		String ccPriority=createdPriority.getText();
		Assert.assertEquals(ccPriority.trim(), cPriority.trim());
		
		String ccOwner=createdOwner.getText();
		Assert.assertEquals(ccOwner.trim(), COwner.trim());
		
	}
	
}

	
	
	
	
	


	

	


