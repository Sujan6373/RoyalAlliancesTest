package com.ra.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ra.qa.base.TestBase;

public class HubAccountingPage extends TestBase
{
	@FindBy(xpath = "//a[contains(text(),'Accounting Details')]")
	WebElement hubAccount558579;
	
	@FindBy(xpath = "//table[@role='grid']/tbody[@role='rowgroup']/descendant::tr[@class='k-group-footer']/descendant::td[contains(text(),'Total: $224,495.81')]")
	WebElement hubTotalAmount558579;
	
	@FindBy (xpath = "//button[@class='k-button btn-refund' and @title='$224,495.81']")
	WebElement hubRequestFundButton558579;
	
	public HubAccountingPage(WebDriver d)
	{
		this.driver = d;
		js = (JavascriptExecutor)d;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnHubAccounting() throws InterruptedException
	{
		hubAccount558579.click();
		Thread.sleep(3000);
	}
	
	public class HubAccountView
	{
		String hubTotalAmount;
		public String getHubTotalAmount() {return this.hubTotalAmount;}
		
		String hubRequestFundButton;
		public String getRequestFundButton() {return this.hubRequestFundButton;}
		
		
		public HubAccountView(String hubTotalAmount, String hubRequestFundButton)
		{
			this.hubTotalAmount = hubTotalAmount;
			this.hubRequestFundButton = hubRequestFundButton;
		}
		
	}
	
	public HubAccountView verifyHubAccounting()
	{
		HubAccountView hubAccountView = new HubAccountView
		(
				hubTotalAmount558579.getText(),
				hubRequestFundButton558579.getText()
		);
		
		return hubAccountView;
	}
	
	
	

}
