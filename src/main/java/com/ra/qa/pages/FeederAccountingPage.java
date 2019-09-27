package com.ra.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ra.qa.base.TestBase;

public class FeederAccountingPage extends TestBase
{
	//String transactionAmount558579_1 = "($142,396.90)";
	//String transactionAmount = "//a[contains(text(),'($142,396.90)')]";
	
	@FindBy(linkText = "/AccountingDetail")
	WebElement accounting558579;
	
	@FindBy(xpath = "//a[contains(text(),'($142,396.90)')]")
	//@FindBy(xpath = transactionAmount)
	WebElement transactionAmount558579;
	
	@FindBy(xpath = "//a[@onclick[contains(.,'showmorelabel')]][1]")
	WebElement showMore558579;
	
	@FindBy(xpath = "//div[@class='panel-body']//descendant::td[contains(text(),'$136,811.11')]")
	WebElement postageCost558579;
	
	@FindBy(xpath = "//div[@class='panel-body']//descendant::td[contains(text(),'$5,585.79')]")
	WebElement serviceCharges558579;
	
	@FindBy(xpath = "//div[@class='panel-body']//descendant::td[contains(text(),'Total Job Cost')]//following-sibling::td")
	WebElement totalJobCost558579;
	
	@FindBy(xpath = "//div[@class='panel-body']//descendant::td[contains(text(),'Transaction Total')]//following-sibling::td")
	WebElement transactionTotal558579;
	
	@FindBy (xpath = "//table[@class='table-condensed modal-table']//descendant::tr//descendant::td[contains(text(),'$0.2410')]")
	WebElement automationCommercialPostageCost558579;
	
	@FindBy (xpath = "//table[@class='table-condensed modal-table']/descendant::tr/descendant::td[contains(text(),'488,816')]")
	WebElement automationCommercialVolume558579;
	
	@FindBy (xpath = "//table[@class='table-condensed modal-table']/descendant::tr/descendant::td/strong[contains(text(),'$117,804.66')]")
	WebElement automationCommercialCost558579;
		
	@FindBy (xpath = "//table[@class='table-condensed modal-table']/descendant::tr/descendant::td[contains(text(),'69,763')]")
	WebElement nonAutomationCommercialVolume558579;
	
	@FindBy (xpath = "//table[@class='table-condensed modal-table']/descendant::tr/descendant::td/strong[contains(text(),'$19,006.46')]")
	WebElement nonAutomationCommercialCost558579;
	
	@FindBy (xpath = "//table[@class='table-condensed modal-table']/descendant::tr/descendant::td/strong[contains(text(),'$136,811.11')]")
	WebElement totalPostageCost558579;
	
	@FindBy (xpath = "//table[@class='table-condensed modal-table']/descendant::tr/descendant::td[contains(text(),'$5,585.79')]")
	WebElement processingFee558579;
		
	
	public FeederAccountingPage(WebDriver d)
	{
		this.driver = d;
		js = (JavascriptExecutor)d;
		PageFactory.initElements(driver, this);
	}
	
	/*
	 * public void clickOnAccounting558579() throws InterruptedException {
	 * js.executeScript("window.scrollBy(0,400)"); accounting558579.click();
	 * driver.findElement(By.xpath(
	 * "//span[@class='btn-link']/a[contains(text(),'($142,396.90)')][1]")).click();
	 * driver.findElement(By.xpath("//a[contains(@href,'-142396.9')]")).click();
	 * //return new AccountingPage(driver); }
	 */
	
	public void clickOnTransactionAmount558579() throws InterruptedException
	{
		//js.executeScript("window.scrollBy(0,400)");
		Thread.sleep(2000);
		
		//transactionAmount558579 = driver.findElement(By.xpath("//a[contains(text(),'"+transactionAmount558579_1+"')]"));
		transactionAmount558579.click();
		Thread.sleep(3000);
	}
	
	public void mailingCostSummary558579() throws InterruptedException
	{
		showMore558579.click();
		Thread.sleep(2000);
	}
	
	public class MailingCostReport
	{
		String postageCost;
		public String getPostageCost() { return this.postageCost;}
		
		String serviceCharge;
		public String getServiceCharge() { return this.serviceCharge;}
		
		String totalJobCost;
		public String getTotalJobCost() { return this.totalJobCost;}
		
		String transactionTotal;
		public String getTransactionTotal() { return this.transactionTotal;}
		
		String automationCommercialPostageCost;
		public String getCommercialPostageCost() {return this.automationCommercialPostageCost;}
		
		String automationCommercialVolume;
		public String getCommercialVolume() {return this.automationCommercialVolume;}
		
		String automationCommercialCost;
		public String getCommercialCost() {return this.automationCommercialCost;}
		
		String nonAutomationCommercialVolume;
		public String getNonAutomationCommercialVolume() {return this.nonAutomationCommercialVolume;}
		
		String nonAutomationCommercialCost;
		public String getNonAutomationCommercialCost() { return this.nonAutomationCommercialCost;}
		
		String totalPostageCost;
		public String getTotalPostageCost() {return this.totalPostageCost;}
		
		String processingFee;
		public String getProcessingFee() {return this.processingFee;}
		
		public MailingCostReport(String postageCost, String serviceCharge, String totalJobCost, String transactionTotal, String automationCommercialPostageCost,
				String automationCommercialVolume, String automationCommercialCost, String nonAutomationCommercialVolume, String nonAutomationCommercialCost,
				String totalPostageCost, String processingFee)
		{
			this.postageCost = postageCost;
			this.serviceCharge = serviceCharge;
			this.totalJobCost = totalJobCost;
			this.transactionTotal = transactionTotal;
			this.automationCommercialPostageCost = automationCommercialPostageCost;
			this.automationCommercialVolume = automationCommercialVolume;
			this.automationCommercialCost = automationCommercialCost;
			this.nonAutomationCommercialVolume = nonAutomationCommercialVolume;
			this.nonAutomationCommercialCost = nonAutomationCommercialCost;
			this.totalPostageCost = totalPostageCost;
			this.processingFee = processingFee;
		}		
		
	}	
	
	public MailingCostReport verifyCostSummary558579() throws InterruptedException
	{
		
		  MailingCostReport report = new MailingCostReport
		(
		  postageCost558579.getText(), 
		  serviceCharges558579.getText(),
		  totalJobCost558579.getText(), 
		  transactionTotal558579.getText(),
		  automationCommercialPostageCost558579.getText(),
		  automationCommercialVolume558579.getText(),
		  automationCommercialCost558579.getText(),
		  nonAutomationCommercialVolume558579.getText(),
		  nonAutomationCommercialCost558579.getText(),
		  totalPostageCost558579.getText(),
		  processingFee558579.getText()		  
		 );
		return report;
	}

}
