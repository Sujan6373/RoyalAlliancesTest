package com.ra.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.ra.qa.base.TestBase;

public class HubHomePage extends TestBase
{
	public HubHomePage(WebDriver d) 
	{
		this.driver = d;
		PageFactory.initElements(driver, this);
	}

}
