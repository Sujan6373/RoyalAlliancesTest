package com.ra.qa.general;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test2 {
	
	//public void invokeBrowser() throws InterruptedException
	public static void main (String[] args) throws InterruptedException
	{
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\mails\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		driver.get("http://www.google.com");
		
		driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys("Selenium");
		Thread.sleep(5000);
		
		List<WebElement> ele = driver.findElements(By.xpath("//ul[@role='listbox']/descendant::li/descendant::div[@class='sbl1']"));
		System.out.println("Total number of suggestions: " + ele.size() );
		
		for (int i = 0; i<ele.size(); i++)
		{
			if(ele.get(i).getText().equalsIgnoreCase("Selenium interview questions")) 
			{
				System.out.println(ele.get(i).getText());
				ele.get(i).click();
				Thread.sleep(5000);
				break;
			}
		}
		
		driver.close();
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	System.setProperty("webdriver.firefox.marionette","C:\\geckodriver.exe");
//	
//	WebDriver driver = new FirefoxDriver();
//	
//    String baseUrl = "http://demo.guru99.com/test/newtours/";

	/*
	 * public static void main (String[] args) throws InterruptedException { Test2
	 * myObj = new Test2(); myObj.invokeBrowser();
	 * 
	 * 
	 * }
	 */
}
