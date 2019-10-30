package com.ra.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ra.qa.base.TestBase;

public class HomePage extends TestBase
{
	//WebDriverWait wait = new WebDriverWait(driver, 20);
	//JavascriptExecutor js = (JavascriptExecutor) driver;	
	//JavascriptExecutor js;
	
	@FindBy(xpath = "//a[@value='Upload']")
	WebElement uploadBtn;
	
	@FindBy(xpath = "//input[@id = 'files']")
	WebElement uploadFile;
	
	@FindBy(xpath = "//button[@id = 'upload_Done_button']")
	WebElement okBtn;
	
	@FindBy(xpath = "//div[@id='pendingFileList']//td[contains(text(),'288,762')][1]//parent::tr//descendant::td/input[@class='k-checkbox']//parent::td//label[1]")
	WebElement readyF1;
	
	@FindBy(xpath = "//div[@id='pendingFileList']//td[contains(text(),'269,817')][1]//parent::tr//descendant::td/input[@class='k-checkbox']//parent::td//label[1]")
	WebElement readyF2;
	
	@FindBy(xpath = "//div[@id='pendingFileList']//td[contains(text(),'264,230')][1]//parent::tr//descendant::td/input[@class='k-checkbox']//parent::td//label[1]")
	WebElement selectPCnLTR;
	
	@FindBy (xpath = "//button[@id = 'btnSubmitPendingFiles']")
	WebElement scheduleMailingBtn;
	
	//@FindBy(xpath = "//button[@type='submit']")
	@FindBy(xpath = "//span[text() ='Confirm']")
	WebElement confirmBtn;
	
	@FindBy(xpath = "//button[@id ='btnSubmitSchedule']")
	WebElement submitScheduleBtn;
	
	@FindBy(xpath = "//button[@id='marketingButton' and @value='standard_mail']")
	WebElement marketing;
	
	@FindBy(xpath = "//a[contains(text(),'Scheduled')]")
	WebElement scheduledTab;
	
	@FindBy(xpath = "//a[contains(text(), 'Site Location ')]")
	WebElement siteSelector;	
	
	@FindBy(xpath = "//button[contains(@class,'multiselect')]")
	WebElement legacySiteSelector;
	
	@FindBy(xpath = "//label/span[contains(text(),'RA56')]")
	WebElement siteRA56;
	
	@FindBy(xpath = "//label/span[contains(text(),'RA57')]")
	WebElement siteRA57;
	
	@FindBy(xpath = "//h1[contains(text(),'Royal Dashboard')]")
	WebElement royalDashboard;
	
	@FindBy(className = "dropdown-toggle")
	WebElement royalCloud;
	
	@FindBy(xpath = "//a[@href='/UploadFiles/ViewFiles']/i[@class='icon-cloud']")
	WebElement selectRAMailCloud;
	
	@FindBy (className = "accordion-toggle")
	WebElement uploadNewFile;
	
	@FindBy (xpath = "//input[contains(@id,'html5')]")
	WebElement uploadFeederFile;
	
	public HomePage(WebDriver d)
	{
		this.driver = d;
		//this.wait = w;
		//wait = (WebDriverWait) d;
		wait = new WebDriverWait(driver, 20);
		js = (JavascriptExecutor) d;
		PageFactory.initElements(driver, this);
	}
	
	public String getPageTitle()
	{
		return driver.getTitle();
	}
	
	public void selectSiteRA55() throws InterruptedException
	{
		legacySiteSelector.click();
			
		siteRA56.click();
		siteRA57.click();
		
		// click on the Dashboard of the RA Cloud
		royalDashboard.click(); 
		Thread.sleep(3000);
	}
	
	public void navigateToRACloud() throws InterruptedException
	{
 		wait.until(ExpectedConditions.visibilityOf(royalCloud));
		royalCloud.click();
		selectRAMailCloud.click();
		//Thread.sleep(3000);
	}
	
	public void clickOnUploadLegacy() throws InterruptedException
	{
		wait.until(ExpectedConditions.visibilityOf(uploadNewFile));
		uploadNewFile.click();
	}
	
	public void clickOnUploadBtn() throws InterruptedException 
	{
		uploadBtn.click();
		Thread.sleep(2000);
	}
	
	public void uploadFile(String filePath) throws InterruptedException
	{
		uploadFile.sendKeys(filePath);
		Thread.sleep(15000);
	}
	
	public void uploadFeederFileLegacy(String filePath) throws InterruptedException
	{
		uploadFeederFile.sendKeys(filePath);
		WebElement upload = driver.findElement(By.xpath("//a[contains(@id,'upload')]"));
		wait.until(ExpectedConditions.visibilityOf(upload));
		upload.click();
		
		WebElement okayBtn = driver.findElement(By.name("successOkButton"));
		wait.until(ExpectedConditions.visibilityOf(okayBtn));
		okayBtn.click();
	}
	
	public void uploadDone() throws InterruptedException
	{
		okBtn.click();
		Thread.sleep(200000);
		System.out.println("*******************Ending Thread 100 Seconds***********************");
	}
	
	public void gotoMarketingTab()
	{
		marketing.click();
	}
	
	public void selectF1AndF2Ready() throws InterruptedException
	{
		readyF1.click();
		Thread.sleep(2000);
		//this.js = j;
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,700)");
		readyF2.click();
	}
	
	public void selectPCnLTR() throws InterruptedException
	{
		selectPCnLTR.click();
		Thread.sleep(2000);
	
	}
	
	public void scheduleMail() throws InterruptedException
	{		
		/*
		 * WebElement scheduleMailingBtn =
		 * driver.findElement(By.xpath("//button[@id = 'btnSubmitPendingFiles']"));
		 * js.executeScript("arguments[0].scrollIntoView()", scheduleMailingBtn);
		 * js.executeScript("window.scrollBy(0,500)");
		 */
		Thread.sleep(1000);
		js.executeScript("window.scrollBy(0,150)");
		Thread.sleep(3000);
		scheduleMailingBtn.click();
	}
	
	
	public void confirm() throws InterruptedException
	{
		confirmBtn.click();
		Thread.sleep(1000);
	}
	
	public SchedulePage submitSchedule() throws InterruptedException
	{
		js.executeScript("window.scrollBy(0,-600)");
		Thread.sleep(3000);
		submitScheduleBtn.click();
		Thread.sleep(120000);
		
		return new SchedulePage(driver);
	}
	
	public SchedulePage navigateToScheduledTab() throws InterruptedException
	{
		scheduledTab.click();
		Thread.sleep(3000);
		return new SchedulePage(driver);
	}
	
	
}
