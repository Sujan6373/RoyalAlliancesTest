package com.ra.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ra.qa.base.TestBase;
import com.ra.qa.pages.HubHomePage;
import com.ra.qa.pages.HubLoginPage;

public class HubLoginPageTest extends TestBase
{

	HubLoginPage hubLoginPage;
	HubHomePage hubHomePage;
	
	public HubLoginPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		hubLoginPage = new HubLoginPage();
	}
	
	@Test(priority = 1)
	public void validateLoginPageTitleTest()
	{
		String title = hubLoginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Royal Alliances | Mailing Services | Irving, TX");
	}
	
	@Test (priority = 2)
	public void loginTest() throws InterruptedException
	{
		hubHomePage = hubLoginPage.login(prop.getProperty("hubusername"), prop.getProperty("hubpassword"));
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}



}
