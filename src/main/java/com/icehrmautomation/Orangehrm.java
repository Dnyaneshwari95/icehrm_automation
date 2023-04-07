package com.icehrmautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Orangehrm {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://opensource-demo.orangehrmlive.com/");
		Thread.sleep(5000);

		// to enter username and password
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).submit();
		Thread.sleep(5000);

		String dashboardText = driver.findElement(By.xpath("//h6[text()='Dashboard']")).getText();
		// get the text of dashboard field

		if (dashboardText.equals("Dashboard")) {
			// check if actual and expected result is same or not
			System.out.println("successfully landed on the home page of an application");// if same then print
																							// successful msg
		} else {
			System.out.println("failed to login to application");// if not then print this msg
		}

		// to click on PIM module
		driver.findElement(By.xpath("//span[text()='PIM']")).click();
		Thread.sleep(2000);

		// locate the search button on PIM module
		WebElement searchButton = driver.findElement(By.xpath("//button[@type='reset']/following-sibling::button"));

		// check if searchbutton is displayed on the screen or not
		if (searchButton.isDisplayed()) {
			System.out.println("successfully able to navigate on PIM module");
		} else {
			System.out.println("unable to navigate on PIM module");
		}
		Thread.sleep(2000);

		// to locate minimize icon
		driver.findElement(By.xpath("//button[@class='oxd-icon-button' and @type='button']/i")).click();
		WebElement selectcheckbox = driver.findElement(By.xpath("//div[text()='Aaliyah ']"));
		selectcheckbox.click();
		Thread.sleep(5000);

		if (driver.findElement(By.xpath("//div[text()='Aaliyah ']")).isSelected()) {
			System.out.println("select checkbox is selected");
		} else {
			System.out.println("selected checkbox is not select");
		}

		driver.quit();

		// TODO Auto-generated method stub

	}

}
