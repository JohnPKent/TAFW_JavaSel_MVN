package com.simplytesting.jsfw.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.testng.Assert;

import jsfw.src.main.java.uiwrappers.UIWrappers;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class TestRun {
	
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static String driverPath;
	public static UIWrappers uiWrappers;
	
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 20;
	static JavascriptExecutor js;
	
	public TestRun(){
		String configPath = "";
		try {
			prop = new Properties();
			configPath = System.getProperty("user.dir") + "\\src\\main\\java\\com\\simplytesting\\jsfw\\config\\config.properties";
			//FileInputStream ip = new FileInputStream( configPath);
			prop.load(new FileInputStream(configPath));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("Unable to load config file '" + configPath + "'aborting");
			Assert.fail();
		} catch (IOException e) {
			e.printStackTrace();
		}
		driverPath = System.getProperty("user.dir")+ "\\src\\main\\resources";
	}
	
	
	public static void initialise(){
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome")){
			try	{
				System.setProperty("webdriver.chrome.driver", driverPath + "\\chromedriver.exe");	
				driver = new ChromeDriver(); 
			}catch(Exception e)	{
				e.printStackTrace();
				System.out.println("Unable to start chrome driver... aborting");
				Assert.fail();
			}
		}
		else if(browserName.equals("FireFox")){
			try	{
				System.setProperty("webdriver.gecko.driver", driverPath + "\\geckodriver.exe");	
				driver = new FirefoxDriver(); 
			}catch(Exception e)	{
				e.printStackTrace();
				System.out.println("Unable to start chrome driver... aborting");
				Assert.fail();
			}
		}
				
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));

		uiWrappers = new UIWrappers(driver);

	}
}


