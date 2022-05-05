package base;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ReadConfig;

public class BaseClass {
	public static WebDriver driver;
	public static Logger logger;
	ReadConfig readconfig;
	public String baseURL;

	public String username;
	public String password;

	@Parameters("browser")
	@BeforeClass
	public void setUp(String br) throws IOException {
		if (driver == null) {

			logger = LogManager.getLogger(BaseClass.class.getName());
						
			readconfig = new ReadConfig();

			baseURL = readconfig.getApplicationURL();

			username = readconfig.getUsername();

			password = readconfig.getPassword();

		}

		if (br.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (br.equalsIgnoreCase("FireFox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (br.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();

		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get(baseURL);
		driver.manage().window().maximize();

	}

	@AfterClass
	public void tearDown() throws InterruptedException {

//		driver.close();
		System.out.println("Teardown Successful");
		driver = null;
	}

	public static String captureScreen(WebDriver driver, String screenshotName) throws IOException {
		String dateName=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		
		
		String destination=System.getProperty("user.dir")+"/ScreenShots/"+screenshotName+dateName+".png";
		File finaldestination=new File (destination);
		FileUtils.copyFile(source, finaldestination);
		System.out.println("Screenshot taken");
		return destination;
		
	}

	public String randomstring() {
		String generatedstring = RandomStringUtils.randomAlphabetic(8);

		return (generatedstring);

	}

	public static String randomNum() {
		String generatedstring = RandomStringUtils.randomNumeric(4);

		return (generatedstring);

	}
}


//	System.getProperty("user.dir")  Give you system home directory: Only can be used in Java Classes
// ./ : Can be used in Java classes and in properties file 
