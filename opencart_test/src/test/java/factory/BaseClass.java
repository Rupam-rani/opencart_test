package factory;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BaseClass {
     static WebDriver driver;
     static Properties p;
     static Logger logger;
	
	public static WebDriver initializeBrowser() throws IOException {
		p=getProperties();
		String executionEnv=p.getProperty("execution_env");
		String browser=p.getProperty("browser").toLowerCase();
		String os=p.getProperty("os").toLowerCase();
		
		if(executionEnv.equalsIgnoreCase("remote")) {
		DesiredCapabilities capabilities=new DesiredCapabilities() ;
		
		switch(os) 
		{case"windows":capabilities.setPlatform(Platform.WIN11);
		break;
		case"mac":capabilities.setPlatform(Platform.MAC);
		break;
		case"linux":capabilities.setPlatform(Platform.LINUX);
		break;
		default:
			System.out.println("no matching os");
		return null;
		}
		switch(browser) 
		{
		case"chrome":capabilities.setBrowserName("chrome");
		break;
		case"edge":capabilities.setBrowserName("MicrosoftEdge");
		break;
		case"firefox":capabilities.setBrowserName("firefox");
		break;
		default:
			System.out.println("no matching browser");
		 return null;
		}
		driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
			
		}
		else if(executionEnv.equalsIgnoreCase("local")) 
		{
			switch(browser.toLowerCase())
			{
			case"chrome":
				driver=new ChromeDriver();
				break;
			case"edge":
				driver=new EdgeDriver();
				break;
			case"firefox":
				driver=new FirefoxDriver();
				break;
			default:
				System.out.println("no matching browser");
			
			}
			
		}
	driver.manage().deleteAllCookies();	
	
		return driver;
	}
	public static WebDriver getDriver() {
		return driver;
	}
	
	
    public static Properties getProperties() throws IOException
    {
    FileReader file=new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties");	
    	p=new Properties();
    	p.load(file);
    	return p;
    }
    public static Logger getLogger() {
    logger=	LogManager.getLogger();
    return logger;
    
    }
    public static String randomString() 
    {
    	String generatedstring=RandomStringUtils.randomAlphabetic(5);
    	return generatedstring;
    }
    public String randomNumber() 
    {
     String generatednumber=RandomStringUtils.randomNumeric(10);
        return generatednumber;
    }

     public static String randomAlphaNumeric() 
    {
    	String generatedstring= RandomStringUtils.randomAlphabetic(3);
    	String generatednumber=RandomStringUtils.randomNumeric(3);
    	
    	return (generatedstring+"@"+generatednumber);
    }
	
	}
	
	
	

