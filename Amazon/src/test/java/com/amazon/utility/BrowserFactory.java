package com.amazon.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {
	WebDriver driver;

	public static  WebDriver start_application(WebDriver driver, String browsername, String appURL) {

		if (browsername.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "./Webdrivers/geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browsername.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.gecko.driver", "./Webdrivers/chrome.exe");
			driver = new ChromeDriver();
		} else {
			System.out.println("we dont support to this driver");

		}

		driver.manage().window().maximize();
		driver.get(appURL);
		return driver;

	}

	public static void quitBrowser(WebDriver driver) {

		driver.quit();
	}
}
