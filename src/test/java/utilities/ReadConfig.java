package utilities;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;

public class ReadConfig 
{
	Properties prop;
	
	
	public ReadConfig()
	{
		File src=new File("C:\\eclipse-workspace\\inetBankingV1\\Configuration\\config.properties");
		
		try {
			FileReader fr = new FileReader(src);
			prop = new Properties();
			prop.load(fr);
			
		}catch (Exception e)
		{
			System.out.println("Exception is "+ e.getMessage());
		}
	}
	
	public String getApplicationURL()
	{
		String url=prop.getProperty("testurl");
		
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
