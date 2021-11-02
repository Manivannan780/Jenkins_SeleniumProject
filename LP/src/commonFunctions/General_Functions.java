package commonFunctions;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class General_Functions {
	public static Properties PropertyObject;
	public static WebDriver driver;


	public Properties GetPropertyFile() {
		PropertyObject = new Properties();
		try {
			System.out.println("Reading the Property File");
			FileInputStream Fileobject=new FileInputStream("ProjectDetails.properties");
			PropertyObject.load(Fileobject);	
		} 

		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return PropertyObject;
	}
	
	
	

	@BeforeSuite
	public void ChromeBrowserLaunch() {
		GetPropertyFile();
		String ChromeJarLocation =PropertyObject.getProperty("ChromeJarlocation");
		System.setProperty("webdriver.chrome.driver", ChromeJarLocation);

		driver=new ChromeDriver();

		String BrowserDetails=PropertyObject.getProperty("browser");
		if(BrowserDetails.equalsIgnoreCase("Chrome")) {
			System.out.println("Browser Started Initilzed");
			String LaunchingURL=PropertyObject.getProperty("LaunchingUrl");
			driver.get(LaunchingURL);
			ImpWaitCondition();
			driver.manage().window().maximize();
			driver.navigate().refresh();
			System.out.println("Site Refreshed Successfully");
			
		}
		else {
			System.out.println("Browser Details are Incoreect");
			driver.quit();
		}

	}

	
	public void PauseExecution() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void ImpWaitCondition() {
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	
	@AfterSuite
	public void BrowserTermination() {
		System.out.println("Process Complete Closing The Browser");
		driver.quit();
	}

	

}