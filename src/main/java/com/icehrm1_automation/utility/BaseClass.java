package com.icehrm1_automation.utility;

import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
//import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass 
{
	public static WebDriver driver;

	public void launchBrowser(String browser) 
	{
		switch (browser) 
		{
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			//WebDriverManager.chromedriver().setup();			
			driver = new ChromeDriver(setChromeOptions());
			break;

		case "edge":
			//WebDriverManager.edgedriver().setup();
			System.setProperty("webdriver.edge.driver", "msedgedriver.exe");
			driver = new EdgeDriver(setEdgeOptions());
			break;

		case "firefox":
			System.setProperty("webdriver.chrome.driver", "firefoxdriver.exe");
			driver = new FirefoxDriver();
			break;

		default:
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			driver = new ChromeDriver();

		}

	}
	
	public ChromeOptions setChromeOptions() {
		ChromeOptions option=new ChromeOptions();
		option.addArguments("start maximized");
		option.addArguments("--remote-allow-origins=*");
		option.addArguments("incognito");
		//option.setHeadless(false);
		option.setExperimentalOption("excludeSwitches",Arrays.asList("disable-popup-clocking"));
		Map<String,String>prefs=new HashMap<>();
		prefs.put("download.default.directory","c:/newfolder/download/");
		option.setExperimentalOption("prefs",prefs);
		option.setAcceptInsecureCerts(true);
		return option;
		
	}

	public EdgeOptions setEdgeOptions() {
		EdgeOptions option1=new EdgeOptions();
		option1.addArguments("start maximized");
		option1.addArguments("--remote-allow-origins=*");
		option1.addArguments("incognito");
		//option.setHeadless(false);
		option1.setExperimentalOption("excludeSwitches",Arrays.asList("disable-popup-clocking"));
		Map<String,String>prefs=new HashMap<>();
		prefs.put("download.default.directory","c:/newfolder/download/");
		option1.setExperimentalOption("prefs",prefs);
		option1.setAcceptInsecureCerts(true);
		return option1;
		
	}
	
	// this method will perform sendkeys operation provided location(element)
	public void enterText(By by, String text) 
	{
		try {
			
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // wait till the element is available for click operation
			wait.until(ExpectedConditions.presenceOfElementLocated(by)); // perform click
			driver.findElement(by).sendKeys(text);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	// this method will perform click operation on given locator
	public void click(By by) 
	{
		try 
		{
			// wait till the element is available for click operation
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(by));
			// perform click
			driver.findElement(by).click();
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void fileUpload(String filePath) {
		try {
			PropertyHandling handling=new PropertyHandling();
			String autoITScript=handling.getProperties("autoITScript");
			Thread.sleep(1000);
			Runtime.getRuntime().exec(autoITScript+" "+filePath);
			Thread.sleep(1000);
			}	catch(Exception e) {
				e.printStackTrace();
			}
	   }
}
