package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.crm.qa.base.TestBase;

public class CompaniesPage extends TestBase{
	

	//Create Page Objects
	@FindBy(xpath="//td[@onclick='showExtendedSearch();']")
	WebElement advancedSearchLabelCompanies;
	
	@FindBy(xpath="//tr[td[strong[text()='Company']]]//../input")
	WebElement company;
	
	@FindBy(xpath="//tr[td[strong[text()='Employees']]]//../input")
	WebElement employees;
	
	@FindBy(xpath="//tr[td[strong[text()='Industry']]]//../input")
	WebElement industry;
	
	@FindBy(xpath="//tr[td[strong[text()='Status']]]//../td/select")
	WebElement companyStatus;
	
	@FindBy(xpath="//tr[td[strong[text()='Category']]]//../td/select")
	WebElement companyCategory;

	@FindBy(xpath="//tr[td[strong[text()='Source']]]//../td/select")
	WebElement companySource;

	@FindBy(xpath="//tr[td[strong[text()='Phone']]]//../td/input[@name='phone']")
	WebElement companyPhone;
	
	@FindBy(xpath="//tr[td[strong[text()='Email']]]//../td/input[@name='email']")
	WebElement companyEmail;
	
	@FindBy(xpath="//input[@value='Save']")
	WebElement companySavebtn;
	
	//PageObjects for created company
	@FindBy(xpath="//td[contains(text(),'Company')]")
	WebElement cCompany;

	@FindBy(xpath="//tr[td[strong[text()='Employees']]]//../td/span")
	WebElement cEmployees;
	
	@FindBy(xpath="//tr[td[strong[text()='Industry']]]//../td/span")
	WebElement cIndustry;
	
	@FindBy(xpath="//tr[td[strong[text()='Status']]]//../td/span")
	WebElement cStatus;
	
	@FindBy(xpath="//tr[td[strong[text()='Category']]]//../td/span")
	WebElement cCategory;

	@FindBy(xpath="//tr[td[strong[text()='Source']]]//../td/span")
	WebElement cSource;

	@FindBy(xpath="//tr[td[strong[text()='Phone']]]//../td/span")
	WebElement cPhone;
	
	@FindBy(xpath="//tr[td[strong[text()='Email']]]//../td/span")
	WebElement cEmail;


	

	
	//initializing the page objects
	public CompaniesPage(){
		PageFactory.initElements(driver, this);
	}
	
	//actions
	
	public boolean verifyAdvancedSearchLabelCompanies(){
		return advancedSearchLabelCompanies.isDisplayed();
		
	}
	
	public void createNewCompanies(String comCompany,String comEmployee,String comIndustry,String comStatus,
			String comCategory,String comSource,String comPhone,String comEmail ){
		company.sendKeys(comCompany);
		employees.sendKeys(comEmployee);
		industry.sendKeys(comIndustry);
		companyPhone.sendKeys(comPhone);
		companyEmail.sendKeys(comEmail);
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("cStatus==" + companyStatus);
		Select ComStatus1=new Select(companyStatus);
		ComStatus1.selectByVisibleText(comStatus.trim());
		
		Select ComCategory=new Select(companyCategory);
		ComCategory.selectByVisibleText(comCategory.trim());
	
		Select ComSource=new Select(companySource);
		ComSource.selectByVisibleText(comSource.trim());
	
		companySavebtn.click();
		
		
	}
	
	public void verifyCompaniesDetails(String comCompany,String comEmployee,String comIndustry,String comStatus,
			String comCategory,String comSource,String comPhone,String comEmail){
		
		String cCompany_Text=cCompany.getText();
		//System.out.println(cCompany_Text.trim());
		String [] a = cCompany_Text.split(":");		
		Assert.assertEquals(a[1].trim(), comCompany.trim());
		
		String cCompany_Employee=cEmployees.getText();
		Assert.assertEquals(cCompany_Employee.trim(), comEmployee.trim());
		
		String cInductry_Text=cIndustry.getText();
		Assert.assertEquals(cInductry_Text.trim(), comIndustry.trim());
		
		String cEmail_Mail=cEmail.getText();
		Assert.assertEquals(cEmail_Mail.trim(), comEmail.trim());
		
		String cPhone_phone=cPhone.getText();
		Assert.assertEquals(cPhone_phone.trim(), comPhone.trim());
		
		String cStatus_status=cStatus.getText();
		Assert.assertEquals(cStatus_status.trim(), comStatus.trim());
		
		String cSource_Source=cSource.getText();
		Assert.assertEquals(cSource_Source.trim(), comSource.trim());
		
		String cCategory_Category=cCategory.getText();
		Assert.assertEquals(cCategory_Category.trim(), comCategory.trim());	
	}
}
