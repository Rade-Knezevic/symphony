package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
	protected WebDriver driver = null;
	
	  protected BasePage(WebDriver driver) {
		    this.driver = driver;
		  }
	  
	  public Object waitUntilVisible(int timeOutInSeconds, WebElement webElement) {
		    WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		    wait.until(ExpectedConditions.visibilityOf(webElement));
		    return this;
		  }
	  
	  public static void sleepInMiliseconds(int miliseconds) {

		  try {
			Thread.sleep(miliseconds);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		        
		    }
	  
	/*  public boolean isElementPresent(WebDriver driver,WebElement locator) {
		Boolean isPresent = locator.isDisplayed();
		  return isPresent;
	  }*/
}


