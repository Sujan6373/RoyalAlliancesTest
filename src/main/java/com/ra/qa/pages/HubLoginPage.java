package com.ra.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.ra.qa.base.TestBase;

public class HubLoginPage extends TestBase
{
	@FindBy(xpath = "//input[@name='UserName']")
	WebElement hubusername;
	
	@FindBy(xpath = "//input[@type='password']")
	WebElement hubpassword;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement submitbtn;
	
	@FindBy(xpath = "//select[@id='locationList']")
	WebElement siteSelector1;
	
	@FindBy(xpath = "//button[@type='button']/span[contains(text(),'3 selected')]")
	WebElement siteSelector;
	
	@FindBy(partialLinkText = "Royal Cloud")
	WebElement royalCloud1;
	
	@FindBy(xpath = "//a[@href='/UploadFiles/ViewFiles'][1]")
	WebElement raMailCloud;
	
	@FindBy(xpath = "//a[@class='dropdown-toggle']")
	WebElement royalCloud;
	
	@FindBy(xpath = "//input[@title='Test Site 2 - RA11']")
	WebElement RA11;
	
	@FindBy(xpath = "//input[@title='Jav Test 3 - RA51']")
	WebElement RA51;
	
	@FindBy(xpath = "//input[@title='Jav Troubleshooting - RA49']")
	WebElement RA49;
	
	public HubLoginPage(WebDriver d)
	{
		this.driver = d;
		PageFactory.initElements(driver, this);
	}
	
	public String validateLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	public HubHomePage login(String hubuname, String hubpwd) throws InterruptedException
	{
		hubusername.sendKeys(hubuname);
		Thread.sleep(1000);
		
		hubpassword.sendKeys(hubpwd);
		Thread.sleep(1000);
		
		submitbtn.click();
		Thread.sleep(3000);
		
		return new HubHomePage(driver);
	}
	
	public void selectRA11() throws InterruptedException
	{/*
		 * Select select = new Select(siteSelector1);
		 * select.selectByVisibleText("Test Site 2 - RA11");
		 * select.selectByVisibleText("Jav Test 3 - RA51");
		 * driver.findElement(By.xpath("//h1[contains(text(), 'Royal Dashboard')]")).
		 * click();
		 */
		
		siteSelector.click();
		RA51.click();
		RA49.click();
		driver.findElement(By.xpath("//h1[contains(text(), 'Royal Dashboard')]")).click();
		
		Thread.sleep(2000);
	}
	
	public void gotoRoyalCloud() throws InterruptedException
	{
		royalCloud.click();
		Thread.sleep(2000);
		
		raMailCloud.click();
		Thread.sleep(3000);
	}
	
	

}
