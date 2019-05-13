package com.pmtpro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class PMTLoginTest {
	
	WebDriver driver = new ChromeDriver();
	@Test
	public void pmtLogin() {
		System.out.println("PMT LOGIN COMPLETED");
	}
	
	@Test
	public void pmiLogin()
	{
		System.out.println("PMI Login");
	}
	
	@Test
	public void mobilePmiLogin() {
		System.out.println("Mobile Login");
	}

}
