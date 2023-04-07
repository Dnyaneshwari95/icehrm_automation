package com.icehrm_automation.login;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.icehrm1_automation.utility.BaseClass;
import com.icehrm1_automation.utility.PropertyHandling;
import com.icehrmautomation.pages.LoginPage;

import junit.framework.Assert;

public class LoginTest extends BaseClass
{
	PropertyHandling property;
	LoginPage loginpage;
	
	@BeforeClass
	public void start()
	{
		property=new PropertyHandling();
		launchBrowser(property.getProperties("browser"));
		driver.get(property.getProperties("icehrmUrl"));
		loginpage=new LoginPage(driver);
	}

	@Test(dataProvider="getLoginData")
	public void verifylogin(String username,String password, String errormsg)
	{
		loginpage.login(username,password);
		if(!username.isEmpty() && !password.isEmpty()) {
			String errorMessage=driver.findElement(loginpage.errorMsg).getText();
			Assert.assertEquals(errorMessage, errormsg);	
	}
}
	@DataProvider
	public Object[][] getLoginData()
	{
		Object[][] data=new Object[][] 
		{
			{"admin123","admin","Login failed"},
			{"admin","admin124","Login failed"},
			{"admin123","2zuzfakn","Login failed"},
			{"","",""},
			{"admin","",""},
		};
		return data;
	}	
}
