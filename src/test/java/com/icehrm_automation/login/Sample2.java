package com.icehrm_automation.login;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.icehrm1_automation.utility.BaseClass;

public class Sample2 extends BaseClass{
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browser) {
		System.out.println("This is before class method");
		launchBrowser(browser);
		driver.get("https//:cybersuccess.icehrm.com");
		System.out.println("Launching" + browser + " browser");
	}
	
	@AfterClass
	public void afterClass(String browser) {
		driver.close();
	}
	
	@Parameters({"username","password"})
	@Test
	public void sample2Test(String username,String password) {
		System.out.println("This is sample2 test1 method");
		System.out.println("UN:" + username + "PWD:" + password);
		enterText(By.id("username"),"username");
		enterText(By.id("password"),"password");
		click(By.xpath("//button[contains(text(),'Log in')]"));
	}

}
