package com.pmtpro;


import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LoginToPMT;
import resources.Base;

public class PMTLoginTest extends Base {

	@BeforeTest
	public void initialize() throws Throwable {
		driver = driverInitialization();
		driver.get(properties.getProperty("url"));
	}
	
	@Test
	public void pmtLogin() throws Throwable {
		
		//driver.get("https://pmtcot.joinallofus.org/login");
		System.out.println("PMT LOGIN COMPLETED");
		LoginToPMT pmtLogin = new LoginToPMT(driver);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		pmtLogin.username().sendKeys(properties.getProperty("LoginUsername"));
		pmtLogin.password().sendKeys("Password@01");
		pmtLogin.loginSubmit().click();
		Thread.sleep(15000);
		pmtLogin.loginSubmit().click();
		
	}
	
	@Test(enabled=false)
	public void privacyPolicy() throws Throwable
	{
		driver = driverInitialization();
		driver.get("https://pmtcot.joinallofus.org/login");
		LoginToPMT pmtLogin = new LoginToPMT(driver);
		pmtLogin.privacyPolicy().click();
		
		Set<String> windowIds = driver.getWindowHandles();
		Iterator<String> itr = windowIds.iterator();
		String parentWindow = itr.next();
		String childWindow = itr.next();
		
		driver.switchTo().window(childWindow);
		Assert.assertEquals(driver.getCurrentUrl(),"https://www.joinallofus.org/en/privacy-policy");
		driver.switchTo().window(parentWindow);
		
	}
	
	@Test(enabled=false)
	public void faq() throws Throwable {
		driver=driverInitialization();
		driver.get("https://pmtcot.joinallofus.org/login");
		LoginToPMT pmtLogin = new LoginToPMT(driver);
		pmtLogin.faq().click();
		
	}
	
	@AfterTest
	public void browserClose() {
		driver.close();
	}

}
