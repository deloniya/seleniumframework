package com.selenium.testCases;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import com.selenium.utilities.ReadConfig;

public class BaseClass {
	
	ReadConfig readconfig=new ReadConfig();
	
	public String baseURL = readconfig.getURL();
    public String username = readconfig.getuname();
    public String password = readconfig.getpassword();
    public static WebDriver driver;
    public static Logger logger;
   
    
    
	@Parameters("browser")
    @BeforeMethod
    public void setup(String br) 
    {
    	
        logger =Logger.getLogger("Hybrid framework");
    	PropertyConfigurator.configure("Log4j.properties");

    	
    	
    	if(br.equals("chrome")) 
    	{
	    	System.setProperty("webdriver.chrome.driver", readconfig.getchromepath());
	    	driver=new ChromeDriver();
    	}
    	else if(br.equals("edge")) {
    		System.setProperty("webdriver.edge.driver", readconfig.getedgepath());
        	driver=new EdgeDriver();
    		
    	}
    	
    	//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    	driver.get(baseURL);
		logger.info("URL is opened");

    }
	

		
	@AfterMethod
    public void closeBrowser() {
    	driver.quit();
    	logger.info("Window closed");
    }
   
    
    
    public static String captureScreen(WebDriver driver, String tname) throws IOException {
    	
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

    	TakesScreenshot ts =(TakesScreenshot) driver;
    	File source = ts.getScreenshotAs(OutputType.FILE);
    	String target = System.getProperty("user.dir") + "/Screenshots/" + tname+ dateName + ".png";
    	File destination =new File(target);
    	FileUtils.copyFile(source, destination);
    	System.out.println("Screenshot Taken");
    	return target;
    }

}
