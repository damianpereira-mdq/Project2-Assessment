package com.pedidosya.utils;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


public class SetupBrowser {

	static WebDriver driver;
	
	static DesiredCapabilities cap;
	public static String hubAddress = "http://192.168.1.64:8888/wd/hub";
	
		
	public static WebDriver startBrowser (WebDriver driver, String browserName) throws MalformedURLException {

		if (browserName.equals("Chrome")) {

			System.setProperty("webdriver.chrome.driver", "webdrivers/chromedriver.exe");
			driver = new ChromeDriver();			
			
			// === For Selenium grid implementation === 
			cap = DesiredCapabilities.chrome();
			cap.setBrowserName("Chrome");
			
			

		} else if (browserName.equals("Firefox")) {

			System.setProperty("webdriver.gecko.driver", "webdrivers/geckodriver.exe");
			driver = new FirefoxDriver();	
			
			// === For Selenium grid implementation === 
			cap = DesiredCapabilities.firefox();
			cap.setBrowserName("Firefox");

		} else if (browserName.equals("Opera")) {

			System.setProperty("webdriver.opera.driver", "webdrivers/operadriver.exe");
			driver = new OperaDriver();	
			
			// === For Selenium grid implementation === 
			cap = DesiredCapabilities.safari();
			cap.setBrowserName("safari");

		} else {

			System.out.println("Browser not supported!");
		}
		
		// === For Selenium grid implementation === 
		//driver = new RemoteWebDriver(new URL(hubAddress), cap);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return driver;
	}
	
	public static void closeBrowser (WebDriver driver) {		
		driver.quit();		
		
	}

}
