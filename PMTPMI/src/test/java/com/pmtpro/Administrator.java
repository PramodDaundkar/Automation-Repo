package com.pmtpro;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Administrator {

	public static void main(String[] args) throws Throwable {
		
		System.setProperty("webdriver.chrome.driver", "D:\\jar\\ChromeDriver\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://pmtcot.joinallofus.org/login");
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("pdaundkar@vignetcorp.com");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Password@01");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(8000);
		driver.findElement(By.xpath("//input[@value='Submit']")).click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		String userRoleAdministartor = driver.findElement(By.xpath("//div/div[3]/button/span[1]")).getText();
		System.out.println(userRoleAdministartor);
		/*if(userRoleAdministartor.equalsIgnoreCase("Administrator"))
		{
			System.out.println("Title:"+driver.findElement(By.xpath("//div/div[2]/div/div/h1")).getText());
			WebElement element = driver.findElement(By.xpath("//span[@class='new-user-span']"));
			
			//driver.findElement(By.xpath("//div[@class='col-xs-2']/a/span")).click();
			driver.findElement(By.xpath("//form/div/div/div[1]/input")).sendKeys("Pramod");
			driver.findElement(By.xpath("//form/div/div/div[2]//input[@type='text']")).sendKeys("Daundkar");
			driver.findElement(By.xpath("//form/div/div/div[3]/input")).sendKeys("pdaundkar9@gmail.com");
			driver.findElement(By.xpath("//div/div/div/div/div//input[@aria-activedescendant='react-select-3--value']")).click();
			driver.findElement(By.xpath("//div/div/div/div/div//input[@aria-activedescendant='react-select-3--option-2']")).click();	
		}*/
		WebElement element = driver.findElement(By.xpath("//div/fieldset/div/input"));
		element.sendKeys("pdaundkar");
		element.sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//tbody/tr/td[6]/div/div/button/span")).click();
		driver.findElement(By.xpath("//tbody/tr/td[6]/div/div/ul/li[1]")).click();
		
		
		Thread.sleep(15000);
		driver.close();
		}

}
