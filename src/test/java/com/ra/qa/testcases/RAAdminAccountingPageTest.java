package com.ra.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ra.qa.base.TestBase;
import com.ra.qa.pages.RAAdminAccountingPage;
import com.ra.qa.pages.RAAdminHomePage;
import com.ra.qa.pages.RAAdminLoginPage;

public class RAAdminAccountingPageTest extends TestBase
{
	RAAdminLoginPage raAdminLoginPage;
	RAAdminHomePage raAdminHomePage;
	RAAdminAccountingPage raAdminAccountingPage;
	
	public RAAdminAccountingPageTest()
	{
		super();
	}
	
	@Test(priority = 10)
	public void setup() throws InterruptedException
	{
		initialization();
		raAdminLoginPage = new RAAdminLoginPage(driver);
		
		raAdminHomePage = raAdminLoginPage.login(prop.getProperty("RAAdminUserName"), prop.getProperty("RAAdminpwd"));
		
		raAdminHomePage.manageAccount();
		
		raAdminAccountingPage = raAdminHomePage.selectRAAdminAccount();
	}	
	
	@Test(priority = 20)
	public void selectRAProfitCenterTest() throws InterruptedException
	{
		raAdminAccountingPage.selectRAProfitCenter();
		Thread.sleep(2000);
	}

	@Test(priority = 30)
	public void cutomerAccountViewTest() throws InterruptedException
	{
		raAdminAccountingPage.cutomerAccountView();
		Thread.sleep(2000);
	}
	
	@Test (priority = 40)
	public void verifyRAProfitCenterTotalAmount()
	{
		String RATotalAmount = raAdminAccountingPage.verifyRAProfitCenterTotalAmount();
		Assert.assertEquals(RATotalAmount, "Total: ($4,640.98)");
		
		
	}

	@Test(priority = 1000)
	public void tearDown()
	{
		driver.quit();
	}
}
