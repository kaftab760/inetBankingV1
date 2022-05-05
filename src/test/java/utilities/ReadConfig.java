package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.Properties;

public class ReadConfig 
{
	Properties prop;
	
	
	public ReadConfig()
	{
		File src=new File(System.getProperty("user.dir")+"\\Configuration\\config.properties"); // 1:Path of config.properties file
		
		try {
			FileInputStream fr = new FileInputStream(src); // 2:Create an object of FileInputStream using config.properties
			prop = new Properties();             // 3:Create an Object of Properties 
			prop.load(fr);						 // 4:Load the complete file 
			
		}catch (Exception e)
		{
			System.out.println("Exception is "+ e.getMessage());
		}
	}
	
	public String getApplicationURL()
	{
		String url=prop.getProperty("testurl");               //Get the value of the variable 
		
		return url;
	}
	
	public String getUsername()
	{
		String url=prop.getProperty("username");
		return url;
	}
	
	public String getPassword()
	{
		String url=prop.getProperty("password");
		return url;
	}
	
	public String getbrowser()
	{
		String url=prop.getProperty("browser");
		return url;
	}
	
	
	
}
