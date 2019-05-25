package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginToPMT {
	
	public WebDriver driver;
	
	By username = By.xpath("//input[@name='email']");
	By password = By.xpath("//input[@name='password']");
	By submitButton = By.xpath("//input[@type='submit']");
	By privacyPolicy = By.xpath("//div[@class='privacy-link']/span[1]/a");
	By faq = By.xpath("//div[@class='privacy-link']/span[2]/a");
	
	public LoginToPMT(WebDriver driver) {
		this.driver=driver;
	}

	public WebElement username() {
		return driver.findElement(username);
	}
	
	public WebElement password() {
		return driver.findElement(password);
	}
	
	public WebElement loginSubmit()
	{
		return driver.findElement(submitButton);
	}
	
	public WebElement privacyPolicy()
	{
		return driver.findElement(privacyPolicy);
	}
	public WebElement faq()
	{
		return driver.findElement(faq);
	}

}
