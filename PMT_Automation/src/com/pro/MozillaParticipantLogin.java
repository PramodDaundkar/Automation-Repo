package com.pro;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MozillaParticipantLogin {
	
	static WebDriverWait waitForPageToLoad;
	public static void main(String[] args) throws Throwable{
		
		System.setProperty("webdriver.chrome.driver", "D:\\jar\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//System.setProperty("webdriver.gecko.driver", "D:\\jar\\firefoxDriver\\geckodriver.exe");
		//WebDriver driver = new FirefoxDriver();
		
		driver.get("https://cotsub.joinallofus.org/#/register");
		WebDriverWait waitForPageToLoad = new WebDriverWait(driver, 50);

		//driver.get("https://cotsub.joinallofus.org/#/login");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		/*waitForPageToLoad.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//vbr-input[@id='usernameEmail']/input")));
		driver.findElement(By.xpath("//vbr-input[@id='usernameEmail']/input")).sendKeys("qwertyab@gmail.com");
		driver.findElement(By.xpath("//vbr-input[@id='userPassword']/input")).sendKeys("Password@01");
		driver.findElement(By.xpath("//button[@data-target='@login|button|submit']")).click();*/
		
		waitForPageToLoad.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//input[@id='signUpEmail']")));
		driver.findElement(By.xpath("//input[@id='signUpEmail']")).sendKeys("qwertyabc@gmail.com");
		driver.findElement(By.xpath("//input[@id='signUpPassword']")).sendKeys("Password@01");
		driver.findElement(By.xpath("//button")).click();
	
		driver.findElement(By.xpath("//input[@id='answer-security-1']")).sendKeys("Qwerty");
		driver.findElement(By.xpath("//input[@id='answer-security-2']")).sendKeys("asdfgh");
		driver.findElement(By.xpath("//input[@id='answer-security-3']")).sendKeys("zxcvbn");
		
		driver.findElement(By.xpath("//button[@data-target='@registration|button|next']")).click();
		driver.findElement(By.xpath("//input[@id='answer-support-1']")).sendKeys("poiuyt");
		
		driver.findElement(By.xpath("//button[@data-target='@supportQuestion|button|submit']")).click();


		waitForPageToLoad.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div/div//div[@aria-label='Welcome']")));
		
		System.out.println(driver.findElement(By.xpath("//div/div//div[@aria-label='Welcome']")).getText());
		int frameCount = driver.findElements(By.tagName("iframe")).size();
		System.out.println("Welcome Screen"+":"+frameCount);
		
		driver.switchTo().frame("unique-youtube-embed-id-1");
		
		//waitForPageToLoad.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@id='player']/div/div[4]/button")));
		/*driver.findElement(By.xpath("//div[@id='player']/div/div[4]/button")).click();
		
		WebElement progressBar = driver.findElement(By.xpath("//div[@class='ytp-progress-bar-container']/div[1]"));
		int width = progressBar.getSize().getWidth();
		Actions act = new Actions(driver);
	    act.moveToElement(progressBar).moveByOffset((width/2)-2, 0).click().perform();*/
		
	    
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
		
		for(int j=2; j<=9;j++)
			{
			System.out.println(driver.findElement(By.xpath("//div[@ng-bind-html='labelValue']")).getText());
			driver.switchTo().frame("unique-youtube-embed-id-"+j);
				videoPlayer(driver);
			}
		
		for(int i=1; i<=16; i++)
		{
			System.out.println(driver.findElement(By.xpath("//div[@ng-bind-html='labelValue']")).getText());
			if(i==1 || i==3 || i==4)
			{
				singleFrame(driver);
			}
			if(i==2){
				driver.switchTo().frame("unique-youtube-embed-id-10");
				videoPlayer(driver);
			}
			if(i==5){
				driver.switchTo().frame("unique-youtube-embed-id-11");
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
	    
	    findaPartner(driver);
	    Thread.sleep(10000);
	    EHRConsent(driver);
	    basicSurvey(driver);
	    Thread.sleep(5000);
	    overallHealthSurvey(driver);
	    Thread.sleep(5000);
	    lifeStyleSurvey(driver);
	    
	    Thread.sleep(30000);
		driver.close();
	}
	
	public static WebDriver videoPlayer(WebDriver driver) throws Throwable{
		
		
		//driver.switchTo().frame("displayObject.fieldValue.value");
		//System.out.println("inside frame");
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
		System.out.println(driver.findElement(By.xpath("//div[@ng-bind-html='labelValue']")).getText());
		driver.findElement(By.xpath("//button[@data-target='@form|button|continue']")).click();
		return driver;
	}
	
	public static WebDriver personalDetails(WebDriver driver){
		System.out.println(driver.findElement(By.xpath("//div[@ng-bind-html='labelValue']")).getText());
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
	
	public static WebDriver cityStateZipSurvey(WebDriver driver)
	{
		WebDriverWait waitForPageToLoad = new WebDriverWait(driver, 5);
		waitForPageToLoad.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div/div[2]/div/slides/survey-card[1]/div/div/div/div[2]/div")));
		WebElement cityStateZip = driver.findElement(By.xpath("//div/div[2]/div/slides/survey-card[1]/div/div/div/div[2]/div"));
		if(cityStateZip.getText().equals("CityStateZip"))
		{
		driver.findElement(By.xpath("//div/div[2]/div/slides/survey-card[1]/div/div/div/div[2]/button")).click();
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
	public static WebDriver basicSurvey(WebDriver driver)
	{
		WebDriverWait waitForPageToLoad = new WebDriverWait(driver, 5);
		waitForPageToLoad.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div/div[2]/div/slides/survey-card[1]/div/div/div/div[2]/div")));
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
	public static WebDriver EHRConsent(WebDriver driver)
	{
		WebDriverWait waitForPageToLoad = new WebDriverWait(driver, 25);
		waitForPageToLoad.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@data-target='@banners|openForm']/div[3]/button")));
		driver.findElement(By.xpath("//div[@data-target='@banners|openForm']/div[3]/button")).click();
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
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebDriverWait waitForPageToLoad = new WebDriverWait(driver, 25);
		waitForPageToLoad.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div/div[3]//button[@data-target='@banners|openForm|button']")));
		driver.findElement(By.xpath("//div/div[3]//button[@data-target='@banners|openForm|button']")).click();
		driver.findElement(By.xpath("//button[@data-target='@form|button|continue']")).click();
		driver.findElement(By.xpath("//div[@class='table-wrap']/div[2]")).click();
		driver.findElement(By.xpath("//button[@data-target='@form|button|continue']")).click();
		driver.findElement(By.xpath("//div/div[1]/div/div/preview-sub-field-multi-select-option-value/label/div[2]")).click();
		driver.findElement(By.xpath("//button[@data-target='@form|button|continue']")).click();
		driver.findElement(By.xpath("//button[@data-target='@form|button|submit']")).click();
		return driver;
	}
	public static WebDriver overallHealthSurvey(WebDriver driver){
		WebElement overallHealth = driver.findElement(By.xpath("//div/div[2]/div/slides/survey-card[2]/div/div/div/div[2]/div"));
		System.out.println(overallHealth.getText());
		if(overallHealth.getText().equals("Overall Health")){
			driver.findElement(By.xpath("//div/div[2]/div/slides/survey-card[2]/div/div/div/div[2]/button")).click();
			driver.findElement(By.xpath("//button[@data-target='@form|button|submit']")).click();
			
			for(int i=1; i<=23; i++)
			{
				driver.findElement(By.xpath("//button[@data-target='@form|button|continue']")).click();
			}
			driver.findElement(By.xpath("//button[@data-target='@form|button|submit']")).click();
		}
		return driver;
	}
	public static WebDriver lifeStyleSurvey(WebDriver driver){
		WebElement lifestyle = driver.findElement(By.xpath("//div/div[2]/div/slides/survey-card[1]/div/div/div/div[2]/div"));
		System.out.println(lifestyle.getText());
		if(lifestyle.getText().equals("Lifestyle")){
			driver.findElement(By.xpath("//div/div[2]/div/slides/survey-card[1]/div/div/div/div[2]/button")).click();
			driver.findElement(By.xpath("//button[@data-target='@form|button|submit']")).click();
			
			for(int i=1; i<=23; i++)
			{
				driver.findElement(By.xpath("//button[@data-target='@form|button|continue']")).click();
			}
			driver.findElement(By.xpath("//button[@data-target='@form|button|submit']")).click();
		}
		return driver;
	}
}

