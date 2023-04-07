package com.icehrmautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Dropdownlist 
{

	public static void main(String[] args) throws Exception
	{
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrm.live.com/");
		Thread.sleep(3000);
		
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).submit();
		Thread.sleep(5000);
		String dashboardText=driver.findElement(By.xpath("//h6[text()='Dashboard']")).getText();
		if(dashboardText.equals("Dashboard")) {
			System.out.println("Successfully landed on the homepage of an application");
		}
		else {
			throw new Exception ("Failed to login application");
		}
		driver.findElement(By.xpath("//span[text()='PIM']")).click();
		Thread.sleep(5000);
		
		WebElement searchButton=driver.findElement(By.xpath("//button[@type='reset']/following-sibling::button"));
		
		if(searchButton.isDisplayed()) {
			System.out.println("Successfully able to navigate on PIM module");
			if(searchButton.isEnabled()) {
				System.out.println("Search button is enable on the screen");
			}
		else {
			System.out.println("Search button is disable on the screen");
		     } 
	    }
		else {
			System.out.println("unable to navigate on PIM module");
		}

	
	}
	}	