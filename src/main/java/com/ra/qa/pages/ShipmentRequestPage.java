package com.ra.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ra.qa.base.TestBase;

public class ShipmentRequestPage extends TestBase
{
	
	@FindBy(xpath = "//a[contains(text(),'Accept')]")
	WebElement accept558579;
	
	@FindBy(xpath = "//input[@name='JobReferenceNumber']")
	WebElement jobReference558579;
	
	@FindBy (xpath = "//button[@id='submitJobReferenceButton']")
	WebElement submit558579;
	
	//@FindBy(xpath = "//i[@class='icon-cloud-upload'][1]")
	@FindBy(xpath = "//a[@class='accordion-toggle']")
	WebElement submitFinal558579;
	
	@FindBy (xpath = "//a[starts-with(@id,'uk-browse-button')]")
	WebElement browse558579;

	//@FindBy(xpath = "//input[@id='uploadFiles']")
	@FindBy(xpath = "//input[@id[contains(.,'html5')]]")
	WebElement sendOffsetFile;
	
	@FindBy (xpath = "//a[starts-with(@id,'uk-upload-button')]")
	WebElement upload558579;
	
	@FindBy (xpath = "//button[@id='btn-upload-successful']")
	WebElement okay558579;
	
	@FindBy(xpath = "//a[@id='btn-processoffset']")
	WebElement process558579;
	
	@FindBy(xpath = "//button[@id='finalizeSubmissionBtn']")
	WebElement finalizeButton558579;
	
	//@FindBy(xpath = "//a[starts-with(@href,'/Report/RAMmailSummary')]")
	@FindBy(xpath = "//a[@class='btn-u' and contains(text(),'View Report')]")
	WebElement viewReport558579;

	@FindBy(xpath = "//button[contains(text(),'Finalize Submission')]")
	WebElement finalizeSubmission558579;
	
	@FindBy (xpath = "//a[contains(text(),'Close')]")
	WebElement close558579;
	
	@FindBy (xpath = "//h5[contains(text(),'Finalization completed')]")
	WebElement Finalization558579;
	
	
	
	public ShipmentRequestPage(WebDriver d) 
	{
		this.driver = d;
		PageFactory.initElements(driver, this);
	}
	
	public void acceptMkt558579() throws InterruptedException 
	{
		accept558579.click();
		Thread.sleep(2000);
	}
	
	public void sendJobReference558579(String jobRef) throws InterruptedException
	{
		jobReference558579.sendKeys(jobRef);
		Thread.sleep(2000);
	}
	
	public void submit558579() throws InterruptedException
	{
		submit558579.click();
		Thread.sleep(3000);
		
		driver.switchTo().alert().accept();
		Thread.sleep(15000);
		
		driver.navigate().refresh();
		Thread.sleep(3000);
	}
	
	public void submitFinal558579() throws InterruptedException
	{
		submitFinal558579.click();
		Thread.sleep(2000);
	}
	
	public void clickBrowse558579(String filePath) throws InterruptedException
	{
		//browse558579.sendKeys("C:\\Users\\sshre\\OneDrive\\Documents\\TestFiles\\NonAutomation\\h1.zip");
		//browse558579.click();
		//driver.switchTo().alert().sendKeys("C:\\\\Users\\\\sshre\\\\OneDrive\\\\Documents\\\\TestFiles\\\\NonAutomation\\\\h1.zip");
		//sendOffsetFile.sendKeys("C:\\Users\\sshre\\OneDrive\\Documents\\TestFiles\\NonAutomation\\h1.zip");
		//driver.findElement(By.xpath("//input[@id[contains(.,'html5')]]")).sendKeys("C:\\Users\\sshre\\OneDrive\\Documents\\TestFiles\\NonAutomation\\h1.zip");
		sendOffsetFile.sendKeys(filePath);
		Thread.sleep(1000);
		
	}
	
	public void upload558579() throws InterruptedException
	{
		upload558579.click();
		//driver.findElement(By.xpath("//a[starts-with(@id,'uk-upload-button')]")).click();
		Thread.sleep(100000);
		
		//driver.switchTo().alert().accept();
		okay558579.click();
		Thread.sleep(7000);
	}
	
	public void process558579() throws InterruptedException
	{
		process558579.click();
		Thread.sleep(120000);
	}
	
	public void finalizeButton558579() throws InterruptedException
	{
		//driver.findElement(By.xpath("//button[@id='finalizeSubmissionBtn']")).click();
		finalizeButton558579.click();
		Thread.sleep(2000);
	}
	
	public void viewReport558579() throws InterruptedException
	{
		viewReport558579.click();
		//driver.findElement(By.xpath("//a[@class='btn-u' and contains(text(),'View Report')]")).click();
		Thread.sleep(5000);
	}
	
	public void finalizeSubmission558579() throws InterruptedException
	{
		finalizeSubmission558579.click();
		Thread.sleep(3000);
	}
	
	public void close558579() throws InterruptedException
	{
		close558579.click();
		Thread.sleep(120000);
		driver.navigate().refresh();
	}
	
	public String verifyFinalizationCompleted558579()
	{
		String status = Finalization558579.getText();
		return status;
	}

}
