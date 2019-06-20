package com.pmtpro;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProgramManager {

	public static void main(String[] args) throws Throwable {
System.setProperty("webdriver.chrome.driver", "D:\\jar\\ChromeDriver\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://pmtqa.joinallofus.org/login");
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("pdaundkar@vignetcorp.com");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Password@01");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(12000);
		driver.findElement(By.xpath("//input[@value='Submit']")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div/div[2]/ul/div/div[3]/button/span[2]")).click();
		WebElement programManager = driver.findElement(By.xpath("//ul[@aria-labelledby='manager-account']/li[5]"));
		System.out.println(programManager.getText());
		if(programManager.getText().equalsIgnoreCase("Program Manager")){
			System.out.println("Program Manager is Correct");
			driver.findElement(By.xpath("//ul[@aria-labelledby='manager-account']/li[5]")).click();
		}
		else
			System.out.println("Wrong role");
		
		System.out.println(driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div[2]/nav/ul/li[4]/a/span")).getText());
		WebElement element = driver.findElement(By.xpath("//div/div/nav/ul/li[4]/a"));
		Actions actions = new Actions(driver);
		actions.moveToElement(element).click().build().perform();
		
		WebElement appointmentSchedular = driver.findElement(By.xpath("//div/div/div/div/h1"));
		WebDriverWait wait = new WebDriverWait(driver, 40);
		
		driver.findElement(By.xpath("//div[@class='content-module-wrapper']/ul/li[2]")).click();
		driver.findElement(By.xpath("//div/div[2]/div[2]/button[1]")).click();
		
		//Create New Prospects
		
		driver.findElement(By.xpath("//input[@label='First Name']")).sendKeys("PramodCOT");
		driver.findElement(By.xpath("//input[@label='Last Name']")).sendKeys("PramodCOT");
		driver.findElement(By.xpath("//input[@label='DOB (MM/DD/YYYY)']")).sendKeys("06/06/1990");
		driver.findElement(By.xpath("//input[@label='Phone Number']")).sendKeys("9685682141");
		driver.findElement(By.xpath("//input[@label='Email Address']")).sendKeys("vibrentqa+pramodA_QA@gmail.com");
		driver.findElement(By.xpath("//span[@class='colored-checkbox-checkmark']")).click();
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div[4]/div/div/div/div/div[2]/div[2]/button")).click();
		
		// Scheduling an appointment for the New Prospects
		driver.findElement(By.xpath("//div[@class='col-sm-12']/textarea")).sendKeys("qwertyuiop");
		driver.findElement(By.xpath("//div/button[2]/span")).click();
		
		WebElement elem = driver.findElement(By.xpath("//div[@class='week-wrapper']/div[1]/span[2]"));
		if(!elem.isEnabled()) {
			System.out.println(elem.getText());
		}
		//printing the Date of appointment
		System.out.println(driver.findElement(By.xpath("//div[@class='day-view-header']")).getText());
		
		//click on the Afternoon time slot
		driver.findElement(By.xpath("//ul[@role='tablist']/li[2]")).click();
		
		//click on the avaiable time slot
		driver.findElement(By.xpath("//div/div[2]/div[5]")).click();
		
		//click on schedule button
		driver.findElement(By.xpath("//div[@class='col-xs-7']/button")).click();
			
		Thread.sleep(10000);
		driver.close();

	}

}
