package testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass
{
	
public static WebDriver driver;

public Logger logger;

public Properties propFile ;
	
    @SuppressWarnings("deprecation")
	@BeforeClass(groups = {"regression","master","sanity"})
    @Parameters({"browser","OS"})
	public void setup(String br , String os) throws IOException
	{
    	
    	propFile = new Properties();
    	
    	//Loading Properties File 
    	
    	FileInputStream file = new FileInputStream("F:\\Java Set up\\Day 01\\OpenCart\\src\\test\\resources\\cofig.properties");
    	
    	propFile.load(file);
    	
    	
    	//Loading Log$J2 file
        logger = LogManager.getLogger(this.getClass());
        
        
         if(propFile.getProperty("execution_env").equalsIgnoreCase("remote"))
         {
        	 DesiredCapabilities capabilities = new DesiredCapabilities();
        	 
        	 // OS
        	 if(os.equalsIgnoreCase("windows"))
        	 {
        		 capabilities.setPlatform(Platform.WINDOWS);
        		 
        		 System.out.println("Windows");
        	 }
        	 else if(os.equalsIgnoreCase("mac"))
        	 {
        		 capabilities.setPlatform(Platform.MAC);
        	 }
        	 else
        	 {
        		 System.out.println("No Match OS ....");
        	 }
        	  
        	 //Browser
        	 switch(br.toLowerCase())
             {
             case "chrome"  : capabilities.setBrowserName("chrome");break;
             case "edge"    : capabilities.setBrowserName("Microsoft Edge");break;
             default: System.out.println("No Matching Browser Found");
             return;
             
             }
        	
        	 
        	  driver = new RemoteWebDriver(new URL("http://192.168.0.102:4444"),capabilities);
        	 
         }
         else if(propFile.getProperty("execution_env").equalsIgnoreCase("local"))
         {
             //launching browser based on condition = locally
            switch(br.toLowerCase())
             {
                 case "chrome"  : driver = new ChromeDriver(); break;
                 case "edge"    : driver = new EdgeDriver();break;
                 case "firefox" : driver = new FirefoxDriver();break;
        
                default: System.out.println("No Matching Browser Found");
                return;
        
             }
    	
         }
		
		driver.manage().window().maximize();
		
		driver.get(propFile.getProperty("appURL"));
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
    
    
    


	@AfterClass(groups = {"regression","master","sanity"})
    public void tearDown()
    {
    	driver.quit();
    }
    
    
    
    public String randomString()
    {
    	String generateString = RandomStringUtils.randomAlphabetic(5) ;
    	
    	
    	return generateString;
    }
    
    public String randomNumbersinString()
    {
    	String generateString = RandomStringUtils.randomNumeric(10);
    	
    	
    	return generateString;
    }
    
    public String randomAlphaNumeric()
    {
    	
    	String str = RandomStringUtils.randomAlphabetic(5) ;
    	String num = RandomStringUtils.randomNumeric(3);
    	
    	
    	return (str+"@"+num);
    }

    public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
			
		return targetFilePath;

	}


}
