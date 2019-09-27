package com.ra.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ra.qa.base.TestBase;
import com.ra.qa.pages.HomePage;
import com.ra.qa.pages.LoginPage;

public class RA229HomePageTest extends TestBase
{

	LoginPage loginPage;
	HomePage homePage;	
	
	public RA229HomePageTest()
	{
		super();
	}
	
	@Test (priority = 10)
	public void setup() throws InterruptedException
	{
		initialization();
		loginPage = new LoginPage(driver);
		homePage = loginPage.login(prop.getProperty("accuzipusername"), prop.getProperty("accuzippassword"));
		System.out.println("************ Initializing the browser and logging in as RA229 *************");
	}
	
	@Test (priority = 20)
	public void getPageTitleTest()
	{
		String pageTitle = homePage.getPageTitle();
		Assert.assertEquals(pageTitle, "Royal Alliances", "Page title did not match");
		System.out.println("************ Verifying the page title *************");
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
		homePage.uploadFile(prop.getProperty("accuzipfeederfilepath"));
		System.out.println("************ Uploading the First Class Mail file that has Post Card and Letter *************");
	}
	
	@Test (priority = 60)
	public void uploadDoneTest() throws InterruptedException
	{
		homePage.uploadDone();
		driver.navigate().refresh();
		Thread.sleep(3000);
		System.out.println("************ Upload completed and refreshing the browser *************");
	}
	
		
	@Test (priority = 70)
	public void selectPCnLTRTest() throws InterruptedException
	{
		homePage.selectPCnLTR();
		Thread.sleep(3000);
		System.out.println("************ Selecting the feeder files that has PCnLTR that are in the Ready Status *************");
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
