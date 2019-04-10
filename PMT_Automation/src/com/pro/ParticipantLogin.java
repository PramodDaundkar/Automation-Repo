package com.pro;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ParticipantLogin {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "D:\\jar\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://pmiqasub.joinallofus.org/#/login");
		
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//form/div[2]/div[5]")).click();
		driver.findElement(By.xpath("//input[@id='signUpEmail']")).sendKeys("qwertyu@gmail.com");
		driver.findElement(By.xpath("//input[@id='signUpPassword']")).sendKeys("Password@01");
		driver.findElement(By.xpath("//button[@data-target='@registration|button|next']")).click();

	}

}
