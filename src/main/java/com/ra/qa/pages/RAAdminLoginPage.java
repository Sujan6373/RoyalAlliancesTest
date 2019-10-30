package com.ra.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.ra.qa.base.TestBase;

public class RAAdminLoginPage extends TestBase
{
	@FindBy(xpath = "//input[@name='UserName']")
	WebElement raAdminUserName;
	
	@FindBy(xpath = "//input[@type='password']")
	WebElement raAdminpwd;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement submitbtn;
	
	@FindBy (xpath = "//a[contains(text(),'Manage Accounts')]")
	WebElement manageAccount;
	
	@FindBy (xpath = "//span[contains(text(),'ROYAL ALLIANCES HOME OFFICE')]/parent::p/button[@type='submit']")
	WebElement	viewDetailsRAHomeOffice;
	
	@FindBy (xpath = "//select[contains(@class,'select')]")
	WebElement selectRAProfitCenter2;
	
	@FindBy (xpath = "//a[contains(text(),'Customer Account View')]")
	WebElement cutomerAccountView;
	
	public RAAdminLoginPage(WebDriver d)
	{
		this.driver = d;
		PageFactory.initElements(driver, this);
		js = (JavascriptExecutor)d;
	}
	
	public String validateLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	public RAAdminHomePage login(String RAAdminUserName, String RAAdminpwd) throws InterruptedException
	{
		raAdminUserName.sendKeys(RAAdminUserName);
		Thread.sleep(1000);
		
		raAdminpwd.sendKeys(RAAdminpwd);
		Thread.sleep(1000);
		
		submitbtn.click();
		Thread.sleep(3000);
		
		return new RAAdminHomePage(driver);
	}
	

	
	

}
