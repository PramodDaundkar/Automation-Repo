package com.pro;

import java.io.File;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ChromeExtensionsExample {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\jar\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		
	
		options.addExtensions(new File("D:\\jar\\authenticator_crx\\bhghoamapcdpbohphigoooaddinpkbai.crx"));
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		WebDriver driver = new ChromeDriver(capabilities);
		driver.get("http://www.google.com");
	
	}

}
