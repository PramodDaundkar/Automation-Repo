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

public class ParticipantLogin {

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
//First Screen completed	    
	    int frameCount2 = driver.findElements(By.tagName("iframe")).size();
	    System.out.println("Are you ready?"+":"+frameCount2);
	    driver.findElement(By.xpath("//button[@data-target='@form|button|continue']")).click();
	    int frameCount3 = driver.findElements(By.tagName("iframe")).size();
	    System.out.println("Just so you know"+":"+frameCount3);
	    
	    driver.findElement(By.xpath("//button[@data-target='@form|button|continue']")).click();
	    int frameCount4 = driver.findElements(By.tagName("iframe")).size();
	    System.out.println("You’re about to make history."+":"+frameCount4);
	    Thread.sleep(2000);
	    
	    driver.findElement(By.xpath("//button[@data-target='@form|button|continue']")).click();
	    int frameCount5 = driver.findElements(By.tagName("iframe")).size();
	    System.out.println("Where You Live."+":"+frameCount5);
	    
	    Select state = new Select(driver.findElement(By.xpath("//div[@class='ng-scope']/select")));
	    
	    state.selectByVisibleText("Arizona");
	    driver.findElement(By.xpath("//button[@data-target='@form|button|continue']")).click();
	    
	    int frameCount6 = driver.findElements(By.tagName("iframe")).size();
	    System.out.println("Before We Begin"+":"+frameCount6);
	    //This will work for Yes only as it needs to be generalise.
	    driver.findElement(By.xpath("//div[@ng-if='shouldShowText()']/div")).click();
	    driver.findElement(By.xpath("//button[@data-target='@form|button|continue']")).click();
	    
	    int frameCount7 = driver.findElements(By.tagName("iframe")).size();
	    System.out.println("Where You Get Healthcare"+":"+frameCount7);
	    Select stateHealth = new Select(driver.findElement(By.xpath("//div[@class='ng-scope']/select")));
	    stateHealth.selectByVisibleText("Arizona");
	    driver.findElement(By.xpath("//button[@data-target='@form|button|continue']")).click();
	    
	    int frameCount8 = driver.findElements(By.tagName("iframe")).size();
	    System.out.println("Check Your Understanding"+":"+frameCount8);
	    driver.findElement(By.xpath("//button[@data-target='@form|button|continue']")).click();
	    
	    int frameCount9 = driver.findElements(By.tagName("iframe")).size();
	    System.out.println("What will I do?"+":"+frameCount9);
	    driver.findElement(By.xpath("//button[@data-target='@form|button|continue']")).click();
	    
	    int frameCount10 = driver.findElements(By.tagName("iframe")).size();
	    System.out.println("Keeping in Touch"+":"+frameCount10);
	    
	    driver.switchTo().frame(0);
		waitForPageToLoad.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@id='player']/div/div[4]/button")));
		driver.findElement(By.xpath("//div[@id='player']/div/div[4]/button")).click();
		
		/* Below Code is from Stackoverflow
		 * https://stackoverflow.com/questions/40546546/how-to-click-on-a-specific-position-of-a-web-element-in-selenium/40571321#40571321
		 */
		WebElement progressBar2 = driver.findElement(By.xpath("//div[@class='ytp-progress-bar-container']/div[1]"));
		int width2 = progressBar2.getSize().getWidth();
		//Actions act2 = new Actions(driver);
	    act.moveToElement(progressBar2).moveByOffset((width2/2)-2, 0).click().perform();
	    
	    driver.switchTo().defaultContent();
	    Thread.sleep(4000);
	    waitForPageToLoad.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@ng-if='shouldShowButtonBar()']/button")));
	   // driver.findElement(By.xpath("//div[@ng-if='shouldShowButtonBar()']/button")).click();
	    driver.findElement(By.xpath("//button[@data-target='@form|button|continue']")).click();
	    
	    int frameCount11 = driver.findElements(By.tagName("iframe")).size();
	    System.out.println("Health Data"+":"+frameCount11);
	    driver.switchTo().frame(0);
		waitForPageToLoad.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@id='player']/div/div[4]/button")));
		driver.findElement(By.xpath("//div[@id='player']/div/div[4]/button")).click();
		
		/* Below Code is from Stackoverflow
		 * https://stackoverflow.com/questions/40546546/how-to-click-on-a-specific-position-of-a-web-element-in-selenium/40571321#40571321
		 */
		WebElement progressBar3 = driver.findElement(By.xpath("//div[@class='ytp-progress-bar-container']/div[1]"));
		int width3 = progressBar3.getSize().getWidth();
		//Actions act3 = new Actions(driver);
	    act.moveToElement(progressBar3).moveByOffset((width3/2)-2, 0).click().perform();
	    
	    driver.switchTo().defaultContent();
	    Thread.sleep(4000);
	    waitForPageToLoad.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@ng-if='shouldShowButtonBar()']/button")));
	   // driver.findElement(By.xpath("//div[@ng-if='shouldShowButtonBar()']/button")).click();
	    driver.findElement(By.xpath("//button[@data-target='@form|button|continue']")).click();
	    	    
	    int frameCount12 = driver.findElements(By.tagName("iframe")).size();
	    System.out.println("Health Record"+":"+frameCount12);
	    driver.switchTo().frame(0);
		waitForPageToLoad.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@id='player']/div/div[4]/button")));
		driver.findElement(By.xpath("//div[@id='player']/div/div[4]/button")).click();
		
		/* Below Code is from Stackoverflow
		 * https://stackoverflow.com/questions/40546546/how-to-click-on-a-specific-position-of-a-web-element-in-selenium/40571321#40571321
		 */
		WebElement progressBar4 = driver.findElement(By.xpath("//div[@class='ytp-progress-bar-container']/div[1]"));
		int width4 = progressBar4.getSize().getWidth();
		//Actions act4 = new Actions(driver);
	    act.moveToElement(progressBar4).moveByOffset((width4/2)-2, 0).click().perform();
	    
	    driver.switchTo().defaultContent();
	    Thread.sleep(4000);
	    waitForPageToLoad.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@ng-if='shouldShowButtonBar()']/button")));
	   // driver.findElement(By.xpath("//div[@ng-if='shouldShowButtonBar()']/button")).click();
	    driver.findElement(By.xpath("//button[@data-target='@form|button|continue']")).click();
	    
	    
	    int frameCount13 = driver.findElements(By.tagName("iframe")).size();
	    System.out.println("Physical Measurements"+":"+frameCount13);
	    driver.switchTo().frame(0);
		waitForPageToLoad.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@id='player']/div/div[4]/button")));
		driver.findElement(By.xpath("//div[@id='player']/div/div[4]/button")).click();
		
		/* Below Code is from Stackoverflow
		 * https://stackoverflow.com/questions/40546546/how-to-click-on-a-specific-position-of-a-web-element-in-selenium/40571321#40571321
		 */
		WebElement progressBar5 = driver.findElement(By.xpath("//div[@class='ytp-progress-bar-container']/div[1]"));
		int width5 = progressBar5.getSize().getWidth();
		//Actions act5 = new Actions(driver);
	    act.moveToElement(progressBar5).moveByOffset((width5/2)-2, 0).click().perform();
	    
	    driver.switchTo().defaultContent();
	    Thread.sleep(4000);
	    waitForPageToLoad.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@ng-if='shouldShowButtonBar()']/button")));
	   // driver.findElement(By.xpath("//div[@ng-if='shouldShowButtonBar()']/button")).click();
	    driver.findElement(By.xpath("//button[@data-target='@form|button|continue']")).click();
	   
	    int frameCount14 = driver.findElements(By.tagName("iframe")).size();
	    System.out.println("Samples"+":"+frameCount14);
	    driver.switchTo().frame(0);
		waitForPageToLoad.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@id='player']/div/div[4]/button")));
		driver.findElement(By.xpath("//div[@id='player']/div/div[4]/button")).click();
		
		/* Below Code is from Stackoverflow
		 * https://stackoverflow.com/questions/40546546/how-to-click-on-a-specific-position-of-a-web-element-in-selenium/40571321#40571321
		 */
		WebElement progressBar6 = driver.findElement(By.xpath("//div[@class='ytp-progress-bar-container']/div[1]"));
		int width6 = progressBar6.getSize().getWidth();
		//Actions act6 = new Actions(driver);
	    act.moveToElement(progressBar6).moveByOffset((width6/2)-2, 0).click().perform();
	    
	    driver.switchTo().defaultContent();
	    Thread.sleep(4000);
	    waitForPageToLoad.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@ng-if='shouldShowButtonBar()']/button")));
	   // driver.findElement(By.xpath("//div[@ng-if='shouldShowButtonBar()']/button")).click();
	    driver.findElement(By.xpath("//button[@data-target='@form|button|continue']")).click();
	    
	    
	    int frameCount15 = driver.findElements(By.tagName("iframe")).size();
	    System.out.println("DNA Analysis"+":"+frameCount15);
	    driver.switchTo().frame(0);
		waitForPageToLoad.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@id='player']/div/div[4]/button")));
		driver.findElement(By.xpath("//div[@id='player']/div/div[4]/button")).click();
		
		/* Below Code is from Stackoverflow
		 * https://stackoverflow.com/questions/40546546/how-to-click-on-a-specific-position-of-a-web-element-in-selenium/40571321#40571321
		 */
		WebElement progressBar7 = driver.findElement(By.xpath("//div[@class='ytp-progress-bar-container']/div[1]"));
		int width7 = progressBar7.getSize().getWidth();
		//Actions act7 = new Actions(driver);
	    act.moveToElement(progressBar7).moveByOffset((width7/2)-2, 0).click().perform();
	    
	    driver.switchTo().defaultContent();
	    Thread.sleep(4000);
	    waitForPageToLoad.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@ng-if='shouldShowButtonBar()']/button")));
	   // driver.findElement(By.xpath("//div[@ng-if='shouldShowButtonBar()']/button")).click();
	    driver.findElement(By.xpath("//button[@data-target='@form|button|continue']")).click();
	    
	    
	    int frameCount16 = driver.findElements(By.tagName("iframe")).size();
	    System.out.println("Fitness Tracker"+":"+frameCount16);
	    driver.switchTo().frame(0);
		waitForPageToLoad.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@id='player']/div/div[4]/button")));
		driver.findElement(By.xpath("//div[@id='player']/div/div[4]/button")).click();
		
		/* Below Code is from Stackoverflow
		 * https://stackoverflow.com/questions/40546546/how-to-click-on-a-specific-position-of-a-web-element-in-selenium/40571321#40571321
		 */
		WebElement progressBar8 = driver.findElement(By.xpath("//div[@class='ytp-progress-bar-container']/div[1]"));
		int width8 = progressBar8.getSize().getWidth();
		//Actions act8 = new Actions(driver);
	    act.moveToElement(progressBar8).moveByOffset((width8/2)-2, 0).click().perform();
	    
	    driver.switchTo().defaultContent();
	    Thread.sleep(4000);
	    waitForPageToLoad.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@ng-if='shouldShowButtonBar()']/button")));
	   // driver.findElement(By.xpath("//div[@ng-if='shouldShowButtonBar()']/button")).click();
	    driver.findElement(By.xpath("//button[@data-target='@form|button|continue']")).click();
	    
	    int frameCount17 = driver.findElements(By.tagName("iframe")).size();
	    System.out.println("Other Health Data"+":"+frameCount17);
	    driver.switchTo().frame(0);
		waitForPageToLoad.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@id='player']/div/div[4]/button")));
		driver.findElement(By.xpath("//div[@id='player']/div/div[4]/button")).click();
		WebElement progressBar9 = driver.findElement(By.xpath("//div[@class='ytp-progress-bar-container']/div[1]"));
		int width9 = progressBar9.getSize().getWidth();
		act.moveToElement(progressBar9).moveByOffset((width9/2)-2, 0).click().perform();
	    driver.switchTo().defaultContent();
	    Thread.sleep(4000);
	    waitForPageToLoad.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@ng-if='shouldShowButtonBar()']/button")));
	    driver.findElement(By.xpath("//button[@data-target='@form|button|continue']")).click();
	    
	    
	    int frameCount18 = driver.findElements(By.tagName("iframe")).size();
	    System.out.println("What will we do?"+":"+frameCount18);
	    waitForPageToLoad.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@ng-if='shouldShowButtonBar()']/button")));
	    driver.findElement(By.xpath("//button[@data-target='@form|button|continue']")).click();
	    
	    int frameCount19 = driver.findElements(By.tagName("iframe")).size();
	    System.out.println("Data Sharing"+":"+frameCount19);
	    driver.switchTo().frame(0);
		waitForPageToLoad.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@id='player']/div/div[4]/button")));
		driver.findElement(By.xpath("//div[@id='player']/div/div[4]/button")).click();
		WebElement progressBar10 = driver.findElement(By.xpath("//div[@class='ytp-progress-bar-container']/div[1]"));
		int width10 = progressBar10.getSize().getWidth();
		act.moveToElement(progressBar10).moveByOffset((width10/2)-2, 0).click().perform();
	    driver.switchTo().defaultContent();
	    Thread.sleep(4000);
	    waitForPageToLoad.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@ng-if='shouldShowButtonBar()']/button")));
	    driver.findElement(By.xpath("//button[@data-target='@form|button|continue']")).click();
	    
	    int frameCount20 = driver.findElements(By.tagName("iframe")).size();
	    System.out.println("Potential Benefits"+":"+frameCount20);
	    waitForPageToLoad.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@ng-if='shouldShowButtonBar()']/button")));
	    driver.findElement(By.xpath("//button[@data-target='@form|button|continue']")).click();
	    
	    int frameCount21 = driver.findElements(By.tagName("iframe")).size();
	    System.out.println("Other Benefits"+":"+frameCount21);
	    waitForPageToLoad.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@ng-if='shouldShowButtonBar()']/button")));
	    driver.findElement(By.xpath("//button[@data-target='@form|button|continue']")).click();
	    
	    int frameCount22 = driver.findElements(By.tagName("iframe")).size();
	    System.out.println("Risk To Privacy"+":"+frameCount22);
	    driver.switchTo().frame(0);
		waitForPageToLoad.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@id='player']/div/div[4]/button")));
		driver.findElement(By.xpath("//div[@id='player']/div/div[4]/button")).click();
		WebElement progressBar11 = driver.findElement(By.xpath("//div[@class='ytp-progress-bar-container']/div[1]"));
		int width11 = progressBar11.getSize().getWidth();
		act.moveToElement(progressBar11).moveByOffset((width10/2)-2, 0).click().perform();
	    driver.switchTo().defaultContent();
	    Thread.sleep(4000);
	    waitForPageToLoad.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@ng-if='shouldShowButtonBar()']/button")));
	    driver.findElement(By.xpath("//button[@data-target='@form|button|continue']")).click();
	    
	    int frameCount23 = driver.findElements(By.tagName("iframe")).size();
	    System.out.println("Not Medical Care"+":"+frameCount23);
	    waitForPageToLoad.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@ng-if='shouldShowButtonBar()']/button")));
	    driver.findElement(By.xpath("//button[@data-target='@form|button|continue']")).click();
	    
	    int frameCount24 = driver.findElements(By.tagName("iframe")).size();
	    System.out.println("You Get To Choose"+":"+frameCount24);
	    waitForPageToLoad.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@ng-if='shouldShowButtonBar()']/button")));
	    driver.findElement(By.xpath("//button[@data-target='@form|button|continue']")).click();
	    
	    int frameCount25 = driver.findElements(By.tagName("iframe")).size();
	    System.out.println("If You Withdraw"+":"+frameCount25);
	    waitForPageToLoad.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@ng-if='shouldShowButtonBar()']/button")));
	    driver.findElement(By.xpath("//button[@data-target='@form|button|continue']")).click();
	    
	    int frameCount26 = driver.findElements(By.tagName("iframe")).size();
	    System.out.println("Think It Over"+":"+frameCount26);
	    waitForPageToLoad.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@ng-if='shouldShowButtonBar()']/button")));
	    driver.findElement(By.xpath("//button[@data-target='@form|button|continue']")).click();
	    
	    int frameCount27 = driver.findElements(By.tagName("iframe")).size();
	    System.out.println("No title Screen"+":"+frameCount27);
	    System.out.println(driver.findElement(By.xpath("//div[@ng-bind-html='labelValue']")).getText());
	    waitForPageToLoad.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@ng-if='shouldShowButtonBar()']/button")));
	    driver.findElement(By.xpath("//button[@data-target='@form|button|continue']")).click();
	    
	    
	    int frameCount28 = driver.findElements(By.tagName("iframe")).size();
	    System.out.println("Consent to Join the"+":"+frameCount28);
	    //System.out.println(driver.findElement(By.xpath("//div[@ng-bind-html='labelValue']")).getText());
	    waitForPageToLoad.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@ng-if='shouldShowButtonBar()']/button")));
	    driver.findElement(By.xpath("//button[@data-target='@form|button|continue']")).click();
	    
	    int frameCount29 = driver.findElements(By.tagName("iframe")).size();
	    System.out.println("Are you ready?"+":"+frameCount29);
	    //System.out.println(driver.findElement(By.xpath("//div[@ng-bind-html='labelValue']")).getText());
	    waitForPageToLoad.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@ng-if='shouldShowButtonBar()']/button")));
	    driver.findElement(By.xpath("//button[@data-target='@form|button|continue']")).click();
	    
	    int frameCount30 = driver.findElements(By.tagName("iframe")).size();
	    System.out.println("Quiz Page 1"+":"+frameCount30);
	    //System.out.println(driver.findElement(By.xpath("//div[@ng-bind-html='labelValue']")).getText());
	    waitForPageToLoad.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@ng-if='shouldShowButtonBar()']/button")));
	    driver.findElement(By.xpath("//button[@data-target='@form|button|continue']")).click();
	    
	    int frameCount31 = driver.findElements(By.tagName("iframe")).size();
	    System.out.println("Quiz Page 2"+":"+frameCount31);
	    //System.out.println(driver.findElement(By.xpath("//div[@ng-bind-html='labelValue']")).getText());
	    waitForPageToLoad.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@ng-if='shouldShowButtonBar()']/button")));
	    driver.findElement(By.xpath("//button[@data-target='@form|button|continue']")).click();
	    
	    int frameCount32 = driver.findElements(By.tagName("iframe")).size();
	    System.out.println("Quiz Page 3"+":"+frameCount32);
	    //System.out.println(driver.findElement(By.xpath("//div[@ng-bind-html='labelValue']")).getText());
	    waitForPageToLoad.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@ng-if='shouldShowButtonBar()']/button")));
	    driver.findElement(By.xpath("//button[@data-target='@form|button|continue']")).click();
	    
	    int frameCount33 = driver.findElements(By.tagName("iframe")).size();
	    System.out.println("Quiz Page 4"+":"+frameCount33);
	    //System.out.println(driver.findElement(By.xpath("//div[@ng-bind-html='labelValue']")).getText());
	    waitForPageToLoad.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@ng-if='shouldShowButtonBar()']/button")));
	    driver.findElement(By.xpath("//button[@data-target='@form|button|continue']")).click();
	    
	    int frameCount34 = driver.findElements(By.tagName("iframe")).size();
	    System.out.println("Quiz Page 5"+":"+frameCount34);
	    //System.out.println(driver.findElement(By.xpath("//div[@ng-bind-html='labelValue']")).getText());
	    waitForPageToLoad.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@ng-if='shouldShowButtonBar()']/button")));
	    driver.findElement(By.xpath("//button[@data-target='@form|button|continue']")).click();
	    
	    int frameCount35 = driver.findElements(By.tagName("iframe")).size();
	    System.out.println("UNdertaking Statement"+":"+frameCount35);
	    //System.out.println(driver.findElement(By.xpath("//div[@ng-bind-html='labelValue']")).getText());
	    waitForPageToLoad.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@ng-if='shouldShowButtonBar()']/button")));
	    driver.findElement(By.xpath("//div[@ng-if='shouldShowLeftImage()']")).click();
	    driver.findElement(By.xpath("//button[@data-target='@form|button|continue']")).click();
	    
	    
	    int frameCount36 = driver.findElements(By.tagName("iframe")).size();
	    System.out.println("UNdertaking Statement"+":"+frameCount36);
	    driver.findElement(By.xpath("//div/div/div[2]/label/input")).click();
	    driver.findElement(By.xpath("//div[@ng-style='displayObject.cssStyles']/input")).sendKeys("asdfgh");
	    
	    //System.out.println(driver.findElement(By.xpath("//div[@ng-bind-html='labelValue']")).getText());
	    waitForPageToLoad.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@ng-if='shouldShowButtonBar()']/button")));
	    //driver.findElement(By.xpath("//div[@ng-if='shouldShowLeftImage()']")).click();
	    driver.findElement(By.xpath("//button[@data-target='@form|button|continue']")).click();
	    
	    String yes = driver.findElement(By.xpath("//div[@ng-if='shouldShowLeftImage()']")).getText();
	    if(yes.equals("Yes"))
	    {
	    	driver.findElement(By.xpath("//input[@aria-label='Name of the person who helped you']")).sendKeys("PRAMOD");
	    }else
	    {
	    	driver.findElement(By.xpath("//button[@data-target='@form|button|continue']")).click();
	    }
	    
	    
	    /*int frameCount25 = driver.findElements(By.tagName("iframe")).size();
	    System.out.println("Risk To Privacy"+":"+frameCount25);
	    driver.switchTo().frame(0);
		waitForPageToLoad.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@id='player']/div/div[4]/button")));
		driver.findElement(By.xpath("//div[@id='player']/div/div[4]/button")).click();
		WebElement progressBar12 = driver.findElement(By.xpath("//div[@class='ytp-progress-bar-container']/div[1]"));
		int width12 = progressBar12.getSize().getWidth();
		act.moveToElement(progressBar12).moveByOffset((width12/2)-2, 0).click().perform();
	    driver.switchTo().defaultContent();
	    Thread.sleep(4000);
	    waitForPageToLoad.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@ng-if='shouldShowButtonBar()']/button")));
	    driver.findElement(By.xpath("//button[@data-target='@form|button|continue']")).click();
	    
	    int frameCount26 = driver.findElements(By.tagName("iframe")).size();
	    System.out.println("Not Medical Care"+":"+frameCount26);
	    waitForPageToLoad.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@ng-if='shouldShowButtonBar()']/button")));
	    driver.findElement(By.xpath("//button[@data-target='@form|button|continue']")).click();
	    
	    int frameCount27 = driver.findElements(By.tagName("iframe")).size();
	    System.out.println("You Get To Choose"+":"+frameCount27);
	    waitForPageToLoad.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@ng-if='shouldShowButtonBar()']/button")));
	    driver.findElement(By.xpath("//button[@data-target='@form|button|continue']")).click();
	    
	    int frameCount28 = driver.findElements(By.tagName("iframe")).size();
	    System.out.println("If You Withdraw"+":"+frameCount28);
	    waitForPageToLoad.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@ng-if='shouldShowButtonBar()']/button")));
	    driver.findElement(By.xpath("//button[@data-target='@form|button|continue']")).click();
	    
	    int frameCount29 = driver.findElements(By.tagName("iframe")).size();
	    System.out.println("Think It Over"+":"+frameCount29);
	    waitForPageToLoad.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@ng-if='shouldShowButtonBar()']/button")));
	    driver.findElement(By.xpath("//button[@data-target='@form|button|continue']")).click();
	    
	    int frameCount30 = driver.findElements(By.tagName("iframe")).size();
	    System.out.println("No title Screen"+":"+frameCount30);
	    System.out.println(driver.findElement(By.xpath("//div[@ng-bind-html='labelValue']")).getText());
	    waitForPageToLoad.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@ng-if='shouldShowButtonBar()']/button")));
	    driver.findElement(By.xpath("//button[@data-target='@form|button|continue']")).click();
	    
	    
	    waitForPageToLoad.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@ng-if='shouldShowButtonBar()']/button")));
	    driver.findElement(By.xpath("//button[@data-target='@form|button|continue']")).click();*/
	    
	    Thread.sleep(30000);
		driver.close();
	}

}
