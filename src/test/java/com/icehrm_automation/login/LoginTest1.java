//test case run here

package com.icehrm_automation.login;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.icehrm1_automation.utility.BaseClass;

public class LoginTest1 extends BaseClass {
	String firstName = "Cyber";
	String lastName = "Success";
	String empId = "001";

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("This is method to launch browser");
		launchBrowser("chrome");
		driver.navigate().to("https://cybersuccess.icehrm.com/");
		enterText(By.id("username"), "admin");
		enterText(By.id("password"), "2zuzfakn");
		click(By.xpath("//button[contains(text(),'Log in')]"));
		click(By.xpath("//span[text()='Employees']"));
		click(By.xpath("//ul[@id='admin_Employees']/li[1]/a"));
	}

	@Test
	public void addEmp() {
		System.out.println("This is create Emp method from @test");
		// click on add button
		click(By.xpath("//span[text()='Employees']"));
		click(By.xpath("//a[text()=' Employees ']"));
		click(By.xpath("//span[text()=' Add New']"));
		// enter emp id
		enterText(By.id("employee_id"), empId);
		// enter first name
		enterText(By.id("first_name"), firstName);
		// enter last name
		enterText(By.id("last_name"), lastName);

	}

	@Test
	public void verifyEmp() {
		System.out.println("This is a verifyEmp method from @test");
	}

	@AfterMethod
	public void tearDown() {
		System.out.println("This is tear down method from @aftermethod");
	}

}
