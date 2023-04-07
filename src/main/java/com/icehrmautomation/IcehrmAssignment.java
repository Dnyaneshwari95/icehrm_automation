package com.icehrmautomation;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IcehrmAssignment {

	public static void main(String[] arg) throws Exception{
		// TODO Auto-generated method stub
      System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	  //WebDriverManager.edgedriver().setup();
		WebDriver driver = new ChromeDriver();
	 
	 driver.get("https://cybersuccess.icehrm.com/");

	 //valid username & valid password
	 WebElement username=driver.findElement(By.id("username"));
	 username.sendKeys("admin");
		
	 WebElement password =driver.findElement(By.id("password"));
	 password.sendKeys("2zuzfakn");
		
	 WebElement loginButton=driver.findElement(By.xpath("//button[contains(text(),'Log in')]"));
	 loginButton.click();
	 
	 driver.findElement(By.xpath("//span[text()='Employees']")).click(); //on homepage select Employees
	 Thread.sleep(5000);
	 
	 driver.findElement(By.xpath("//ul[@id='admin_Employees']/li[1]/a[1]")).click();
	 
	 driver.findElement(By.xpath("//span[@aria-label='plus-circle']/following-sibling::span")).click(); //click on Add new tab
	 driver.findElement(By.xpath("//input[@id='employee_id']")).sendKeys("98765");
	 driver.findElement(By.xpath("//input[@id='first_name']")).sendKeys("Dnyaneshwari");
	 driver.findElement(By.xpath("//input[@id='middle_name']")).sendKeys("Dattatraya");
	 driver.findElement(By.xpath("//input[@id='last_name']")).sendKeys("Naikwade");
	 WebElement selectnationality=driver.findElement(By.xpath("//input[@ id='rc_select_0']"));
	 selectnationality.click();
	 selectnationality.sendKeys("Indian");
	 
	 Thread.sleep(5000);
	 
	 List<WebElement>nationalitydropdownvalues=driver.findElements(By.xpath("div[@id='rc_select_0_list']/following-sibling::div/div/div/div/div/div"));
	 for(int i=0; i<nationalitydropdownvalues.size();i++){
		 {
			 WebElement element=nationalitydropdownvalues.get(i);
			 String value=element.getText();
			 /*if(value.equals("Austria"))
			 {
				 //element.click();
				 //break;
			 }*/
			 System.out.println("Nationality is selected");
		}
		
		 WebElement selectGender=driver.findElement(By.xpath("//input[@id='rc_select_1']"));
		 selectGender.click();
		 selectGender.sendKeys("Female");
		 
		 Thread.sleep(2000);
		 
		 List<WebElement> genderdropdownvalues=driver.findElements(By.xpath("//div[@label='Female']/div"));
		 for(int j=0; j<genderdropdownvalues.size();j++)
		 {
			 WebElement element1=genderdropdownvalues.get(j);
			 String value=element1.getText();
			 element1.click();
			 break;
		 }
		 System.out.println("Gender is selected");
		 
		 
		
	}
 

	 
	 

	  
	 
	 
	 
	 
	 
	 
	 
	 
	}
}
	 
	

