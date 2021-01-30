package appModule;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utility.Constant;
import utility.ExcelUtils;

public class TestSignIn {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		Logger Log = Logger.getLogger(TestSignIn.class.getName());
		
		DOMConfigurator.configure("log4j.xml");

		
	 WebDriver driver = new ChromeDriver();
	    
	    //Maximise browser window 
		driver.manage().window().maximize(); 
		
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS );
		
		driver.get(Constant.URL);
		
		driver.findElement(By.id("tab_signin")).click();
		Log.info("Sign in button click - pass");
		
		
		driver.findElement(By.cssSelector("#tabs-func > li.dropdown > div > a.si_menuitem_last")).click();
		
		//This is to open the Excel file. Excel path, file name and the sheet name are parameters to this method
	   
		
	   ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData,"Sheet1");
	   String email = ExcelUtils.getCellData(1, 1);
	   String password= ExcelUtils.getCellData(1, 2);
	   driver.findElement(By.cssSelector("#screen-login > form > input:nth-child(2)")).sendKeys(email);
	   driver.findElement(By.cssSelector("#screen-login > form > input:nth-child(4)")).sendKeys(password);
	 
		
		/* Reading data from Constant.class java file */
	   
	   // driver.findElement(By.cssSelector("#screen-login > form > input:nth-child(2)")).sendKeys(Constant.Username);
	   //	driver.findElement(By.cssSelector("#screen-login > form > input:nth-child(4)")).sendKeys(Constant.Password);
			
		
		driver.findElement(By.cssSelector("#screen-login > form > div:nth-child(6) > input")).click();
		
		driver.findElement(By.id("tab_account")).click();
		
		driver.findElement(By.cssSelector("#tabs-func > li.dropdown > div > a.si_menuitem_last")).click();
		
		driver.quit();
		
		//ExcelUtils.setCellData("pass", 1, 3);
		
	//	ExcelUtils.setCellData("fail", 2, 3);
		
	//	ExcelUtils.setCellData("fail", 3, 3);
		
		
		

		
		
		
	}

}
