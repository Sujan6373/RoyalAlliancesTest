package com.ra.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ra.qa.base.TestBase;

public class SchedulePage extends TestBase
{
	@FindBy(xpath = "//td[contains(text(),'558,579')]//parent::tr[@class='k-master-row']//descendant::td[contains(text(),'Scheduled')]")
	WebElement F1F2FileScheduled;
	
	//@FindBy(xpath = "//td[contains(text(),'264,230')]//parent::tr[@class='k-master-row']//descendant::td[contains(text(),'Scheduled')]")
	@FindBy(xpath = "//td[contains(text(),'264,230')]//parent::tr[@class='k-master-row']//descendant::td[contains(text(),'Awaiting Payment')]")
	WebElement PCnLTRFileScheduled;
	
	@FindBy(xpath = "//a[contains(text(),'Scheduled')]")
	WebElement scheduledTab;
	
	public SchedulePage(WebDriver d)
	{		
		this.driver = d;
		PageFactory.initElements(driver, this);
	}
	
	public String getPageTitle()
	{
		return driver.getTitle();
	}	
	
	/*
	 * public void navigateToScheduledTab() { scheduledTab.click(); }
	 */
	
	public boolean verifyFilePresentF1F2()
	{
		/*
		 * F1F2FileScheduled.isDisplayed(); String fileStatus =
		 * F1F2FileScheduled.getText(); return fileStatus;
		 */
		return F1F2FileScheduled.isDisplayed();
	}
	
	public boolean verifyFilePresentPCnLTRFileScheduled()
	{
		return PCnLTRFileScheduled.isDisplayed();
	}

}
