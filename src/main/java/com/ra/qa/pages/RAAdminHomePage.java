package com.ra.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ra.qa.base.TestBase;

public class RAAdminHomePage extends TestBase
{
	@FindBy (xpath = "//a[contains(text(),'Manage Accounts')]")
	WebElement manageAccount;
	
	@FindBy (xpath = "//span[contains(text(),'ROYAL ALLIANCES HOME OFFICE')]/parent::p/button[@type='submit']")
	WebElement	viewDetailsRAHomeOffice;
	
	//@FindBy (xpath = "//ul[@class='chosen-results']")
	
	//@FindBy (xpath = "//ul[@class='chosen-results']")
	
	@FindBy (xpath = "//div[contains(@class,'multi')]")
	WebElement raAdminSiteSelector;
	
	@FindBy (xpath = "//ul[@class='chosen-results']/descendant::li[contains(text(),'RA Profit Center')]")
	WebElement selectRAProfitCenter;
	
	public RAAdminHomePage(WebDriver d)
	{
		this.driver = d;
		PageFactory.initElements(driver, this);
		js = (JavascriptExecutor)d;
	}
	
	public String validateLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	public void manageAccount() throws InterruptedException
	{
		manageAccount.click();
		Thread.sleep(5000);
	}
	
	public RAAdminAccountingPage selectRAAdminAccount() throws InterruptedException
	{
		js.executeScript("window.scrollBy(0,4000)");
		Thread.sleep(2000);
		
		viewDetailsRAHomeOffice.click();
		Thread.sleep(3000);
		
		return new RAAdminAccountingPage(driver);
	}
	

}
