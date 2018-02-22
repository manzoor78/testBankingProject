package testBase;

import java.io.IOException;

import utils.invokeBrowserDriver;
import utils.readProperties;

public class testBaseCommon {
	
	public static readProperties propertyFile = new readProperties();
	
	public void initialize() throws IOException{
		propertyFile.loadPropertyFile();
		System.out.println("Property File loaded");
		invokeBrowserDriver.browser(propertyFile.getBrowser());
		invokeBrowserDriver.driver.get(propertyFile.getURL());
		
	}


}
