package com.pro;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

public class MCLogin {
	public WebDriver driver= null;
	public Properties prop = null;
	public FileInputStream fis = null;
	
	@Test
	public void LaunchUrl() throws IOException, Throwable{
		
		prop = new Properties();
		fis = new FileInputStream("D:\\Ecilipse\\TestNG\\src\\com\\pro\\datadriven.properties");
		
		prop.load(fis);
		
		if(prop.getProperty("browser").equals("Chrome"))
		{
			System.setProperty(prop.getProperty("ChromeWebDriver"), prop.getProperty("ChromeLocation"));
			driver = new ChromeDriver();
		}
		
		else if(prop.getProperty("browser").equals("Firefox"))
		{
			System.setProperty(prop.getProperty("FireFoxWebDriver"), prop.getProperty("FireFoxWebDriverLocation"));
			driver = new FirefoxDriver();
		}
		
		else if(prop.getProperty("browser").equals("InternetExplorer"))
		{
			System.setProperty(prop.getProperty("InternetExplorerWebDriver"), prop.getProperty("InternetExplorerWebDriverLocation"));
			driver = new InternetExplorerDriver();
		}

		driver.get(prop.getProperty("url"));
	}
	
	@Test(enabled=false)
	public void LoginSubmission() throws Throwable{
		
			driver.findElement(By.xpath("//input[@name='email']")).sendKeys(prop.getProperty("username"));
			driver.findElement(By.xpath("//input[@name='password']")).sendKeys(prop.getProperty("password"));
			
			driver.findElement(By.xpath("//input[@type='submit']")).click();
			
			Thread.sleep(15000);
			
			driver.findElement(By.xpath("//input[@value='Submit']")).click();

		}
		
	@Test(dependsOnMethods={"LaunchUrl"},enabled=false)
	public void BeforeLoginPrivacyStatement()
	{
		driver.findElement(By.xpath("//div[@class='privacy-link']/span[1]/a")).click();
		System.out.println(driver.getTitle());
		
		Set<String> ids =driver.getWindowHandles();
		Iterator<String> itr = ids.iterator();
		String parentWindow = itr.next();
		String childWindow = itr.next();
		
		driver.switchTo().window(childWindow);
		System.out.println(driver.getTitle());
		
		driver.switchTo().window(parentWindow);
		System.out.println(driver.getTitle());
		
	}
	
	@Test(dependsOnMethods="LaunchUrl")
	public void BeforeLoginFAQ()
	{
		driver.findElement(By.xpath("//div[@class='privacy-link']/span[2]/a")).click();
		System.out.println(driver.findElement(By.xpath("//div[@class='subwrapper']/div/div/h1")).getText());
	}
}
