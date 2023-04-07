package com.icehrmautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://cybersuccess.icehrm.com/");
		
		//valid username & valid password
		WebElement username=driver.findElement(By.id("username"));
		username.sendKeys("admin");
		
		WebElement password=driver.findElement(By.id("password"));
		password.sendKeys("2zuzfakn");
		
		WebElement loginButton=driver.findElement(By.xpath("//button[contains(text(),'Log in')]"));
		loginButton.click();
		
		String homeText=driver.findElement(By.xpath("//header[@id='delegationDiv']/a")).getText();
		System.out.println(homeText);
		
		if(homeText.equals("Home"))
		{
			System.out.println("Test Case is passed");
		}
		else
		{
			System.out.println("failed to login to application");
		
		}
		
		//locating signoff and performing click operation
		driver.findElement(By.xpath("//ul[@class='nav navbar-nav']li[5]/a/span")).click();
		driver.findElement(By.xpath("//div[@class='pull-right']/a")).click();
		
		
		
		//Invalid username & Invalid password
		WebElement username1=driver.findElement(By.id("username"));
		username1.sendKeys("admin1");
		
		WebElement password1=driver.findElement(By.id("password"));
		password1.sendKeys("123456");
		
		WebElement loginButton1=driver.findElement(By.xpath("//button[contains(text(),'Log in')]"));
		loginButton1.click();
		
		String homeText1=driver.findElement(By.xpath("//div[@class='pb-9']/h3")).getText();
		System.out.println(homeText1);
		if(homeText1.equals("IceHrm login"))
		{
			System.out.println("Test case is pass");
		}
		else
		{
			System.out.println("Test case is fail");
		}

	}
}



