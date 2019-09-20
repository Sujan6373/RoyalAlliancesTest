package com.ra.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ra.qa.base.TestBase;
import com.ra.qa.pages.AccountingPage;
import com.ra.qa.pages.AccountingPage.MailingCostReport;
import com.ra.qa.pages.HomePage;
import com.ra.qa.pages.LoginPage;

public class AccountingPageTest extends TestBase
{
	LoginPage loginPage;
	HomePage homePage;
	AccountingPage accountingPage;
	
	public AccountingPageTest()
	{
		super();
	}
	
	@Test(priority = 10)
	public void setup() throws InterruptedException
	{
		initialization();
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		
		System.out.println("************ Initializing the browser and logging in as NewCustomer2 *************");
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
		System.out.println("************ Navigating to Mail Queue *************");
		loginPage.navigateToMailQueue(prop.getProperty("url_mailqueue"));
		
		System.out.println("************ Logging into the Site B - RA135 *************");
		loginPage.selectSiteB();
		
		accountingPage = loginPage.clickOnAccounting558579();
	}
	
	/*
	 * @Test (priority = 20) public void clickOnAccounting558579Test() throws
	 * InterruptedException { accountingPage.clickOnAccounting558579(); }
	 */
	
	@Test (priority = 30)
	public void clickOnTransactionAmount558579Test() throws InterruptedException
	{
		System.out.println("************ Click on Transaction Amonunt *************");
		accountingPage.clickOnTransactionAmount558579();
	}
	
	@Test (priority = 40)
	public void mailingCostSummary558579Test() throws InterruptedException
	{
		System.out.println("************ Click on Show More *************");
		accountingPage.mailingCostSummary558579();
	}
	
	@Test (priority = 50)
	public void verifyCostSummary558579Test() throws InterruptedException
	{
		MailingCostReport result = accountingPage.verifyCostSummary558579();
				
		Assert.assertEquals(result.getPostageCost(), "$136,811.11", "Postage Cost");
		Assert.assertEquals(result.getServiceCharge(), "$5,585.79", "Service Charge");
		Assert.assertEquals(result.getTotalJobCost(), "$142,396.90", "Total Job Cost");
		Assert.assertEquals(result.getTransactionTotal(), "($142,396.90)", "Transaction Total");
		Assert.assertEquals(result.getCommercialPostageCost(), "$0.2410", "Automation Commercial Postage Cost");
		Assert.assertEquals(result.getCommercialVolume(), "488,816", "Automation Commercial Volume");
		Assert.assertEquals(result.getCommercialCost(), "$117,804.66", "Automation Commercial Cost");
		Assert.assertEquals(result.getNonAutomationCommercialVolume(), "69,763", "Non Automation Commercial Volume");
		Assert.assertEquals(result.getNonAutomationCommercialCost(), "$19,006.46", "Non Automation Commercial Cost");
		Assert.assertEquals(result.getTotalPostageCost(), "$136,811.11", "Total Postage Cost");
		Assert.assertEquals(result.getProcessingFee(), "$5,585.79", "Processing Fee");
	}
	
	@Test (priority = 1000)
	public void tearDown()
	{
		driver.close();
	}

}
