package com.amazon.utility;

import java.io.File;
import java.io.IOException;
import java.io.ObjectOutput;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper {
	// capture screenshot,alerts,frame,multiple windows,syc issue,java script
	// executor
	public static String captureScreen_shot(WebDriver driver) {

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String screenshotpath = System.getProperty("user.dir" + "/Screenshots/Amazon" + getcurrent_Date() + ".png");

		try {
			FileHandler.copy(src, new File(screenshotpath));
			System.out.println("screenshot taken");
		} catch (IOException e) {
			System.out.println("Unable to capture screenshot");
		}
		System.out.println("screenshotpath : " + screenshotpath);
		return screenshotpath;

	}

	public static String getcurrent_Date() {
		DateFormat custom_date = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date date_current = new Date();
		return custom_date.format(date_current);

	}

}
