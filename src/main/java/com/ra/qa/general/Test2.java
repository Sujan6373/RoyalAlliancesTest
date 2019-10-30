package com.ra.qa.general;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Test2 {
	
	WebDriver driver;
	
	public void invokeBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\mails\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
	}
	
	//public void invokeBrowser() throws InterruptedException
	//public static void main (String[] args) throws InterruptedException
	
	@Test (priority = 10)
	public void googleSearch() throws InterruptedException
	{
		invokeBrowser();
		driver.get("http://www.google.com");
		
		//driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys("Selenium");
		driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys("Nepal");
		Thread.sleep(2000);
		
		List<WebElement> ele = driver.findElements(By.xpath("//ul[@role='listbox']/descendant::li/descendant::div[@class='sbl1']"));
		System.out.println("Total number of suggestions: " + ele.size() );
		
		for (int i = 0; i<ele.size(); i++)
		{
			//if(ele.get(i).getText().equalsIgnoreCase("Selenium interview questions")) 
			if(ele.get(i).getText().equalsIgnoreCase("nepal map")) 
			{
				System.out.println(ele.get(i).getText());
				ele.get(i).click();
				Thread.sleep(2000);
				break;
			}
		}		
		driver.close();				
	}
	
	@DataProvider (name = "TestData")
	public Object[][] getData()
	{
		Object[][] data = new Object [3][2];
		
		data [0][0] = "ABC1";
		data [0][1] = "Pass1";
		
		data [1][0] = "ABC2";
		data [1][1] = "Pass2";
		
		data [2][0] = "ABC3";
		data [2][1] = "Pass3";
		
		return data;
 	}
	
	@Test(dataProvider = "TestData", priority = 20)
	public void fbLogin(String userName, String password) throws InterruptedException
	{
		invokeBrowser();
		driver.get("https://www.facebook.com/");
		
		WebElement username = driver.findElement(By.xpath("//input[@name='email']"));
		username.sendKeys(userName);
		Thread.sleep(1000);
		
		WebElement passWord = driver.findElement(By.xpath("//input[@name='pass']"));
		passWord.sendKeys(password);
		Thread.sleep(1000);
		
		driver.quit();
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
