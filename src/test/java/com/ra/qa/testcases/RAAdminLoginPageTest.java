package com.ra.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ra.qa.base.TestBase;
import com.ra.qa.pages.RAAdminHomePage;
import com.ra.qa.pages.RAAdminLoginPage;

public class RAAdminLoginPageTest extends TestBase
{
	
	RAAdminLoginPage raAdminLoginPage;
	RAAdminHomePage raAdminHomePage;
	
	public RAAdminLoginPageTest()
	{
		super();
	}
	
	@Test(priority = 10)
	public void setup()
	{
		initialization();
		raAdminLoginPage = new RAAdminLoginPage(driver);
	}
	
	@Test(priority = 20)
	public void validateLoginPageTitleTest() throws InterruptedException
	{
		String title = raAdminLoginPage.validateLoginPageTitle();
		Thread.sleep(2000);
		Assert.assertEquals(title, "Royal Alliances | Mailing Services | Irving, TX");
	}
	
	@Test (priority = 30)
	public void loginTest() throws InterruptedException
	{
		raAdminLoginPage.login(prop.getProperty("RAAdminUserName"), prop.getProperty("RAAdminpwd"));
	}

	
	@Test(priority = 1000)
	public void tearDown()
	{
		driver.quit();
	}

}
