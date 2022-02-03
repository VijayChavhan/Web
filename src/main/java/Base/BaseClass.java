package Base;

import java.io.FileInputStream;  
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;



public class BaseClass {
	public static WebDriver driver;
	public static Logger logger;
	Properties prop;
	

	public void Open_The_Browser() {
		String ProjectPath = System.getProperty("user.dir");
		 logger=Logger.getLogger(BaseClass.class);
		
		PropertyConfigurator.configure("Log4j.properties");
		FileInputStream file;
		try {
			file=new FileInputStream(ProjectPath+"/Config/Config.Properties");
			prop=new Properties();
			try {
				prop.load(file);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.setProperty("webdriver.chrome.driver",ProjectPath+"/Drivers/chromedriver.exe");
		logger.info("Properties are set");
		ChromeOptions options=new ChromeOptions();
		options.addArguments("start maximize"); 
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(ChromeOptions.CAPABILITY, options);
		       driver=new ChromeDriver(cap);
		
		
//		String browser = prop.getProperty("browser");
//		if(browser.contentEquals("chrome")) {
//			System.setProperty("webdriver.chrome.driver",ProjectPath+"/Drivers/chromedriver.exe");
//		      driver=new ChromeDriver();
//		}
//		else if(browser.contains("ff")) {
//			System.setProperty("webdriver.gecko.driver",ProjectPath+"/Drivers/geckodriver.exe");
//		      driver=new FirefoxDriver();
//		}
//		else if(browser.contentEquals("ie")) {
//			System.setProperty("webdriver.ie.driver",ProjectPath+"/Drivers/ie.exe");
//		      driver=new InternetExplorerDriver();
//		}
		      //driver.manage().window().maximize();
		      logger.info("Browser is open");
		      driver.get(prop.getProperty("url"));
		      logger.info("url inserted and connecting");
		      driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		      driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		      logger.info("Connection timeout");
	}
	
	
	
	public void ClosetheBrowser() {
		driver.close();
		driver.quit();
	}

}
