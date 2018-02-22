package testScripts;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageLibrary.loginPage;
import testBase.*;
import utils.invokeBrowserDriver;

public class validateLoginTest extends testBaseCommon {
 
	loginPage lpage = new loginPage(invokeBrowserDriver.driver);
	//public static Logger log = LogManager.getLogger(validateLoginTest.class.getName());
	
	// Method to check Login with Valid Credentials
    @Test(priority=2)
	public void acheckLogin() throws InterruptedException, IOException{
		
		lpage.enterUserId();
		lpage.enterPassword();
		lpage.clickLogin();
		Thread.sleep(2000);
		
		//System.out.println("Value of logout is "+ lpage.checkLoggedIn());
		System.out.println("This is log 4j error");
		//log.error("This is log 4j error");
		
		AssertJUnit.assertEquals(true, lpage.checkLoggedIn());
		
	}
	
    //Method to check Login with Invalid Credentials
	@Test(dataProvider="getUserData",priority=1)
	public void checkInvalidLogin(String user,String pwd) throws IOException, InterruptedException{
		
		System.out.println("UserName is "+ user);
		System.out.println("Password is "+ pwd);
		
		lpage.enterUserFromFile(user);
		lpage.enterPasswordFromFile(pwd);
		lpage.clickLogin();
		Thread.sleep(1000);
		Alert alert = invokeBrowserDriver.driver.switchTo().alert();
		    
	   if(alert.getText().equalsIgnoreCase("User or Password is not valid")){
				AssertJUnit.assertEquals(true, true);
				alert.accept();
				Thread.sleep(2000);
				//invokeBrowserDriver.driver.close();
		}
	
	}
	
	@DataProvider
	public Object[][] getUserData() throws IOException, EncryptedDocumentException, InvalidFormatException{
		
		String dataFilePath = "/Users/manzoorhunagund/Desktop/GitHub/AutomationExample/banking_project/test_input.xlsx";
		//String dataFilePath = System.getProperty("/Users/manzoorhunagund/Desktop/test_input.xlsx");
		File file = new File(dataFilePath);
		FileInputStream fis = new FileInputStream(file);
		
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		
		Sheet sh = wb.getSheet("Sheet1");
		
		int nRows = sh.getLastRowNum();
		nRows++;
		int cols= sh.getRow(1).getLastCellNum();
		Object[][] obj = new Object[nRows][cols];
		
		for(int i=1;i<nRows;i++){
			for (int j=0;j<cols;j++){
				obj[i-1][j] = sh.getRow(i).getCell(j);
				obj[i-1][j] = obj[i-1][j].toString();
				System.out.println("Value is " + obj[i-1][j]);
				
			}
		}
		
		wb.close();
		return obj;

	}
	

	@BeforeClass
	public void setUp() throws IOException{
		initialize();
	}
	
	@AfterClass
	public void tearDown() throws InterruptedException{
		//Thread.sleep(4000);
		//invokeBrowserDriver.driver.quit();
	}

}
