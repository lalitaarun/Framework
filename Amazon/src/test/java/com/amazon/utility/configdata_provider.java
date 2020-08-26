package com.amazon.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.io.FileHandler;

public class configdata_provider {
	Properties pro;
	
	public configdata_provider() {

		File src = new File("./config/config.properties");
		try {
			FileInputStream fis = new FileInputStream(src);
			 pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("unable to load the file" + e.getMessage());
		}

	}
	public String getBrowser()
	{
		return pro.getProperty("Browser");
		
	}
	public String stagingURL()
	{
		return pro.getProperty("URL");
	}

}
