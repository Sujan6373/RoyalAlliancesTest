package com.ra.qa.testcases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.ra.qa.base.TestBase;
import com.ra.qa.pages.HomePage;
import com.ra.qa.pages.LoginPage;
import com.ra.qa.pages.SchedulePage;

public class SchedulePageTest extends TestBase
{
	LoginPage loginPage;
	HomePage homePage;
	SchedulePage schedulePage;
	
	public SchedulePageTest()
	{
		super();		
	}
	
	@Test(priority = 10)
	public void setup() throws InterruptedException
	{	
		initialization();
		Thread.sleep(2000);

		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		System.out.println("************ Initializing the browser and logging in to RA *************");
		
		loginPage.navigateToMailQueue(prop.getProperty("url_mailqueue"));
		System.out.println("************ Navigating to Mail Queue*************");
		Thread.sleep(2000);
		
		loginPage.selectSiteB();	
		schedulePage = homePage.navigateToScheduledTab();
	}
	
	
	@Test(priority = 20) 
	public void getPageTitleTest() 
	{
		String schPageTitle = loginPage.validateLoginPageTitle(); 
		AssertJUnit.assertEquals(schPageTitle, "Royal Alliances"); 
	}
	 
	@Test(priority = 30)		
	public void navigateToScheduledTabTest() throws InterruptedException		{		
		homePage.navigateToScheduledTab();
	}
	
	@Test(priority = 40)
	public void verifyFilePresentF1F2Test()
	{
		/*
		 * String fileStatus = schedulePage.verifyFilePresentF1F2();
		 * Assert.assertEquals(fileStatus, "Scheduled");
		 */
		Assert.assertTrue(schedulePage.verifyFilePresentF1F2(), "Scheduled File is not present");
	}
	
	@Test (priority = 1000)
	public void tearDown() 
	{
		driver.quit();
	}

}
