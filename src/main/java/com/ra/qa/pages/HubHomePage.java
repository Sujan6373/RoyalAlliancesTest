package com.ra.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ra.qa.base.TestBase;

public class HubHomePage extends TestBase
{
	@FindBy(xpath = "//td[contains(text(),'558,579')][1]//parent::tr//descendant::td/div/div/span[@class='detailInformation']")
	WebElement mktInfo558579;
	
	@FindBy(xpath = "//td[contains(text(),'264,230')][1]//parent::tr//descendant::td/div/div/span[@class='detailInformation']")
	WebElement PCnLTRInfoIcon;
	
	public HubHomePage(WebDriver d) 
	{
		this.driver = d;
		PageFactory.initElements(driver, this);
	}
	
	//selecting information icon for marketing file
	public ShipmentRequestPage clickOnInfoMkt() throws InterruptedException
	{
		mktInfo558579.click();
		Thread.sleep(3000);
		
		return new ShipmentRequestPage(driver);
	}
	
	public ShipmentRequestPage clickOnPCnLTRInfoIcon() throws InterruptedException
	{
		PCnLTRInfoIcon.click();
		Thread.sleep(3000);
		
		return new ShipmentRequestPage(driver);
	}

}
