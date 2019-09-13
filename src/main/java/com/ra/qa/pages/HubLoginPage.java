package com.ra.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ra.qa.base.TestBase;

public class HubLoginPage extends TestBase
{
	@FindBy(xpath = "//input[@name='UserName']")
	WebElement username;
	
	@FindBy(xpath = "//input[@type='password']")
	WebElement password;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement submitbtn;
	
	public HubLoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String validateLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	public HubHomePage login(String uname, String pwd) throws InterruptedException
	{
		username.sendKeys(uname);
		Thread.sleep(1000);
		
		password.sendKeys(pwd);
		Thread.sleep(1000);
		
		submitbtn.click();
		
		return new HubHomePage();
	}
	

}
