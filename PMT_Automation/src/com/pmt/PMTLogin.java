package com.pmt;

import org.jboss.aerogear.security.otp.Totp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PMTLogin {

public static void main(String[] args) throws Throwable {
		
		System.setProperty("webdriver.chrome.driver","D:\\jar\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://pmtcot.joinallofus.org");
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("pdaundkar@vignetcorp.com");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Password@01");
		
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		WebDriverWait authenicationWait = new WebDriverWait(driver, 50);
		authenicationWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='enter6DigitCode']")));
		
		String otpKeyStr = "FUWRFIPHMI67BQNE";
		Totp totp = new Totp(otpKeyStr);
		String twoFactorCode = totp.now();
		driver.findElement(By.xpath("//input[@name='enter6DigitCode']")).sendKeys(twoFactorCode);
		driver.findElement(By.xpath("//input[@value='Submit']")).click();
		Thread.sleep(15000);
		
		
/*		WebDriverWait authenicationWait = new WebDriverWait(driver, 50);
		authenicationWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value='Submit']")));
		
		driver.findElement(By.xpath("//input[@value='Submit']")).click();
Selecting the Enterprise actors
		
		WebDriverWait wiat = new WebDriverWait(driver, 50);
		wiat.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button#manager-account.dropdown-toggle.btn.btn-default")));
		driver.findElement(By.cssSelector("button#manager-account.dropdown-toggle.btn.btn-default")).click();
		
		for(int i=1; i<=9;i++){
			System.out.println(driver.findElement(By.xpath("//ul[@aria-labelledby='manager-account']/li["+i+"]")).getText());
		}
		Communication and Engagement Manager
		//driver.findElement(By.xpath("//ul[@aria-labelledby='manager-account']/li[1]")).click();
		Program Coordinator
		//driver.findElement(By.xpath("//ul[@aria-labelledby='manager-account']/li[2]")).click();

		 Program Manager
		//driver.findElement(By.xpath("//ul[@aria-labelledby='manager-account']/li[3]")).click();

		Research Assistant
		//driver.findElement(By.xpath("//ul[@aria-labelledby='manager-account']/li[4]")).click();

		Site Manager
		//driver.findElement(By.xpath("//ul[@aria-labelledby='manager-account']/li[5]")).click();

		Support Admin	
		
		driver.findElement(By.xpath("//ul[@aria-labelledby='manager-account']/li[6]")).click();
		System.out.println("Enterprise User:"+driver.findElement(By.xpath("//ul[@aria-labelledby='manager-account']/li[6]")));
		//driver.findElement(By.xpath("//li[@role='presentation'][6]")).click();

		Thread.sleep(10000);
		driver.close();*/
/*Click on HELPDESK and then tap on cancel*/
		//driver.findElement(By.cssSelector("//span[@class='help-desk-label']")).click();
/*		driver.findElement(By.xpath("//div/div//span[@class='help-desk-label']")).click();
		driver.findElement(By.xpath("//div/div/form/div[3]/button[1]")).click();
		3
		System.out.println("COMPLETED");
		
		driver.findElement(By.xpath("//*[@id='root']/div/div/div/div[1]/nav/div/div[2]/ul/div/div[1]/button")).click();
*/	}

	public static WebDriver accountManagement(WebDriver driver){
		WebDriverWait accountMgmtDelay = new WebDriverWait(driver, 80);
		accountMgmtDelay.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.dropdown-toggle.btn.btn-default")));

		driver.findElement(By.cssSelector("button.dropdown-toggle.btn.btn-default")).click();
		driver.findElement(By.xpath("//div/div[2]/ul/li[1]")).click();
		System.out.println(driver.findElement(By.xpath("//div/div/div/h1")).getText());
		return driver;
	}
	
	public static WebDriver pmtLogout(WebDriver driver){
		driver.findElement(By.cssSelector("button.dropdown-toggle.btn.btn-default")).click();
		driver.findElement(By.xpath("//div/div[2]/ul/li[2]")).click();
		return driver;
	}
}
