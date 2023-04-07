package com.icehrmautomation;



import java.util.List;
import java.lang.InterruptedException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Washingmachine {
   public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		 
		 driver.get("https://www.amazon.in/");
		 
		 WebElement dropDown=driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
		 Select select=new Select(dropDown);
		 
		 List<WebElement> dropDownValues=select.getOptions();
		 for(int i=0;i<dropDownValues.size();i++) 
		 {
			 WebElement values=dropDownValues.get(i);
			 String ss=values.getText();
		 }
		 select.selectByVisibleText("Electronics");
		 driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Washing machine");
		 driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
		 
		 int totalResult;
		 List<WebElement>wmResult=driver.findElements(By.xpath("//div[starts-with(@cel_widget_id,\"MAIN-SEARCH_RESULTS-\")]/descendant::h2//span"));
		 
		 totalResult=wmResult.size();
		 System.out.println("Total result:" +totalResult);
		 
		 for(int i=3; i<9 ;i++)
		 {
			 try {
		     String nameXpath="//div[starts-with(@data-cel_widget,'search_result_')][" + i + "]/descendant::h2//span";
			 String priceXpath="//div[starts-with(@data-cel-widget,'search_result_')][" + i + "]/descendant::span[@class='a-price-whole']";
			 Thread.sleep(7000);
			  
			 String washingmachinename=driver.findElement(By.xpath(nameXpath)).getText();
			 String washingmachineprice=driver.findElement(By.xpath(priceXpath)).getText();
		     Thread.sleep(5000);
		     
			 String price=washingmachineprice.replaceAll(",","");
			 Integer ii=Integer.parseInt(price);
		
			 System.out.println(" price: " + ii +" name: "+ washingmachinename );
			 
			 }
			 catch(Exception e)
			 {
				System.out.println(e.getMessage());
			 }
		 
		 }
		 
		 
		 driver.quit();
		
		 
	}

}
