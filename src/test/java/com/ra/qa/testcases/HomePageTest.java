
package com.ra.qa.testcases;

import org.testng.Assert;
/*import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;*/
import org.testng.annotations.Test;

import com.ra.qa.base.TestBase;
import com.ra.qa.pages.HomePage;
import com.ra.qa.pages.LoginPage;

public class HomePageTest extends TestBase
{
	LoginPage loginPage;
	HomePage homePage;	
	
	public HomePageTest()
	{
		super();
	}
	
	@Test (priority = 10)
	public void setup() throws InterruptedException
	{
		initialization();
		loginPage = new LoginPage(driver);
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
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
	public void selectSiteB() throws InterruptedException
	{
		loginPage.navigateToMailQueue(prop.getProperty("url_mailqueue"));
		loginPage.selectSiteB();
		System.out.println("************ Selecting Site B *************");
	}
	
	@Test (priority = 40)
	public void clickOnUploadBtnTest() throws InterruptedException
	{
		homePage.clickOnUploadBtn();
		System.out.println("************ Clicking on the upload button *************");
	}
	
	@Test (priority = 50)
	public void uploadFileTest() throws InterruptedException
	{
		homePage.uploadFile(prop.getProperty("feederfilepath1"));
		homePage.uploadFile(prop.getProperty("feederfilepath2"));
		System.out.println("************ Uploading the 2 Feeder Files  *************");
	}
	
	@Test (priority = 60)
	public void uploadDoneTest() throws InterruptedException
	{
		homePage.uploadDone();
		driver.navigate().refresh();
		Thread.sleep(3000);
		System.out.println("************ Upload completed and refreshing the browser *************");
	}
	
	@Test (priority = 61)
	public void gotoMarketingTabTest() throws InterruptedException
	{
		homePage.gotoMarketingTab();
		Thread.sleep(3000);
		System.out.println("************ Switching to Marketing tab *************");
	}
		
	@Test (priority = 70)
	public void selectRA061215ReadyTest() throws InterruptedException
	{
		homePage.selectF1AndF2Ready();
		Thread.sleep(3000);
		System.out.println("************ Selecting the feeder files that are in the Ready Status *************");
	}
	
	@Test (priority = 80)
	public void scheduleMailTest() throws InterruptedException
	{
		Thread.sleep(1000);
		homePage.scheduleMail();
		System.out.println("************ Scheduking the mail *************");
	}
	
	@Test (priority = 90)
	public void confirmTest() throws InterruptedException
	{
		Thread.sleep(3000);		
		homePage.confirm();
		System.out.println("************ Clicking on Ok button for confirmation *************");
	}
	
	@Test (priority = 100)
	public void submitScheduleTest() throws InterruptedException
	{		
		homePage.submitSchedule();
		System.out.println("************ Clink on the Submit button *************");
	}
			
	
	@Test (priority = 1000)
	public void tearDown()
	{
		driver.quit();
		System.out.println("****** Closing all the instances of the automated browser *******");
	}

}
