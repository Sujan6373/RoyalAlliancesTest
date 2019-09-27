package com.ra.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ra.qa.base.TestBase;
import com.ra.qa.pages.HomePage;
import com.ra.qa.pages.LoginPage;

public class RA229LoginPageTest extends TestBase
{

//	Logs in as Feeder
//	Navigates to Mailqueue
//	Selects Site B RA-135
//	Validates the title of the page
	
	
	LoginPage loginPage;
	HomePage homePage;
	
	public RA229LoginPageTest()
	{
		super();		
	}
	
	@Test(priority = 1)
	public void setup()
	{
		initialization();	
		loginPage = new LoginPage(driver);
	}
	
	@Test(priority = 2)
	public void validateLoginPageTitleTest()
	{
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Royal Alliances | Mailing Services | Irving, TX");
	}
	
	@Test (priority = 3)
	public void loginTest() throws InterruptedException
	{
		homePage = loginPage.login(prop.getProperty("accuzipusername"), prop.getProperty("accuzippassword"));
	}
	
	@Test (priority = 4)
	public void navigateToMailQueueTest() throws InterruptedException 
	{
		loginPage.navigateToMailQueue(prop.getProperty("url_mailqueue"));
	}
	
	
	
	@Test (priority = 1000)
	public void tearDown() 
	{
		driver.quit(); 
	}
	 



}
