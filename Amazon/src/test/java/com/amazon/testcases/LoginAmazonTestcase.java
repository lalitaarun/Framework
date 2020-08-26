package com.amazon.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.amazon.pages.Baseclass;
import com.amazon.pages.LoginPage;
import com.amazon.utility.BrowserFactory;
import com.amazon.utility.ExcelDataProvider;
import com.amazon.utility.Helper;

public class LoginAmazonTestcase extends Baseclass {

	@Test(priority=1)
	public void loginApp() {

		// create object of the login page,page factory class will return the object of the specified page class
		
		logger=report.createTest("Login to Amazon");
		logger.info("Starting Amazon");
		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
		// Hard coded data
//		login.login_amazon("lalitaarun1213@gmail.com", "admin123");
		
		login.login_amazon(excel.getStringData(0, 0, "Amazon_login"), excel.getStringData(0, 1, "Amazon_login"));
		
		logger.pass("Login successfully");
		Helper.captureScreen_shot(driver);
	}
	

}
