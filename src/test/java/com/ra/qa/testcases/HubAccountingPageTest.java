package com.ra.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ra.qa.base.TestBase;
import com.ra.qa.pages.HubAccountingPage;
import com.ra.qa.pages.HubAccountingPage.HubAccountView;
import com.ra.qa.pages.HubHomePage;
import com.ra.qa.pages.HubLoginPage;

public class HubAccountingPageTest extends TestBase
{
	HubLoginPage hubLoginPage;
	HubHomePage hubHomePage;
	HubAccountingPage hubAccountingPage;
	
	public HubAccountingPageTest()
	{
		super();
	}
	
	@Test (priority = 10)
	public void setup() throws InterruptedException
	{
		initialization();
		hubLoginPage = new HubLoginPage(driver);
		hubHomePage = new HubHomePage(driver);
		
		System.out.println("************ Initializing the browser and logging in as TestSite2 *************");
		hubHomePage = hubLoginPage.login(prop.getProperty("hubusername"), prop.getProperty("hubpassword"));
				
		System.out.println("************ Logging into the Test Site 2 - RA11 *************");
		hubLoginPage.selectRA11();
		
		hubAccountingPage = hubLoginPage.clickOnHubAccounting558579();
	}
	
	@Test (priority = 20)
	public void verifyHubAccounting()
	{
		HubAccountView result = hubAccountingPage.verifyHubAccounting();
		
		Assert.assertEquals(result.getHubTotalAmount(), "Total: $224,495.81");
		Assert.assertEquals(result.getRequestFundButton(), "Request Funds");
	}
	
	@Test (priority = 1000)
	public void tearDown()
	{
		driver.close();
	}

}
