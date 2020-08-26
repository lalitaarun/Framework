package com.amazon.pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.amazon.utility.BrowserFactory;
import com.amazon.utility.ExcelDataProvider;
import com.amazon.utility.Helper;
import com.amazon.utility.configdata_provider;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Baseclass {
	public WebDriver driver;
	public ExcelDataProvider excel;
	public configdata_provider config;
	public ExtentReports report;
	public ExtentTest logger;

	@BeforeSuite
	public void setUpSuite() {
		Reporter.log("Setting up reports and test is getting ready", true);
		excel = new ExcelDataProvider();
		config = new configdata_provider();
		ExtentHtmlReporter extent = new ExtentHtmlReporter(
				new File(System.getProperty("user.dir") +Helper.getcurrent_Date()+ "/Reports/Amazon.html"));
		report = new ExtentReports();
		report.attachReporter(extent);
		Reporter.log("Setting up is done and test can be started", true);

	}

	@BeforeClass
	public void setUp() {
		Reporter.log("Trying to start browser and getting application", true);

		driver = BrowserFactory.start_application(driver, config.getBrowser(), config.stagingURL());
		Reporter.log("Browser and application is up and Running", true);

	}

	@AfterClass()
	public void tear_down() {
		BrowserFactory.quitBrowser(driver);

	}

	@AfterMethod
	public void teardownmethod(ITestResult result) throws IOException  {
		Reporter.log("Test is about to end", true);

		if (result.getStatus() == ITestResult.FAILURE) {
			System.out.println("In Failure");
			//Helper.captureScreen_shot(driver);
			logger.fail("Test failed",MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreen_shot(driver)).build());
		}
		else if(result.getStatus() == ITestResult.SUCCESS)
		{
			System.out.println("In Success");
			logger.pass("Test passed",MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreen_shot(driver)).build());

		}
		report.flush();
		Reporter.log(" Test completed>>>Reports generated", true);

	}
}
