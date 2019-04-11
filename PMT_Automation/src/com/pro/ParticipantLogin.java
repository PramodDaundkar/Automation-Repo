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
		System.out.println(driver.findElement(By.xpath("//div/div//div[@aria-label='Welcome']")).getText());
		
		driver.switchTo().frame(0);
		waitForPageToLoad.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@id='player']/div/div[4]/button")));
		driver.findElement(By.xpath("//div[@id='player']/div/div[4]/button")).click();
		
		/*driver.findElement(By.xpath("//div[@class='ytp-progress-bar-container']/div[1]"));

		Actions actions = new Actions(driver);
		
		actions.keyDown(Keys.SHIFT.ARROW_RIGHT).build().perform();
*/		
		Thread.sleep(15000);
		driver.close();
	}

}
