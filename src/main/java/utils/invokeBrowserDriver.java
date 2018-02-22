package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class invokeBrowserDriver {
	
public static WebDriver driver=null;
	
	public static void browser(String browser){
		
		try{
		if(browser.equalsIgnoreCase("firefox")){
			System.out.println("Firefox browser selected");
			// Windows - System.setProperty("webdriver.firefox.driver","C:\\Users\\manzo\\Desktop\\firefox.exe");
			System.setProperty("webdriver.gecko.driver","/Users/manzoorhunagund/Desktop/geckodriver");
			driver = new FirefoxDriver();
			
		}
		else if(browser.equalsIgnoreCase("chrome")){
			System.out.println("Chrome browser selected");
			System.setProperty("webdriver.chrome.driver","/Users/manzoorhunagund/Desktop/chromedriver");
			driver = new ChromeDriver();
			
		}
		
		}
		catch (Exception e) {
			e.printStackTrace();
			
		}

		
	}
	

}
