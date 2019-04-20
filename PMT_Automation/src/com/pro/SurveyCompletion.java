package com.pro;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SurveyCompletion {

	public static void main(String[] args) throws Throwable {
		
		System.setProperty("webdriver.chrome.driver", "D:\\jar\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://pmiqasub.joinallofus.org/#/login");//URL LOGIN page 
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='usernameEmail']")).sendKeys("qwerty1@gmail.com");
		driver.findElement(By.xpath("//input[@id='userPassword']")).sendKeys("Password@01");
		driver.findElement(By.xpath("//button[@data-target='@login|button|submit']")).click();
		
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
/*FInd A Partner*/	
		/*driver.findElement(By.xpath("//div/div[3]//button[@data-target='@banners|openForm|button']")).click();
		
		driver.findElement(By.xpath("//button[@data-target='@form|button|continue']")).click();
		driver.findElement(By.xpath("//div[@class='table-wrap']/div[2]")).click();
		driver.findElement(By.xpath("//button[@data-target='@form|button|continue']")).click();
		driver.findElement(By.xpath("//div/div[1]/div/div/preview-sub-field-multi-select-option-value/label/div[2]")).click();
		driver.findElement(By.xpath("//button[@data-target='@form|button|continue']")).click();
		driver.findElement(By.xpath("//button[@data-target='@form|button|submit']")).click();*/
/*EHR Consent*/
		/*WebDriverWait waitForPageToLoad = new WebDriverWait(driver, 50);
		driver.findElement(By.xpath("//div/div[3]//button[@data-target='@banners|openForm|button']")).click();
		for(int i=0; i<=20;i++)
		{
		waitForPageToLoad.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//button[@data-target='@form|button|continue']")));	
		driver.findElement(By.xpath("//button[@data-target='@form|button|continue']")).click();
		}
		driver.findElement(By.xpath("//div/div[1]/div/div/preview-sub-field-multi-select-option-value/label/div[2]")).click();
		driver.findElement(By.xpath("//button[@data-target='@form|button|continue']")).click();
		
		driver.findElement(By.xpath("//div/div/div[2]/label/input")).click();
	    driver.findElement(By.xpath("//div[@ng-style='displayObject.cssStyles']/input")).sendKeys("asdfgh");
	    driver.findElement(By.xpath("//button[@data-target='@form|button|continue']")).click();
	    
	    driver.findElement(By.xpath("//div/div[2]/div/div/preview-sub-field-multi-select-option-value/label/div[2]")).click();
		driver.findElement(By.xpath("//button[@data-target='@form|button|continue']")).click();
		driver.findElement(By.xpath("//button[@data-target='@form|button|submit']")).click();*/
		
/*Survey 1: CityStateZip*/		
		/*WebElement cityStateZip = driver.findElement(By.xpath("//div/div[2]/div/slides/survey-card[1]/div/div/div/div[2]/div"));
		if(cityStateZip.getText().equals("CityStateZip"))
		{
		driver.findElement(By.xpath("//div/div[2]/div/slides/survey-card[1]/div/div/div/div[2]/button")).click();
		driver.findElement(By.xpath("//button[@data-target='@form|button|submit']")).click();
		}*/
		
/* Survey 2: Address Main*/	
		
		/*WebElement element = driver.findElement(By.xpath("//div/div[2]/div/slides/survey-card[1]/div/div/div/div[2]/div"));
		System.out.println(element.getText());
		if(element.getText().equals("Address Main"))
		{
		
		driver.findElement(By.xpath("//div/div[2]/div/slides/survey-card[1]/div/div/div/div[2]/button")).click();
		
		driver.findElement(By.xpath("//button[@data-target='@form|button|continue']")).click();
		
		driver.findElement(By.xpath("//button[@data-target='@form|button|submit']")).click();
		}*/
		
		/*WebElement basics = driver.findElement(By.xpath("//div/div[2]/div/slides/survey-card[1]/div/div/div/div[2]/div"));
		System.out.println(basics.getText());
		if(basics.getText().equals("The Basics"))
		{
			driver.findElement(By.xpath("//div/div[2]/div/slides/survey-card[1]/div/div/div/div[2]/button")).click();
			driver.findElement(By.xpath("//button[@data-target='@form|button|submit']")).click();
			for(int i=1; i<=27;i++)
			{
				driver.findElement(By.xpath("//button[@data-target='@form|button|continue']")).click();
			}
			
			driver.findElement(By.xpath("//button[@data-target='@form|button|submit']")).click();
		}*/
		Thread.sleep(30000);
		driver.close();

	}
	
	public static WebDriver login(WebDriver driver)
	{
		driver.findElement(By.xpath("//input[@id='usernameEmail']")).sendKeys("qwerty1@gmail.com");
		driver.findElement(By.xpath("//input[@id='userPassword']")).sendKeys("Password@01");
		driver.findElement(By.xpath("//button[@data-target='@login|button|submit']")).click();	
		return driver;
	}

	
	public static WebDriver basicSurvey(WebDriver driver)
	{
		WebElement basics = driver.findElement(By.xpath("//div/div[2]/div/slides/survey-card[1]/div/div/div/div[2]/div"));
		System.out.println(basics.getText());
		if(basics.getText().equals("The Basics"))
		{
			driver.findElement(By.xpath("//div/div[2]/div/slides/survey-card[1]/div/div/div/div[2]/button")).click();
			driver.findElement(By.xpath("//button[@data-target='@form|button|submit']")).click();
			for(int i=1; i<=27;i++)
			{
				driver.findElement(By.xpath("//button[@data-target='@form|button|continue']")).click();
			}
			
			driver.findElement(By.xpath("//button[@data-target='@form|button|submit']")).click();
		}
		return driver;
		
	}

	public static WebDriver addressSurvey(WebDriver driver)
	{
		WebElement element = driver.findElement(By.xpath("//div/div[2]/div/slides/survey-card[1]/div/div/div/div[2]/div"));
		System.out.println(element.getText());
		if(element.getText().equals("Address Main"))
		{
		
		driver.findElement(By.xpath("//div/div[2]/div/slides/survey-card[1]/div/div/div/div[2]/button")).click();
		
		driver.findElement(By.xpath("//button[@data-target='@form|button|continue']")).click();
		
		driver.findElement(By.xpath("//button[@data-target='@form|button|submit']")).click();
		}
		return driver;
	}
	
	public static WebDriver cityStateZipSurvey(WebDriver driver)
	{
		WebElement cityStateZip = driver.findElement(By.xpath("//div/div[2]/div/slides/survey-card[1]/div/div/div/div[2]/div"));
		if(cityStateZip.getText().equals("CityStateZip"))
		{
		driver.findElement(By.xpath("//div/div[2]/div/slides/survey-card[1]/div/div/div/div[2]/button")).click();
		driver.findElement(By.xpath("//button[@data-target='@form|button|submit']")).click();
		}
		return driver;
	}
	
	public static WebDriver EHRConsent(WebDriver driver)
	{
		WebDriverWait waitForPageToLoad = new WebDriverWait(driver, 50);
		driver.findElement(By.xpath("//div/div[3]//button[@data-target='@banners|openForm|button']")).click();
		for(int i=0; i<=20;i++)
		{
		waitForPageToLoad.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//button[@data-target='@form|button|continue']")));	
		driver.findElement(By.xpath("//button[@data-target='@form|button|continue']")).click();
		}
		driver.findElement(By.xpath("//div/div[1]/div/div/preview-sub-field-multi-select-option-value/label/div[2]")).click();
		driver.findElement(By.xpath("//button[@data-target='@form|button|continue']")).click();
		
		driver.findElement(By.xpath("//div/div/div[2]/label/input")).click();
	    driver.findElement(By.xpath("//div[@ng-style='displayObject.cssStyles']/input")).sendKeys("asdfgh");
	    driver.findElement(By.xpath("//button[@data-target='@form|button|continue']")).click();
	    
	    driver.findElement(By.xpath("//div/div[2]/div/div/preview-sub-field-multi-select-option-value/label/div[2]")).click();
		driver.findElement(By.xpath("//button[@data-target='@form|button|continue']")).click();
		driver.findElement(By.xpath("//button[@data-target='@form|button|submit']")).click();
		
		return driver;
	}
	
	public static WebDriver findaPartner(WebDriver driver)
	{
driver.findElement(By.xpath("//div/div[3]//button[@data-target='@banners|openForm|button']")).click();
		
		driver.findElement(By.xpath("//button[@data-target='@form|button|continue']")).click();
		driver.findElement(By.xpath("//div[@class='table-wrap']/div[2]")).click();
		driver.findElement(By.xpath("//button[@data-target='@form|button|continue']")).click();
		driver.findElement(By.xpath("//div/div[1]/div/div/preview-sub-field-multi-select-option-value/label/div[2]")).click();
		driver.findElement(By.xpath("//button[@data-target='@form|button|continue']")).click();
		driver.findElement(By.xpath("//button[@data-target='@form|button|submit']")).click();
		return driver;
	}
	
}
