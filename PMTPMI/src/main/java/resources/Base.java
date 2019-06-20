package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Base {
	
	public WebDriver driver;
	public Properties properties;
	public WebDriver driverInitialization() throws Throwable {
	
		properties = new Properties();
		FileInputStream fis = new FileInputStream("D:\\Pramod_Automation_GitHub\\PMTPMI\\src\\main\\java\\resources\\data.properties");
		
		properties.load(fis);
		String browserName = properties.getProperty("browser");
		
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "D:\\jar\\ChromeDriver\\chromedriver.exe");
			driver = new ChromeDriver();
			
		}else if(browserName.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "D:\\jar\\FirefoxDriver\\geckodriver.exe");
			driver = new FirefoxDriver();
		}else if(browserName.equals("IE11"))
		{
			System.setProperty("webdriver.ie.driver", "D:\\jar\\IEDriver\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		return driver;

	}
	
}
