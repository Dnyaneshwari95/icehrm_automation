//what is inside page model=locators + reusable methods

package com.icehrmautomation.pages;

import org.openqa.selenium.By;
import com.icehrm1_automation.utility.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass{
	public WebDriver driver;
	By username=By.name("username");
	By password=By.name("password");
	By loginButton=By.xpath("//button[contains(text(),'Log in')]");
	By resetPasswordLink=By.xpath("//a[contains(text(),'Reset Password')]");
	public By errorMsg=By.xpath("//div[contains(@class,'alert-danger')]");
	
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public void login(String username,String password) 
	{
		enterText(this.username,username);
		enterText(this.password,password);
		click(loginButton);
		
		
		/*
		 * @FindBy(name="username") public WebElement username;
		 * 
		 * @FindBy(name="password") public WebElement password;
		 * 
		 * @FindBy(xpath="/button[contains(text(),'Log in')]") public WebElement
		 * loginButton;
		 */
		/*
		 * public LoginPage(WebDriver driver) { PageFactory.initElements(driver, this);
		 * }
		 */
		/*
		 * this.username.sendKeys(username); this.password.sendKeys(password);
		 * this.loginButton.click();
		 */
	}
 
}
