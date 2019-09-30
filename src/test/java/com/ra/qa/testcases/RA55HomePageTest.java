package com.ra.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ra.qa.base.TestBase;
import com.ra.qa.pages.HomePage;
import com.ra.qa.pages.LoginPage;

public class RA55HomePageTest extends TestBase
{

	LoginPage loginPage;
	HomePage homePage;	
	
	public RA55HomePageTest()
	{
		super();
	}
	
	@Test (priority = 10)
	public void setup() throws InterruptedException
	{
		initialization();
		loginPage = new LoginPage(driver);
		homePage = loginPage.login(prop.getProperty("RA55username"), prop.getProperty("RA55password"));
		System.out.println("************ Initializing the browser and logging in to Site B - RA135 *************");
	}
	
	@Test (priority = 20)
	public void getPageTitleTest()
	{
		String pageTitle = homePage.getPageTitle();
		Assert.assertEquals(pageTitle, "Royal Alliances | Royal Dashboard", "Page title did not match");
		System.out.println("************ Verifying the page title *************");
	}
	
	/*
	 * @Test (priority = 2) public void clickOnBrowseBtnTest() {
	 * homePage.clickOnBrowseBtn(); }
	 */
	@Test (priority = 30)
	public void selectSiteRA55Test() throws InterruptedException
	{
		homePage.selectSiteRA55();
		System.out.println("************ Selecting Site RA55 *************");
	}
	
	@Test (priority = 35)
	public void navigateToRACloudTest() throws InterruptedException
	{
		homePage.navigateToRACloud();
		System.out.println("************ Navigates to RA Mail Cloud *************");
	}
	
	@Test (priority = 40)
	public void clickOnUploadLegacyTest() throws InterruptedException
	{
		homePage.clickOnUploadLegacy();
		System.out.println("************ Clicking on the upload button *************");
	}
	
	@Test (priority = 50)
	public void uploadFeederFileLegacyTest() throws InterruptedException
	{
		homePage.uploadFeederFileLegacy(prop.getProperty("RA55feederfilepath"));
		System.out.println("************ Uploading the FCM Feeder Files from RA55 *************");
	}
	
	@Test (priority = 60)
	public void uploadDoneTest() throws InterruptedException
	{
		//homePage.uploadDone();
		driver.navigate().refresh();
		Thread.sleep(3000);
		System.out.println("************ Upload completed and refreshing the browser *************");
	}
	
	
	@Test (priority = 1000)
	public void tearDown()
	{
		driver.quit();
		System.out.println("****** Closing all the instances of the automated browser *******");
	}


}
