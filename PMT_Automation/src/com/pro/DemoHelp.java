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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DemoHelp {
	static WebDriver driver;
	static WebDriverWait waitForPageToLoad;
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
		
		videoPlayer(driver);
		
//First Screen completed	    
	    int frameCount2 = driver.findElements(By.tagName("iframe")).size();
	    System.out.println("Are you ready?"+":"+frameCount2);
	    singleFrame(driver);
	    
	    int frameCount3 = driver.findElements(By.tagName("iframe")).size();
	    System.out.println("Just so you know"+":"+frameCount3);
	    singleFrame(driver);
	    
	    int frameCount4 = driver.findElements(By.tagName("iframe")).size();
	    System.out.println("You’re about to make history."+":"+frameCount4);
	    Thread.sleep(2000);
	    singleFrame(driver);
	    
	    int frameCount5 = driver.findElements(By.tagName("iframe")).size();
	    System.out.println("Where You Live."+":"+frameCount5);
	    Select state = new Select(driver.findElement(By.xpath("//div[@class='ng-scope']/select")));
	    state.selectByVisibleText("Arizona");
	    singleFrame(driver);
	    
	    int frameCount6 = driver.findElements(By.tagName("iframe")).size();
	    System.out.println("Before We Begin"+":"+frameCount6);
	    //This will work for Yes only as it needs to be generalise.
	    driver.findElement(By.xpath("//div[@ng-if='shouldShowText()']/div")).click();
	    singleFrame(driver);
	    
	    int frameCount7 = driver.findElements(By.tagName("iframe")).size();
	    System.out.println("Where You Get Healthcare"+":"+frameCount7);
	    Select stateHealth = new Select(driver.findElement(By.xpath("//div[@class='ng-scope']/select")));
	    stateHealth.selectByVisibleText("Arizona");
	    singleFrame(driver);
	    
	    int frameCount8 = driver.findElements(By.tagName("iframe")).size();
	    System.out.println("Check Your Understanding"+":"+frameCount8);
	    driver.findElement(By.xpath("//button[@data-target='@form|button|continue']")).click();
	    
	    int frameCount9 = driver.findElements(By.tagName("iframe")).size();
	    System.out.println("What will I do?"+":"+frameCount9);
	    driver.findElement(By.xpath("//button[@data-target='@form|button|continue']")).click();
	    
	   
	    Thread.sleep(30000);
		driver.close();
	}
	
	public static WebDriver videoPlayer(WebDriver driver) throws Throwable{
		driver.switchTo().frame(0);
		WebDriverWait waitForPageToLoad = new WebDriverWait(driver, 50);
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
	    return driver;
	}

	public static WebDriver singleFrame(WebDriver driver){
		driver.findElement(By.xpath("//button[@data-target='@form|button|continue']")).click();
		return driver;
	}
}
