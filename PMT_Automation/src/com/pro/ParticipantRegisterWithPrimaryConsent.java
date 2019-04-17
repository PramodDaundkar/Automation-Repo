package com.pro;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ParticipantRegisterWithPrimaryConsent {

	public static void main(String[] args) throws Throwable {
		System.setProperty("webdriver.chrome.driver", "D:\\jar\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://pmiqasub.joinallofus.org/#/register");
		
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='signUpEmail']")).sendKeys("Qwertyjun@gmail.com");
		driver.findElement(By.xpath("//input[@id='signUpPassword']")).sendKeys("Password@01");
		driver.findElement(By.xpath("//button")).click();
		
		driver.findElement(By.xpath("//input[@id='answer-security-1']")).sendKeys("Qwerty");
		driver.findElement(By.xpath("//input[@id='answer-security-2']")).sendKeys("asdfgh");
		driver.findElement(By.xpath("//input[@id='answer-security-3']")).sendKeys("zxcvbn");
		
		driver.findElement(By.xpath("//button[@data-target='@registration|button|next']")).click();
		driver.findElement(By.xpath("//input[@id='answer-support-1']")).sendKeys("poiuyt");
		
		driver.findElement(By.xpath("//button[@data-target='@supportQuestion|button|submit']")).click();
		
		WebDriverWait waitForPageToLoad = new WebDriverWait(driver, 50);
		waitForPageToLoad.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div/div//div[@aria-label='Welcome']")));

// Primary Consent: Welcome Screen
		System.out.println(driver.findElement(By.xpath("//div/div//div[@aria-label='Welcome']")).getText());
		int frameCount = driver.findElements(By.tagName("iframe")).size();
		System.out.println("Welcome Screen"+":"+frameCount);
		
		videoPlayer(driver);
		
		for(int i=0; i<=8; i++)
		{
			System.out.println(driver.findElement(By.xpath("//div[@ng-bind-html='labelValue']")).getText());
			if(i==3)
					Thread.sleep(2000);
					
			if(i==4){
						Select state = new Select(driver.findElement(By.xpath("//div[@class='ng-scope']/select")));
					    state.selectByVisibleText("Arizona");
					}
			if(i==5){
				 driver.findElement(By.xpath("//div[@ng-if='shouldShowText()']/div")).click();
			}
			if(i==6){
				Select stateHealth = new Select(driver.findElement(By.xpath("//div[@class='ng-scope']/select")));
			    stateHealth.selectByVisibleText("Arizona");
			}
			singleFrame(driver);
		}
		
		for(int j=1; j<=8;j++)
			{
				videoPlayer(driver);
			}
		
		for(int i=1; i<=16; i++)
		{
			if(i==1 || i==3 || i==4)
			{
				singleFrame(driver);
			}
			if(i==2 || i==5){
			
			videoPlayer(driver);
			}
			singleFrame(driver);
		}
		
		waitForPageToLoad.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@ng-if='shouldShowButtonBar()']/button")));
	    driver.findElement(By.xpath("//div[@ng-if='shouldShowLeftImage()']")).click();
	    driver.findElement(By.xpath("//button[@data-target='@form|button|continue']")).click();
		
		driver.findElement(By.xpath("//div/div/div[2]/label/input")).click();
	    driver.findElement(By.xpath("//div[@ng-style='displayObject.cssStyles']/input")).sendKeys("asdfgh");
	    
	    //System.out.println(driver.findElement(By.xpath("//div[@ng-bind-html='labelValue']")).getText());
	    waitForPageToLoad.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@ng-if='shouldShowButtonBar()']/button")));
	    //driver.findElement(By.xpath("//div[@ng-if='shouldShowLeftImage()']")).click();
	    //driver.findElement(By.xpath("//button[@data-target='@form|button|continue']")).click();
	    singleFrame(driver);
	    driver.findElement(By.xpath("//div[@class='table-wrap']/div[2]")).click();
	    singleFrame(driver);
	    //driver.findElement(By.xpath("//button[@data-target='@form|button|continue']")).click();
	    
	    personalDetails(driver);
	    driver.findElement(By.xpath("//button[@data-target='@form|button|submit']")).click();
	    
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
	
	public static WebDriver personalDetails(WebDriver driver){
		driver.findElement(By.xpath("//input[@aria-label='first name']")).sendKeys("Qwerty");
		driver.findElement(By.xpath("//input[@aria-label='last name']")).sendKeys("Asdfg");
		driver.findElement(By.xpath("//input[@aria-label='address 1']")).sendKeys("Zxcvb");
		driver.findElement(By.xpath("//input[@aria-label='address 2']")).sendKeys("QWERTYU");
		driver.findElement(By.xpath("//input[@aria-label='city']")).sendKeys("Las Vegas");
		
		Select stateSelect = new Select(driver.findElement(By.xpath("//select")));
		stateSelect.selectByVisibleText("Arizona");
		
		driver.findElement(By.xpath("//input[@aria-label='zip code']")).sendKeys("88901");
		driver.findElement(By.xpath("//input[@aria-label='phone number']")).sendKeys("9725360124");
		driver.findElement(By.xpath("//input[@ui-mask-placeholder='mm/dd/yyyy']")).sendKeys("05/05/1972");
		driver.findElement(By.xpath("//button[@data-target='@form|button|continue']")).click();	
		return driver;
	}
}
