package com.ra.qa.testcases;

import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.ra.qa.base.TestBase;
import com.ra.qa.pages.HomePage;
import com.ra.qa.pages.LoginPage;
import com.ra.qa.pages.SchedulePage;

public class RA229SchedulePageTest extends TestBase
{

	LoginPage loginPage;
	HomePage homePage;
	SchedulePage schedulePage;
	
	public RA229SchedulePageTest()
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
		
		loginPage.login(prop.getProperty("accuzipusername"), prop.getProperty("accuzippassword"));
		System.out.println("************ Initializing the browser and logging in *************");
		
	}
	
	
	@Test(priority = 20) 
	public void getPageTitleTest() 
	{
		String schPageTitle = loginPage.validateLoginPageTitle(); 
		AssertJUnit.assertEquals(schPageTitle, "Royal Alliances"); 
	}
	 

	@Test(priority = 30)		
	public void navigateToScheduledTabTest() throws InterruptedException	
	{		
		schedulePage = homePage.navigateToScheduledTab();
	}
	
	@Test(priority = 40)
	public void verifyFilePresentPCnLTRFileScheduledTest()
	{
		Assert.assertTrue(schedulePage.verifyFilePresentPCnLTRFileScheduled(), "Scheduled File is not present");
	}
	
	@Test (priority = 1000)
	public void tearDown() 
	{
		driver.quit();
	}



}
