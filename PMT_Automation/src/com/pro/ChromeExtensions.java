package com.pro;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ChromeExtensions {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\jar\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addExtensions(new File("D:\\jar\\bhghoamapcdpbohphigoooaddinpkbai.zip"));
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		  capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		  
		  @SuppressWarnings("deprecation")
		WebDriver driver = new ChromeDriver(capabilities);
		  driver.get("http://www.google.com");
	}

}
