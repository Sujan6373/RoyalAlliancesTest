package com.ra.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ra.qa.base.TestBase;
import com.ra.qa.pages.RAAdminHomePage;
import com.ra.qa.pages.RAAdminLoginPage;

public class RAAdminHomePageTest extends TestBase
{
	RAAdminLoginPage raAdminLoginPage;
	RAAdminHomePage raAdminHomePage;
	
	public RAAdminHomePageTest()
	{
		super();
	}
	
	@Test(priority = 10)
	public void setup() throws InterruptedException
	{
		initialization();
		raAdminLoginPage = new RAAdminLoginPage(driver);
		
		raAdminHomePage = raAdminLoginPage.login(prop.getProperty("RAAdminUserName"), prop.getProperty("RAAdminpwd"));
	}
	
	@Test(priority = 20)
	public void validateLoginPageTitleTest() throws InterruptedException
	{
		String title = raAdminLoginPage.validateLoginPageTitle();
		Thread.sleep(2000);
		Assert.assertEquals(title, "Royal Alliances | Royal Dashboard");
	}

	@Test(priority = 30)
	public void manageAccountTest() throws InterruptedException
	{
		raAdminHomePage.manageAccount();
		Thread.sleep(2000);
	}
	
	@Test(priority = 40)
	public void selectRAAdminAccountTest() throws InterruptedException
	{
		raAdminHomePage.selectRAAdminAccount();
		Thread.sleep(2000);
	}
	
	@Test(priority = 1000)
	public void tearDown()
	{
		driver.quit();
	}
	
	
}
