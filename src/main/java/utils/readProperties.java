package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class readProperties {
	
	Properties property = new Properties();

	public void loadPropertyFile() throws IOException{
		
		String filePath = System.getProperty("user.dir")+"/src/main/java/config/config.properties";
		FileInputStream fis = new FileInputStream(filePath);
		property.load(fis);
	}
	
	public String getBrowser(){
		return property.getProperty("browser");
	}
	
	public String getURL(){
		return property.getProperty("url");
	}
	
	public String getUserId(){
		return property.getProperty("userid");
	}
	
	public String getPassword(){
		return property.getProperty("password");
	}
	
}
