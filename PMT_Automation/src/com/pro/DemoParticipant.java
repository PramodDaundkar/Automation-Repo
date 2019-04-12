package com.pro;

import java.awt.RenderingHints.Key;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DemoParticipant {

	public static void main(String[] args) throws Throwable {
		
		System.setProperty("webdriver.chrome.driver", "D:\\jar\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://pmiqasub.joinallofus.org/#/login");//URL LOGIN page 
		
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//form/div[2]/div[5]")).click();//Click on the link for SIGN UP 
		
		driver.findElement(By.xpath("//input[@id='signUpEmail']")).sendKeys("qwertyu@gmail.com");//Enter the Email
		
		WebElement element = driver.findElement(By.xpath("//div[@role='alert']/span"));
		
		if(element.isDisplayed())//if user is already exists. If exists then move to Login Page
		{
			driver.findElement(By.xpath("//a[@data-target='signin.actions.signin']")).click();
			driver.findElement(By.xpath("//input[@id='usernameEmail']")).sendKeys("qwertyu@gmail.com");
			driver.findElement(By.xpath("//input[@id='userPassword']")).sendKeys("Password@01");
			driver.findElement(By.xpath("//button[@data-target='@login|button|submit']")).click();
		}
		else// continue with the SIGN UP process
		{
		driver.findElement(By.xpath("//input[@id='signUpPassword']")).sendKeys("Password@01");
		driver.findElement(By.xpath("//button[@data-target='@registration|button|next']")).click();
		}
		
		WebDriverWait waitForPageToLoad = new WebDriverWait(driver, 50);
		waitForPageToLoad.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div/div//div[@aria-label='Welcome']")));

// Primary Consent: Welcome Screen
		System.out.println(driver.findElement(By.xpath("//div/div//div[@aria-label='Welcome']")).getText());
		int frameCount = driver.findElements(By.tagName("iframe")).size();
		System.out.println("Welcome Screen"+":"+frameCount);
		
		for(int i=0; i<10;i++)
		{
		if(frameCount>1)
		{
		
		driver.switchTo().frame(0);
		waitForPageToLoad.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@id='player']/div/div[4]/button")));
		driver.findElement(By.xpath("//div[@id='player']/div/div[4]/button")).click();
		
		/* Below Code is from Stackoverflow
		 * https://stackoverflow.com/questions/40546546/how-to-click-on-a-specific-position-of-a-web-element-in-selenium/40571321#40571321
		 */
		WebElement progressBar = driver.findElement(By.xpath("//div[@class='ytp-progress-bar-container']/div[1]"));
		int width = progressBar.getSize().getWidth();
		Actions act = new Actions(driver);
	    act.moveToElement(progressBar).moveByOffset((width/2)-2, 0).click().perform();
	    
	    driver.switchTo().defaultContent();
	    Thread.sleep(4000);
	    waitForPageToLoad.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@ng-if='shouldShowButtonBar()']/button")));
	   // driver.findElement(By.xpath("//div[@ng-if='shouldShowButtonBar()']/button")).click();
	    driver.findElement(By.xpath("//button[@data-target='@form|button|continue']")).click();
		}else{
//First Screen completed	    
	    //int frameCount2 = driver.findElements(By.tagName("iframe")).size();
	    //System.out.println("Are you ready?"+":"+frameCount2);
	    driver.findElement(By.xpath("//button[@data-target='@form|button|continue']")).click();
		}
	    int frameCount3 = driver.findElements(By.tagName("iframe")).size();
	    System.out.println("Just so you know"+":"+frameCount3);
	    
		}
	    Thread.sleep(30000);
		driver.close();
	}

}
