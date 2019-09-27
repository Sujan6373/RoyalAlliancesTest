package com.ra.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ra.qa.base.TestBase;

public class LoginPage extends TestBase
{
	@FindBy(xpath = "//input[@name='UserName']")
	WebElement username;
	
	@FindBy(xpath = "//input[@type='password']")
	WebElement password;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement submitbtn;
	
	@FindBy(xpath = "//a[contains(text(), 'Site Location ')]")
	WebElement siteSelector;
	
	@FindBy(xpath = "//label[contains(text(), 'Site A - RA136')]")
	WebElement siteA;
	
	@FindBy(xpath = "//label[contains(text(), 'Site - C')]")
	WebElement siteC;
	
	@FindBy(xpath = "//a[contains(text(),'Accounting')]")
	WebElement accounting558579;
	
	
	
	public LoginPage(WebDriver d)
	{
		this.driver = d;
		js = (JavascriptExecutor)d;
		PageFactory.initElements(driver, this);
	}
	
	public String validateLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	public HomePage login(String uname, String pwd) throws InterruptedException
	{
		username.sendKeys(uname);
		Thread.sleep(1000);
		
		password.sendKeys(pwd);
		Thread.sleep(1000);
		
		submitbtn.click();
		Thread.sleep(3000);
		
		return new HomePage(driver);
	}
	
	public void navigateToMailQueue(String url_mailqueue) throws InterruptedException
	{
		driver.get(url_mailqueue);
		Thread.sleep(2000);
	}
	
	public void selectSiteB() throws InterruptedException
	{
		siteSelector.click();
			
		siteA.click();
		siteC.click();
		driver.findElement(By.xpath("//th[@data-field='JobId']")).click();
		Thread.sleep(3000);
	}
	
	public FeederAccountingPage clickOnAccounting558579() throws InterruptedException
	{
		js.executeScript("window.scrollBy(0,400)");
		accounting558579.click();
		Thread.sleep(3000);
//		FeederAccountingPage accountingPage = new FeederAccountingPage(driver);
//		accountingPage.transactionAmount558579_1 = "333333";
		return new FeederAccountingPage(driver);
	}
	
	
}
