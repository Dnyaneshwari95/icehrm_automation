package com.orangehrm_automation;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.icehrm1_automation.utility.BaseClass;
import com.icehrm1_automation.utility.PropertyHandling;
import com.orangehrm_automation.pages.MyInfoPage;
import com.orangehrm_automation.pages.OrangeHrmLoginPage;

public class FileUploadTest extends BaseClass
{
	
	OrangeHrmLoginPage orangeHrmLoginPage;
	MyInfoPage myInfoPage;
	PropertyHandling property;
	
	@BeforeClass
	public void beforeClass() 
	{
		orangeHrmLoginPage = new OrangeHrmLoginPage();
		myInfoPage = new MyInfoPage();
		property = new PropertyHandling();
		String username=property.getProperties("orangeHrmUN");
		String password=property.getProperties("orangeHrmPW");
		String browser=property.getProperties("browser");
		String url=property.getProperties("orangeHrmUrl");
		launchBrowser(browser);
		driver.get(url);
		orangeHrmLoginPage.login(username,password);
	}

	@Test
	public void fileUpload() {
		click(myInfoPage.myInfoMenu);
		click(myInfoPage.profileImg);
		click(myInfoPage.addImg);
		this.fileUpload("\"C:\\Users\\dnyan\\OneDrive\\Desktop\\Screenshot 2023.png\"");
	}
}