package com.amazon.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	WebDriver driver;
//new commit from lalita
	public LoginPage(WebDriver ldriver) {
		this.driver = ldriver;
	}

	@FindBy(id="nav-link-accountList")
	WebElement Sign_in;

	@FindBy(id="continue")
	WebElement Continue1;
	
	
	@FindBy(id = "ap_email")
	WebElement username;
	
	@FindBy(name = "password")
	WebElement password;
	@FindBy(id = "signInSubmit")
	WebElement login_btn;

	public void login_amazon(String uname, String paswd) {
		//Actions act = new Actions(driver);
		//act.moveToElement(Sign_in).build().perform();
		//JavascriptExecutor js = (JavascriptExecutor)driver;
		//js.executeScript("argument[0].click();",sign);
		Sign_in.click();
		username.sendKeys(uname);
	Continue1.click();
		password.sendKeys(paswd);
		login_btn.click();

	}

}
