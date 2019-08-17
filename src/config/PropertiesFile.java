package config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;


public class PropertiesFile {
	
	static Properties prop = new Properties();
	
	public static void writePropertiesFile() {
		try {
			OutputStream output = new FileOutputStream("C:\\workspace\\symphony\\symphony\\src\\config\\config.properties");
			prop.setProperty("browser","Chrome");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected WebDriver driver = null;
	
	  protected PropertiesFile(WebDriver driver) {
		    this.driver = driver;
		  }
	
}
