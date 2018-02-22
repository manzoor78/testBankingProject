package pageLibrary;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import utils.invokeBrowserDriver;
import utils.readProperties;

public class loginPage {
	
	WebDriver driver=null;
	public loginPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public static readProperties read = new readProperties();
	By userIdText = By.xpath(".//input[@name='uid']");
	By pass = By.xpath(".//input[@name='password']");
	By loginBtn = By.xpath(".//input[@name='btnLogin']");
	By logOutLink = By.xpath(".//a[@href='Logout.php']");
	
	public void enterUserId() throws IOException{
		read.loadPropertyFile();
		System.out.println("User Id is " + read.getUserId());
		String id = read.getUserId();
		
		invokeBrowserDriver.driver.findElement(userIdText).click();
		invokeBrowserDriver.driver.findElement(userIdText).sendKeys(id);
	}
	
	public void enterPassword(){
		System.out.println("Password is " + read.getPassword());
		invokeBrowserDriver.driver.findElement(pass).sendKeys(read.getPassword());
	}
	
	public void enterUserFromFile(String user) throws IOException{
		read.loadPropertyFile();
		
		invokeBrowserDriver.driver.findElement(userIdText).click();
		invokeBrowserDriver.driver.findElement(userIdText).sendKeys(user);
	}
	
	public void enterPasswordFromFile(String password){
		//System.out.println("Password is " + read.getPassword());
		invokeBrowserDriver.driver.findElement(pass).sendKeys(password);
	}
	
	public void clickLogin(){
		invokeBrowserDriver.driver.findElement(loginBtn).click();
	}
	
	public boolean checkLoggedIn(){
		return invokeBrowserDriver.driver.findElement(logOutLink).isDisplayed();
	}
	
	
	public boolean checkInvalidCred(){
		return true;
	}

}
