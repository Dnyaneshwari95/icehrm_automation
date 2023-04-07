package com.icehrmautomation;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.lang.InterruptedException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Imgassignment {

	public static void main(String[] arg) throws InterruptedException {
		 
		System.setProperty("Webdriver.chrome.driver","chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.navigate().to("https://www.amazon.in");
		
		List<WebElement> links=driver.findElements(By.tagName("img"));
		for(int i=0 ; i<links.size();i++)
		{
			WebElement element =links.get(i);
			String url=element.getAttribute("src");
			Thread.sleep(5000);
			
			if(url!=null && !url.equals("javascript:void(0)"))
			{
				try 
				{
					URL uri=new URL(url);
					URLConnection urlConnection=uri.openConnection();
					HttpURLConnection httpURLConnection=(HttpURLConnection) urlConnection;
					httpURLConnection.connect();
					int statuscode=httpURLConnection.getResponseCode();
					if(statuscode>=300)
					{
						System.out.println("Broken Url:" + "status code:" + statuscode+ "url:" +url);
					}
					httpURLConnection.disconnect();
				}
				catch(Exception ignored)
				{
				}
			}
		}
		
		// driver.close();

	}
}



