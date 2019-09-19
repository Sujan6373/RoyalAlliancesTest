package com.ra.qa.testcases;

import org.testng.annotations.Test;

import com.ra.qa.base.TestBase;
import com.ra.qa.pages.HubHomePage;
import com.ra.qa.pages.HubLoginPage;

public class HubHomePageTest extends TestBase
{
	HubLoginPage hubLoginPage;
	HubHomePage hubHomePage;
	
	public HubHomePageTest()
	{
		super();
	}
	
	@Test (priority = 10)
	public void setup() throws InterruptedException
	{
		initialization();
		hubLoginPage = new HubLoginPage(driver);
		
		hubHomePage = hubLoginPage.login(prop.getProperty("hubusername"), prop.getProperty("hubpassword"));
		System.out.println("************ Initializing the browser and logging in to RA11 - Test Site 2 as a Hub *************");
		
		hubLoginPage.selectRA11();
		hubLoginPage.gotoRoyalCloud();
	}
	
	@Test(priority = 20)
	public void clickOnInfoMktTest() throws InterruptedException
	{
		hubHomePage.clickOnInfoMkt();
	}
	
	@Test (priority = 1000)
	public void tearDown()
	{
		driver.quit();
		System.out.println("****** Closing all the instances of the browser *******");
	}

}
