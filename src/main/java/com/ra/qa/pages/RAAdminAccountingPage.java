package com.ra.qa.pages;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ra.qa.base.TestBase;

public class RAAdminAccountingPage extends TestBase
{
	@FindBy (xpath = "//div[contains(@class,'multi')]")
	WebElement raAdminSiteSelector;
	
	@FindBy (xpath = "//ul[@class='chosen-results']/descendant::li[contains(text(),'RA Profit Center')]")
	WebElement selectRAProfitCenter;
	
	@FindBy (xpath = "//select[contains(@class,'select')]")
	WebElement selectRAProfitCenter2;
	
	@FindBy (xpath = "//a[contains(text(),'Customer Account View')]")
	WebElement cutomerAccountView;
	
	@FindBy (xpath = "//tbody[@role='rowgroup']/descendant::tr[@class='k-group-footer']/descendant::td[contains(text(),'Total: ($4,640.98)')]")
	WebElement RAProfitCenterTotal558579;
	
	public RAAdminAccountingPage(WebDriver d)
	{
		this.driver = d;
		PageFactory.initElements(driver, this);
		js = (JavascriptExecutor)d;
	}
	
	public void selectRAProfitCenter() throws InterruptedException
	{
		raAdminSiteSelector.click();
		Thread.sleep(1000);
		
//		Select raProfitCenter = new Select(selectRAProfitCenter);
//		raProfitCenter.selectByVisibleText("RA Profit Center");
		
		selectRAProfitCenter.click();
		Thread.sleep(3000);
	}
	
	public void cutomerAccountView() throws InterruptedException
	{
		cutomerAccountView.click();
		Thread.sleep(5000);
	}
	
	public String verifyRAProfitCenterTotalAmount()
	{
		assertTrue(RAProfitCenterTotal558579.isDisplayed()==true);
		assertTrue(RAProfitCenterTotal558579.isEnabled());
		String RAProfitCenterTotalAmount = RAProfitCenterTotal558579.getText();
		RAProfitCenterTotalAmount.equalsIgnoreCase("");
		return RAProfitCenterTotalAmount;
		
	}
}
