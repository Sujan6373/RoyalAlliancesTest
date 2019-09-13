package com.ra.qa.testcases;

import org.testng.Assert;
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
	
	@Test(priority = 10)
	public void setup()
	{
		initialization();
		hubLoginPage = new HubLoginPage(driver);
	}
	
	@Test(priority = 20)
	public void validateLoginPageTitleTest() throws InterruptedException
	{
		String title = hubLoginPage.validateLoginPageTitle();
		Thread.sleep(2000);
		Assert.assertEquals(title, "Royal Alliances | Mailing Services | Irving, TX");
	}
	
	@Test (priority = 30)
	public void loginTest() throws InterruptedException
	{
		hubLoginPage.login(prop.getProperty("hubusername"), prop.getProperty("hubpassword"));
	}
		
	@Test(priority = 40)
	public void selectRA49Test() throws InterruptedException
	{
		hubLoginPage.selectRA49();
	}
	
	@Test(priority = 50)
	public void gotoRoyalCloudTest() throws InterruptedException
	{
		hubLoginPage.gotoRoyalCloud();
	}
	
	@Test(priority = 1000)
	public void tearDown()
	{
		driver.quit();
	}



}
