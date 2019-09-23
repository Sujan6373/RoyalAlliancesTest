package com.ra.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;


import com.ra.qa.util.TestUtil;
import com.ra.qa.util.WebEventListener;

public class TestBase {
	
	public WebDriver driver;
	public Properties prop;
	public EventFiringWebDriver e_driver;
	public WebEventListener eventListener;
	
	public  JavascriptExecutor js = (JavascriptExecutor) driver;
	
	public  Logger log  = Logger.getLogger(TestBase.class);
	
	public TestBase()
	{
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:\\Users\\mails\\ExistingProject\\RoyalAlliancesTest\\src\\main\\java\\com\\ra\\qa\\config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void initialization()
	{
		String broswerName = prop.getProperty("browser");
		
		if(broswerName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\mails\\Downloads\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if (broswerName.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\mails\\Downloads\\geckodriver-v0.25.0-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		//adding log message
		log.info("**************************launching browser*******************************");
		
		e_driver = new EventFiringWebDriver(driver);
		
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
	}
}