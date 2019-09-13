package com.ra.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ra.qa.base.TestBase;
import com.ra.qa.pages.HomePage;
import com.ra.qa.pages.LoginPage;

public class LoginPageTest extends TestBase
{
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest()
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
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test (priority = 4)
	public void navigateToMailQueueTest() throws InterruptedException 
	{
		loginPage.navigateToMailQueue(prop.getProperty("url_mailqueue"));
	}
	
	@Test (priority = 5)
	public void selectSiteBTest() throws InterruptedException
	{
		loginPage.selectSiteB();
	}
	
	
	@Test (priority = 1000)
	public void tearDown() 
	{
		driver.quit(); 
	}
	 

}
