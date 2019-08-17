package tests;


import org.testng.annotations.Test;
import config.PropertiesFile;
import constants.Constants;
import pages.SearchResultsPage;
import pages.StartPage;
import utils.BaseTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class firstTest {

	
	public static void main(String[] args) {
		System.setProperty(Constants.CHROME_DRIVER_PROPERTY, Constants.CHROME_DRIVER_LOCATION);
		WebDriver driver = null;
			String email = "rade.testing@gmail.com";
			String password = "test123";
			String searchString = "Printed dresses";
			
		    System.out.println("Initializing driver");
		    driver = new ChromeDriver();
		    driver.get(Constants.URL_BASE);
		    
		    System.out.println("Maximizing window");
		    driver.manage().window().maximize();
		    
		    
		    StartPage startPage = new StartPage(driver);
		      
		    startPage.waitUntilStartPageLoads();
		    
		    System.out.println("Clicking 'Sign in' button");
		    startPage.clickSignInButton(driver);
		    
		    startPage.waitForEmailFieldToBeDisplayed(driver);
		    
		    System.out.println("Login to web app");
		    startPage
		    .populateEmailField(driver,email)
		    .populatePasswordField(driver,password)
		    .clickSubmitButton(driver);	    	

		    startPage.sleepInMiliseconds(3000);
		    
		    System.out.println("Checking if user is logged in");
		    boolean isUserLoggedIn = startPage.isSignOutButtonPresent(driver);
		    
		    assert isUserLoggedIn==true: "User not logged in!";
		    
		    System.out.println("Go back to home page");
		    driver.get(Constants.URL_BASE);
		    
		    System.out.println("Checking number of elements in popular section");
		    int numberOfElementsInPopularSection = startPage.countNumberOfItems();
		    
		    assert numberOfElementsInPopularSection==7: "Expected number of items in popular section: 7, bot got: "+numberOfElementsInPopularSection;
		    
		    
		    startPage.clickBestSellersTab(driver);
		    
		    
		    System.out.println("Checking number of elements in best sellers section");
		    int numberOfElementsInBestSellerSection = startPage.countNumberOfItems();
		    
		    assert numberOfElementsInBestSellerSection==7: "Expected number of items in best seller section: 7, bot got: "+numberOfElementsInBestSellerSection;
		    
		    System.out.println("Searching for 'Printed dresses'");
		     startPage.insertSearchString(driver,searchString);
		     
		     SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
		     
		     searchResultsPage.clickSearchButton(driver);
		     
		     SearchResultsPage.sleepInMiliseconds(2000);
		     
		     SearchResultsPage.getTitlesOfItems(driver);
		     
			// quitting driver
			// driver.quit();
	}

}
