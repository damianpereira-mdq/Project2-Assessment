package com.pedidosya.utils;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;


public class SetupBrowser {

	static WebDriver driver;
	//, String appURL
	
	public static WebDriver startBrowser (WebDriver driver, String browserName) {

		if (browserName.equals("Chrome")) {

			System.setProperty("webdriver.chrome.driver", "webdrivers/chromedriver.exe");
			driver = new ChromeDriver();			

		} else if (browserName.equals("Firefox")) {

			System.setProperty("webdriver.gecko.driver", "webdrivers/geckodriver.exe");
			driver = new FirefoxDriver();	

		} else if (browserName.equals("Opera")) {

			System.setProperty("webdriver.opera.driver", "webdrivers/operadriver.exe");
			driver = new OperaDriver();	

		} else {

			System.out.println("Browser not supported!");
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return driver;
	}
	
	public static void closeBrowser (WebDriver driver) {		
		driver.quit();		
		
	}

}
