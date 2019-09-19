package com.ra.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ra.qa.base.TestBase;
import com.ra.qa.pages.HubHomePage;
import com.ra.qa.pages.HubLoginPage;
import com.ra.qa.pages.ShipmentRequestPage;

public class ShipmentRequestPageTest extends TestBase
{
	
	HubLoginPage hubLoginPage;
	HubHomePage hubHomePage;
	ShipmentRequestPage shipmentRequestPage;
	
	public ShipmentRequestPageTest()
	{
		super();
	}
	
	@Test(priority = 10)
	public void setup() throws InterruptedException
	{	
		initialization();
		hubLoginPage = new HubLoginPage(driver);
		
		hubHomePage = hubLoginPage.login(prop.getProperty("hubusername"), prop.getProperty("hubpassword"));
		System.out.println("************ Initializing the browser and logging in to RA11 - Test Site 2 as a Hub *************");
		
		hubLoginPage.selectRA11();
		hubLoginPage.gotoRoyalCloud();
		System.out.println("************ From site selector select Site RA11 and navigate to Royal Cloud *************");
		
		shipmentRequestPage = hubHomePage.clickOnInfoMkt();
		System.out.println("************ In the RA Cloud, click on the information icon for 558579 Mkt File *************");
	}
	
	@Test(priority = 20)
	public void acceptMkt558579Test() throws InterruptedException
	{
		shipmentRequestPage.acceptMkt558579();
		System.out.println("************ Accept the 558579 Mkt File *************");
	}
	
	@Test(priority = 30)
	public void sendJobReference558579Test() throws InterruptedException
	{
		shipmentRequestPage.sendJobReference558579("Suj558579");
		System.out.println("************ Sending the Job Reference Number *************");
	}
	
	@Test(priority = 40)
	public void submit558579Test() throws InterruptedException
	{
		shipmentRequestPage.submit558579();
		System.out.println("************ Submit the Job Reference Number and Cliking on 'OK' Alert Window *************");
		
		//return new HubHomePage(driver);
	}
	
	@Test(priority = 50)
	public void clickOnInfoRAMailAccepted558579() throws InterruptedException
	{
		hubHomePage.clickOnInfoMkt();
		System.out.println("************ Click on Information icon for File RA Mail Accepted 558,579 *************");
	}
	
	@Test (priority = 60)
	public void submitFinal558579Test() throws InterruptedException
	{
		shipmentRequestPage.submitFinal558579();
		System.out.println("************ Click on the Submit Final Document Process *************");
	}
	
	@Test (priority = 70)
	public void clickBrowse558579Test() throws InterruptedException
	{
		System.out.println("************ Uploading the 3 Hub Files *************");

		shipmentRequestPage.clickBrowse558579(prop.getProperty("hubfilepath1"));
		shipmentRequestPage.clickBrowse558579(prop.getProperty("hubfilepath2"));
		shipmentRequestPage.clickBrowse558579(prop.getProperty("hubfilepath3"));
		
		System.out.println("************ Uploaded the 3 Hub Files  *************");
	}
	
	@Test (priority = 80)
	public void upload558579Test() throws InterruptedException
	{
		System.out.println("************ Clicking on the Upload Button *************");
		shipmentRequestPage.upload558579();
	}
	
	@Test (priority = 90)
	public void process558579Test() throws InterruptedException
	{
		System.out.println("************ Clicking on the Process Button *************");
		shipmentRequestPage.process558579();
	}
	
	@Test (priority = 100)
	public void finalizeButton558579Test() throws InterruptedException
	{
		System.out.println("************ Clicking on the Finalize Submission Button *************");
		shipmentRequestPage.finalizeButton558579();
	}
	
	@Test (priority = 110)
	public void viewReport558579Test() throws InterruptedException
	{
		System.out.println("************ Clicking on the View Report Button *************");
		shipmentRequestPage.viewReport558579();
	}
	
	@Test (priority = 120)
	public void finalizeSubmission558579Test() throws InterruptedException
	{
		System.out.println("************ Clicking on the View Report Button *************");
		shipmentRequestPage.finalizeSubmission558579();
	}
	
	@Test (priority = 130)
	public void close558579Test() throws InterruptedException
	{
		System.out.println("************ Clicking on the View Report Button *************");
		shipmentRequestPage.close558579();
	}
	
	@Test (priority = 140)
	public void verifyFinalizationCompleted558579Test() throws InterruptedException
	{
		System.out.println("************ Clicking on the View Report Button *************");
		Assert.assertEquals(shipmentRequestPage.verifyFinalizationCompleted558579(), "Finalization completed");
	}
	
	
	
	
	
	
	@Test (priority = 1000)
	public void testDown()
	{
		driver.quit();
		System.out.println("****** Closing all the instances of the browser *******");
	}
	
	

}
