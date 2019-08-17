package utils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import constants.Constants;
public class BaseTest {

		protected WebDriver driver = null;
		
		  protected BaseTest(WebDriver driver) {
			    this.driver = driver;
			  }
	  
	  public void setFullScreen(WebDriver driver) {
	  driver.manage().window().maximize();
	  }
	  
/*	  
	static Properties prop = new Properties();
	 
	  public static String getPropertiesFile() {
			String browserType = null;
			try {
				
				InputStream input = new FileInputStream("C:\\workspace\\symphony\\symphony\\src\\config\\config.properties");
				prop.load(input);
				browserType = prop.getProperty("browser");
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return browserType;
		}
	  
	  public static void runBrowser() {
		  
		  String browser = getPropertiesFile();
		  
		  if (browser=="Chrome") {
			  System.setProperty(Constants.CHROME_DRIVER_PROPERTY,Constants.CHROME_DRIVER_LOCATION);
		    	 
			  driver = new ChromeDriver();
		  } else if (browser=="Firefox"){
			  System.setProperty(Constants.FIREFOX_DRIVER_PROPERTY,Constants.FIREFOX_DRIVER_LOCATION);
			  
			  driver = new FirefoxDriver();
		  }
		  else {}
	  }
*/
}