//path to navigate credentials in config.properties

package com.icehrm1_automation.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyHandling 
{

	Properties properties;

	public PropertyHandling() 
	{
		try 
		{
			// config.properties file path
			String filePath = System.getProperty("user.dir") + "/config.properties";
			FileInputStream file = new FileInputStream(filePath); // to read the file
			properties = new Properties(); // make property class instance to get method of load
			properties.load(file); // load the file in properties class to retrieve values
		} 
		catch (IOException e) 
		{
			throw new RuntimeException(e);
		}
	}

	public String getProperties(String key) 
	{
		String value = properties.getProperty(key);
		System.out.println(value);
		return value;
	}

	 
	
}
